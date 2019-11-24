
INSERT INTO funcionario VALUES(1, 'Ted', 50156, 'rua lins', '8399999999', 1000.00, '19/05/1990', '01/03/2019', null);

INSERT INTO item  VALUES(1, 'Ossinho', 'Brinquedo', 80.00, 100.00, '01/01/2023', 10);

INSERT INTO animal VALUES(2, 'doguinho', 5.00, 0.34, '21/11/2019', 'pinscher', 0, 100.00, '01/01/2019');

INSERT INTO venda_item(nota_fiscal, item_cod, mat_func, dia, mes, ano, desconto) VALUES(1, 1, 1, 19, 5, 2019, 10);

INSERT INTO venda_animal(nota_fiscal, reg_animal, mat_func, dia, mes, ano, desconto) VALUES(2, 2, 1, 19, 5, 2019, 10);

DELETE FROM venda_item WHERE nota_fiscal = 1;

UPDATE venda_item SET desconto = 20 where nota_fiscal = 1;

select * from item;
select * from venda_item;