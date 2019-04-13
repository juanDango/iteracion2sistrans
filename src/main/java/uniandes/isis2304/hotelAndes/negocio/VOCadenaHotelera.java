package uniandes.isis2304.hotelAndes.negocio;

public interface VOCadenaHotelera {

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.ICadenaHotelera#getId()
	 */
	long getId();

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.ICadenaHotelera#setId(long)
	 */
	void setId(long id);

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.ICadenaHotelera#getNombre()
	 */
	String getNombre();

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.ICadenaHotelera#setNombre(java.lang.String)
	 */
	void setNombre(String nombre);

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.ICadenaHotelera#toString()
	 */
	String toString();

}