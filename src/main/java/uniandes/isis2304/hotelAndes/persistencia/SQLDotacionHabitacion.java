package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.DotacionHabitacion;

public class SQLDotacionHabitacion {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLDotacionHabitacion(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarDotacionHabitacion (PersistenceManager pm, long idDotacion, long idHabitacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO DotacionHabitacion (idDotacion, idHabitacion) values (?, ?)");
        q.setParameters(idDotacion, idHabitacion);
        return (long) q.executeUnique();
	}
	
	public long eliminarDotacionHabitacionPorId (PersistenceManager pm, long idHabitacion, long idDotacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM DotacionHabitacion WHERE idHabitacion = ? AND idDotacion = ?");
        q.setParameters(idHabitacion, idDotacion);
        return (long) q.executeUnique();
	}
	
	public DotacionHabitacion darDotacionHabitacionPorId (PersistenceManager pm, long idHabitacion, long idDotacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM DotacionHabitacion WHERE idHabitacion = ? AND idDotacion = ?");
		q.setResultClass(DotacionHabitacion.class);
		q.setParameters(idHabitacion, idDotacion);
		return (DotacionHabitacion) q.executeUnique();
	}
	
	public List<DotacionHabitacion> darDotacionHabitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM DotacionHabitacion");
		q.setResultClass(DotacionHabitacion.class);
		return (List<DotacionHabitacion>) q.executeList();
	}
}
