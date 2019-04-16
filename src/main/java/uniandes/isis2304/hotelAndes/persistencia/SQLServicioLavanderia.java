package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLServicioLavanderia {
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

	public SQLServicioLavanderia(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarServLavanderia(PersistenceManager pm, long idServicio, String nombreServicio, String descripcion, String tipo, long costoUnitario)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaServicioLavanderia() + " (IDSERVICIO,NOMBRESERVICIO,DESCRIPCION,TIPO,COSTOUNITARIO,CANTUNIDADES) VALUES (?, ?, ?, ?, ?, 0)");
		q.setParameters(idServicio, nombreServicio, descripcion, tipo, costoUnitario);
		return (long)q.executeUnique();
	}
}
