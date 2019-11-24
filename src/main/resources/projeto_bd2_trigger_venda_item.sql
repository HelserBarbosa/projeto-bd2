
CREATE OR REPLACE FUNCTION calcula_valor_final_e_comissao_item()
RETURNS TRIGGER AS $$
	DECLARE
		preco_venda NUMERIC(10,2);
	BEGIN
		SELECT i.preco_loja 
		INTO preco_venda
		FROM item i
		WHERE i.codigo = NEW.item_cod;
		
		UPDATE venda_item SET valor_final = preco_venda - (preco_venda * (NEW.desconto/100))
		WHERE item_cod = NEW.item_cod;
		
		UPDATE venda_item SET comissao_item = valor_final * 0.02
		WHERE item_cod = NEW.item_cod;
		
		RETURN NEW;
	END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER trg_calcula_valor_final_e_comissao_item
AFTER INSERT OR UPDATE OF desconto ON venda_item
FOR EACH ROW EXECUTE FUNCTION calcula_valor_final_e_comissao_item();