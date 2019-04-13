SELECT ha.idhabitacion AS "NumeroHabitacion" , SUM(cu.valor) AS "DineroRecolectado"
FROM CUENTA cu
INNER JOIN CUENTAALOJAMIENTO ca ON cu.idcuenta = ca.idcuenta
INNER JOIN SERVICIOALOJAMIENTO sa ON sa.idservicioalojamiento = ca.idservicioalojamiento
INNER JOIN HABITACION ha ON re.idhabitacion = ha.idhabitacion
INNER JOIN RESERVA re ON re.idCuenta = cu.idCuenta AND su.id = es.idsucursal
INNER JOIN HORARIO ho ON re.idhorario = ho.idhorario
GROUP BY ha.idhabitacion HAVING ho.fechainicio BETWEEN ? AND ?;