SELECT idserviciocomplementario, count(idserviciocomplementario)
FROM CUENTASERVICIO
WHERE ROWNUM <= 20
ORDER BY count(idserviciocomplementario) desc;