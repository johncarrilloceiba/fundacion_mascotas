update donacion
set dona_valor = :valor,
	dona_fecha_creacion = :fechaCreacion,
	masc_id = :idMascota
where dona_id = :id