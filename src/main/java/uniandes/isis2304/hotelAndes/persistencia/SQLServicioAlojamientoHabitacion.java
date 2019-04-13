package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.CuentaAlojamiento;
import uniandes.isis2304.hotelAndes.negocio.ServicioAlojamientoHabitacion;

public class SQLServicioAlojamientoHabitacion {

private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLServicioAlojamientoHabitacion(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarServicioAlojamientoHabitacion (PersistenceManager pm, long idHabitacion, long idServicioAlojamiento) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ServicioAlojamientoHabitacion (idHabitacion, idServicioAlojamiento) values (?, ?)");
        q.setParameters(idHabitacion, idServicioAlojamiento);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioAlojamientoHabitacionPorId (PersistenceManager pm, long idServicioAlojamiento, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM ServicioAlojamientoHabitacion WHERE idServicioAlojamiento = ? AND idHabitacion = ?");
        q.setParameters(idServicioAlojamiento, idHabitacion);
        return (long) q.executeUnique();
	}
	
	public ServicioAlojamientoHabitacion darServicioAlojamientoHabitacionPorId (PersistenceManager pm, long idServicioAlojamiento, long idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioAlojamientoHabitacion WHERE idServicioAlojamiento = ? AND idHabitacion = ?");
		q.setResultClass(CuentaAlojamiento.class);
		q.setParameters(idServicioAlojamiento, idHabitacion);
		return (ServicioAlojamientoHabitacion) q.executeUnique();
	}
	
	public List<ServicioAlojamientoHabitacion> darServicioAlojamientoHabitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioAlojamientoHabitacion");
		q.setResultClass(CuentaAlojamiento.class);
		return (List<ServicioAlojamientoHabitacion>) q.executeList();
	}
}
