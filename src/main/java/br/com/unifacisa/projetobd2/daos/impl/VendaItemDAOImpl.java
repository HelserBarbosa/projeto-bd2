package br.com.unifacisa.projetobd2.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unifacisa.projetobd2.daos.VendaItemDAO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.VendaItem;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;

public class VendaItemDAOImpl implements VendaItemDAO {

	private PreparedStatement createStatement(Connection connection, String query) {
		try {
			return connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

	@Override
	public VendaItem insertCompleto(VendaItem vendaItem) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder(
				"INSERT INTO public.venda_item(item_cod, mat_func, dia, mes, ano, desconto, valor_final) VALUES (?, ?, ?, ?, ?, ?, ?);");

		PreparedStatement statement = createStatement(conn, sql.toString());

		try {
			statement.setLong(1, vendaItem.getIteCod());
			statement.setLong(2, vendaItem.getMatFunc());
			statement.setInt(3, vendaItem.getDia());
			statement.setInt(4, vendaItem.getMes());
			statement.setInt(5, vendaItem.getAno());
			statement.setBigDecimal(6, vendaItem.getDesconto());
			statement.setBigDecimal(7, vendaItem.getValoFinal());

			statement.execute();
			setVendaItemKey(statement, vendaItem);
			conn.commit();
			statement.close();
			conn.close();
			return vendaItem;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public VendaItem insertSemDesconto(VendaItem vendaItem) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder(
				"INSERT INTO public.venda_item(item_cod, mat_func, dia, mes, ano, valor_final) VALUES (?, ?, ?, ?, ?, ?);");

		PreparedStatement statement = createStatement(conn, sql.toString());

		try {
			statement.setLong(1, vendaItem.getIteCod());
			statement.setLong(2, vendaItem.getMatFunc());
			statement.setInt(3, vendaItem.getDia());
			statement.setInt(4, vendaItem.getMes());
			statement.setInt(5, vendaItem.getAno());
			statement.setBigDecimal(6, vendaItem.getValoFinal());

			statement.execute();
			setVendaItemKey(statement, vendaItem);
			conn.commit();
			statement.close();
			conn.close();
			return vendaItem;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public VendaItem updateItemCod(VendaItem vendaItem) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder("UPDATE public.venda_item SET item_cod=? WHERE  nota_fiscal=?;");

		PreparedStatement statement = createStatement(conn, sql.toString());

		try {
			statement.setLong(1, vendaItem.getIteCod());
			statement.setLong(2, vendaItem.getNotaFiscal());

			statement.execute();
			setVendaItemKey(statement, vendaItem);
			conn.commit();
			statement.close();
			conn.close();
			return vendaItem;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public VendaItem updateFuncMat(VendaItem vendaItem) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder("UPDATE public.venda_item SET func_mat=? WHERE  nota_fiscal=?;");

		PreparedStatement statement = createStatement(conn, sql.toString());

		try {
			statement.setLong(1, vendaItem.getMatFunc());
			statement.setLong(2, vendaItem.getNotaFiscal());

			statement.execute();
			setVendaItemKey(statement, vendaItem);
			conn.commit();
			statement.close();
			conn.close();
			return vendaItem;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public VendaItem updateDiaMesAno(VendaItem vendaItem) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder("UPDATE public.venda_item SET dia=?,mes=?,ano=? WHERE  nota_fiscal=?;");

		PreparedStatement statement = createStatement(conn, sql.toString());

		try {
			statement.setLong(1, vendaItem.getDia());
			statement.setLong(2, vendaItem.getMes());
			statement.setLong(3, vendaItem.getAno());
			statement.setLong(4, vendaItem.getNotaFiscal());

			statement.execute();
			setVendaItemKey(statement, vendaItem);
			conn.commit();
			statement.close();
			conn.close();
			return vendaItem;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public VendaItem updateDesconto(VendaItem vendaItem) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder("UPDATE public.venda_item SET desconto=? WHERE  nota_fiscal=?;");

		PreparedStatement statement = createStatement(conn, sql.toString());

		try {
			statement.setBigDecimal(1, vendaItem.getDesconto());
			statement.setLong(2, vendaItem.getNotaFiscal());

			statement.execute();
			setVendaItemKey(statement, vendaItem);
			conn.commit();
			statement.close();
			conn.close();
			return vendaItem;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	public VendaItem deletePorNotaFiscal(VendaItem vendaItem) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder("DELETE public.venda_item WHERE  nota_fiscal=?;");

		PreparedStatement statement = createStatement(conn, sql.toString());

		try {
			statement.setLong(1, vendaItem.getNotaFiscal());

			statement.execute();
			setVendaItemKey(statement, vendaItem);
			conn.commit();
			statement.close();
			conn.close();
			return vendaItem;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public List<VendaItem> listar() {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder("SELECT * FROM public.venda_item;");

		PreparedStatement statement = createStatement(conn, sql.toString());

		List<VendaItem> vendas = new ArrayList<>();

		try {

			ResultSet executeQuery = statement.executeQuery();
			
			mapper(vendas, executeQuery);
			
			return vendas;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}
	
	@Override
	public List<VendaItem> listarPorDescricaoItem(String nome) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder("SELECT * FROM public.venda_item vi, public.item i WHERE i.codigo = vi.item_cod and i.descricao=?;");

		PreparedStatement statement = createStatement(conn, sql.toString());

		
		List<VendaItem> vendas = new ArrayList<>();

		try {
			statement.setString(1, nome);

			ResultSet executeQuery = statement.executeQuery();
			
			mapper(vendas, executeQuery);
			
			return vendas;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public List<VendaItem> listarPorDescricaoItem(Integer dia,Integer mes, Integer ano, String nome) {
		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder("SELECT * FROM public.venda_item vi, public.item i WHERE i.codigo = vi.item_cod and i.descricao=?");
		sql.append(" AND vi.dia=? AND vi.ano=? AND vi.mes=?;");

		PreparedStatement statement = createStatement(conn, sql.toString());

		
		List<VendaItem> vendas = new ArrayList<>();

		try {
			statement.setString(1, nome);
			statement.setInt(2, dia);
			statement.setInt(3, ano);
			statement.setInt(4, mes);

			ResultSet executeQuery = statement.executeQuery();
			
			mapper(vendas, executeQuery);
			
			return vendas;

		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	
	private void mapper(List<VendaItem> vendas, ResultSet executeQuery) throws SQLException {
		while(executeQuery.next()) {
			VendaItem vendaItem = new VendaItem();
			
			vendaItem.setNotaFiscal(executeQuery.getLong("nota_fiscal"));
			vendaItem.setAno(executeQuery.getInt("ano"));
			vendaItem.setDesconto(executeQuery.getBigDecimal("desconto"));
			vendaItem.setDia(executeQuery.getInt("dia"));
			vendaItem.setMes(executeQuery.getInt("mes"));
			
			vendas.add(vendaItem);
		}
	}

	private void rollback(Connection connection, Exception e) {
		try {
			connection.rollback();
		} catch (SQLException ex) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
	}

	private void setVendaItemKey(PreparedStatement statement, VendaItem vendaItem) {
		try (ResultSet rs = statement.getGeneratedKeys()) {
			if (rs.next()) {
				vendaItem.setNotaFiscal(rs.getLong("nota_fiscal"));
			}
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
	}

}
