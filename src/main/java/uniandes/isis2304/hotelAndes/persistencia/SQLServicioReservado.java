package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLServicioReservado {
	
	
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

	public SQLServicioReservado(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarServLavanderia(PersistenceManager pm, long idServicio, String nombreServicio, String descripcion, String tipo, long costoUnitario)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pha.darTablaServicioReservado() + " (IDSERVICIO, NOMBREESPECIFICO,TIPO,DURACION,NOMBRESERVICIO,DESCRIPCION,IDHORARIO,COSTO)  VALUES (957, 'MascarillaChocolate', 'Mascarilla',1,'Spa','deja la piel suave',96,15000)");
		q.setParameters(idServicio, nombreServicio, descripcion, tipo, costoUnitario);
		return (long)q.executeUnique();
	}

}
