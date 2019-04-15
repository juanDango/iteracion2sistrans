package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.Query;
import javax.jdo.PersistenceManager;

public class SQLCadenaHotelera {

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
	
	public SQLCadenaHotelera(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}
	
	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------
	
	public long adicionarCadenaHotelera(PersistenceManager pm, long idCadenaHotelera, String nombreCadenaHotelera)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaCadenaHotelera() + " (IDCADENAHOTELERA, NOMBRECADENAHOTELERA) VALUES (?, ?) ");
		q.setParameters(idCadenaHotelera, nombreCadenaHotelera);
		return (long)q.executeUnique();
	}
	
}
