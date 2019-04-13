package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.CuentaAlojamiento;
import uniandes.isis2304.hotelAndes.negocio.ProductoServicio;

public class SQLProductoServicio {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLProductoServicio(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarProductoServicio (PersistenceManager pm, long idProducto, long idServicio) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ProductoServicio (idProducto, idServicio) values (?, ?)");
        q.setParameters(idProducto, idServicio);
        return (long) q.executeUnique();
	}
	
	public long eliminarProductoServicioPorId (PersistenceManager pm, long idServicio, long idProducto)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM ProductoServicio WHERE idServicio = ? AND idProducto = ?");
        q.setParameters(idServicio, idProducto);
        return (long) q.executeUnique();
	}
	
	public ProductoServicio darProductoServicioPorId (PersistenceManager pm, long idServicio, long idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ProductoServicio WHERE idServicio = ? AND idProducto = ?");
		q.setResultClass(CuentaAlojamiento.class);
		q.setParameters(idServicio, idProducto);
		return (ProductoServicio) q.executeUnique();
	}
	
	public List<ProductoServicio> darProductoServicio (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ProductoServicio");
		q.setResultClass(CuentaAlojamiento.class);
		return (List<ProductoServicio>) q.executeList();
	}
}
