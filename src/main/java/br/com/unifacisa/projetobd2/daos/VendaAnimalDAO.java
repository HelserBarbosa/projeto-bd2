package br.com.unifacisa.projetobd2.daos;

import java.math.BigDecimal;
import java.util.List;

import br.com.unifacisa.projetobd2.dtos.TotalizacaoVendaAnimalDTO;
import br.com.unifacisa.projetobd2.models.VendaAnimal;


public interface VendaAnimalDAO {

	VendaAnimal insertComTodosOsDados(VendaAnimal vendaAnimal);

	VendaAnimal insertSemInformarDesconto(VendaAnimal vendaAnimal);

	void deleteVendaPorNotaFiscal(Long notaFiscal);

	boolean updateNotaFiscalPelaNotaFiscal(Long antigaNotaFiscal, Long novaNotaFiscal);

	boolean updateRegAnimalPorNotaFiscal(VendaAnimal vendaAnimal);

	boolean updateMatFuncPorNotaFiscal(VendaAnimal vendaAnimal);

	boolean updateDiaMesAnoPorNotaFiscal(VendaAnimal vendaAnimal);

	boolean updateDisconto(BigDecimal novoDesconto);

	List<VendaAnimal> listarVendas();

	List<VendaAnimal> listarVendasPorTipo(String tipo);

	List<VendaAnimal> listarVendasPorNomeVendedor(String nomeVendedor);

	List<VendaAnimal> listarVendasPorMesEAno(int mes, int ano);

	List<VendaAnimal> listarVendasPorVendedorETipoAnimal(Long matriculaVendedor, String tipoAnimal);

	List<TotalizacaoVendaAnimalDTO> buscarTotalizacaoVendaAnimal();

	List<TotalizacaoVendaAnimalDTO> buscarTotalizacaoVendaAnimalFiltradaPorFuncionarioMesAno(Long matriculaFuncionario,
			int mes, int ano);

}
