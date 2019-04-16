package uniandes.isis2304.hotelAndes.negocio;

public class ServicioReservado implements VOServicioReservado {
	public ServicioReservado(long idServicio, String nombreEspecifico, String tipo, long duracion,
			String nombreservicio, String descripcion, long costo) {
		super();
		this.idServicio = idServicio;
		this.nombreEspecifico = nombreEspecifico;
		this.tipo = tipo;
		this.duracion = duracion;
		this.nombreservicio = nombreservicio;
		this.descripcion = descripcion;
		this.costo = costo;
	}
	private long idServicio;
	private String nombreEspecifico;
	private String tipo;
	private long duracion;
	private String nombreservicio;
	private String descripcion;
	private long costo;
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#getIdServicio()
	 */
	@Override
	public long getIdServicio() {
		return idServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#setIdServicio(long)
	 */
	@Override
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
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
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#getNombreservicio()
	 */
	@Override
	public String getNombreservicio() {
		return nombreservicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioReservado#setNombreservicio(java.lang.String)
	 */
	@Override
	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
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
		return "ServicioReservado [idServicio=" + idServicio + ", nombreEspecifico=" + nombreEspecifico + ", tipo="
				+ tipo + ", duracion=" + duracion + ", nombreservicio=" + nombreservicio + ", descripcion="
				+ descripcion + ", costo=" + costo + "]";
	}



}
