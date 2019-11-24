package br.com.unifacisa.projetobd2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Item;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;
import br.com.unifacisa.projetobd2.util.SQLUtils;

public class ItemDAO {

	public Item inserirNovoItem(Item item) {
		PreparedStatement statement = null;
		Connection connection = ConnectionFactory.getConnection();

		String sql = SQLUtils.getExternalQuery("INSERIR_NOVO_ITEM");
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, item.getDescricao());
			statement.setString(2, item.getTipo());
			statement.setBigDecimal(3, item.getPrecoFornecedor());
			statement.setBigDecimal(4, item.getPrecoLoja());
			statement.setDate(5, item.getSqlDate());
					
			statement.setInt(6, item.getQuantidade());
			statement.execute();
			connection.commit();
			ConnectionFactory.closeConnection();
			return setGeneratedKey(item, statement);
		} catch (SQLException | ParseException e) {
			ConnectionFactory.rollback();
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	private Item setGeneratedKey(Item item, PreparedStatement statement) {
		try {
			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next()) {
				item.setCodigo(rs.getLong("codigo"));
				return item;
			}
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}
		return null;
	}

}
