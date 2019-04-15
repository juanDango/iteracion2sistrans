package uniandes.isis2304.hotelAndes.negocio;

public interface VOProducto {

	long getIdProducto();

	void setIdProducto(long idProducto);

	String getNombreProducto();

	void setNombreProducto(String nombreProducto);

	long getPrecio();

	void setPrecio(long precio);

	String toString();

}