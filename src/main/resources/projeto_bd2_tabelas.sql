CREATE TABLE animal(
	registro serial,
	tipo varchar(200),
	peso numeric(10,2),
	altura numeric(10,2),
	dat_ult_med date,
	raca varchar(200),
	preco_compra numeric(10,2),
	preco_venda numeric(10,2),
	dat_nasc date,
	CONSTRAINT animal_pk PRIMARY KEY(registro) 
);

CREATE TABLE funcionario(
	matricula serial,
	nome varchar(200),
	cpf int,
	endereco varchar(200),
	telefone varchar(200),
	salario numeric(10,2),
	dat_nasc date,
	dat_adm date,
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
	nota_fiscal int,
	reg_animal int,
	mat_func int,
	dia varchar(2),
	mes varchar(2),
	ano varchar(2),
	comissao_a numeric(10,2),
	desconto numeric(10,2),
	valor_final numeric(10,2),
	CONSTRAINT venda_animal_pk PRIMARY KEY(nota_fiscal),
	CONSTRAINT reg_animal_fk FOREIGN KEY(reg_animal) REFERENCES animal(registro),
	CONSTRAINT mat_func_fk FOREIGN KEY(mat_func) REFERENCES funcionario(matricula)
);

CREATE TABLE venda_item(
	nota_fiscal int,
	item_cod int,
	mat_func int,
	dia varchar(2),
	mes varchar(2),
	ano varchar(2),
	comissao_item numeric(10,2),
	desconto numeric(10,2),
	valor_final numeric(10,2),
	CONSTRAINT venda_intem_pk PRIMARY KEY(nota_fiscal),
	CONSTRAINT item_cod_fk FOREIGN KEY(item_cod) REFERENCES item(codigo),
	CONSTRAINT mat_func_fk FOREIGN KEY(mat_func) REFERENCES funcionario(matricula)
);

