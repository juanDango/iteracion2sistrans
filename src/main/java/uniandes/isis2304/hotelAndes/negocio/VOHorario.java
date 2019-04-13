package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

public interface VOHorario {

	/**
	 * @return el id del horario
	 */
	long getIdHorario();

	/**
	 * @param idHorario - el nuevo valor para el id
	 */
	void setIdHorario(long idHorario);

	/**
	 * @return la fecha inicial del horario
	 */
	Timestamp getFechaInicial();

	/**
	 * @param fechaInicial - nueva fecha inicial del horario
	 */
	void setFechaInicial(Timestamp fechaInicial);

	/**
	 * @return la hora inicial del horario
	 */
	int getHoraInicial();

	/**
	 * @param horaInicial - La nueva hora inicial
	 */
	void setHoraInicial(int horaInicial);

	/**
	 * @return la fecha final del horario
	 */
	Timestamp getFechaFinal();

	/**
	 * @param fechaFinal - El nuevo valor de la fecha final
	 */
	void setFechaFinal(Timestamp fechaFinal);

	/**
	 * @return hora a la que finaliza el servicio
	 */
	int getHoraFinal();

	/**
	 * @param horaFinal nuevo valor para la hora final
	 */
	void setHoraFinal(int horaFinal);

	/**
	 * @return Una cadena con la información básica de la Horario
	 */
	String toString();

}