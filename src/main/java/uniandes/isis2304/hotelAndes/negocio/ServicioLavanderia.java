package uniandes.isis2304.hotelAndes.negocio;

public class ServicioLavanderia extends ServicioHotelComplementario implements VOServicioLavanderia {
	
	
	private String nombreSer;
	
	private String descripcion;
	
	private String tipo;
	
	private double costoUnitario;
	
	private int cantUnidades;
	
	public ServicioLavanderia()
	{
		nombreSer = "";
		descripcion = "";
		tipo = "";
		costoUnitario = 0;
		cantUnidades = 0;
	}

	public ServicioLavanderia(long id, String nom, long idHot, String nombreSer, String descripcion, String tipo, double costoUnitario, int cantUnidades) {
		super(id, nom, idHot);
		this.nombreSer = nombreSer;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.costoUnitario = costoUnitario;
		this.cantUnidades = cantUnidades;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#getnombreSer()
	 */
	@Override
	public String getnombreSer() {
		return nombreSer;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#setnombreSer(java.lang.String)
	 */
	@Override
	public void setnombreSer(String nombreSer) {
		this.nombreSer = nombreSer;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#getTipo()
	 */
	@Override
	public String getTipo() {
		return tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#setTipo(java.lang.String)
	 */
	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#getCostoUnitario()
	 */
	@Override
	public double getCostoUnitario() {
		return costoUnitario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#setCostoUnitario(double)
	 */
	@Override
	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#getCantUnidades()
	 */
	@Override
	public int getCantUnidades() {
		return cantUnidades;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#setCantUnidades(int)
	 */
	@Override
	public void setCantUnidades(int cantUnidades) {
		this.cantUnidades = cantUnidades;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioLavanderia#toString()
	 */
	@Override
	public String toString() 
	{
		return "ServicioLavanderia [nombreSer=" + nombreSer + ", descripcion=" + descripcion + ", tipo=" + tipo + ", costoUnitario=" + costoUnitario + ", cantUnidades=" + cantUnidades + "]";
	}
}
