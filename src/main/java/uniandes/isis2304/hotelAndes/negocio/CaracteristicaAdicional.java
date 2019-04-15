package uniandes.isis2304.hotelAndes.negocio;

public class CaracteristicaAdicional implements VOCaracteristicaAdicional {
	
	//------------
	//Atributos
	//------------
	
	private long idCaracteristicaAdicional;
	
	private long limite;
	
	private long dcto;
	
	private String descripcion;
	
	private long idServicioComplementario;
	
	private long idServicioAlojamiento;

	//-------------
	//Constructor
	//-------------
	
	public CaracteristicaAdicional(long idCaracteristicaAdicional, long limite, long dcto, String descripcion,
			long idServicioComplementario, long idServicioAlojamiento) {
		super();
		this.idCaracteristicaAdicional = idCaracteristicaAdicional;
		this.limite = limite;
		this.dcto = dcto;
		this.descripcion = descripcion;
		this.idServicioComplementario = idServicioComplementario;
		this.idServicioAlojamiento = idServicioAlojamiento;
	}
	
	public CaracteristicaAdicional() {
		super();
		this.idCaracteristicaAdicional = 0;
		this.limite = 0;
		this.dcto = 0;
		this.descripcion = "";
		this.idServicioComplementario = 0;
		this.idServicioAlojamiento = 0;
	}

	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#getIdCaracteristicaAdicional()
	 */
	@Override
	public long getIdCaracteristicaAdicional() {
		return idCaracteristicaAdicional;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#setIdCaracteristicaAdicional(long)
	 */
	@Override
	public void setIdCaracteristicaAdicional(long idCaracteristicaAdicional) {
		this.idCaracteristicaAdicional = idCaracteristicaAdicional;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#getLimite()
	 */
	@Override
	public long getLimite() {
		return limite;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#setLimite(long)
	 */
	@Override
	public void setLimite(long limite) {
		this.limite = limite;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#getDcto()
	 */
	@Override
	public long getDcto() {
		return dcto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#setDcto(long)
	 */
	@Override
	public void setDcto(long dcto) {
		this.dcto = dcto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#getIdServicioComplementario()
	 */
	@Override
	public long getIdServicioComplementario() {
		return idServicioComplementario;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#setIdServicioComplementario(long)
	 */
	@Override
	public void setIdServicioComplementario(long idServicioComplementario) {
		this.idServicioComplementario = idServicioComplementario;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#getIdServicioAlojamiento()
	 */
	@Override
	public long getIdServicioAlojamiento() {
		return idServicioAlojamiento;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#setIdServicioAlojamiento(long)
	 */
	@Override
	public void setIdServicioAlojamiento(long idServicioAlojamiento) {
		this.idServicioAlojamiento = idServicioAlojamiento;
	}
	
	//---------
	//toString
	//---------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaAdicional#toString()
	 */
	@Override
	public String toString() {
		return "Caracteristica Adicional [id=" + idCaracteristicaAdicional + ", límite=" + limite + ", dcto=" + dcto + ", descripcion=" + descripcion + ", idServicio=" + idServicioComplementario + ", idAlojamiento=" + idServicioAlojamiento +"]";
	}
	
}
