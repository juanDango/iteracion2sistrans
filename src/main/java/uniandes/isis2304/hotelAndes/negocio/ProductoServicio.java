package uniandes.isis2304.hotelAndes.negocio;

public class ProductoServicio implements VOProductoServicio {

	private long idProducto;
	
	private long idServicio;
	
	public ProductoServicio(){
		idProducto = 0;
		idServicio = 0;
	}

	public ProductoServicio(long idProducto, long idServicio) {
		this.idProducto = idProducto;
		this.idServicio = idServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProductoServicio#getIdProducto()
	 */
	@Override
	public long getIdProducto() {
		return idProducto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProductoServicio#setIdProducto(long)
	 */
	@Override
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProductoServicio#getIdServicio()
	 */
	@Override
	public long getIdServicio() {
		return idServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProductoServicio#setIdServicio(long)
	 */
	@Override
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProductoServicio#toString()
	 */
	@Override
	public String toString() 
	{
		return "Producto Servicio [idProducto=" + idProducto + ", idServicio=" + idServicio + "]";
	}
}
