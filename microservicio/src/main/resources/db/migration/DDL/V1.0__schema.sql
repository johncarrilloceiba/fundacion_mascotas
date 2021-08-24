create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table contacto (
 cont_id int(11) not null auto_increment,
 cont_nombre varchar(50) not null,
 cont_numero varchar(15) not null,
 primary key (cont_id)
);

create table raza (
 raza_id int(11) not null auto_increment,
 raza_nombre varchar(50) not null,
 primary key (raza_id)
);

create table mascota (
 masc_id int(11) not null auto_increment,
 masc_nombre varchar(50) not null,
 raza_id int(11) not null,
 masc_fecha_adopcion datetime null,
 masc_fecha_nacimiento datetime null,
 cont_id int(11) null,
 primary key (masc_id),
 constraint fk_mascota_raza foreign key(raza_id) references raza(raza_id),
 constraint fk_mascota_contacto foreign key(cont_id) references contacto(cont_id)
);

create table donacion (
 dona_id int(11) not null auto_increment,
 dona_valor varchar(50) not null,
 dona_fecha_creacion datetime null,
 masc_id int(11) not null,
 primary key (dona_id),
 constraint fk_donacion_mascota foreign key(masc_id) references mascota(masc_id)
);
