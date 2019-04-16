package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Usuario;

public class SQLRegistro {

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

	public SQLRegistro(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarRegistro(PersistenceManager pm, long idRegistro, long idReserva, char estadoCheckIn, char estadoCheckOut, long idRegistrador)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pha.darTablaRegistro() + "(IDREGISTRO, IDRESERVA,ESTADOCHECKIN, ESTADOCHECKOUT, IDREGISTRADOR) VALUES (?, ?, ?, ?, ?);");
		q.setParameters(idRegistro, idReserva, estadoCheckIn, estadoCheckOut, idRegistrador);
		return (long)q.executeUnique();
	}

	public long modificarRegistro(PersistenceManager pm, long idRegistro)
	{
		Query q = pm.newQuery(SQL, "UPDATE REGISTRO SET ESTADOCHECKOUT = 'E' WHERE IDREGISTRO = ?;");
		q.setParameters(idRegistro);
		return (long)q.executeUnique();
	}
	
}
