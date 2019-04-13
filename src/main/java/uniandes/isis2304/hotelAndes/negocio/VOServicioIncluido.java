package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioIncluido {

	/**
	 * @return el nombre del servicio
	 */
	String getNombreServicio();

	/**
	 * @param nombreServicio el nuevo nombre del servicio
	 */
	void setNombreServicio(String nombreServicio);

	/**
	 * @return la capacidad del lugar
	 */
	int getCapacidad();

	/**
	 * @param capacidad - la nueva capacidad del lugar
	 */
	void setCapacidad(int capacidad);


	/**
	 * @return Una cadena con la información básica de la Servicio Incluido
	 */
	String toString();

}