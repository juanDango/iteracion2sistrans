package uniandes.isis2304.hotelAndes.negocio;

public interface VOConvencion {

	long getIdConvencion();

	void setIdConvencion(long idConvencion);

	long getIdHotel();

	void setIdHotel(long idHotel);

	long getNumParticipantes();

	void setNumParticipantes(long numParticipantes);

	String getNombreConvencion();

	void setNombreConvencion(String nombreConvencion);

	String toString();

}