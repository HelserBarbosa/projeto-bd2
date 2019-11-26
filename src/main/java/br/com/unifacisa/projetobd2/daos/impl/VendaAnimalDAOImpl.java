package br.com.unifacisa.projetobd2.daos.impl;

import br.com.unifacisa.projetobd2.daos.AnimalDAO;
import br.com.unifacisa.projetobd2.daos.FuncionarioDAO;
import br.com.unifacisa.projetobd2.daos.VendaAnimalDAO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Animal;
import br.com.unifacisa.projetobd2.models.Funcionario;
import br.com.unifacisa.projetobd2.models.VendaAnimal;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;
import br.com.unifacisa.projetobd2.util.SQLUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class VendaAnimalDAOImpl implements VendaAnimalDAO {

    public static void main(String[] args) {
        VendaAnimal va = new VendaAnimal();
        Animal animal = new Animal();
        AnimalDAO animalDao = new AnimalDAO();
        FuncionarioDAO fdao = new FuncionarioDAOImpl();
        VendaAnimalDAO vdao = new VendaAnimalDAOImpl();
        
        animal.setAltura(new BigDecimal("15"));
        animal.setPeso(new BigDecimal("15"));
        animal.setPrecoCompra(new BigDecimal("150"));
        animal.setPrecoCompra(new BigDecimal("130"));
        animal.setRaca("raca");
        animal.setTipo("tipo");
        animalDao.inserirAnimal(animal);
        
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("12345678910");
        funcionario.setDtAdm(LocalDate.of(2015, 2, 5));
        funcionario.setDtNasc(LocalDate.of(1989, 5, 25));
        funcionario.setEndereço("rua rua rua rua");
        funcionario.setFuncao("atendente");
        funcionario.setNome("nome");
        funcionario.setTelefone("333333333");
        fdao.criarFuncionario(funcionario);

        
        va.setAnimal(animal);
        va.setFuncionario(funcionario);
        va.setAno("2019");
        va.setComissao(new BigDecimal("5"));
        va.setDesconto(new BigDecimal("5"));
        va.setValorFinal(new BigDecimal("50"));
        va.setMes("03");
        va.setDia("14");
        vdao.insertComTodosOsDados(va);
    }

    @Override
    public VendaAnimal insertComTodosOsDados(VendaAnimal vendaAnimal) {
        if (vendaAnimal.getAnimal() == null || vendaAnimal.getFuncionario() == null) {
            throw new PetShopConnectionException("Venda possui campos invalidos");
        }
        Connection conn = getConnection();
        try (PreparedStatement statement = createStatement(conn)) {
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
        	rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
        }
        return null;
    }

    private VendaAnimal setGeneratedKey(VendaAnimal vendaAnimal, PreparedStatement statement) {
        try (ResultSet rs = statement.getGeneratedKeys()) {
            while (rs.next()) {
                vendaAnimal.setNotaFiscal(rs.getLong("nota_fiscal"));
                return vendaAnimal;
            }
        } catch (SQLException e) {
            throw new PetShopConnectionException(e.getMessage());
        }
        return null;
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

    private void rollback(Connection connection, Exception e) {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            PetShopConnectionException.handlePetShopConnectionException(e);
        }
    }

    private PreparedStatement createStatement(Connection connection) {
        try {
            return connection.prepareStatement(
                    SQLUtils.getExternalQuery("INSERIR_NOVA_VENDA_ANIMAL"),
                    Statement.RETURN_GENERATED_KEYS
            );
        } catch (SQLException e) {
            PetShopConnectionException.handlePetShopConnectionException(e);
        }
        throw new PetShopConnectionException("Algo quebrou no prepare statement");
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
