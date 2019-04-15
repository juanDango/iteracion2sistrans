package uniandes.isis2304.hotelAndes.negocio;

public class ProductoServicio implements VOProductoServicio {

	//----------
	//Atributos
	//----------
	
	private long idProducto;
	
	private long idServicio;
	
	//------------
	//Constructor
	//------------

	public ProductoServicio(long idProducto, long idServicio) {
		super();
		this.idProducto = idProducto;
		this.idServicio = idServicio;
	}

	public ProductoServicio() {
		this.idProducto = 0;
		this.idServicio = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProductoServicio#getIdProducto()
	 */
	@Override
	public long getIdProducto() {
		return idProducto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProductoServicio#setIdProducto(long)
	 */
	@Override
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProductoServicio#getIdServicio()
	 */
	@Override
	public long getIdServicio() {
		return idServicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProductoServicio#setIdServicio(long)
	 */
	@Override
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOProductoServicio#toString()
	 */
	@Override
	public String toString() {
		return "Producto Servicio [producto=" + idProducto + ", servicio=" + idServicio + "]";
	}
	
}
