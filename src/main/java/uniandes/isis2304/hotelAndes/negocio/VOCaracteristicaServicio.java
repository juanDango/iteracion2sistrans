package uniandes.isis2304.hotelAndes.negocio;

public interface VOCaracteristicaServicio {

	long getIdCaracteristica();

	void setIdCaracteristica(long idCaracteristica);

	long getIdServicio();

	void setIdServicio(long idServicio);

	String getNombreCaracteristica();

	void setNombreCaracteristica(String nombreCaracteristica);

	String getDescripcion();

	void setDescripcion(String descripcion);

	String toString();

}