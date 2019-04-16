package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioAlimentacion {

	long getIdServicio();

	void setIdServicio(long idServicio);

	String getNombreServicio();

	void setNombreServicio(String nombreServicio);

	String getEstilo();

	void setEstilo(String estilo);

	long getCapacidad();

	void setCapacidad(long capacidad);

	String getTipo();

	void setTipo(String tipo);

	String getDescripcion();

	void setDescripcion(String descripcion);

	boolean isEsconsumohabitacion();

	void setEsconsumohabitacion(boolean esconsumohabitacion);

	long getIdhorario();

	void setIdhorario(long idhorario);

	String toString();

}