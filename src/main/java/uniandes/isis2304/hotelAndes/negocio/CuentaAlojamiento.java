package uniandes.isis2304.hotelAndes.negocio;

public class CuentaAlojamiento implements VOCuentaAlojamiento {
	private long idCuenta;
	
	private long idServicio;
	
	public CuentaAlojamiento(){
		idCuenta = 0;
		idServicio = 0;
	}

	public CuentaAlojamiento(long idCuenta, long idServicio) {
		super();
		this.idCuenta = idCuenta;
		this.idServicio = idServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaAlojamiento#getIdCuenta()
	 */
	@Override
	public long getIdCuenta() {
		return idCuenta;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaAlojamiento#setIdCuenta(long)
	 */
	@Override
	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaAlojamiento#getIdServicio()
	 */
	@Override
	public long getIdServicio() {
		return idServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaAlojamiento#setIdServicio(long)
	 */
	@Override
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaAlojamiento#toString()
	 */
	@Override
	public String toString() 
	{
		return "Producto Servicio [idCuenta=" + idCuenta + ", idServicio=" + idServicio + "]";
	}
}
