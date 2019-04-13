package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.CaracteristicaAdicional;

public class SQLCaracteristicaAdicional {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLCaracteristicaAdicional(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarCaracteristicaAdicional (PersistenceManager pm, long idCaracteristicaAdicional, long limite, double dcto, String descripcion, long idServicioComplementario, long idServicioAloja) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO CaracteristicaAdicional (idCaracteristica, limite, dcto, descripcion, idServicioComp, idServicioAloja) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idCaracteristicaAdicional, limite, dcto, descripcion, idServicioComplementario, idCaracteristicaAdicional);
        return (long) q.executeUnique();
	}
	
	public long eliminarCaracteristicaAdicionalPorId (PersistenceManager pm, long idCaracteristicaAdicional)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM CaracteristicaAdicional WHERE idCaracteristica = ?");
        q.setParameters(idCaracteristicaAdicional);
        return (long) q.executeUnique();
	}
	
	public CaracteristicaAdicional darCaracteristicaAdicionalPorId (PersistenceManager pm, long idCaracteristicaAdicional) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM CaracteristicaAdicional WHERE idCaracteristica = ?");
		q.setResultClass(CaracteristicaAdicional.class);
		q.setParameters(idCaracteristicaAdicional);
		return (CaracteristicaAdicional) q.executeUnique();
	}
	
	public List<CaracteristicaAdicional> darCaracteristicaAdicional (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Caracteristica");
		q.setResultClass(CaracteristicaAdicional.class);
		return (List<CaracteristicaAdicional>) q.executeList();
	}
}
