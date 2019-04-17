package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Cuenta;

public class SQLConvencionHabitacion {
	private final static String SQL = PersistenciaHotelAndes.SQL;

	//----------
	//Atributos
	//----------

	private PersistenciaHotelAndes pha;

	//------------
	//Constructor
	//------------

	public SQLConvencionHabitacion(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionar(PersistenceManager pm, long idConvencion, long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaConvencionrestbarcafeteria() + " (idConvencion, idHabitacion) VALUES (?, ?) ");
		q.setParameters(idConvencion, idHabitacion);
		return (long)q.executeUnique();
	}

	
}
