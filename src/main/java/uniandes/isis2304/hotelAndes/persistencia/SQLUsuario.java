package uniandes.isis2304.hotelAndes.persistencia;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Habitacion;
import uniandes.isis2304.hotelAndes.negocio.Usuario;

public class SQLUsuario {
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

	public SQLUsuario(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarUsuario(PersistenceManager pm, String tipoDocumento, long numeroDocumento, String correoElectronico, String rol, long idUsuario)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaUsuario() + "(TIPODOCUMENTO, NUMERODOCUMENTO,CORREOELECTRONICO, ROL,IDUSUARIO) VALUES (?, ?, ?, ?, ?)");
		q.setParameters(tipoDocumento, numeroDocumento, correoElectronico, rol, idUsuario);
		return (long)q.executeUnique();
	}

	public Usuario darUsuarioPorId (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Usuario WHERE idUsuario = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(idUsuario);
		return (Usuario) q.executeUnique();
	}
	
	
}
