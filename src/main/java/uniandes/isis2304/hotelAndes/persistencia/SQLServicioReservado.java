package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.ServicioReservado;

public class SQLServicioReservado {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLServicioReservado(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarServicioReservado (PersistenceManager pm, long idServicioReservado, String nombreEspecifico, String tipo, long duracion, double costo, String nombreServicio, String descripcion, long idHorario) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ServicioReservado (idServicio, nombreEspecifico, tipo, duracion, costo, nombreServicio, descrpcion, idHorario) values (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idServicioReservado, nombreEspecifico, tipo, duracion, costo, nombreServicio, descripcion, idHorario);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioReservadoPorId (PersistenceManager pm, long idServicioReservado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM ServicioReservado WHERE idServicio = ?");
        q.setParameters(idServicioReservado);
        return (long) q.executeUnique();
	}
	
	public ServicioReservado darServicioReservadoPorId (PersistenceManager pm, long idServicioReservado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioReservado WHERE idServicio = ?");
		q.setResultClass(ServicioReservado.class);
		q.setParameters(idServicioReservado);
		return (ServicioReservado) q.executeUnique();
	}
	
	public List<ServicioReservado> darServicioReservado (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioReservado");
		q.setResultClass(ServicioReservado.class);
		return (List<ServicioReservado>) q.executeList();
	}
}
