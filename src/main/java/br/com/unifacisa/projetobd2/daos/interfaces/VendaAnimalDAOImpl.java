package br.com.unifacisa.projetobd2.daos.interfaces;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unifacisa.projetobd2.daos.VendaAnimalDAO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.VendaAnimal;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;
import br.com.unifacisa.projetobd2.util.SQLUtils;

public class VendaAnimalDAOImpl implements VendaAnimalDAO {

	@Override
	public VendaAnimal insertComTodosOsDados(VendaAnimal vendaAnimal) {
		if (vendaAnimal.getAnimal() == null || vendaAnimal.getFuncionario() == null) {
			throw new PetShopConnectionException("Venda possui campos invalidos");
		}
		
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement statement = null;
		String sql = SQLUtils.getExternalQuery("INSERIR_NOVA_VENDA_ANIMAL");
		try {
			conn.setAutoCommit(false);
			statement= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, vendaAnimal.getAnimal().getRegistro());
			statement.setLong(2, vendaAnimal.getFuncionario().getMatricula());
			statement.setString(3, vendaAnimal.getDia());
			statement.setString(4, vendaAnimal.getMes());
			statement.setString(5, vendaAnimal.getAno());
			statement.setBigDecimal(6, vendaAnimal.getComissao());
			statement.setBigDecimal(7, vendaAnimal.getDesconto());
			statement.setBigDecimal(8, vendaAnimal.getValorFinal());
			statement.execute();
			conn.commit();
			setGeneratedKey(vendaAnimal, statement);
			conn.close();
			return vendaAnimal;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PetShopConnectionException(e.getMessage() + ", " + e);
		}
	}

	private VendaAnimal setGeneratedKey(VendaAnimal vendaAnimal, PreparedStatement statement) {
		try {
			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next()) {
				vendaAnimal.setNotaFiscal(rs.getLong("nota_fiscal"));
				return vendaAnimal;
			}
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) {
		VendaAnimal va = new VendaAnimal();
		va.setAno("2019");
		va.setComissao(new BigDecimal("5"));
		va.setDesconto(new BigDecimal("5"));
		va.setValorFinal(new BigDecimal("50"));
	}

	@Override
	public VendaAnimal insertSemInformarDesconto(VendaAnimal vendaAnimal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVendaPorNotaFiscal(Long notaFiscal) {
		// TODO Auto-generated method stub

	}

	@Override
	public VendaAnimal updateNotaFiscalPelaNotaFiscal(VendaAnimal vendaAnimal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendaAnimal updateRegAnimalPorNotaFiscal(VendaAnimal vendaAnimal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendaAnimal updateMatFuncPorNotaFiscal(VendaAnimal vendaAnimal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendaAnimal updateDiaMesAnoPorNotaFiscal(VendaAnimal vendaAnimal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendaAnimal updateDisconto(BigDecimal novoDesconto) {
		// TODO Auto-generated method stub
		return null;
	}

}
