create database wiki;

use wiki;

create table autor(
id int auto_increment primary key not null,
nome varchar(50) not null
);

create table editora(
codigo int auto_increment primary key not null,
editora varchar(50) not null
);

create table manga(
id int auto_increment primary key not null,
autor_id int not null,
editora_id int not null,
titulo varchar(100) not null,
genero varchar(100) not null,
volume int not null,
dt_lancamento date null,
status varchar(50) not null,
link varchar(250) not null,
foreign key(autor_id) references autor(id),
foreign key(editora_id) references editora(codigo)
);

create table usuario(
usuario varchar(200) primary key not null,
senha varchar(200) not null
);

insert into autor values
('Masashi Kishimoto'),
('Eiichiro Oda'),
('Hiromu Arakawa');

insert into editora values
('Panini Comics'),
('JBC');

insert into manga values
(1, 1, 'Naruto', 'Aventura, comédia, fantasia, shounen', 27, '01/05/2007', 'Concluído', 'http://cdmnet.com.br/titulos/naruto'),
(2, 1, 'One Piece', 'Ação, aventura, fantasia, shounen', 81, '01/02/2012', 'Em andamento', 'http://cdmnet.com.br/titulos/one-piece'),
(3, 2, 'Fullmetal Alchemist', 'Ação, aventura, comédia, drama, shounen', 54, '16/01/2007', 'Concluído', 'https://lermangasonline.info/manga/fullmetal-alchemist/');

insert into usuario values
('admin', aes_encrypt('admin', 'key'));

select usuario, cast(aes_decrypt(senha, 'key') as varchar(200)) from usuario 

select a.nome, e.editora, m.titulo, m.genero, m.volume, convert(char(10), m.dt_lancamento, 103) as data_publicacao, m.status, m.link
from manga m
inner join autor a 
on a.id = m.autor_id
inner join editora e 
on e.codigo = m.editora_id