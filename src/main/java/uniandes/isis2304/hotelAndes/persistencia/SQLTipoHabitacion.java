package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.TipoHabitacion;

public class SQLTipoHabitacion {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLTipoHabitacion(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarTipoHabitacion (PersistenceManager pm, String nombre, String descripcion) 
	{
		nombre = nombre.toUpperCase();
        Query q = pm.newQuery(SQL, "INSERT INTO TipoHabitacion (NombreTipo, Descripcion)values (?, ?)");
        q.setParameters(nombre, descripcion);
        return (long) q.executeUnique();
	}
	
	public long eliminarTipoHabitacionPorId (PersistenceManager pm, String nombre)
	{
		nombre=nombre.toUpperCase();
        Query q = pm.newQuery(SQL, "DELETE FROM TipoHabitacion WHERE nombreTipo = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();
	}
	
	public TipoHabitacion darTipoHabitacionPorId (PersistenceManager pm, String nombre) 
	{
		nombre = nombre.toUpperCase();
		Query q = pm.newQuery(SQL, "SELECT * FROM TipoHabitacion WHERE nombreTipo = ?");
		q.setResultClass(TipoHabitacion.class);
		q.setParameters(nombre);
		return (TipoHabitacion) q.executeUnique();
	}
	
	public List<TipoHabitacion> darTipoHabitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM TipoHabitacion");
		q.setResultClass(TipoHabitacion.class);
		return (List<TipoHabitacion>) q.executeList();
	}
}
