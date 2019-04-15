package uniandes.isis2304.hotelAndes.negocio;

public interface VOHabitacion {

	long getIdHabitacion();

	void setIdHabitacion(long idHabitacion);

	String getTipoHabitacion();

	void setTipoHabitacion(String tipoHabitacion);

	long getCostoNoche();

	void setCostoNoche(long costoNoche);

	long getCapacidadHabitacion();

	void setCapacidadHabitacion(long capacidadHabitacion);

	long getIdHotel();

	void setIdHotel(long idHotel);

	long getNumeroHabitacion();

	void setNumeroHabitacion(long numeroHabitacion);

	String toString();

}