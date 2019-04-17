package uniandes.isis2304.hotelAndes.persistencia;


import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Habitacion;
import uniandes.isis2304.hotelAndes.negocio.Usuario;

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

	public long adicionarHabitacion(PersistenceManager pm, long idHabitacion, String tipoHabitacion, long costoNoche, long capacidadHabitacion, long idHotel, long numeroHabitacion,String disponible)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaHabitacion() + " (IDHABITACION, TIPOHABITACION, COSTONOCHE, CAPACIDADHABITACION, IDHOTEL, NUMEROHABITACION, disponible) VALUES (?, ?, ?, ?, ?, ?,?)");
		q.setParameters(idHabitacion, tipoHabitacion, costoNoche, capacidadHabitacion, idHotel, numeroHabitacion,disponible);
		return (long)q.executeUnique();
	}

	public Habitacion darHabitacionPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaHabitacion() + " WHERE IDHABITACION = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(id);
		return (Habitacion) q.executeUnique();
	}

	public ArrayList<Habitacion> darHabitacionesPorTipo(PersistenceManager pm, String tipo) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaHabitacion() + " WHERE TIPOHABITACION = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(tipo);
		return (ArrayList<Habitacion>) q.executeUnique();
	}

	public ArrayList<Habitacion>  darHabitacionesLibresPorTipo(PersistenceManager pm, String nombreTipo) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaHabitacion() + " WHERE TIPOHABITACION = ? AND DISPONIBLE = 'S'");
		q.setResultClass(Habitacion.class);
		q.setParameters(nombreTipo);
		
		return (ArrayList<Habitacion>) q.executeUnique();
	}
	
}
