package uniandes.isis2304.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Usuario;

public class SQLUsuario{
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLUsuario(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarUsuario (PersistenceManager pm, String tipoDocumento, long numeroDocumento, String correoElectronico, String rol, long idUsuario) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO Usuario (tipoDocumento, numeroDocumento, correoElectronico, rol, idUsuario) values (?, ?, ?, ?, ?)");
        q.setParameters(tipoDocumento, numeroDocumento, correoElectronico, rol, idUsuario);
        return (long) q.executeUnique();
	}
	
	public long eliminarUsuarioPorId (PersistenceManager pm, long idUsuario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM Usuario WHERE idUsuario = ?");
        q.setParameters(idUsuario);
        return (long) q.executeUnique();
	}
	
	public Usuario darUsuarioPorId (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Usuario WHERE idUsuario = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(idUsuario);
		Usuario a = new Usuario("Cedula", 1071171201, "jd.castrellón@", "Cliente", 1001);
		try {
			 a = (Usuario) q.executeUnique();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  a;
	}
	
	public List<Usuario> darUsuario (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Usuario");
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}
}
