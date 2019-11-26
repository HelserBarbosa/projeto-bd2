package br.com.unifacisa.projetobd2.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.projetobd2.daos.AnimalDAO;
import br.com.unifacisa.projetobd2.dtos.ConsultaLucroDTO;
import br.com.unifacisa.projetobd2.models.Animal;

@Service
public class AnimalService {

	@Autowired
	private AnimalDAO dao;
	
	public Animal inserirAnimal(Animal animal) {
		return dao.inserirAnimal(animal);
	}
	
	public Animal inserirAnimalSemPesoAlturaMedicao(Animal animal) {
		return dao.inserirAnimalSemPesoAlturaMedicao(animal);
	}
	
	public Animal inserirAnimalSemPrecoVenda(Animal animal) {
		return dao.inserirAnimalSemPrecoVenda(animal);
	}
	
	public Animal inserirAnimalSemPrecoCompra(Animal animal) {
		return dao.inserirAnimalSemPrecoCompra(animal);
	}
	
	public Animal inserirAnimalSemPrecoCompraVenda(Animal animal) {
		return dao.inserirAnimalSemPrecoCompraVenda(animal);
	}
	
	public Animal inserirAnimalSemDataNasc(Animal animal) {
		return dao.inserirAnimalSemDataNasc(animal);
	}
	public void updateAnimalPesoAlturaDtaMed(Animal animal) {
		dao.updateAnimalAlturaDtaMed(animal);
	}
	
	public void updateAnimalPrecoCompra(Animal animal) {
		dao.updateAnimalPrecoCompra(animal);
	}
	public void updateAnimalPrecoCompraVenda(Animal animal) {
		dao.updateAnimalPrecoCompraVenda(animal);
	}
	public void updateAnimalTipo(Animal animal) {
		dao.updateAnimalTipo(animal);
	}
	public void updateAnimalRaca(Animal animal) {
		dao.updateAnimalRaca(animal);
	}
	
	public void updateAnimalTipoRaca(Animal animal) {
		dao.updateAnimalTipoRaca(animal);
	}
	
	public void deletarAnimalPorRegistro(Long registro) {
		dao.deletarAnimalPorRegistro(registro);
	}
	
	public void deletarAnimalPorTipo(String tipo) {
		dao.deletarAnimalPorTipo(tipo);
	}
	
	public List<Animal> listar(){
		return dao.listar();
	}
	
	public List<Animal> listarPorTipo(String tipo){
		return dao.listarPorTipo(tipo);
	}
	
	public List<Animal> listarPorPrecoVenda(BigDecimal precoVenda){
		return dao.listarPorPrecoVenda(precoVenda);
	}
	
	public List<ConsultaLucroDTO> consultaLucro(){
		return dao.consultaLucro();
	}
}
