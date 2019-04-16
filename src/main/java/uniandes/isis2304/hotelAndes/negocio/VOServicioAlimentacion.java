package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioAlimentacion {

	String getEstilo();

	void setEstilo(String estilo);

	long getCapacidad();

	void setCapacidad(long capacidad);

	String getTipo();

	void setTipo(String tipo);

	char getEsConsumoHabitacion();

	void setEsConsumoHabitacion(char esConsumoHabitacion);

	long getIdHorario();

	void setIdHorario(long idHorario);

	String getDescripcion();

	void setDescripcion(String descripcion);

	String toString();

}