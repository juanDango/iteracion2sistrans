package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioReservado {

	long getIdServicio();

	void setIdServicio(long idServicio);

	String getNombreEspecifico();

	void setNombreEspecifico(String nombreEspecifico);

	String getTipo();

	void setTipo(String tipo);

	long getDuracion();

	void setDuracion(long duracion);

	String getNombreservicio();

	void setNombreservicio(String nombreservicio);

	String getDescripcion();

	void setDescripcion(String descripcion);

	long getCosto();

	void setCosto(long costo);

}