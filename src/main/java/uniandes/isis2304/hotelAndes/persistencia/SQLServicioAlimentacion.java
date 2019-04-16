package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLServicioAlimentacion {

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

	public SQLServicioAlimentacion(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarServAlimentacion(PersistenceManager pm, long idServicio, String nombreSevicio, String estilo, long capacidad, String tipo, char esConsumoHabitacion, String descripcion)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pha.darTablaServicioAlimentacion() + "(IDSERVICIO, NOMBRESERVICIO, ESTILO, CAPACIDAD, TIPO, ESCONSUMOHABITACION, IDHORARIO, DESCRIPCION) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
		q.setParameters(idServicio, nombreSevicio, estilo, capacidad, tipo, esConsumoHabitacion, descripcion);
		return (long)q.executeUnique();
	}
	
}
