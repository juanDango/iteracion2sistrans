package uniandes.isis2304.hotelAndes.negocio;

public class ServicioIncluido implements VOServicioIncluido {
	public ServicioIncluido(long idServicio, String nombreServicio, String tipo, long cantuniandes,
			String nombreservicio2, String descripcion, long costounitario) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.tipo = tipo;
		this.cantuniandes = cantuniandes;
		nombreservicio = nombreservicio2;
		this.descripcion = descripcion;
		this.costounitario = costounitario;
	}
	private long idServicio;
	private String nombreServicio;
	private String tipo;
	private long cantuniandes;
	private String nombreservicio;
	private String descripcion;
	private long costounitario;
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#getIdServicio()
	 */
	@Override
	public long getIdServicio() {
		return idServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#setIdServicio(long)
	 */
	@Override
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#getNombreServicio()
	 */
	@Override
	public String getNombreServicio() {
		return nombreServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#setNombreServicio(java.lang.String)
	 */
	@Override
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#getTipo()
	 */
	@Override
	public String getTipo() {
		return tipo;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#setTipo(java.lang.String)
	 */
	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#getCantuniandes()
	 */
	@Override
	public long getCantuniandes() {
		return cantuniandes;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#setCantuniandes(long)
	 */
	@Override
	public void setCantuniandes(long cantuniandes) {
		this.cantuniandes = cantuniandes;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#getNombreservicio()
	 */
	@Override
	public String getNombreservicio() {
		return nombreservicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#setNombreservicio(java.lang.String)
	 */
	@Override
	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#getCostounitario()
	 */
	@Override
	public long getCostounitario() {
		return costounitario;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#setCostounitario(long)
	 */
	@Override
	public void setCostounitario(long costounitario) {
		this.costounitario = costounitario;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido#toString()
	 */
	@Override
	public String toString() {
		return "ServicioIncluido [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", tipo=" + tipo
				+ ", cantuniandes=" + cantuniandes + ", nombreservicio=" + nombreservicio + ", descripcion="
				+ descripcion + ", costounitario=" + costounitario + "]";
	}
}
