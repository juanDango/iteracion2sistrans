SELECT idcliente 
FROM   (SELECT idcliente, 
               Count(*) AS MESESCONSECUTIVOS 
        FROM   (SELECT idcliente, 
                       mes, 
                       anio, 
                       Count(*) compras 
                FROM   (SELECT re.idcliente, 
                               Extract (month FROM h.fechaInicio) AS mes, 
                               Extract (year FROM h.fechaInicio)  AS anio 
                        FROM   horario h,
                               cuenta cu,
                               reserva re,
                               servicioalojamiento sa
                               WHERE  h.idhorario = re.idhorario
                               AND sa.idcuenta = cu.idcuenta
                               AND (DATEDIFF(DAY, h.fechainicio, h.fechafinal)>=14) OR cu.valor >= 15000000)
                GROUP  BY mes, 
                          anio, 
                          idcliente) 
        WHERE  compras >= 2 
        GROUP  BY idcliente) 
WHERE  mesesconsecutivoscomprando >= ( ( (SELECT Extract(year FROM sysdate) 
                                          FROM   dual) - (SELECT Extract( 
                                                         year FROM fechamenor) 
                                                          FROM   (SELECT 
                                         Min(h.fechaInicio) AS fechaMenor 
                                         FROM reserva re, horario h
                                         WHERE re.idhorario = h.idhorario
                                         )) ) * 12 ) 
                                            + 
                                                          ( (SELECT Extract( 
                                                            month FROM sysdate) 
                                                             FROM   dual) - 
                                     (SELECT 
                                     Extract(month FROM 
                                             fechamenor) 
                                                      FROM 
                                     (SELECT Min(h.fechaInicio) AS 
                                             fechaMenor 
                                      FROM   reserva re, horario h
                                         WHERE re.idhorario = h.idhorario)) 
                                                          ) 

