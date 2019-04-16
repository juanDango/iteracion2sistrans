package uniandes.isis2304.hotelAndes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Plan;

public class SQLPlan {

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

	public SQLPlan(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarPlan(PersistenceManager pm, long idPlan, String nombrePlan, String tipo)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pha.darTablaPlan() + "(IDPLAN, NOMBREPLAN, TIPO) VALUES (?, ?, ?);");
		q.setParameters(idPlan, nombrePlan, tipo);
		return (long)q.executeUnique();
	}

	public Plan darPlanPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaPlan() + " WHERE IDHORARIO = ?");
		q.setResultClass(Plan.class);
		q.setParameters(id);
		return (Plan) q.executeUnique();
	}
	
	
}
