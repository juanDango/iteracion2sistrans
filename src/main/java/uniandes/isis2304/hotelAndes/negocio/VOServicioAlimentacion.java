package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioAlimentacion {

	String getNombreServicio();

	void setNombreServicio(String nombreServicio);

	int getCapacidad();

	void setCapacidad(int capacidad);

	String getTipo();

	void setTipo(String tipo);

	int getEsConsumoHabitacion();

	void setEsConsumoHabitacion(int esConsumoHabitacion);

	long getIdHorario();

	void setIdHorario(long idHorario);

	String getDescripcion();

	void setDescripcion(String descripcion);

	String toString();
	
	public String getEstilo();

	public void setEstilo(String estilo);

}