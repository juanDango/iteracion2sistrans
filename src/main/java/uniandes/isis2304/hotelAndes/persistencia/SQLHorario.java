package uniandes.isis2304.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Horario;

public class SQLHorario {

private final static String SQL = PersistenciaHotelAndes.SQL;
	
	private PersistenciaHotelAndes pm;
	
	public SQLHorario(PersistenciaHotelAndes pm)
	{
		this.pm = pm;
	}
	
	public long adicionarHorario (PersistenceManager pm, long idHorario, long horaInicio, long horaFinal, Timestamp fechaInicial, Timestamp fechaFinal) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO HorarioES (idHorario, horaInicio, horaFinal, fechaInicio, fechaFinal) values (?, ?, ?, ?, ?)");
        q.setParameters(idHorario, horaInicio, horaFinal, fechaInicial, fechaFinal);
        return (long) q.executeUnique();
	}
	
	public long eliminarHorarioPorId (PersistenceManager pm, long idHorario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM HorarioES WHERE idHorario = ?");
        q.setParameters(idHorario);
        return (long) q.executeUnique();
	}
	
	public Horario darHorarioId (PersistenceManager pm, long idHorario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM HorarioES WHERE idHorario = ?");
		q.setResultClass(Horario.class);
		q.setParameters(idHorario);
		return (Horario) q.executeUnique();
	}
	
	public List<Horario> darHorario (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM HorarioES");
		q.setResultClass(Horario.class);
		return (List<Horario>) q.executeList();
	}
}
