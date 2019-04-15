package uniandes.isis2304.hotelAndes.negocio;

public class Producto implements VOProducto {
	
	//----------
	//Atributos
	//----------
	
	private long idProducto;
	
	private String nombreProducto;
	
	private long precio;
	
	//------------
	//Constructor
	//------------

	public Producto(long idProducto, String nombreProducto, long precio) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
	}

	public Producto() {
		this.idProducto = 0;
		this.nombreProducto = "";
		this.precio = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProducto#getIdProducto()
	 */
	@Override
	public long getIdProducto() {
		return idProducto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProducto#setIdProducto(long)
	 */
	@Override
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProducto#getNombreProducto()
	 */
	@Override
	public String getNombreProducto() {
		return nombreProducto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProducto#setNombreProducto(java.lang.String)
	 */
	@Override
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProducto#getPrecio()
	 */
	@Override
	public long getPrecio() {
		return precio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProducto#setPrecio(long)
	 */
	@Override
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProducto#toString()
	 */
	@Override
	public String toString() {
		return "Producto [id=" + idProducto + ", nombre=" + nombreProducto + ", precio=" + precio + "]";
	}

}
