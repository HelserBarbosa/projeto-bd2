package br.com.unifacisa.projetobd2.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.projetobd2.daos.VendaAnimalDAO;
import br.com.unifacisa.projetobd2.dtos.TotalizacaoVendaAnimalDTO;
import br.com.unifacisa.projetobd2.models.VendaAnimal;

@Service
public class VendaAnimalService {

	@Autowired
	private VendaAnimalDAO dao;

	public VendaAnimal insertComTodosOsDados(VendaAnimal vendaAnimal) {
		return dao.insertComTodosOsDados(vendaAnimal);
	}

	public VendaAnimal insertSemInformarDesconto(VendaAnimal vendaAnimal) {
		return dao.insertSemInformarDesconto(vendaAnimal);
	}

	public void deleteVendaPorNotaFiscal(Long notaFiscal) {
		dao.deleteVendaPorNotaFiscal(notaFiscal);
	}

	public boolean updateNotaFiscalPelaNotaFiscal(Long antigaNotaFiscal, Long novaNotaFiscal) {
		return dao.updateNotaFiscalPelaNotaFiscal(antigaNotaFiscal, novaNotaFiscal);
	}

	public boolean updateRegAnimalPorNotaFiscal(VendaAnimal vendaAnimal) {
		return dao.updateRegAnimalPorNotaFiscal(vendaAnimal);
	}

	public boolean updateMatFuncPorNotaFiscal(VendaAnimal vendaAnimal) {
		return dao.updateMatFuncPorNotaFiscal(vendaAnimal);
	}

	public boolean updateDiaMesAnoPorNotaFiscal(VendaAnimal vendaAnimal) {
		return dao.updateDiaMesAnoPorNotaFiscal(vendaAnimal);
	}

	public boolean updateDisconto(BigDecimal novoDesconto) {
		return dao.updateDisconto(novoDesconto);
	}

	public List<VendaAnimal> listarVendas() {
		return dao.listarVendas();
	}

	public List<VendaAnimal> listarVendasPorTipo(String tipo) {
		return dao.listarVendasPorTipo(tipo);
	}

	public List<VendaAnimal> listarVendasPorNomeVendedor(String nomeVendedor) {
		return dao.listarVendasPorNomeVendedor(nomeVendedor);
	}

	public List<VendaAnimal> listarVendasPorMesEAno(int mes, int ano) {
		return dao.listarVendasPorMesEAno(mes, ano);
	}

	public List<VendaAnimal> listarVendasPorVendedorETipoAnimal(Long matriculaVendedor, String tipoAnimal) {
		return dao.listarVendasPorVendedorETipoAnimal(matriculaVendedor, tipoAnimal);
	}

	public List<TotalizacaoVendaAnimalDTO> buscarTotalizacaoVendaAnimal() {
		return dao.buscarTotalizacaoVendaAnimal();
	}

	public List<TotalizacaoVendaAnimalDTO> buscarTotalizacaoVendaAnimalFiltradaPorFuncionarioMesAno(
			Long matriculaFuncionario, int mes, int ano) {
		return dao.buscarTotalizacaoVendaAnimalFiltradaPorFuncionarioMesAno(matriculaFuncionario, mes, ano);
	}

}
