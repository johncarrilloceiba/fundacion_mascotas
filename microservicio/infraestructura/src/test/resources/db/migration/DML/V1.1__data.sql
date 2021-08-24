insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into raza(raza_nombre) values('Bulldog');

insert into contacto (cont_nombre, cont_numero) values ('John Jairo Carrillo', '3004230343');

insert into  mascota (masc_nombre, raza_id, masc_fecha_adopcion, masc_fecha_nacimiento, cont_id) values ('Lomito', 1, null, now(), null);

insert into  donacion (dona_valor, dona_fecha_creacion, masc_id) values (50000, now(), 1);