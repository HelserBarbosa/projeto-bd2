package br.com.unifacisa.projetobd2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.projetobd2.models.VendaItem;
import br.com.unifacisa.projetobd2.services.VendaItemService;

@RestController
@RequestMapping("venda-item")
public class VendaItemController {

	@Autowired
	private VendaItemService service;

	@PostMapping
	public VendaItem insertCompleto(@RequestBody VendaItem vendaItem) {
		return service.insertCompleto(vendaItem);
	}

	@PostMapping("desconto")
	public VendaItem insertSemDesconto(@RequestBody VendaItem vendaItem) {
		return service.insertSemDesconto(vendaItem);
	}

	@PutMapping("item-cod")
	public VendaItem updateItemCod(@RequestBody VendaItem vendaItem) {
		return service.updateItemCod(vendaItem);
	}

	@PutMapping("func-mat")
	public VendaItem updateFuncMat(@RequestBody VendaItem vendaItem) {
		return service.updateFuncMat(vendaItem);
	}

	@PutMapping("data")
	public VendaItem updateDiaMesAno(@RequestBody VendaItem vendaItem) {
		return service.updateDiaMesAno(vendaItem);
	}

	@PutMapping("desconto")
	public VendaItem updateDesconto(@RequestBody VendaItem vendaItem) {
		return service.updateDesconto(vendaItem);
	}

	@DeleteMapping
	public VendaItem deletePorNotaFiscal(@RequestBody VendaItem vendaItem) {
		return service.deletePorNotaFiscal(vendaItem);
	}

	@GetMapping
	public List<VendaItem> listar() {
		return service.listar();
	}

	@GetMapping("descricao")
	public List<VendaItem> listarPorDescricaoItem(@RequestParam("descricao") String nome) {
		return service.listarPorDescricaoItem(nome);
	}

	@GetMapping("data-descricao")
	public List<VendaItem> listarPorDescricaoItem(@RequestParam("dia") Integer dia, @RequestParam("mes") Integer mes,
			@RequestParam("ano") Integer ano, @RequestParam("descricao") String nome) {
		return service.listarPorDescricaoItem(dia, mes, ano, nome);
	}
}
