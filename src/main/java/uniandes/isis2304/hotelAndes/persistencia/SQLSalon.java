package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Salon;

public class SQLSalon {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLSalon(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarSalon (PersistenceManager pm,  long id, String nombre, int capacidad, double costoPorHora) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO Salon (idServicio, nombre, capacidad, costoPorHora) values (?, ?, ?, ?, ?)");
        q.setParameters(id, nombre, nombre, capacidad, costoPorHora);
        return (long) q.executeUnique();
	}
	
	public long eliminarSalonPorId (PersistenceManager pm, long idSalon)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Salon WHERE idServicio = ?");
        q.setParameters(idSalon);
        return (long) q.executeUnique();
	}
	
	public Salon darSalonPorId (PersistenceManager pm, long idSalon) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Salon WHERE idServicio = ?");
		q.setResultClass(Salon.class);
		q.setParameters(idSalon);
		return (Salon) q.executeUnique();
	}
	
	public List<Salon> darSalon (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Salon");
		q.setResultClass(Salon.class);
		return (List<Salon>) q.executeList();
	}
}
