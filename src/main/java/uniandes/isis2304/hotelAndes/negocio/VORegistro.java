package uniandes.isis2304.hotelAndes.negocio;

public interface VORegistro {

	long getIdRegistro();

	void setIdRegistro(long idRegistro);

	long getIdReserva();

	void setIdReserva(long idReserva);

	char getCheckIn();

	void setCheckIn(char checkIn);

	char getCheckOut();

	void setCheckOut(char checkOut);

	String toString();

}