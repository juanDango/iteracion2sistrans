package uniandes.isis2304.hotelAndes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Horario;

public class SQLReserva {


	//-----------
	//Constantes
	//-----------

	private final static String SQL = PersistenciaHotelAndes.SQL;

	//----------
	//Atributos
	//----------

	private PersistenciaHotelAndes pha;

	//------------
	//Constructor
	//------------

	public SQLReserva(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarReserva(PersistenceManager pm, long idReserva, long abono, long idHabitacion, long idHorario, long idCliente, long idHotel, long idCuenta)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaReserva() + " (IDRESERVA, ABONO, IDHABITACION, IDHORARIO, IDCLIENTE, IDHOTEL, IDCUENTA) VALUES (?, ?, ?, ?, ?, ?, ?) ");
		q.setParameters(idReserva, abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta);
		return (long)q.executeUnique();
	}

	public Horario darReservaPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaReserva() + " WHERE IDRESERVA = ?");
		q.setResultClass(Horario.class);
		q.setParameters(id);
		return (Horario) q.executeUnique();
	}
	
}
