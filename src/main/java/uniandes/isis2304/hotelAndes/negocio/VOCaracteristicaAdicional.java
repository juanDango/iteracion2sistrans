package uniandes.isis2304.hotelAndes.negocio;

public interface VOCaracteristicaAdicional {

	/**
	 * @return El id de la Caracteristica Adicional
	 */
	long getIdCaracteristica();

	/**
	 * @param id - El nuevo id de la Caracteristica Adicional 
	 */
	void setIdCaracteristica(long id);

	/**
	 * @return El nombre de la Caracteristica Adicional
	 */
	int getLimite();

	/**
	 * @param nombre - El nuevo nombre de la Caracteristica Adicional
	 */
	void setLimite(int limite);

	/**
	 * @return el descuento de la Caracteristica
	 */
	double getDcto();

	/**
	 * @param dcto - el nuevo valor del descuento
	 */
	void setDcto(double dcto);

	/**
	 * @return la descripcion de la Caracteristica
	 */
	String getDescripcion();

	/**
	 * @param descripcion - el nuevo valor de la descripcion
	 */
	void setDescripcion(String descripcion);

	/**
	 * @return el id del plan de consumo asociado
	 */
	long getPlanDeConsumoId();

	/**
	 * @param planDeConsumoId el nuevo id del plan de consumo
	 */
	void setPlanDeConsumoId(long planDeConsumoId);

	/**
	 * @return el id del servicio del hotel
	 */
	long getIdServicioHotel();

	/**
	 * @param idServicioHotel - El nuevo id del servicio del hotel
	 */
	void setIdServicioHotel(long idServicioHotel);

	/**
	 * @return Una cadena con la información básica de la Caracteristica Adicional
	 */
	String toString();

}