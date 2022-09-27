use anotacao;

drop table tra_trabalho;

create table tra_trabalho (
    tra_id bigint primary key auto_increment,
    tra_titulo varchar(100) not null unique,
    tra_descricao varchar(200),
    tra_nota int 
);
insert into tra_trabalho (tra_titulo, tra_descricao, tra_nota)
    values('Teste 1', 'Trabalho para avaliação 1', 6),
          ('Teste 2', 'Trabalho para avaliação 2', 3);
