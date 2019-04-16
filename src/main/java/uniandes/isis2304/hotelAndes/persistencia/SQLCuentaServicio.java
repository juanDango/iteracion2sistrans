package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Plan;

public class SQLCuentaServicio {

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

	public SQLCuentaServicio(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarCuentaServicio(PersistenceManager pm, long idCuenta, long idServicioComplementario)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pha.darTablaCuentaServicio() + "(IDCUENTA, IDSERVICIOCOMPLEMENTARIO) VALUES (?, ?);");
		q.setParameters(idCuenta, idServicioComplementario);
		return (long)q.executeUnique();
	}
	
}
