update mascota
set masc_nombre = :nombre,
	raza_id = :idRaza,
	masc_fecha_adopcion = :fechaAdopcion,
	cont_id = :idContacto
where masc_id = :id