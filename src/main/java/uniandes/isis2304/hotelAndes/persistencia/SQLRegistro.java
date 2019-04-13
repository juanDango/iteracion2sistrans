package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Registro;

public class SQLRegistro {
	
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLRegistro(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarRegistro (PersistenceManager pm, long idRegistro, long idReserva, char estadoCheckIn, char estadoCheckOut, long idRegistrador) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO Registro (idRegistro, idReserva, estadoCheckIn, estadoCheckOut, idRegistrador) values (?, ?, ?, ?, ?)");
        q.setParameters(idRegistro, idReserva, estadoCheckIn, estadoCheckOut, idRegistrador);
        return (long) q.executeUnique();
	}
	
	public long eliminarRegistroPorId (PersistenceManager pm, long idRegistro)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Registro WHERE idRegistro = ?");
        q.setParameters(idRegistro);
        return (long) q.executeUnique();
	}
	
	public Registro darRegistroPorId (PersistenceManager pm, long idRegistro) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Registro WHERE idRegistro = ?");
		q.setResultClass(Registro.class);
		q.setParameters(idRegistro);
		return (Registro) q.executeUnique();
	}
	
	public List<Registro> darRegistro (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Registro");
		q.setResultClass(Registro.class);
		return (List<Registro>) q.executeList();
	}
	
	public long updateCheckIn (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "UPDATE Registro SET checkOut = 'E' ? WHERE idRegistro = ?");
		q.setParameters( id);
		return (long) q.executeUnique();            
	}
}
