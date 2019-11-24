package br.com.unifacisa.projetobd2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.projetobd2.daos.ItemDAO;
import br.com.unifacisa.projetobd2.models.Item;

@RestController
@RequestMapping("item")
public class ItemController {
	
	private ItemDAO dao;
	
	@PostMapping
	public ResponseEntity<Item> criarItem(@RequestBody Item item) {
		return new ResponseEntity<Item>(dao.inserirNovoItem(item), HttpStatus.OK);
	}
	
	
}
