package uniandes.isis2304.hotelAndes.negocio;

public class ServicioAlimentacion implements VOServicioAlimentacion {
	public ServicioAlimentacion(long idServicio, String nombreServicio, String estilo, long capacidad, String tipo,
			String descripcion, boolean esconsumohabitacion, long idhorario) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.estilo = estilo;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.esconsumohabitacion = esconsumohabitacion;
		this.idhorario = idhorario;
	}
	private long idServicio;
	private String nombreServicio;
	private String estilo;
	private long capacidad;
	private String tipo;
	private String descripcion;
	private boolean esconsumohabitacion;
	private long idhorario;
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getIdServicio()
	 */
	@Override
	public long getIdServicio() {
		return idServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setIdServicio(long)
	 */
	@Override
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getNombreServicio()
	 */
	@Override
	public String getNombreServicio() {
		return nombreServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setNombreServicio(java.lang.String)
	 */
	@Override
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getEstilo()
	 */
	@Override
	public String getEstilo() {
		return estilo;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setEstilo(java.lang.String)
	 */
	@Override
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getCapacidad()
	 */
	@Override
	public long getCapacidad() {
		return capacidad;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setCapacidad(long)
	 */
	@Override
	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getTipo()
	 */
	@Override
	public String getTipo() {
		return tipo;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setTipo(java.lang.String)
	 */
	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#isEsconsumohabitacion()
	 */
	@Override
	public boolean isEsconsumohabitacion() {
		return esconsumohabitacion;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setEsconsumohabitacion(boolean)
	 */
	@Override
	public void setEsconsumohabitacion(boolean esconsumohabitacion) {
		this.esconsumohabitacion = esconsumohabitacion;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getIdhorario()
	 */
	@Override
	public long getIdhorario() {
		return idhorario;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setIdhorario(long)
	 */
	@Override
	public void setIdhorario(long idhorario) {
		this.idhorario = idhorario;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#toString()
	 */
	@Override
	public String toString() {
		return "ServicioAlimentacion [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", estilo="
				+ estilo + ", capacidad=" + capacidad + ", tipo=" + tipo + ", descripcion=" + descripcion
				+ ", esconsumohabitac=" + esconsumohabitacion + ", idhorario=" + idhorario + "]";
	}
}
