package br.com.unifacisa.projetobd2.daos;

import java.util.List;

import br.com.unifacisa.projetobd2.dtos.LucroDTO;
import br.com.unifacisa.projetobd2.dtos.TotalizacaoDTO;
import br.com.unifacisa.projetobd2.models.Item;

public interface ItemDAO {

	Item inserirNovoItem(Item item);

	Item inserirSemPrecoLoja(Item item);

	Item inserirItemSemValidade(Item item);

	void deletarItemPeloCodigo(Long codigo);

	Item alterarPrecoFornecedorPorCodigo(Item item);

	Item alterarPrecoLojaPorCodigo(Item item);

	Item alterarPrecoLojaEPrecoFornecedorPorCodigo(Item item);

	Item alterarDescricaoETipoPorCodigo(Item item);

	List<Item> buscarTodosOsRegistros();

	List<Item> buscarItensPorDescricao(String descricao);

	List<Item> buscarItensPorTipo(String tipo);

	TotalizacaoDTO buscarTotalizacao();
	
	LucroDTO buscarLucroParaCadaItem();

}
