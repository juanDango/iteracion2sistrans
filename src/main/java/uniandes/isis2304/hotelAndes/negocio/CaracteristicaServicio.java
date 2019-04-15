package uniandes.isis2304.hotelAndes.negocio;

public class CaracteristicaServicio implements VOCaracteristicaServicio {

	//----------
	//Atributos
	//----------
	
	private long idCaracteristica;
	
	private long idServicio;
	
	private String nombreCaracteristica;
	
	private String descripcion;

	//------------
	//Constructor
	//------------
	
	public CaracteristicaServicio(long idCaracteristica, long idServicio, String nombreCaracteristica,
			String descripcion) {
		this.idCaracteristica = idCaracteristica;
		this.idServicio = idServicio;
		this.nombreCaracteristica = nombreCaracteristica;
		this.descripcion = descripcion;
	}
	
	public CaracteristicaServicio() {
		super();
		this.idCaracteristica = 0;
		this.idServicio = 0;
		this.nombreCaracteristica = "";
		this.descripcion = "";
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#getIdCaracteristica()
	 */
	@Override
	public long getIdCaracteristica() {
		return idCaracteristica;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#setIdCaracteristica(long)
	 */
	@Override
	public void setIdCaracteristica(long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#getIdServicio()
	 */
	@Override
	public long getIdServicio() {
		return idServicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#setIdServicio(long)
	 */
	@Override
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#getNombreCaracteristica()
	 */
	@Override
	public String getNombreCaracteristica() {
		return nombreCaracteristica;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#setNombreCaracteristica(java.lang.String)
	 */
	@Override
	public void setNombreCaracteristica(String nombreCaracteristica) {
		this.nombreCaracteristica = nombreCaracteristica;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCaracteristicaServicio#toString()
	 */
	@Override
	public String toString() {
		return "Caracteristica Servicio [idCaracteristica=" + idCaracteristica + ", idServicio=" + idServicio + ", nombreCaracteristica=" + nombreCaracteristica + ", descripcion=" + descripcion +"]";
	}
}
