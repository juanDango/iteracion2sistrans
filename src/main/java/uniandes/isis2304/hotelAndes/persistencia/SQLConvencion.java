package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Convencion;
import uniandes.isis2304.hotelAndes.negocio.Cuenta;

public class SQLConvencion {
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

	public SQLConvencion(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarConvencion(PersistenceManager pm,long idConvencion, long idHotel, long numparticipantes,
			String nombreConvencion, long idHorario)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaConvencion() + " (IDCONVENCION, IDHOTEL, NUMPARTICIPANTES, NOMBRECONVENCION, IDHORARIO) VALUES (?, ?, ?, ?, ?) ");
		q.setParameters(idConvencion, idHotel, numparticipantes, nombreConvencion, idHorario);
		return (long)q.executeUnique();
	}

	public Convencion darConvencionPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaConvencion() + " WHERE IDCONVENCION = ?");
		q.setResultClass(Cuenta.class);
		q.setParameters(id);
		return (Convencion) q.executeUnique();
	}
	
	
}
