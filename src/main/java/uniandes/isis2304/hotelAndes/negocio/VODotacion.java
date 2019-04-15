package uniandes.isis2304.hotelAndes.negocio;

public interface VODotacion {

	long getIdDotacion();

	void setIdDotacion(long idDotacion);

	String getNombreObjeto();

	void setNombreObjeto(String nombreObjeto);

	char getEsCobrable();

	void setEsCobrable(char esCobrable);

	long getValorObjeto();

	void setValorObjeto(long valorObjeto);

	long getIdHabitacion();

	void setIdHabitacion(long idHabitacion);

	String toString();

}