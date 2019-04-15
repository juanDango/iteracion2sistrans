package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.TipoHabitacion;

public class SQLTipoHabitacion {

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

	public SQLTipoHabitacion(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarTipoHabitacion(PersistenceManager pm, String nombreTipo, String descripcion)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaTipoHabitacion() + "(NOMBRETIPO, DESCRIPCION) VALUES (?, ?)");
		q.setParameters(nombreTipo, descripcion);
		return (long)q.executeUnique();
	}

	public Horario darTipoHabitacionPorNombre(PersistenceManager pm, String nombreTipo){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaReserva() + " WHERE NOMBRETIPO = ?");
		q.setResultClass(Horario.class);
		q.setParameters(nombreTipo);
		return (Horario) q.executeUnique();
	}
	
}
