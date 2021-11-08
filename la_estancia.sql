
create database la_estancia;
use la_estancia;

create table habitaciones(
    id_habitacion int primary key not null,
    tipo_habitacion varchar(50),
    estatus varchar(10) default "Disponible",
    no_habitacion int not null,
    costo float
);

create table reservaciones( 
    id_reservacion int primary key not null,
    fecha_entrada varchar(10),
    fecha_salida varchar(10),
    dias int, 
    id_habitacion int not null,
    foreign key(id_habitacion) references habitaciones(id_habitacion) 
);

insert into habitaciones(id_habitacion, tipo_habitacion, no_habitacion, costo)
values(1,"Sencilla", 1, 250),
(2,"Doble", 2, 250),
(3,"Triple", 3, 450),
(4,"Cuádruple", 4, 650),
(5,"Sencilla", 5, 250),
(6,"Triple", 6, 450),
(7,"Cuádruple", 7, 650),
(8,"Doble", 8, 250),
(9,"Sencilla", 8, 250),
(10,"Sencilla", 8, 250);