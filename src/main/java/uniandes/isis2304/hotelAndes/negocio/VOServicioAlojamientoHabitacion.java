package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioAlojamientoHabitacion {

	/**
	 * @return El id de la Habitacion
	 */
	long getIdHabitacion();

	/**
	 * @param id - El nuevo id de la Habitacion 
	 */
	void setId(long id);

	/**
	 * @return El id del Servicio Alojamiento 
	 */
	long getIdServicioAlojamiento();

	/**
	 * @param nombre - El nuevo id del Servicio Alojamiento 
	 */
	void setIdServicioAlojamiento(long idServicioAlojamiento);

	/**
	 * @return Una cadena con la información básica de la Servicio Alojamiento Habitacion
	 */
	String toString();

}