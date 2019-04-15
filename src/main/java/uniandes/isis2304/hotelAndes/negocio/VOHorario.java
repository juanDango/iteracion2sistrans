package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

public interface VOHorario {

	long getIdHorario();

	void setIdHorario(long idHorario);

	long getHoraInicio();

	void setHoraInicio(long horaInicio);

	long getHoraFinal();

	void setHoraFinal(long horaFinal);

	Timestamp getFechaInicio();

	void setFechaInicio(Timestamp fechaInicio);

	Timestamp getFechaFinal();

	void setFechaFinal(Timestamp fechaFinal);

	String toString();

}