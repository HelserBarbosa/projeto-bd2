package br.com.unifacisa.projetobd2.daos.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unifacisa.projetobd2.daos.ItemDAO;
import br.com.unifacisa.projetobd2.dtos.LucroDTO;
import br.com.unifacisa.projetobd2.dtos.TotalizacaoDTO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Item;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;

@Repository
public class ItemDAOImpl implements ItemDAO {

	public static void main(String[] args) {
		Item item = new Item();
		item.setDescricao("Descrição");
		item.setPrecoFornecedor(new BigDecimal("200"));
		item.setPrecoLoja(new BigDecimal("200"));
		item.setQuantidade(10);
		item.setValidade(LocalDate.of(2020, 11, 29));
		ItemDAO dao = new ItemDAOImpl();
		dao.inserirSemPrecoLoja(item);
	}

	public Item inserirNovoItem(Item item) {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = "INSERT INTO item (descricao, tipo, preco_fornecedor, preco_loja, validade, quantidade) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, item.getDescricao());
			statement.setString(2, item.getTipo().toString());
			statement.setBigDecimal(3, item.getPrecoFornecedor());
			statement.setBigDecimal(4, item.getPrecoLoja());
			statement.setObject(5, item.getSqlDate());
			statement.setInt(6, item.getQuantidade());
			statement.execute();
			connection.commit();
			connection.close();
			return setGeneratedKey(item, statement);
		} catch (SQLException | ParseException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	public List<Item> findAll() {
		Connection connection = new ConnectionFactory().getConnection();
		String sql = "SELECT * FROM item;";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			statement.execute();
			List<Item> list;
			try (ResultSet rs = statement.getResultSet()) {
				list = new ArrayList<>();
				mapper(rs, list);
				connection.commit();
				connection.close();
			}
			return list;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new PetShopConnectionException(e.getMessage());
			}
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	private Item setGeneratedKey(Item item, PreparedStatement statement) {
		try (ResultSet rs = statement.getGeneratedKeys()) {
			while (rs.next()) {
				item.setCodigo(rs.getLong("codigo"));
				return item;
			}
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}
		return null;
	}

	public Item inserirItemSemValidade(Item item) {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = "INSERT INTO item (descricao, tipo, preco_fornecedor, preco_loja, quantidade) VALUES(?, ?, ?, ?, ?)";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, item.getDescricao());
			statement.setString(2, item.getTipo().toString());
			statement.setBigDecimal(3, item.getPrecoFornecedor());
			statement.setBigDecimal(4, item.getPrecoLoja());
			statement.setInt(5, item.getQuantidade());
			statement.execute();
			connection.commit();
			connection.close();
			return setGeneratedKey(item, statement);
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage() + ", " + e);
		}
	}

	public Item inserirSemPrecoLoja(Item item) {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = "INSERT INTO item (descricao, tipo, preco_fornecedor, validade, quantidade) VALUES(?, ?, ?, ?, ?)";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, item.getDescricao());
			statement.setString(2, item.getTipo().toString());
			statement.setBigDecimal(3, item.getPrecoFornecedor());
			statement.setDate(4, item.getSqlDate());
			statement.setInt(5, item.getQuantidade());
			statement.execute();
			connection.commit();
			connection.close();
			return setGeneratedKey(item, statement);
		} catch (SQLException | ParseException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	public void deletarItemPeloCodigo(Long codigo) {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = "DELETE FROM item WHERE codigo = ?";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, codigo);
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	private void mapper(ResultSet rs, List<Item> resultado) throws SQLException {
		while (rs.next()) {
			Item item = new Item();
			item.setCodigo(rs.getLong("codigo"));
			item.setDescricao(rs.getString("descricao"));
			item.setPrecoFornecedor(rs.getBigDecimal("preco_fornecedor"));
			item.setPrecoLoja(rs.getBigDecimal("preco_loja"));
			item.setQuantidade(rs.getInt("quantidade"));
			item.setValidade(rs.getDate("validade").toLocalDate());
			resultado.add(item);
		}
	}

	@Override
	public Item alterarPrecoFornecedorPorCodigo(Item item) {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = "UPDATE item SET preco_fornecedor = ? where codigo = ?";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setBigDecimal(1, item.getPrecoFornecedor());
			statement.setLong(2, item.getCodigo());
			statement.execute();
			connection.commit();
			connection.close();
			return item;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	@Override
	public Item alterarPrecoLojaPorCodigo(Item item) {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = "UPDATE item SET preco_loja = ? where codigo = ?";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setBigDecimal(1, item.getPrecoLoja());
			statement.setLong(2, item.getCodigo());
			statement.execute();
			connection.commit();
			connection.close();
			return item;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	@Override
	public Item alterarPrecoLojaEPrecoFornecedorPorCodigo(Item item) {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = "UPDATE item SET preco_loja = ?, preco_fornecedor = ? where codigo = ?";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setBigDecimal(1, item.getPrecoLoja());
			statement.setBigDecimal(2, item.getPrecoFornecedor());
			statement.setLong(3, item.getCodigo());
			statement.execute();
			connection.commit();
			connection.close();
			return item;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	@Override
	public Item alterarDescricaoETipoPorCodigo(Item item) {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = "UPDATE item SET descricao = ?, tipo = ? where codigo = ?";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setString(1, item.getDescricao());
			statement.setString(2, item.getTipo().toString());
			statement.setLong(3, item.getCodigo());
			statement.execute();
			connection.commit();
			connection.close();
			return item;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage());
		}
	}

	private Connection getConnection() {
		Connection conn = new ConnectionFactory().getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return conn;
	}

	private void rollback(Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
	}

	@Override
	public List<Item> buscarTodosOsRegistros() {
		Connection connection = getConnection();
		String sql = "SELECT * FROM item";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();
			ResultSet rs = statement.getResultSet();
			List<Item> itens = new ArrayList<Item>();
			while (rs.next()) {
				mapper(rs, itens);
			}
			return itens;
		} catch (SQLException e) {
			rollback(connection);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public List<Item> buscarItensPorDescricao(String descricao) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM item WHERE descricao = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, descricao);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			List<Item> itens = new ArrayList<Item>();
			while (rs.next()) {
				mapper(rs, itens);
			}
			return itens;
		} catch (SQLException e) {
			rollback(connection);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public List<Item> buscarItensPorTipo(String tipo) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM item WHERE tipo = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, tipo);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			List<Item> itens = new ArrayList<Item>();
			while (rs.next()) {
				mapper(rs, itens);
			}
			return itens;
		} catch (SQLException e) {
			rollback(connection);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public TotalizacaoDTO buscarTotalizacao() {
		Connection connection = getConnection();
		// TODO: criar query para buscar totalizacao
		String sql = "";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();
			ResultSet rs = statement.getResultSet();
			TotalizacaoDTO dto = new TotalizacaoDTO();
			while (rs.next()) {
				dto.setQuantidade(rs.getInt("quantidade"));
				dto.setTipoItem(rs.getString("tipo"));
				dto.setTotalizacao(rs.getBigDecimal("totalizacao"));
				return dto;
			}
		} catch (SQLException e) {
			rollback(connection);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public List<LucroDTO> buscarLucroParaCadaItem() {
		Connection connection = getConnection();
		// TODO: criar query para buscar lucro
		String sql = "";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();
			ResultSet rs = statement.getResultSet();
			List<LucroDTO> list = new ArrayList<LucroDTO>();
			while (rs.next()) {
				LucroDTO dto = new LucroDTO();
				dto.setLucro(rs.getBigDecimal("lucro"));
				dto.setNomeItem(rs.getString("nome"));
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			rollback(connection);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

}
