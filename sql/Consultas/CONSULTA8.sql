 SELECT t1.cod
FROM (SELECT ip.codigoproducto AS cod , EXTRACT(week from shc.fechaInicio) AS semana , COUNT(*) AS contador
    FROM horario h INNER JOIN servicioHotelComplementario shc ON shc.idhorario = h.idhorario
    GROUP BY h.fechaInicio 
    ORDER BY cod, h.fechaInicio )t1
WHERE t1.contador < 3;

