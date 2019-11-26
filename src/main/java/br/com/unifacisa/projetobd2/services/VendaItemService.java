package br.com.unifacisa.projetobd2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.projetobd2.daos.VendaItemDAO;
import br.com.unifacisa.projetobd2.models.VendaItem;

@Service
public class VendaItemService {

	@Autowired
	private VendaItemDAO dao;
	
	public VendaItem insertCompleto(VendaItem vendaItem) {
		return dao.insertCompleto(vendaItem);
	}
	
	public VendaItem insertSemDesconto(VendaItem vendaItem) {
		return dao.insertSemDesconto(vendaItem);
	}
	
	public VendaItem updateItemCod(VendaItem vendaItem) {
		return dao.updateItemCod(vendaItem);
	}
	
	public VendaItem updateFuncMat(VendaItem vendaItem) {
		return dao.updateFuncMat(vendaItem);
	}
	
	public VendaItem updateDiaMesAno(VendaItem vendaItem) {
		return dao.updateDiaMesAno(vendaItem);
	}
	
	public VendaItem updateDesconto(VendaItem vendaItem) {
		return dao.updateDesconto(vendaItem);
	}
	
	public VendaItem deletePorNotaFiscal(VendaItem vendaItem) {
		return dao.deletePorNotaFiscal(vendaItem);
	}
	
	public List<VendaItem> listar(){
		return dao.listar();
	}
	
	public List<VendaItem> listarPorDescricaoItem(String nome){
		return dao.listarPorDescricaoItem(nome);
	}
	
	public List<VendaItem> listarPorDescricaoItem(Integer dia, Integer mes, Integer ano, String nome){
		return dao.listarPorDescricaoItem(dia, mes, ano, nome);
	}
}
