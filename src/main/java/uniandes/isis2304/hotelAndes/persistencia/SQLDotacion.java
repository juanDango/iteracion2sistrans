package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Dotacion;

public class SQLDotacion {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLDotacion(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarDotacion (PersistenceManager pm, long idDotacion, String nombreObjeto, char esCobrable, double valorObjeto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO Dotacion (idDotacion, nombreObjeto, esCobrable, valorObjeto) values (?, ?, ?, ?)");
        q.setParameters(idDotacion, nombreObjeto, esCobrable, valorObjeto);
        return (long) q.executeUnique();
	}
	
	public long eliminarDotacionPorId (PersistenceManager pm, long idDotacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Dotacion WHERE idDotacion = ?");
        q.setParameters(idDotacion);
        return (long) q.executeUnique();
	}
	
	public Dotacion darDotacionPorId (PersistenceManager pm, long idDotacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Dotacion WHERE idDotacion = ?");
		q.setResultClass(Dotacion.class);
		q.setParameters(idDotacion);
		return (Dotacion) q.executeUnique();
	}
	
	public List<Dotacion> darDotacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Dotacion");
		q.setResultClass(Dotacion.class);
		return (List<Dotacion>) q.executeList();
	}
}
