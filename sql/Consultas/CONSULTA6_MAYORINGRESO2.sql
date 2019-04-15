SELECT tt.hotel, 
       dm."dia", 
       dm."mes", 
       tt.maxi 
FROM   (SELECT hotel, 
               Max(ingremax) AS maxi 
        FROM   (SELECT hotel, 
               "mes", 
               "dia", 
               Sum(monto) AS INGREMAX
        FROM   (SELECT ha.idhotel AS hotel, 
                       Extract (day FROM h.fechainicio)  AS "dia", 
                       Extract(month FROM h.fechainicio) AS "mes", 
                       cu.valor AS monto 
                FROM   hotel hot,
                       servicioalojamiento sa,
                       horario h,
                       reserva re,
                       cuenta cu,
                       habitacion ha,
                       tipohabitacion th,
                       servicioalojamientohabitacion sah
                WHERE  re.idcuenta = cu.idcuenta 
                       AND hot.idhotel = ha.idhotel
                       AND h.idhorario = re.idhorario
                       AND th.nombretipo = ha.tipohabitacion
                       AND sa.idservicioalojamiento = sah.idservicioalojamiento
                       AND sah.idhabitacion = ha.idhabitacion
                       AND ha.tipohabitacion LIKE ?
                       AND Extract(year FROM h.fechainicio) = ?) 
        GROUP  BY hotel, 
                  "mes", 
                  "dia") 
        GROUP  BY hotel) tt, 
       (SELECT hotel, 
               "mes", 
               "dia", 
               Sum(monto) AS demandamaxima
        FROM   (SELECT ha.idhotel AS hotel, 
                       Extract (day FROM h.fechainicio)  AS "dia", 
                       Extract(month FROM h.fechainicio) AS "mes", 
                       cu.valor AS monto 
                FROM   hotel hot,
                       servicioalojamiento sa,
                       horario h,
                       reserva re,
                       cuenta cu,
                       habitacion ha,
                       tipohabitacion th,
                       servicioalojamientohabitacion sah
                WHERE  re.idcuenta = cu.idcuenta 
                       AND hot.idhotel = ha.idhotel
                       AND h.idhorario = re.idhorario
                       AND th.nombretipo = ha.tipohabitacion
                       AND sa.idservicioalojamiento = sah.idservicioalojamiento
                       AND sah.idhabitacion = ha.idhabitacion
                       AND ha.tipohabitacion LIKE ?
                       AND Extract(year FROM h.fechainicio) = ?) 
        GROUP  BY hotel, 
                  "mes", 
                  "dia") dm 
WHERE  tt.maxi = dm.demandamaxima; 