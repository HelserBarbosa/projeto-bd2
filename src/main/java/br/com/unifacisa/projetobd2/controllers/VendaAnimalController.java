package br.com.unifacisa.projetobd2.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.projetobd2.dtos.TotalizacaoVendaAnimalDTO;
import br.com.unifacisa.projetobd2.models.VendaAnimal;
import br.com.unifacisa.projetobd2.services.VendaAnimalService;

@RestController
@RequestMapping("vendaanimal")
public class VendaAnimalController {

	@Autowired
	private VendaAnimalService service;

	@PostMapping
	public VendaAnimal insertComTodosOsDados(@RequestBody VendaAnimal vendaAnimal) {
		return service.insertComTodosOsDados(vendaAnimal);
	}

	@PostMapping("sem-desconto")
	public VendaAnimal insertSemInformarDesconto(@RequestBody VendaAnimal vendaAnimal) {
		return service.insertSemInformarDesconto(vendaAnimal);
	}

	@DeleteMapping("{notaFiscal}")
	public void deleteVendaPorNotaFiscal(Long notaFiscal) {
		service.deleteVendaPorNotaFiscal(notaFiscal);
	}

	@PutMapping("nota-fiscal/{antigaNotaFiscal}/{novaNotaFiscal}")
	public boolean updateNotaFiscalPelaNotaFiscal(Long antigaNotaFiscal, Long novaNotaFiscal) {
		return service.updateNotaFiscalPelaNotaFiscal(antigaNotaFiscal, novaNotaFiscal);
	}

	@PutMapping("reg-animal")
	public boolean updateRegAnimalPorNotaFiscal(@RequestBody VendaAnimal vendaAnimal) {
		return service.updateRegAnimalPorNotaFiscal(vendaAnimal);
	}

	@PutMapping("nota-fiscal")
	public boolean updateMatFuncPorNotaFiscal(@RequestBody VendaAnimal vendaAnimal) {
		return service.updateMatFuncPorNotaFiscal(vendaAnimal);
	}

	@PutMapping("dia-mes-ano")
	public boolean updateDiaMesAnoPorNotaFiscal(@RequestBody VendaAnimal vendaAnimal) {
		return service.updateDiaMesAnoPorNotaFiscal(vendaAnimal);
	}

	@PutMapping("disconto/{novoDesconto}")
	public boolean updateDisconto(@PathVariable BigDecimal novoDesconto) {
		return service.updateDisconto(novoDesconto);
	}

	@GetMapping
	public List<VendaAnimal> listarVendas() {
		return service.listarVendas();
	}

	@GetMapping("tipo/{tipo}")
	public List<VendaAnimal> listarVendasPorTipo(@PathVariable String tipo) {
		return service.listarVendasPorTipo(tipo);
	}

	@GetMapping("nome-vendedor/{nomeVendedor}")
	public List<VendaAnimal> listarVendasPorNomeVendedor(@PathVariable String nomeVendedor) {
		return service.listarVendasPorNomeVendedor(nomeVendedor);
	}

	@GetMapping("mes-ano/{mes}/{ano}")
	public List<VendaAnimal> listarVendasPorMesEAno(@PathVariable Integer mes, @PathVariable Integer ano) {
		return service.listarVendasPorMesEAno(mes, ano);
	}

	@GetMapping("vendedor-tipo-animal/{matriculaVendedor}/{tipoAnimal}")
	public List<VendaAnimal> listarVendasPorVendedorETipoAnimal(@PathVariable Long matriculaVendedor,
			@PathVariable String tipoAnimal) {
		return service.listarVendasPorVendedorETipoAnimal(matriculaVendedor, tipoAnimal);
	}

	@GetMapping("totalizacao")
	public List<TotalizacaoVendaAnimalDTO> buscarTotalizacaoVendaAnimal() {
		return service.buscarTotalizacaoVendaAnimal();
	}

	@GetMapping("totalizacao-filtrada/{matriculaFuncionario}/{mes}/{ano}")
	public List<TotalizacaoVendaAnimalDTO> buscarTotalizacaoVendaAnimalFiltradaPorFuncionarioMesAno(
			@PathVariable Long matriculaFuncionario, @PathVariable Integer mes, @PathVariable Integer ano) {
		return service.buscarTotalizacaoVendaAnimalFiltradaPorFuncionarioMesAno(matriculaFuncionario, mes, ano);
	}

}
