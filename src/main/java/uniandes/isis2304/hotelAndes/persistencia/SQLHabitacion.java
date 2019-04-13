package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Habitacion;

public class SQLHabitacion {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLHabitacion(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarHabitacion (PersistenceManager pm, long idHabitacion, String tipoHabitacion, double costoNoche, int capacidad, long idHotel) 
	{
		tipoHabitacion = tipoHabitacion.toUpperCase();
        Query q = pm.newQuery(SQL, "INSERT INTO Habitaciones (idHabitacion, tipoHabitacion, costoNoche, capacidadHabitacion, idHotel) values (?, ?, ?, ?, ?)");
        q.setParameters(idHabitacion, tipoHabitacion, costoNoche, capacidad, idHotel);
        return (long) q.executeUnique();
	}
	
	public long eliminarHabitacionPorId (PersistenceManager pm, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Habitaciones WHERE idHabitacion = ?");
        q.setParameters(idHabitacion);
        return (long) q.executeUnique();
	}
	
	public Habitacion darHabitacionPorId (PersistenceManager pm, long idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Habitaciones WHERE idHabitacion = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idHabitacion);
		return (Habitacion) q.executeUnique();
	}
	
	public List<Habitacion> darHabitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Habitaciones");
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}
}
