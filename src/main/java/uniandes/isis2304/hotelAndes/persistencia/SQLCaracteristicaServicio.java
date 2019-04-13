package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.CaracteristicaServicio;

public class SQLCaracteristicaServicio {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLCaracteristicaServicio(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarCaracteristicaServicio (PersistenceManager pm, long idCaracteristicaServicio, long idServicio, String nombreCaracteristica, String descripcion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO CaracteristicaServicio (idCaracteristica, idServicio, nombreCaracteristica, descripcion) values (?, ?, ?, ?)");
        q.setParameters(idCaracteristicaServicio, idServicio, nombreCaracteristica, descripcion);
        return (long) q.executeUnique();
	}
	
	public long eliminarCaracteristicaServicioPorId (PersistenceManager pm, long idCaracteristicaServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM CaracteristicaServicio WHERE idCaracteristica = ?");
        q.setParameters(idCaracteristicaServicio);
        return (long) q.executeUnique();
	}
	
	public CaracteristicaServicio darCaracteristicaServicioPorId (PersistenceManager pm, long idCaracteristicaServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM CaracteristicaServicio WHERE idCaracteristica = ?");
		q.setResultClass(CaracteristicaServicio.class);
		q.setParameters(idCaracteristicaServicio);
		return (CaracteristicaServicio) q.executeUnique();
	}
	
	public List<CaracteristicaServicio> darCaracteristicaServicio (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Caracteristica");
		q.setResultClass(CaracteristicaServicio.class);
		return (List<CaracteristicaServicio>) q.executeList();
	}
}
