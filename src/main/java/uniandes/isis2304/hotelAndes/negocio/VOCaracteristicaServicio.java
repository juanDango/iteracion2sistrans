package uniandes.isis2304.hotelAndes.negocio;

public interface VOCaracteristicaServicio {

	long getIdCaracteristica();

	void setIdCaracteristica(long idCaracteristica);

	long getidServicio();

	void setidServicio(long idServicio);

	String getDescripcion();

	void setDescripcion(String descripcion);

	String getnombreCaracteristica();

	void setnombreCaracteristica(String nombreCaracteristica);

	/**
	 * @return Una cadena con la información básica de la Caracteristica Adicional
	 */
	String toString();

}