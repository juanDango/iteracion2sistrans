package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.CuentaAlojamiento;
import uniandes.isis2304.hotelAndes.negocio.PlanCaracteristicaAdicional;

public class SQLPlanCaracteristicaAdicional {

private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLPlanCaracteristicaAdicional(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarPlanCaracteristicaAdicional (PersistenceManager pm, long idPlan, long idCaracteristica) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO PlanServicioAdicional (idPlan, idCaracteristica) values (?, ?)");
        q.setParameters(idPlan, idCaracteristica);
        return (long) q.executeUnique();
	}
	
	public long eliminarPlanCaracteristicaAdicionalPorId (PersistenceManager pm, long idCaracteristicaAlojamiento, long idPlan)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM PlanServicioAdicional WHERE idCaracteristica = ? AND idPlan = ?");
        q.setParameters(idCaracteristicaAlojamiento, idPlan);
        return (long) q.executeUnique();
	}
	
	public PlanCaracteristicaAdicional darPlanCaracteristicaAdicionalPorId (PersistenceManager pm, long idCaracteristicaAlojamiento, long idPlan) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM PlanServicioAdicional WHERE idCaracteristica = ? AND idPlan = ?");
		q.setResultClass(CuentaAlojamiento.class);
		q.setParameters(idCaracteristicaAlojamiento, idPlan);
		return (PlanCaracteristicaAdicional) q.executeUnique();
	}
	
	public List<PlanCaracteristicaAdicional> darPlanCaracteristicaAdicional (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM PlanServicioAdicional");
		q.setResultClass(CuentaAlojamiento.class);
		return (List<PlanCaracteristicaAdicional>) q.executeList();
	}
}
