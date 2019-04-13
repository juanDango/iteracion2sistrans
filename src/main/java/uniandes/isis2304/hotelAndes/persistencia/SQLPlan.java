package uniandes.isis2304.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Plan;

public class SQLPlan {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLPlan(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarPlan (PersistenceManager pm, long idPlan, String nombrePlan, String tipo, Timestamp fechaInicial, Timestamp fechaFinal) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO Plan (idPlan, nombrePlan, tipo, fechaInicial, fechaFinal) values (?, ?, ?, ?, ?)");
        q.setParameters(idPlan, nombrePlan, tipo, fechaInicial, fechaFinal);
        return (long) q.executeUnique();
	}
	
	public long eliminarPlanPorId (PersistenceManager pm, long idPlan)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Plan WHERE idPlan = ?");
        q.setParameters(idPlan);
        return (long) q.executeUnique();
	}
	
	public Plan darPlanPorId (PersistenceManager pm, long idPlan) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Plan WHERE idPlan = ?");
		q.setResultClass(Plan.class);
		q.setParameters(idPlan);
		return (Plan) q.executeUnique();
	}
	
	public List<Plan> darPlan (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Plan");
		q.setResultClass(Plan.class);
		return (List<Plan>) q.executeList();
	}
}
