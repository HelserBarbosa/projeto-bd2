package br.com.unifacisa.projetobd2.daos;

import org.springframework.stereotype.Repository;

import br.com.unifacisa.projetobd2.models.VendaItem;

@Repository
public interface VendaItemDAO {

	VendaItem insertCompleto(VendaItem vendaItem);

	VendaItem insertSemDesconto(VendaItem vendaItem);

	VendaItem updateItemCod(VendaItem vendaItem);

	VendaItem updateFuncMat(VendaItem vendaItem);

	VendaItem updateDiaMesAno(VendaItem vendaItem);

	VendaItem updateDesconto(VendaItem vendaItem);

	VendaItem deletePorNotaFiscal(VendaItem vendaItem);
	

}
