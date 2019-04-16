SELECT idserviciocomplementario, count(idserviciocomplementario)
FROM CUENTASERVICIO
WHERE ROWNUM <= 20
GROUP BY idServicioComplementario
ORDER BY count(idserviciocomplementario) desc;