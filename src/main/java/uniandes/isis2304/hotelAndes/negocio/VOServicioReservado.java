package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioReservado {

	String getNombreEspecifico();

	void setNombreEspecifico(String nombreEspecifico);

	String getTipo();

	void setTipo(String tipo);

	long getDuracion();

	void setDuracion(long duracion);

	String getDescripcion();

	void setDescripcion(String descripcion);

	long getCosto();

	void setCosto(long costo);

}