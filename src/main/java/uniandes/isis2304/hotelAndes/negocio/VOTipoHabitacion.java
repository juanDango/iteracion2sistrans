package uniandes.isis2304.hotelAndes.negocio;

public interface VOTipoHabitacion {

	/**
	 * @return El nombreTipo de la Tipo Habitacion
	 */
	String getnombreTipo();

	/**
	 * @param nombreTipo - El nuevo nombreTipo de la Tipo Habitacion 
	 */
	void setnombreTipo(String nombreTipo);

	/**
	 * @return El descripcion de la Tipo Habitacion
	 */
	String getdescripcion();

	/**
	 * @param descripcion - El nuevo descripcion de la Tipo Habitacion
	 */
	void setdescripcion(String descripcion);

	/**
	 * @return Una cadena con la información básica de la Tipo Habitacion
	 */
	String toString();

}