package uniandes.isis2304.hotelAndes.negocio;

public class CuentaAlojamiento implements VOCuentaAlojamiento {

	//----------
	//Atributos
	//----------
	
	private long idCuenta;
	
	private long idServicioAlojamiento;
	
	//------------
	//Constructor
	//------------
	
	public CuentaAlojamiento(long idCuenta, long idServicioAlojamiento) {
		this.idCuenta = idCuenta;
		this.idServicioAlojamiento = idServicioAlojamiento;
	}
	
	public CuentaAlojamiento() {
		super();
		this.idCuenta = 0;
		this.idServicioAlojamiento = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaAlojamiento#getIdCuenta()
	 */
	@Override
	public long getIdCuenta() {
		return idCuenta;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaAlojamiento#setIdCuenta(long)
	 */
	@Override
	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaAlojamiento#getIdServicioAlojamiento()
	 */
	@Override
	public long getIdServicioAlojamiento() {
		return idServicioAlojamiento;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaAlojamiento#setIdServicioAlojamiento(long)
	 */
	@Override
	public void setIdServicioAlojamiento(long idServicioAlojamiento) {
		this.idServicioAlojamiento = idServicioAlojamiento;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaAlojamiento#toString()
	 */
	@Override
	public String toString() {
		return "Cuenta Alojamiento [idCuenta=" + idCuenta + ", idAlojamiento=" + idServicioAlojamiento + "]";
	}
}
