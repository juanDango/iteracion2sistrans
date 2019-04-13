package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Hotel;

public class SQLHotel {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLHotel(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarHotel (PersistenceManager pm, long idHotel, String nombre, String ciudad, String pais, int estrellas, long cadenaHotelera) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO HOTELES (idHotel, nombreHotel, estrellas, ciudad, pais, cadenaHotelera) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idHotel, nombre, estrellas, ciudad, pais, cadenaHotelera);
        return (long) q.executeUnique();
	}
	
	public long eliminarHotelPorId (PersistenceManager pm, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM HOTELES WHERE idHotel = ?");
        q.setParameters(idHotel);
        return (long) q.executeUnique();
	}
	
	public Hotel darHotelId (PersistenceManager pm, long idHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM HOTELES WHERE idHotel = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(idHotel);
		return (Hotel) q.executeUnique();
	}
	
	public List<Hotel> darHoteles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM HOTELES");
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}
}
