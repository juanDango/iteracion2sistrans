package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.ServicioLavanderia;

public class SQLServicioLavanderia {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLServicioLavanderia(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarServicioLavanderia (PersistenceManager pm, long idServicioLavanderia, String nombre, String nombreServicio, String descripcion, String tipo, long costoUnitario, long cantUnidades) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ServicioLavanderia (idServicio, nombre, nombreServicio, descripcion, tipo, costoUnitario, cantUnidades) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idServicioLavanderia, nombre, nombreServicio, descripcion, tipo, costoUnitario, cantUnidades);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioLavanderiaPorId (PersistenceManager pm, long idServicioLavanderia)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM ServicioLavanderia WHERE idServicio = ?");
        q.setParameters(idServicioLavanderia);
        return (long) q.executeUnique();
	}
	
	public ServicioLavanderia darServicioLavanderiaPorId (PersistenceManager pm, long idServicioLavanderia) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioLavanderia WHERE idServicio = ?");
		q.setResultClass(ServicioLavanderia.class);
		q.setParameters(idServicioLavanderia);
		return (ServicioLavanderia) q.executeUnique();
	}
	
	public List<ServicioLavanderia> darServicioLavanderia (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioLavanderia");
		q.setResultClass(ServicioLavanderia.class);
		return (List<ServicioLavanderia>) q.executeList();
	}
}
