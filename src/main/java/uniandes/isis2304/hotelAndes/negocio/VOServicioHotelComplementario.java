package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioHotelComplementario {

	/**
	 * @return El id del Servicio Hotel Complementario
	 */
	long getId();

	/**
	 * @param id - El nuevo id del Servicio Hotel Complementario 
	 */
	void setId(long id);

	/**
	 * @return El nombre del Servicio Hotel Complementario
	 */
	String getNombre();

	/**
	 * @param nombre - El nuevo nombre del Servicio Hotel Complementario
	 */
	void setNombre(String nombre);

	long getIdHotel();

	void setIdHotel(long idHotel);

	/**
	 * @return Una cadena con la información básica del Servicio Hotel Complementario
	 */
	String toString();

}