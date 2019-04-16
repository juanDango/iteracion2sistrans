package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.ServicioAlojamientoHabitacion;
import uniandes.isis2304.hotelAndes.negocio.Usuario;

public class SQLServicioAlojamientoHabitacion {

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

	public SQLServicioAlojamientoHabitacion(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarServicioAlojaHabita(PersistenceManager pm, long idHabitacion, long idServicioAlojamiento)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO servicioalojamientohabitacion (IDHABITACION, IDSERVICIOALOJAMIENTO)  VALUES (? ,?)");
		q.setParameters(idHabitacion, idServicioAlojamiento);
		return (long)q.executeUnique();
	}

	public ServicioAlojamientoHabitacion darRelacionPorHabitacion(PersistenceManager pm, long cedula){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaServicioAlojamientoHabitacion() + " WHERE IDHABITACION = ?");
		q.setResultClass(ServicioAlojamientoHabitacion.class);
		q.setParameters(cedula);
		return (ServicioAlojamientoHabitacion) q.executeUnique();
	}
	
}
