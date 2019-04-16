package uniandes.isis2304.hotelAndes.negocio;

public class ServicioAlojamiento implements VOServicioAlojamiento {
	public ServicioAlojamiento(long idServicioAlojamiento, long cantpersonas, long idcuenta) {
		super();
		this.idServicioAlojamiento = idServicioAlojamiento;
		this.cantpersonas = cantpersonas;
		this.idcuenta = idcuenta;
	}

	private long idServicioAlojamiento;

	private long cantpersonas;
	
	private long idcuenta;

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamiento#getIdServicioAlojamiento()
	 */
	@Override
	public long getIdServicioAlojamiento() {
		return idServicioAlojamiento;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamiento#setIdServicioAlojamiento(long)
	 */
	@Override
	public void setIdServicioAlojamiento(long idServicioAlojamiento) {
		this.idServicioAlojamiento = idServicioAlojamiento;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamiento#getCantpersonas()
	 */
	@Override
	public long getCantpersonas() {
		return cantpersonas;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamiento#setCantpersonas(long)
	 */
	@Override
	public void setCantpersonas(long cantpersonas) {
		this.cantpersonas = cantpersonas;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamiento#getIdcuenta()
	 */
	@Override
	public long getIdcuenta() {
		return idcuenta;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamiento#setIdcuenta(long)
	 */
	@Override
	public void setIdcuenta(long idcuenta) {
		this.idcuenta = idcuenta;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamiento#toString()
	 */
	@Override
	public String toString() {
		return "ServicioAlojamiento [idServicioAlojamiento=" + idServicioAlojamiento + ", cantpersonas=" + cantpersonas
				+ ", idcuenta=" + idcuenta + "]";
	}
}
