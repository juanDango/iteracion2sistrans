package uniandes.isis2304.hotelAndes.negocio;

public interface VORegistro {

	long getIdRegistro();

	void setIdRegistro(long idRegistro);

	long getIdReserva();

	void setIdReserva(long idReserva);

	char getEstadoCheckIn();

	void setEstadoCheckIn(char estadoCheckIn);

	char getEstadoCheckOut();

	void setEstadoCheckOut(char estadoCheckOut);

	long getIdRegistrador();

	void setIdRegistrador(long idRegistrador);

	String toString();

}