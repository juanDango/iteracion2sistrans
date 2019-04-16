package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLServicioIncluido {
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

	public SQLServicioIncluido(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarServIncluido(PersistenceManager pm, long idServicio, String nombre, long capacidad, long idHotel)
	{
		Query q = pm.newQuery(SQL, "	INSERT INTO " + pha.darTablaServicioIncluido() + " (IDSERVICIO, NOMBRE, CAPACIDAD,IDHOTEL) VALUES (?, ?, ?, ?)");
		q.setParameters(idServicio, nombre, capacidad, idHotel);
		return (long)q.executeUnique();
	}
}
