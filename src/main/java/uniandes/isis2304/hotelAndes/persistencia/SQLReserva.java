package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Reserva;

public class SQLReserva{
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLReserva(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarReserva (PersistenceManager pm, long idReserva, long abono,long idHabitacion, long idHorario,long idCliente,long idHotel, long idCuenta) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO Reserva (idReserva, abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idReserva, abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta);
        return (long) q.executeUnique();
	}
	
	public long eliminarReservaPorId (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Reserva WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();
	}
	
	public Reserva darReservaPorId (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Reserva WHERE idReserva = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(idReserva);
		return (Reserva) q.executeUnique();
	}
	
	public List<Reserva> darReserva (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Reserva");
		q.setResultClass(Reserva.class);
		return (List<Reserva>) q.executeList();
	}
}
