package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.CadenaHotelera;

public class SQLCadenaHotelera {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes ph;
	
	public SQLCadenaHotelera (PersistenciaHotelAndes ph){
		this.ph = ph;
	}
	
	public long adicionarCadenaHotelera(PersistenceManager pm, long idCadenaHotelera, String nombreCadena){
		Query q = pm.newQuery(SQL, "INSERT INTO CADENAHOTELERA (idCadenaHotelera, nombreCadena) values (?, ?)");
        q.setParameters(idCadenaHotelera, nombreCadena);
        return (long) q.executeUnique();
	}
	
	public long eliminarCadenaHoteleraId (PersistenceManager pm, long idCadenaHotelera)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM CADENAHOTELERA WHERE idCadenaHotelera = ?");
        q.setParameters(idCadenaHotelera);
        return (long) q.executeUnique();
	}
	
	public CadenaHotelera darCadenaHoteleraPorId (PersistenceManager pm, long idCadenaHotelera) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM CADENAHOTELERA WHERE idCadenaHotelera = ?");
		q.setResultClass(CadenaHotelera.class);
		q.setParameters(idCadenaHotelera);
		return (CadenaHotelera) q.executeUnique();
	}
	
	public List<CadenaHotelera> darCadenaHotelera (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM CADENAHOTELERA" );
		q.setResultClass(CadenaHotelera.class);
		return (List<CadenaHotelera>) q.executeList();
	}
}
