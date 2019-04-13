package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Cuenta;

public class SQLCuenta {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLCuenta(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarCuenta (PersistenceManager pm, long idCuenta, double valor, String metodoDePago, long idPlanConsumo, long idCliente, long idReserva) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO Cuenta (idCuenta, valor, metodoDePago, idPlanConsumo, idCliente, idReserva) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idCuenta, valor, metodoDePago, idPlanConsumo, idCliente, idReserva);
        return (long) q.executeUnique();
	}
	
	public long eliminarCuentaPorId (PersistenceManager pm, long idCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Cuenta WHERE idCuenta = ?");
        q.setParameters(idCuenta);
        return (long) q.executeUnique();
	}
	
	public Cuenta darCuentaPorId (PersistenceManager pm, long idCuenta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Cuenta WHERE idCuenta = ?");
		q.setResultClass(Cuenta.class);
		q.setParameters(idCuenta);
		return (Cuenta) q.executeUnique();
	}
	
	public List<Cuenta> darCuenta (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Cuenta");
		q.setResultClass(Cuenta.class);
		return (List<Cuenta>) q.executeList();
	}
}
