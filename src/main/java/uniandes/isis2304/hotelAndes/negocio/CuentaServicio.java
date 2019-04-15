package uniandes.isis2304.hotelAndes.negocio;

public class CuentaServicio implements VOCuentaServicio {

	//----------
	//Atributos
	//----------
	
	private long idCuenta;
	
	private long idServicio;

	//------------
	//Constructor
	//------------

	public CuentaServicio(long idCuenta, long idServicio) {
		this.idCuenta = idCuenta;
		this.idServicio = idServicio;
	}

	public CuentaServicio() {
		this.idCuenta = 0;
		this.idServicio = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaServicio#getIdCuenta()
	 */
	@Override
	public long getIdCuenta() {
		return idCuenta;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaServicio#setIdCuenta(long)
	 */
	@Override
	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaServicio#getIdServicio()
	 */
	@Override
	public long getIdServicio() {
		return idServicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaServicio#setIdServicio(long)
	 */
	@Override
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuentaServicio#toString()
	 */
	@Override
	public String toString() {
		return "Cuenta Servicio [Cuenta=" + idCuenta + ", servicio=" + idServicio + "]";
	}
	
}
