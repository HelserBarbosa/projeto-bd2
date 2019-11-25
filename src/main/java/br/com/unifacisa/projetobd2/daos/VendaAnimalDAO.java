package br.com.unifacisa.projetobd2.daos;

import br.com.unifacisa.projetobd2.models.VendaAnimal;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface VendaAnimalDAO {

    VendaAnimal insertComTodosOsDados(VendaAnimal vendaAnimal);

    VendaAnimal insertSemInformarDesconto(VendaAnimal vendaAnimal);

    void deleteVendaPorNotaFiscal(Long notaFiscal);

    VendaAnimal updateNotaFiscalPelaNotaFiscal(VendaAnimal vendaAnimal);

    VendaAnimal updateRegAnimalPorNotaFiscal(VendaAnimal vendaAnimal);

    VendaAnimal updateMatFuncPorNotaFiscal(VendaAnimal vendaAnimal);

    VendaAnimal updateDiaMesAnoPorNotaFiscal(VendaAnimal vendaAnimal);

    VendaAnimal updateDisconto(BigDecimal novoDesconto);

}
