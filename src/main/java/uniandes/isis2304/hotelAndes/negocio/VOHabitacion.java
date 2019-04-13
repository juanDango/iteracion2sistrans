package uniandes.isis2304.hotelAndes.negocio;

public interface VOHabitacion {

	/**
	 * @return el tipo de documento del Habitacion
	 */
	long getIdHabitacion();

	/**
	 * @param idHabitacion - El nuevo tipo de documento del Habitacion
	 */
	void setIdHabitacion(long idHabitacion);

	/**
	 * @return el Numero de documento del Habitacion
	 */
	String getTipoHabitacion();

	/**
	 * @param tipoHabitacion - El nuevo numero de documento
	 */
	void setTipoHabitacion(String tipoHabitacion);

	/**
	 * @return el correo electronico asociado
	 */
	long getIdHotel();

	/**
	 * @param idHotel - el nuevo correo electronico a asociar
	 */
	void setIdHotel(long idHotel);

	/**
	 * @return el costoNoche del Habitacion
	 */
	double getCostoNoche();

	/**
	 * @param costoNoche - el nuevo costoNoche del Habitacion
	 */
	void setcostoNoche(double costoNoche);

	/**
	 * @return el capacidad del Habitacion
	 */
	int getCapacidad();

	/** 
	 * @param capacidad - El capacidad a cambiar del Habitacion
	 */
	void setCapacidad(int capacidad);

	/**
	 * @return Una cadena con la información básica del Habitacion
	 */
	String toString();

}