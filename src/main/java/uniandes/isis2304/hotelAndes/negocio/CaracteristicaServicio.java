package uniandes.isis2304.hotelAndes.negocio;

public class CaracteristicaServicio implements VOCaracteristicaServicio {

	private long idCaracteristica;
	
	private long idServicio;
	
	private String descripcion;
	
	private String nombreCaracteristica;
	
	public CaracteristicaServicio(){
		idCaracteristica = 0;
		idServicio = 0;
		descripcion = "";
		nombreCaracteristica = "";
	}

	public CaracteristicaServicio(long idCaracteristica, long idServicio, String descripcion,
			String nombreCaracteristica) {
		this.idCaracteristica = idCaracteristica;
		this.idServicio = idServicio;
		this.descripcion = descripcion;
		this.nombreCaracteristica = nombreCaracteristica;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#getIdCaracteristica()
	 */
	@Override
	public long getIdCaracteristica() {
		return idCaracteristica;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#setIdCaracteristica(long)
	 */
	@Override
	public void setIdCaracteristica(long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#getidServicio()
	 */
	@Override
	public long getidServicio() {
		return idServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#setidServicio(long)
	 */
	@Override
	public void setidServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#getnombreCaracteristica()
	 */
	@Override
	public String getnombreCaracteristica() {
		return nombreCaracteristica;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#setnombreCaracteristica(java.lang.String)
	 */
	@Override
	public void setnombreCaracteristica(String nombreCaracteristica) {
		this.nombreCaracteristica = nombreCaracteristica;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCaracteristicaSercvicio#toString()
	 */
	@Override
	public String toString() 
	{
		return "Caracteristica Servicio [idCaracteristica=" + idCaracteristica + ", idServicio=" + idServicio + ", descripcion=" + descripcion + ", nombreCaracteristica=" + nombreCaracteristica + "]";
	}
}
