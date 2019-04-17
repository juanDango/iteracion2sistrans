package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Cuenta;

public class SQLConvencionrestbarcafeteria {
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

	public SQLConvencionrestbarcafeteria(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarConvencionrestbarcafeteria(PersistenceManager pm, long idConvencion, long idServicioComplementario)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaConvencionrestbarcafeteria() + " (idConvencion, idServicioComplementario) VALUES (?, ?) ");
		q.setParameters(idConvencion, idServicioComplementario);
		return (long)q.executeUnique();
	}

	public Cuenta darConvencionrestbarcafeteriaPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaCuenta() + " WHERE IDCUENTA = ?");
		q.setResultClass(Cuenta.class);
		q.setParameters(id);
		return (Cuenta) q.executeUnique();
	}

	
	
	
}
