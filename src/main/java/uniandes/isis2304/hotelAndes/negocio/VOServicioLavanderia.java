package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioLavanderia {

	String getnombreSer();

	void setnombreSer(String nombreSer);

	String getDescripcion();

	void setDescripcion(String descripcion);

	String getTipo();

	void setTipo(String tipo);

	double getCostoUnitario();

	void setCostoUnitario(double costoUnitario);

	int getCantUnidades();

	void setCantUnidades(int cantUnidades);

	String toString();

}