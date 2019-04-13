package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.ServicioAlojamiento;

public class SQLServicioAlojamiento {

private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLServicioAlojamiento(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarServicioAlojamiento (PersistenceManager pm, long idServicioAlojamiento, int cantidadPersonas, long idCuenta) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ServicioAlojamiento (idServicioAlojamiento, cantidadPersonas, idCuenta) values (?, ?, ?)");
        q.setParameters(idServicioAlojamiento, cantidadPersonas, idCuenta);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioAlojamientoPorId (PersistenceManager pm, long idServicioAlojamiento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM ServicioAlojamiento WHERE idServicioAlojamiento = ?");
        q.setParameters(idServicioAlojamiento);
        return (long) q.executeUnique();
	}
	
	public ServicioAlojamiento darServicioAlojamientoPorId (PersistenceManager pm, long idServicioAlojamiento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioAlojamiento WHERE idServicioAlojamiento = ?");
		q.setResultClass(ServicioAlojamiento.class);
		q.setParameters(idServicioAlojamiento);
		return (ServicioAlojamiento) q.executeUnique();
	}
	
	public List<ServicioAlojamiento> darServicioAlojamiento (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioAlojamiento");
		q.setResultClass(ServicioAlojamiento.class);
		return (List<ServicioAlojamiento>) q.executeList();
	}
}
