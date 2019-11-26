package br.com.unifacisa.projetobd2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.projetobd2.dtos.LucroDTO;
import br.com.unifacisa.projetobd2.dtos.TotalizacaoDTO;
import br.com.unifacisa.projetobd2.models.Item;
import br.com.unifacisa.projetobd2.services.ItemService;

@RestController
@RequestMapping("item")
@CrossOrigin("http://localhost:4200")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping
	public ResponseEntity<Item> criarItem(@RequestBody Item item) {
		return new ResponseEntity<Item>(itemService.inserirNovoItem(item), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> deletarItemPeloCodigo(@PathVariable Long codigo) {
		itemService.deletarItemPeloCodigo(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Item> alterarPrecoFornecedorPorCodigo(@RequestBody Item item) {
		return new ResponseEntity<Item>(itemService.alterarPrecoFornecedorPorCodigo(item), HttpStatus.OK);
	}

	@PutMapping("codigo")
	public ResponseEntity<Item> alterarPrecoLojaPorCodigo(@RequestBody Item item) {
		return new ResponseEntity<Item>(itemService.alterarPrecoLojaPorCodigo(item), HttpStatus.OK);
	}

	@PutMapping("fornecedor-e-codigo")
	public ResponseEntity<Item> alterarPrecoLojaEPrecoFornecedorPorCodigo(@RequestBody Item item) {
		return new ResponseEntity<Item>(itemService.alterarPrecoLojaEPrecoFornecedorPorCodigo(item), HttpStatus.OK);
	}

	@PutMapping("descricao-e-tipo-codigo")
	public ResponseEntity<Item> alterarDescricaoETipoPorCodigo(@RequestBody Item item) {
		return new ResponseEntity<Item>(itemService.alterarDescricaoETipoPorCodigo(item), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Item>> buscarTodosOsRegistros() {
		return new ResponseEntity<List<Item>>(itemService.buscarTodosOsRegistros(), HttpStatus.OK);
	}

	@GetMapping("param/descricao/{descricao}")
	public ResponseEntity<List<Item>> buscarItensPorDescricao(@RequestParam String descricao) {
		return new ResponseEntity<List<Item>>(itemService.buscarItensPorDescricao(descricao), HttpStatus.OK);
	}

	@GetMapping("param/descricao/{descricao}")
	public ResponseEntity<List<Item>> buscarItensPorTipo(@RequestParam String tipo) {
		return new ResponseEntity<List<Item>>(itemService.buscarItensPorTipo(tipo), HttpStatus.OK);
	}

	@GetMapping("totalizacao")
	public ResponseEntity<List<TotalizacaoDTO>> buscarTotalizacao() {
		return new ResponseEntity<List<TotalizacaoDTO>>(itemService.buscarTotalizacao(), HttpStatus.OK);
	}

	@GetMapping("lucro")
	public ResponseEntity<List<LucroDTO>> buscarLucroParaCadaItem() {
		return new ResponseEntity<List<LucroDTO>>(itemService.buscarLucroParaCadaItem(), HttpStatus.OK);
	}

}
