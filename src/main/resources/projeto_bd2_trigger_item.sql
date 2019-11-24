DROP FUNCTION decrementa_qtd_item();
CREATE OR REPLACE FUNCTION decrementa_qtd_item()
RETURNS TRIGGER AS $$
	DECLARE 
		quantidade_item int;
	BEGIN
		SELECT i.quantidade 
		INTO quantidade_item
		FROM item i 
		WHERE i.codigo = NEW.item_cod;
		
		IF quantidade_item = 0 THEN
			RAISE EXCEPTION 'Não existe itens em estoque!';
		ELSE
			UPDATE item SET quantidade = quantidade - 1 WHERE codigo = NEW.item_cod;
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER trg_decrementa_qtd_item
AFTER INSERT ON venda_item
FOR EACH ROW EXECUTE FUNCTION decrementa_qtd_item();

