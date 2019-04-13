package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioAlojamiento {

	/**
	 * @return El id del servicio alojamiento
	 */
	long getId();

	/**
	 * @param id - El nuevo id de la servicio alojamiento 
	 */
	void setId(long id);

	/**
	 * @return El numeroDePersonas del servicio alojamiento
	 */
	int getNumeroDePersonas();

	/**
	 * @param numeroDePersonas - El nuevo numeroDePersonas del servicio alojamiento
	 */
	void setNumeroDePersonas(int numeroDePersonas);

	/** 
	 * @return el id de la cuenta
	 */
	long getIdCuenta();

	/**
	 * @param idCuenta el nuevo id de la cuenta
	 */
	void setIdCuenta(long idCuenta);

	/**
	 * @return Una cadena con la información básica de la servicio alojamiento
	 */
	String toString();

}