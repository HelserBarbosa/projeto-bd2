package br.com.unifacisa.projetobd2.daos;

import br.com.unifacisa.projetobd2.models.VendaAnimal;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface VendaAnimalDAO {

	VendaAnimal insertComTodosOsDados(VendaAnimal vendaAnimal);

	VendaAnimal insertSemInformarDesconto(VendaAnimal vendaAnimal);

	void deleteVendaPorNotaFiscal(Long notaFiscal);

	boolean updateNotaFiscalPelaNotaFiscal(Long antigaNotaFiscal, Long novaNotaFiscal);

	boolean updateRegAnimalPorNotaFiscal(VendaAnimal vendaAnimal);

	boolean updateMatFuncPorNotaFiscal(VendaAnimal vendaAnimal);

	boolean updateDiaMesAnoPorNotaFiscal(VendaAnimal vendaAnimal);

	boolean updateDisconto(BigDecimal novoDesconto);

}
