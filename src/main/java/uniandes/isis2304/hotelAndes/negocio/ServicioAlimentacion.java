package uniandes.isis2304.hotelAndes.negocio;


public class ServicioAlimentacion extends ServicioHotelComplementario implements VOServicioAlimentacion {
	
	private String nombreestilo;
	
	private String estilo;
	
	private int capacidad;
	
	private String tipo;
	
	private int esConsumoHabitacion;
	
	private long idHorario;
	
	private String descripcion;
	
	public ServicioAlimentacion(){
		nombreestilo = "";
		estilo = "";
		capacidad = 0;
		tipo = "";
		esConsumoHabitacion = 0;
		idHorario = 0;
		descripcion = "";
	}

	public ServicioAlimentacion(long idServicio, String nom, long idHot, String nombreServicio, String estilo, int capacidad, String tipo,
			int esConsumoHabitacion, long idHorario, String descripcion) {
		super(idServicio, nom, idHot);
		this.nombreestilo = nombreestilo;
		this.estilo = estilo;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.esConsumoHabitacion = esConsumoHabitacion;
		this.idHorario = idHorario;
		this.descripcion = descripcion;
	}

	

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#getNombreestilo()
	 */
	@Override
	public String getNombreServicio() {
		return nombreestilo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#setNombreestilo(java.lang.String)
	 */
	@Override
	public void setNombreServicio(String nombreServicio) {
		this.nombreestilo = nombreestilo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#getestilo()
	 */
	@Override
	public String getEstilo() {
		return estilo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#setestilo(java.lang.String)
	 */
	@Override
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#getCapacidad()
	 */
	@Override
	public int getCapacidad() {
		return capacidad;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#setCapacidad(int)
	 */
	@Override
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#getTipo()
	 */
	@Override
	public String getTipo() {
		return tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#setTipo(java.lang.String)
	 */
	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#getEsConsumoHabitacion()
	 */
	@Override
	public int getEsConsumoHabitacion() {
		return esConsumoHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#setEsConsumoHabitacion(int)
	 */
	@Override
	public void setEsConsumoHabitacion(int esConsumoHabitacion) {
		this.esConsumoHabitacion = esConsumoHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#getIdHorario()
	 */
	@Override
	public long getIdHorario() {
		return idHorario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#setIdHorario(long)
	 */
	@Override
	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOestiloAlimentacion#toString()
	 */
	@Override
	public String toString() 
	{
		return "estiloAlimentacion [nombreestilo=" + nombreestilo + ", estilo=" + estilo + ", capacidad=" + capacidad + ", tipo=" + tipo + ", esConsumoHabitacion=" + esConsumoHabitacion + ", idHorario=" + idHorario + ", descripcion=" + descripcion + "]";
	}
}
