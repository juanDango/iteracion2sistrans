package uniandes.isis2304.hotelAndes.negocio;

public interface VODotacion {

	long getIdDotacion();

	void setIdDotacion(long idDotacion);

	String getNombreObjeto();

	void setNombreObjeto(String nombreObjeto);

	char getEsCobrable();

	void setEsCobrable(char esCobrable);

	double getValorObjeto();

	void setValorObjeto(double valorObjeto);

	int getIdHabitacion();

	void setIdHabitacion(int idHabitacion);

	String toString();

}