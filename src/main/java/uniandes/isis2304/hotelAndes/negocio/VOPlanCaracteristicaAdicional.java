package uniandes.isis2304.hotelAndes.negocio;

public interface VOPlanCaracteristicaAdicional {

	/**
	 * @return El id del Plan
	 */
	long getIdPlan();

	/**
	 * @param id - El nuevo id del Plan 
	 */
	void setIdPlan(long id);

	/**
	 * @return El id de la Caracteristica Adicional
	 */
	long getIdCaracteristicaAd();

	/**
	 * @param nombre - El nuevo id de la Caracteristica Adicional
	 */
	void setIdCaracteristicaAd(long idCaracteristicaAd);

	/**
	 * @return Una cadena con la información básica de la Plan Caracteristica Adicional
	 */
	String toString();

}