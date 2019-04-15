package uniandes.isis2304.hotelAndes.negocio;

public interface VOHotel {

	String getNombreHotel();

	void setNombreHotel(String nombreHotel);

	long getEstrellas();

	void setEstrellas(long estrellas);

	String getCiudad();

	void setCiudad(String ciudad);

	String getPais();

	void setPais(String pais);

	long getIdCadenaHotelera();

	void setIdCadenaHotelera(long idCadenaHotelera);

	long getIdHotel();

	void setIdHotel(long idHotel);

	long getCantidadHabitaciones();

	void setCantidadHabitaciones(long cantidadHabitaciones);

	String toString();

}