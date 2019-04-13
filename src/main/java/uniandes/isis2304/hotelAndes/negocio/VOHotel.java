package uniandes.isis2304.hotelAndes.negocio;

public interface VOHotel {

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getId()
	 */
	long getId();

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setId(long)
	 */
	void setId(long id);

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getNombre()
	 */
	String getNombre();

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setNombre(java.lang.String)
	 */
	void setNombre(String nombre);

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getEstrellas()
	 */
	int getEstrellas();

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setEstrellas(int)
	 */
	void setEstrellas(int estrellas);

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getPais()
	 */
	String getPais();

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setPais(java.lang.String)
	 */
	void setPais(String pais);

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getCiudad()
	 */
	String getCiudad();

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setCiudad(java.lang.String)
	 */
	void setCiudad(String ciudad);

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getIdCadenaHotelera()
	 */
	long getIdCadenaHotelera();

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setIdCadenaHotelera(long)
	 */
	void setIdCadenaHotelera(long idCadenaHotelera);

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#toString()
	 */
	String toString();

}