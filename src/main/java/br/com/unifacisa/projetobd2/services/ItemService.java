package br.com.unifacisa.projetobd2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.unifacisa.projetobd2.daos.impl.ItemDAOImpl;
import br.com.unifacisa.projetobd2.dtos.LucroDTO;
import br.com.unifacisa.projetobd2.dtos.TotalizacaoDTO;
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

	public void deletarItemPeloCodigo(Long codigo) {
		dao.deletarItemPeloCodigo(codigo);
	}

	public Item alterarPrecoFornecedorPorCodigo(Item item) {
		return dao.alterarPrecoFornecedorPorCodigo(item);
	}

	public Item alterarPrecoLojaPorCodigo(Item item) {
		return dao.alterarPrecoLojaPorCodigo(item);
	}

	public Item alterarPrecoLojaEPrecoFornecedorPorCodigo(Item item) {
		return dao.alterarPrecoLojaEPrecoFornecedorPorCodigo(item);
	}

	public Item alterarDescricaoETipoPorCodigo(Item item) {
		return dao.alterarDescricaoETipoPorCodigo(item);
	}

	public List<Item> buscarTodosOsRegistros() {
		return dao.buscarTodosOsRegistros();
	}

	public List<Item> buscarItensPorDescricao(String descricao) {
		return dao.buscarItensPorDescricao(descricao);
	}

	public List<Item> buscarItensPorTipo(String tipo) {
		return dao.buscarItensPorTipo(tipo);
	}

	public TotalizacaoDTO buscarTotalizacao() {
		return dao.buscarTotalizacao();
	}

	public List<LucroDTO> buscarLucroParaCadaItem() {
		return dao.buscarLucroParaCadaItem();
	}

}
