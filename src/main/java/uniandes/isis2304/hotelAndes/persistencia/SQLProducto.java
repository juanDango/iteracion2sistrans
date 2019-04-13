package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Producto;

public class SQLProducto {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLProducto(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarProducto (PersistenceManager pm, long idProducto, String nombreProducto, double precio) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO Producto (idSComplementario, nombreproducto, precio) values (?, ?, ?)");
        q.setParameters(idProducto, nombreProducto, precio);
        return (long) q.executeUnique();
	}
	
	public long eliminarProductoPorId (PersistenceManager pm, long idProducto)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Producto WHERE idSComplementario = ?");
        q.setParameters(idProducto);
        return (long) q.executeUnique();
	}
	
	public Producto darProductoPorId (PersistenceManager pm, long idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Producto WHERE idSComplementario = ?");
		q.setResultClass(Producto.class);
		q.setParameters(idProducto);
		return (Producto) q.executeUnique();
	}
	
	public List<Producto> darProducto (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Producto");
		q.setResultClass(Producto.class);
		return (List<Producto>) q.executeList();
	}
}
