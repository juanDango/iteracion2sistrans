package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Usuario;

public class SQLServicioAlojamiento {
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

	public SQLServicioAlojamiento(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarServicioAloja(PersistenceManager pm, long idServicioAlojamiento, long cantidadPersonas, long idCuenta)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pha.darTablaSevicioAlojamiento() + "(IDSERVICIOALOJAMIENTO, CANTIDADPERSONAS, IDCUENTA) VALUES (?, ?, ?);");
		q.setParameters(idServicioAlojamiento, cantidadPersonas, idCuenta);
		return (long)q.executeUnique();
	}

	public Usuario darUsuarioPorCedula(PersistenceManager pm, long cedula){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaSevicioAlojamiento() + " WHERE IDSERVICIOALOJAMIENTO = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(cedula);
		return (Usuario) q.executeUnique();
	}
}
