package uniandes.isis2304.hotelAndes.negocio;

public interface VOSalon {

	/**
	 * @return el nombre del salon 
	 */
	String getNombreSalon();

	/**
	 * @param nombreSalon - El nuevo nombre del salon
	 */
	void setNombreSalon(String nombreSalon);

	/**
	 * @return la capacidad del salon
	 */
	int getCapacidad();

	/**
	 * @param capacidad - La nueva capacidad del salon
	 */
	void setCapacidad(int capacidad);

	/**
	 * @return el costo por hora del salon
	 */
	double getCostoPorHora();

	/**
	 * @param costoPorHora - El nuevo costo por hora del salon
	 */
	void setCostoPorHora(double costoPorHora);

	String toString();

}