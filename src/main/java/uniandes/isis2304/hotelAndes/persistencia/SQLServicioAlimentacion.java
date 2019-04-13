package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.ServicioAlimentacion;

public class SQLServicioAlimentacion {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLServicioAlimentacion(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarServicioAlimentacion (PersistenceManager pm, long idServicioAlimentacion, String nombre, String estilo, long capacidad, String tipo, char esConsumo, long idHorario, String descripcion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ServicioAlimentacion (idServicio, nombreservicio, estilo, capacidad, tipo, esconsumohabitacion, idHorario, descripcion) values (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idServicioAlimentacion, nombre, estilo, capacidad, tipo, esConsumo, idHorario, descripcion);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioAlimentacionPorId (PersistenceManager pm, long idServicioAlimentacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM ServicioAlimentacion WHERE idServicio = ?");
        q.setParameters(idServicioAlimentacion);
        return (long) q.executeUnique();
	}
	
	public ServicioAlimentacion darServicioAlimentacionPorId (PersistenceManager pm, long idServicioAlimentacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioAlimentacion WHERE idServicio = ?");
		q.setResultClass(ServicioAlimentacion.class);
		q.setParameters(idServicioAlimentacion);
		return (ServicioAlimentacion) q.executeUnique();
	}
	
	public List<ServicioAlimentacion> darServicioAlimentacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioAlimentacion");
		q.setResultClass(ServicioAlimentacion.class);
		return (List<ServicioAlimentacion>) q.executeList();
	}
}
