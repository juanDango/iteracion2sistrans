package uniandes.isis2304.hotelAndes.negocio;

public class ServicioAlojamientoHabitacion implements VOServicioAlojamientoHabitacion {
	
	private long idHabitacion;
	
	private long idServicioAlojamiento;

	public ServicioAlojamientoHabitacion(long idHabitacion, long idServicioAlojamiento) {
		super();
		this.idHabitacion = idHabitacion;
		this.idServicioAlojamiento = idServicioAlojamiento;
	}
	
	public ServicioAlojamientoHabitacion() {
		this.idHabitacion = 0;
		this.idServicioAlojamiento = 0;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamientoHabitacion#getIdHabitacion()
	 */
	@Override
	public long getIdHabitacion() {
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamientoHabitacion#setIdHabitacion(long)
	 */
	@Override
	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamientoHabitacion#getIdServicioAlojamiento()
	 */
	@Override
	public long getIdServicioAlojamiento() {
		return idServicioAlojamiento;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioAlojamientoHabitacion#setIdServicioAlojamiento(long)
	 */
	@Override
	public void setIdServicioAlojamiento(long idServicioAlojamiento) {
		this.idServicioAlojamiento = idServicioAlojamiento;
	}
}
