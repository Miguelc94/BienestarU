drop schema pn2;
create schema pn2;

use pn2;

# use miguelcc_pn2;

create trigger PRESTAMO
after update on `productos`
for each row
insert into `prestamos` values (new.fecha_devolucion, new.fecha_prestamo, new.solicitante, new.nombre_producto);


insert into usuarios values
('admin', 'admin');

insert into categorias (nombre) values
('Juegos de mesa'),
('Consolas'),
('Cartas'),
('Balones de Futbol'),
('Balones de Voleibol');

insert into productos (categoria, estado, nombre) values
(1, 1, 'Parques'),
(2, 1, 'PS4'),
(4, 0, 'Balon Futsal');

create table if not exists usuarios(
usuario varchar(100) primary key,
contrasena varchar(100)
);

create table if not exists categorias(
id int(10) primary key auto_increment,
nombre varchar(100)
);

create table if not exists productos(
id int(10) primary key auto_increment,
nombre varchar(100),
estado boolean,
codigoCategoria int(10),
key `foreing categoria` (codigoCategoria)
);