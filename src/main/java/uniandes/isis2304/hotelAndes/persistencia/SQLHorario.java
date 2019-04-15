package uniandes.isis2304.hotelAndes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Horario;

public class SQLHorario {

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

	public SQLHorario(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarHorario(PersistenceManager pm, long idHorario, long horaInicio, long horaFinal, Timestamp fechaInicio, Timestamp fechaFinal)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaHorario() + " (IDHORARIO, HORAINICIO, HORAFINAL, FECHAINICIO, FECHAFINAL) VALUES (?, ?, ?, ?, ?) ");
		q.setParameters(idHorario, horaInicio, horaFinal, fechaInicio, fechaFinal);
		return (long)q.executeUnique();
	}

	public Horario darHorarioPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaHorario() + " WHERE IDHORARIO = ?");
		q.setResultClass(Horario.class);
		q.setParameters(id);
		return (Horario) q.executeUnique();
	}
	
}
