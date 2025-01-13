DROP DATABASE IF EXISTS apihoteles;
CREATE DATABASE apihoteles;
USE apihoteles;

create table habitaciones (
    id_habitacion bigint not null auto_increment,
    desayuno bool not null,
    ocupada bool not null,
    precio float(23) not null,
    tamano integer not null,
    id_hotel bigint,
    primary key (id_habitacion)
) engine=InnoDB;

create table hoteles (
    id_hotel bigint not null auto_increment,
    categoria varchar(255),
    descripcion varchar(255),
    localidad varchar(255),
    nombre varchar(255),
    piscina bool not null,
    primary key (id_hotel)
) engine=InnoDB;

alter table habitaciones
    add constraint FKdt09g936qaeh78qp1130b8qnk
        foreign key (id_hotel)
            references hoteles (id_hotel);

INSERT INTO hoteles(categoria, descripcion, localidad, nombre, piscina) VALUES('1', 'hotel 1', 'Valladolid', 'hotel 1', false);
INSERT INTO hoteles(categoria, descripcion, localidad, nombre, piscina) VALUES('2', 'hotel 2', 'Valladolid', 'hotel 2', true);
INSERT INTO hoteles(categoria, descripcion, localidad, nombre, piscina) VALUES('1', 'hotel 3', 'Madrid', 'hotel 3', false);

INSERT INTO habitaciones(desayuno, ocupada, precio, tamano, id_hotel) VALUES(false, false, 3.40, 2, 1);
INSERT INTO habitaciones(desayuno, ocupada, precio, tamano, id_hotel) VALUES(true, true, 6.40, 1, 1);
INSERT INTO habitaciones(desayuno, ocupada, precio, tamano, id_hotel) VALUES(false, false, 1.40, 1, 1);

INSERT INTO habitaciones(desayuno, ocupada, precio, tamano, id_hotel) VALUES(true, true, 10.40, 2, 2);
INSERT INTO habitaciones(desayuno, ocupada, precio, tamano, id_hotel) VALUES(true, false, 10.40, 2, 2);
INSERT INTO habitaciones(desayuno, ocupada, precio, tamano, id_hotel) VALUES(true, false, 7.40, 1, 2);