SELECT t1.hotel, 
       tb."dia" AS DIA,
       tb."month" AS MES, 
       t1.maxi AS MAYOR_DEMANDA
FROM   (SELECT hotel, 
               Max(ingremax) AS maxi 
        FROM   (SELECT hotel, 
                       "month", 
                       "dia", 
                       Sum(monto) AS INGREMAX 
                FROM   (SELECT ps.idhotel                AS Hotel, 
                               Extract (day FROM tc.fecha)  AS "dia", 
                               Extract(month FROM tc.fecha) AS "month", 
                               cc.cantidadproducto          AS monto 
                        FROM   producto p, 
                               productosuministrado ps, 
                               transaccioncliente tc, 
                               compra cc 
                        WHERE  p.codigodebarras = ps.codigodebarras 
                               AND tc.id = cc.idtransaccion 
                               AND cc.codigoproducto = ps.codigodebarras 
                               AND p.tipo = 'Carnes' 
                               AND Extract(year FROM tc.fecha) = 2018) 
                GROUP  BY hotel, 
                          "month", 
                          "dia") 
        GROUP  BY hotel) t1, 
       (SELECT hotel, 
               "month", 
               "dia", 
               Sum(monto) AS "Demanda máxima" 
        FROM   (SELECT ps.idhotel                AS Hotel, 
                       Extract (day FROM tc.fecha)  AS "dia", 
                       Extract(month FROM tc.fecha) AS "month", 
                       cc.cantidadproducto          AS monto 
                FROM   producto p, 
                       productosuministrado ps, 
                       transaccioncliente tc, 
                       compra cc 
                WHERE  p.codigodebarras = ps.codigodebarras 
                       AND tc.id = cc.idtransaccion 
                       AND cc.codigoproducto = ps.codigodebarras 
                       AND p.tipo = 'Carnes' 
                       AND Extract(year FROM tc.fecha) = 2019) 
        GROUP  BY hotel, 
                  "month", 
                  "dia") tb 
WHERE  t1.maxi = tb."demanda maxima"; 