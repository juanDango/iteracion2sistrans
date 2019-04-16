package uniandes.isis2304.hotelAndes.negocio;

public class ServicioAlimentacion extends ServicioHotelComplementario implements VOServicioAlimentacion {

	private String estilo;
	
	private long capacidad;
	
	private String tipo;
	
	private char esConsumoHabitacion;
	
	private long idHorario;
	
	private String descripcion;

	public ServicioAlimentacion(long idSComplementario, String nombreServicio, long idHotel, String estilo,
			long capacidad, String tipo, char esConsumoHabitacion, long idHorario, String descripcion) {
		super(idSComplementario, nombreServicio, idHotel);
		this.estilo = estilo;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.esConsumoHabitacion = esConsumoHabitacion;
		this.idHorario = idHorario;
		this.descripcion = descripcion;
	}

	public ServicioAlimentacion() {
		super();
		this.estilo = "";
		this.capacidad = 0;
		this.tipo = "";
		this.esConsumoHabitacion = 0;
		this.idHorario = 0;
		this.descripcion = "";
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
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getEsConsumoHabitacion()
	 */
	@Override
	public char getEsConsumoHabitacion() {
		return esConsumoHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setEsConsumoHabitacion(char)
	 */
	@Override
	public void setEsConsumoHabitacion(char esConsumoHabitacion) {
		this.esConsumoHabitacion = esConsumoHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#getIdHorario()
	 */
	@Override
	public long getIdHorario() {
		return idHorario;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#setIdHorario(long)
	 */
	@Override
	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
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
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlimentacion#toString()
	 */
	@Override
	public String toString() {
		return "ServicioAlimentacion "+ super.toStringTemporal()+", estilo="+estilo+", capacidad="+capacidad+", tipo="+tipo+", esConsumoHabitacion="+esConsumoHabitacion+", descripcion="+descripcion+"]";	
	}
}
