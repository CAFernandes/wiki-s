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
estado varchar(50) not null,
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

insert into manga(autor_id, editora_id, titulo, genero, volume, dt_lancamento, estado, link) values
(1, 1, 'Naruto', 'Aventura, comédia, fantasia, shounen', 27, '2007-05-01', 'Concluído', 'http://cdmnet.com.br/titulos/naruto'),
(2, 1, 'One Piece', 'Ação, aventura, fantasia, shounen', 81, '2012-02-01', 'Em andamento', 'http://cdmnet.com.br/titulos/one-piece'),
(3, 2, 'Fullmetal Alchemist', 'Ação, aventura, comédia, drama, shounen', 54, '2007-01-16', 'Concluído', 'https://lermangasonline.info/manga/fullmetal-alchemist/');

insert into usuario values
('admin', aes_encrypt('admin', 'key'));

select aes_decrypt(senha, 'key') as valido from usuario WHERE usuario = 'admin'

select a.nome, e.editora, m.titulo, m.genero, m.volume, m.dt_lancamento as data_publicacao, m.estado, m.link
from manga m
inner join autor a 
on a.id = m.autor_id
inner join editora e 
on e.codigo = m.editora_id
WHERE m.titulo LIKE '%a%'