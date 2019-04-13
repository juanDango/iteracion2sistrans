package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.CuentaAlojamiento;
import uniandes.isis2304.hotelAndes.negocio.CuentaServicio;

public class SQLCuentaServicio {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLCuentaServicio(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarCuentaServicio (PersistenceManager pm, long idCuenta, long idServicioServicio) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO CuentaServicio (idCuenta, idServicioComplementario) values (?, ?)");
        q.setParameters(idCuenta, idServicioServicio);
        return (long) q.executeUnique();
	}
	
	public long eliminarCuentaServicioPorId (PersistenceManager pm, long idCuentaAlojamiento, long idCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM CuentaServicio WHERE idServicioComplementario = ? AND idCuenta = ?");
        q.setParameters(idCuentaAlojamiento, idCuenta);
        return (long) q.executeUnique();
	}
	
	public CuentaServicio darCuentaServicioPorId (PersistenceManager pm, long idCuentaAlojamiento, long idCuenta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM CuentaServicio WHERE idServicioComplementario = ? AND idCuenta = ?");
		q.setResultClass(CuentaAlojamiento.class);
		q.setParameters(idCuentaAlojamiento, idCuenta);
		return (CuentaServicio) q.executeUnique();
	}
	
	public List<CuentaServicio> darCuentaServicio (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM CuentaServicio");
		q.setResultClass(CuentaAlojamiento.class);
		return (List<CuentaServicio>) q.executeList();
	}
}
