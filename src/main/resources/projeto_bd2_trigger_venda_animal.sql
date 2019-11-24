--drop trigger trg_calcula_valor_final_e_comissao on venda_animal cascade;
--drop function calcula_valor_final();

CREATE OR REPLACE FUNCTION calcula_valor_final_e_comissao()
RETURNS TRIGGER AS $$
	DECLARE
		preco_venda NUMERIC(10,2);
	BEGIN
		SELECT an.preco_venda 
		INTO preco_venda
		FROM animal an
		WHERE an.registro = NEW.reg_animal;
		
		UPDATE venda_animal SET valor_final = preco_venda - (preco_venda * (NEW.desconto/100))
		WHERE reg_animal = NEW.reg_animal;
		
		UPDATE venda_animal SET comissao_a = valor_final * 0.05
		WHERE reg_animal = NEW.reg_animal;
		
		RETURN NEW;
	END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER trg_calcula_valor_final_e_comissao
AFTER INSERT OR UPDATE OF desconto ON venda_animal
FOR EACH ROW EXECUTE FUNCTION calcula_valor_final_e_comissao();
