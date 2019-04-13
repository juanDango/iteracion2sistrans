package uniandes.isis2304.hotelAndes.negocio;

public interface VOCuenta {

	/**
	 * @return El id de la Cuenta
	 */
	long getIdCuenta();

	/**
	 * @param id - El nuevo id de la Cuenta 
	 */
	void setIdCuenta(long id);

	/**
	 * @return El valor de la Cuenta
	 */
	double getValor();

	/**
	 * @param valor - El nuevo valor de la Cuenta
	 */
	void setValor(int valor);

	/**
	 * @return el tipo de pago de la cuenta
	 */
	String getmetodoPago();

	/**
	 * @param tipo - el nuevo tipo de pago de la cuenta
	 */
	void setmetodoPago(String tipo);

	/**
	 * @return cedula
	 */
	long getCedula();

	/**
	 * @param cedula, la nueva cedula
	 */
	void setCedula(long cedula);

	/**
	 * @return el plan de consumo asociado
	 */
	long getIdPlanConsumo();

	/**
	 * @param IdPlanConsumo, el nuevo plan de consumo
	 */
	void setIdPlanConsumo(long IdPlanConsumo);

	/**
	 * @return Una cadena con la información básica de la Cuenta
	 */
	String toString();

}