package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

public interface VOPlan {

	/**
	 * @return El id de la Plan
	 */
	long getId();

	/**
	 * @param id - El nuevo id de la Plan 
	 */
	void setId(long id);

	/**
	 * @return El nombre de la Plan
	 */
	String getNombrePlan();

	/**
	 * @param nombre - El nuevo nombre de la Plan
	 */
	void setNombrePlan(String nombrePlan);

	/**
	 * @return el tipo de la bebida
	 */
	String getTipo();

	/**
	 * @param tipo, el nuevo tipo de bebida
	 */
	void setTipo(String tipo);

	/**
	 * @return la fecha inicial
	 */
	Timestamp getFechaInicial();

	/**
	 * @param fechaInicial, la nueva fecha inicial
	 */
	void setFechaInicial(Timestamp fechaInicial);

	/**
	 * @return la fecha final del plan
	 */
	Timestamp getFechaFinal();

	/**
	 * @param fechaFinal, la nueva fecha final del plan
	 */
	void setFechaFinal(Timestamp fechaFinal);

	/**
	 * @return Una cadena con la información básica de la Plan
	 */
	String toString();

}