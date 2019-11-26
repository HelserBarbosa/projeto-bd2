package br.com.unifacisa.projetobd2.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.projetobd2.dtos.ConsultaLucroDTO;
import br.com.unifacisa.projetobd2.models.Animal;
import br.com.unifacisa.projetobd2.services.AnimalService;

@RestController
@RequestMapping("animal")
public class AnimalController {

	@Autowired
	private AnimalService service;

	@PostMapping
	public ResponseEntity<Animal> inserirAnimal(@RequestBody Animal animal) {
		return new ResponseEntity<>(service.inserirAnimal(animal), HttpStatus.CREATED);
	}

	@PostMapping("peso-altura")
	public ResponseEntity<Animal> inserirAnimalSemPesoAlturaMedicao(@RequestBody Animal animal) {
		return new ResponseEntity<>(service.inserirAnimalSemPesoAlturaMedicao(animal), HttpStatus.CREATED);
	}

	@PostMapping("preco-venda")
	public ResponseEntity<Animal> inserirAnimalSemPrecoVenda(@RequestBody Animal animal) {
		return new ResponseEntity<>(service.inserirAnimalSemPrecoVenda(animal), HttpStatus.CREATED);
	}

	@PostMapping("preco-compra")
	public ResponseEntity<Animal> inserirAnimalSemPrecoCompra(@RequestBody Animal animal) {
		return new ResponseEntity<>(service.inserirAnimalSemPrecoCompra(animal), HttpStatus.CREATED);
	}

	@PostMapping("preco-venda-compra")
	public Animal inserirAnimalSemPrecoCompraVenda(@RequestBody Animal animal) {
		return service.inserirAnimalSemPrecoCompraVenda(animal);
	}

	@PostMapping("data-nasc")
	public ResponseEntity<Animal> inserirAnimalSemDataNasc(@RequestBody Animal animal) {
		return new ResponseEntity<>(service.inserirAnimalSemDataNasc(animal), HttpStatus.CREATED);
	}

	@PutMapping("peso-altura")
	public ResponseEntity<Void> updateAnimalPesoAlturaDtaMed(@RequestBody Animal animal) {
		service.updateAnimalPesoAlturaDtaMed(animal);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("preco-compra")
	public ResponseEntity<Void> updateAnimalPrecoCompra(@RequestBody Animal animal) {
		service.updateAnimalPrecoCompra(animal);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("preco-compra-venda")
	public ResponseEntity<Void> updateAnimalPrecoCompraVenda(@RequestBody Animal animal) {
		service.updateAnimalPrecoCompraVenda(animal);
		return new ResponseEntity<>(HttpStatus.OK)
	}

	@PutMapping("tipo")
	public ResponseEntity<Void> updateAnimalTipo(@RequestBody Animal animal) {
		service.updateAnimalTipo(animal);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("raca")
	public ResponseEntity<Void> updateAnimalRaca(@RequestBody Animal animal) {
		service.updateAnimalRaca(animal);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("tipo-raca")
	public ResponseEntity<Void> updateAnimalTipoRaca(@RequestBody Animal animal) {
		service.updateAnimalTipoRaca(animal);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("registro")
	public ResponseEntity<Void> deletarAnimalPorRegistro(@PathParam("registro") Long registro) {
		service.deletarAnimalPorRegistro(registro);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("tipo")
	public ResponseEntity<Void> deletarAnimalPorTipo(@PathParam("tipo") String tipo) {
		service.deletarAnimalPorTipo(tipo);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Animal>> listar() {
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}

	@GetMapping("tipo")
	public ResponseEntity<List<Animal>> listarPorTipo(@RequestParam("tipo") String tipo) {
		return new ResponseEntity<>(service.listarPorTipo(tipo), HttpStatus.OK);
	}

	@GetMapping("preco-venda")
	public ResponseEntity<List<Animal>> listarPorPrecoVenda(@RequestParam("preco") BigDecimal precoVenda) {
		return new ResponseEntity<>(service.listarPorPrecoVenda(precoVenda), HttpStatus.OK);
	}

	@GetMapping("lucro")
	public ResponseEntity<List<ConsultaLucroDTO>> consultaLucro() {
		return new ResponseEntity<>(service.consultaLucro(), HttpStatus.OK);
	}
}
