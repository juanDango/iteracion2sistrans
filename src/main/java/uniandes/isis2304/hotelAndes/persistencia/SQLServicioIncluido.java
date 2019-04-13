package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.ServicioIncluido;

public class SQLServicioIncluido {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLServicioIncluido(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarServicioIncluido (PersistenceManager pm, long idServicioIncluido, String nombre, long capacidad, long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ServicioIncluido (idServicio, nombre, capacidad, idHotel) values (?, ?, ?, ?)");
        q.setParameters(idServicioIncluido, nombre, capacidad, idHotel);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioIncluidoPorId (PersistenceManager pm, long idServicioIncluido)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM ServicioIncluido WHERE idServicio = ?");
        q.setParameters(idServicioIncluido);
        return (long) q.executeUnique();
	}
	
	public ServicioIncluido darServicioIncluidoPorId (PersistenceManager pm, long idServicioIncluido) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioIncluido WHERE idServicio = ?");
		q.setResultClass(ServicioIncluido.class);
		q.setParameters(idServicioIncluido);
		return (ServicioIncluido) q.executeUnique();
	}
	
	public List<ServicioIncluido> darServicioIncluido (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioIncluido");
		q.setResultClass(ServicioIncluido.class);
		return (List<ServicioIncluido>) q.executeList();
	}
}
