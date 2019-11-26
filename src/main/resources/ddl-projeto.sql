CREATE TABLE animal(
                       registro serial,
                       tipo varchar(200),
                       peso numeric(10,2),
                       altura numeric(10,2),
                       dat_ult_med date,
                       raca varchar(200),
                       preco_compra numeric(10,2) DEFAULT 0.00,
                       preco_venda numeric(10,2),
                       dat_nasc date,
                       CONSTRAINT animal_pk PRIMARY KEY(registro)
);

CREATE TABLE funcionario(
                            matricula serial,
                            nome varchar(200),
                            cpf varchar(50),
                            endereco varchar(200),
                            telefone varchar(200),
                            salario numeric(10,2),
                            dat_nasc date,
                            dat_adm date,
                            funcao VARCHAR(200),
                            dat_demissao date,
                            CONSTRAINT funcionario_pk PRIMARY KEY(matricula)
);

CREATE TABLE item(
                     codigo serial,
                     descricao varchar(200),
                     tipo varchar(200),
                     preco_fornecedor numeric(10,2),
                     preco_loja numeric(10,2),
                     validade date,
                     quantidade int,
                     CONSTRAINT item_pk PRIMARY KEY(codigo)
);

CREATE TABLE venda_animal(
                             nota_fiscal serial,
                             reg_animal int,
                             mat_func int,
                             dia int,
                             mes int,
                             ano int,
                             comissao_a numeric(10,2),
                             desconto numeric(10,2) DEFAULT 0.00,
                             valor_final numeric(10,2),
                             CONSTRAINT venda_animal_pk PRIMARY KEY(nota_fiscal),
                             CONSTRAINT reg_animal_fk FOREIGN KEY(reg_animal) REFERENCES animal(registro) ON DELETE CASCADE,
                             CONSTRAINT mat_func_fk FOREIGN KEY(mat_func) REFERENCES funcionario(matricula) ON DELETE CASCADE
);

CREATE TABLE venda_item(
                           nota_fiscal serial,
                           item_cod int,
                           mat_func int,
                           dia int,
                           mes int,
                           ano int,
                           comissao_item numeric(10,2),
                           desconto numeric(10,2) DEFAULT 0.00,
                           valor_final numeric(10,2),
                           CONSTRAINT venda_intem_pk PRIMARY KEY(nota_fiscal),
                           CONSTRAINT item_cod_fk FOREIGN KEY(item_cod) REFERENCES item(codigo) ON DELETE CASCADE,
                           CONSTRAINT mat_func_fk FOREIGN KEY(mat_func) REFERENCES funcionario(matricula) ON DELETE CASCADE
);
-----------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION folha_salarial(mes_folha int, ano_folha int)
    RETURNS NUMERIC(10,2) AS $$
DECLARE
    som_sal numeric(10,2);
BEGIN
    SELECT SUM(f.salario)
    INTO som_sal
    FROM funcionario f
    WHERE f.mes = mes_folha
      AND f.ano = ano_folha;

    RETURN som_sal;
END;
$$ LANGUAGE 'plpgsql';
----------------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION set_comissao_salario(mat int, mes_compra int, ano_compra int)
    RETURNS NUMERIC(10,2) AS $$
DECLARE
    salario_inicial NUMERIC(10,2);
    comissao_item NUMERIC(10,2);
    comissao_animal NUMERIC(10,2);
BEGIN
    SELECT SUM(vi.comissao_item)
    INTO comissao_item
    FROM venda_item vi
    WHERE vi.mat_func = mat
      AND vi.mes = mes_compra
      AND vi.ano = ano_compra;

    SELECT SUM(va.comissao_a)
    INTO comissao_animal
    FROM venda_animal va
    WHERE va.mat_func = mat
      AND va.mes = mes_compra
      AND va.ano = ano_compra;

    SELECT f.salario
    INTO salario_inicial
    FROM funcionario f
    WHERE f.matricula = mat;

    RETURN salario_inicial + comissao_item + comissao_animal;
END;
$$ LANGUAGE 'plpgsql';
--------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION set_salario()
    RETURNS TRIGGER AS $$
BEGIN
    IF NEW.funcao = 'atendente' THEN
        UPDATE funcionario f SET salario = 1000.00 WHERE f.matricula = NEW.matricula;
    ELSIF NEW.funcao = 'caixa' THEN
        UPDATE funcionario f SET salario = 1500.00 WHERE f.matricula = NEW.matricula;
    ELSIF NEW.funcao = 'veterinário' THEN
        UPDATE funcionario f SET salario = 5000.00 WHERE f.matricula = NEW.matricula;
    ELSIF NEW.funcao = 'cuidador' THEN
        UPDATE funcionario f SET salario = 2000.00 WHERE f.matricula = NEW.matricula;
    ELSIF NEW.funcao = 'gerente' THEN
        UPDATE funcionario f SET salario = 4000.00 WHERE f.matricula = NEW.matricula;
    ELSE
        RAISE EXCEPTION 'Função não encontrada no quadro de funcionários';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER trg_set_salario
    AFTER INSERT ON funcionario
    FOR EACH ROW EXECUTE FUNCTION set_salario();
----------------------------------------------------------------------------------------------------------------
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
--------------------------------------------------------------------------------------------------------------
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