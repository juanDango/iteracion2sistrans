package uniandes.isis2304.hotelAndes.negocio;

public interface VOCuentaServicio {

	/**
	 * @return El id de la Cadena Hotelera
	 */
	long getidCuenta();

	/**
	 * @param id - El nuevo id de la Cadena Hotelera 
	 */
	void setidCuenta(long id);

	/**
	 * @return El nombre de la Cadena Hotelera
	 */
	long getidServicioComplementario();

	/**
	 * @param nombre - El nuevo nombre de la Cadena Hotelera
	 */
	void setidServicioComplementario(long idServicioComplementario);

	/**
	 * @return Una cadena con la información básica de la Cadena Hotelera
	 */
	String toString();

}