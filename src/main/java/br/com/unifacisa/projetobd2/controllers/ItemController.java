package br.com.unifacisa.projetobd2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
