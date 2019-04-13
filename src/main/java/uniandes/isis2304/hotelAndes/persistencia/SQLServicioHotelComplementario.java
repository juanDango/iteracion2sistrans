package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.ServicioHotelComplementario;

public class SQLServicioHotelComplementario {
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLServicioHotelComplementario(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarServicioHotelComplementario (PersistenceManager pm, long idServicioHotelComplementario, String nombreServicio, long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ServicioHotelComplementario (idSComplementario, nombreservicio, idHotel) values (?, ?, ?)");
        q.setParameters(idServicioHotelComplementario, nombreServicio, idHotel);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioHotelComplementarioPorId (PersistenceManager pm, long idServicioHotelComplementario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM ServicioHotelComplementario WHERE idSComplementario = ?");
        q.setParameters(idServicioHotelComplementario);
        return (long) q.executeUnique();
	}
	
	public ServicioHotelComplementario darServicioHotelComplementarioPorId (PersistenceManager pm, long idServicioHotelComplementario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioHotelComplementario WHERE idSComplementario = ?");
		q.setResultClass(ServicioHotelComplementario.class);
		q.setParameters(idServicioHotelComplementario);
		return (ServicioHotelComplementario) q.executeUnique();
	}
	
	public List<ServicioHotelComplementario> darServicioHotelComplementario (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServicioHotelComplementario");
		q.setResultClass(ServicioHotelComplementario.class);
		return (List<ServicioHotelComplementario>) q.executeList();
	}
}
