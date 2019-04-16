package uniandes.isis2304.hotelAndes.negocio;

public class ServicioReservado extends ServicioHotelComplementario implements VOServicioReservado {

	
	private String nombreEspecifico;
	private String tipo;
	private long duracion;
	private String descripcion;
	private long costo;
	
	public ServicioReservado(long idSComplementario, String nombreServicio, long idHotel, String nombreEspecifico,
			String tipo, long duracion, String descripcion, long costo) {
		super(idSComplementario, nombreServicio, idHotel);
		this.nombreEspecifico = nombreEspecifico;
		this.tipo = tipo;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.costo = costo;
	}
	
	public ServicioReservado() {
		super();
		this.nombreEspecifico = "";
		this.tipo = "";
		this.duracion = 0;
		this.descripcion = "";
		this.costo = 0;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#getNombreEspecifico()
	 */
	@Override
	public String getNombreEspecifico() {
		return nombreEspecifico;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#setNombreEspecifico(java.lang.String)
	 */
	@Override
	public void setNombreEspecifico(String nombreEspecifico) {
		this.nombreEspecifico = nombreEspecifico;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#getTipo()
	 */
	@Override
	public String getTipo() {
		return tipo;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#setTipo(java.lang.String)
	 */
	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#getDuracion()
	 */
	@Override
	public long getDuracion() {
		return duracion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#setDuracion(long)
	 */
	@Override
	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#getCosto()
	 */
	@Override
	public long getCosto() {
		return costo;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#setCosto(long)
	 */
	@Override
	public void setCosto(long costo) {
		this.costo = costo;
	}
	
	@Override
	public String toString() {
		return "ServicioReservado "+ super.toStringTemporal()+", nombreEspecifico="+nombreEspecifico+", tipo="+tipo+", duracion="+duracion+", descripcion="+descripcion+", costo="+costo+"]";	
	}
}
