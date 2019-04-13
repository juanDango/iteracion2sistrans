package uniandes.isis2304.hotelAndes.negocio;

public interface VOProducti {

	/**
	 * @return El id del Producto
	 */
	long getId();

	/**
	 * @param id - El nuevo id del Producto 
	 */
	void setId(long id);

	/**
	 * @return El nombre del Producto
	 */
	String getNombreProducto();

	/**
	 * @param nombre - El nuevo nombre del Producto
	 */
	void setNombreProducto(String nombre);

	/**
	 * @return el precio del producto
	 */
	double getPrecio();

	/**
	 * @param precio - Nuevo precio del producto
	 */
	void setPrecio(double precio);

	/**
	 * @return Una cadena con la información básica del Producto
	 */
	String toString();

}