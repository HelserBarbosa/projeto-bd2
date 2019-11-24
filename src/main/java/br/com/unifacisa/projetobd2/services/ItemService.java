package br.com.unifacisa.projetobd2.services;

import org.springframework.stereotype.Service;

import br.com.unifacisa.projetobd2.daos.interfaces.ItemDAOImpl;
import br.com.unifacisa.projetobd2.models.Item;

@Service
public class ItemService {
	
	private ItemDAOImpl dao;

	public ItemService(ItemDAOImpl dao) {
		this.dao = dao;
	}
	
	public Item inserirNovoItem(Item item) {
		
		if (item.getValidade() == null) {
			return dao.inserirItemSemValidade(item);
		}
		
		if (item.getPrecoLoja() == null) {
			return dao.inserirSemPrecoLoja(item);
		}
		
		return dao.inserirNovoItem(item);
	}
	
}
