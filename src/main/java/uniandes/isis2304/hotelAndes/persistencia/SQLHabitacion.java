package uniandes.isis2304.hotelAndes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Habitacion;

public class SQLHabitacion {

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

	public SQLHabitacion(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarHabitacion(PersistenceManager pm, long idHabitacion, String tipoHabitacion, long costoNoche, long capacidadHabitacion, long idHotel, long numeroHabitacion)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaHabitacion() + " (IDHABITACION, TIPOHABITACION, COSTONOCHE, CAPACIDADHABITACION, IDHOTEL, NUMEROHABITACION, DISPONIBILIDAD) VALUES (?, ?, ?, ?, ?, ?, 'S')");
		q.setParameters(idHabitacion, tipoHabitacion, costoNoche, capacidadHabitacion, idHotel, numeroHabitacion);
		return (long)q.executeUnique();
	}

	public Habitacion darHabitacionPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaHabitacion() + " WHERE IDHABITACION = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(id);
		return (Habitacion) q.executeUnique();
	}
	
	public long darActualizarPorEstado(PersistenceManager pm, long id, String estado){
		Query q = pm.newQuery(SQL, "UPDATE " + pha.darTablaHabitacion() + "SET DISPONIBILIDAD = '?' WHERE IDHABITACION = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(estado, id);
		return (long) q.executeUnique();
	}
	
}
