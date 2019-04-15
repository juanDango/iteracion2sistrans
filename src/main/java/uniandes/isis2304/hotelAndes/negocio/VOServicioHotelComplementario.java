package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioHotelComplementario {

	long getIdSComplementario();

	void setIdSComplementario(long idSComplementario);

	String getNombreServicio();

	void setNombreServicio(String nombreServicio);

	long getIdHotel();

	void setIdHotel(long idHotel);

	String toString();

}