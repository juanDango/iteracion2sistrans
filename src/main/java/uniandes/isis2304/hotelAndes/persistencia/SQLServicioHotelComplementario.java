package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLServicioHotelComplementario {


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

	public SQLServicioHotelComplementario(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarServHotelComplementario(PersistenceManager pm, long idSComplementario, String nombreServicio, long idHotel)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pha.darTablaServicioHotelComplementario() + "(IDSCOMPLEMENTARIO, NOMBRESERVICIO,IDHOTEL)  VALUES (?, ?, ?)");
		q.setParameters(idSComplementario, nombreServicio, idHotel);
		return (long)q.executeUnique();
	}
	
}
