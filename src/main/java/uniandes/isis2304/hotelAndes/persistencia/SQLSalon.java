package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLSalon {

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

	public SQLSalon(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarServAlimentacion(PersistenceManager pm, long idServicio, String nombre, long capacidad, long costoPorHora)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaSalon() + " (IDSERVICIO,NOMBRE,CAPACIDAD,COSTOPORHORA) VALUES (?,?,?,?)");
		q.setParameters(idServicio, nombre, capacidad, costoPorHora);
		return (long)q.executeUnique();
	}
	
}
