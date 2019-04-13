package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.CuentaAlojamiento;

public class SQLCuentaAlojamiento {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLCuentaAlojamiento(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarCuentaAlojamiento (PersistenceManager pm, long idCuenta, long idServicioAlojamiento) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO CuentaAlojamiento (idCuenta, idServicioAlojamiento) values (?, ?)");
        q.setParameters(idCuenta, idServicioAlojamiento);
        return (long) q.executeUnique();
	}
	
	public long eliminarCuentaAlojamientoPorId (PersistenceManager pm, long idCuentaAlojamiento, long idCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM CuentaAlojamiento WHERE idServicioAlojamiento = ? AND idCuenta = ?");
        q.setParameters(idCuentaAlojamiento, idCuenta);
        return (long) q.executeUnique();
	}
	
	public CuentaAlojamiento darCuentaAlojamientoPorId (PersistenceManager pm, long idCuentaAlojamiento, long idCuenta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM CuentaAlojamiento WHERE idServicioAlojamiento = ? AND idCuenta = ?");
		q.setResultClass(CuentaAlojamiento.class);
		q.setParameters(idCuentaAlojamiento, idCuenta);
		return (CuentaAlojamiento) q.executeUnique();
	}
	
	public List<CuentaAlojamiento> darCuentaAlojamiento (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM CuentaAlojamiento");
		q.setResultClass(CuentaAlojamiento.class);
		return (List<CuentaAlojamiento>) q.executeList();
	}
}
