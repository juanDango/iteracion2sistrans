package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto ServicioAlojamientoHabitacion del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class ServicioAlojamientoHabitacion implements VOServicioAlojamientoHabitacion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la Habitacion
	 */
	private long idHabitacion;
	
	/**
	 * El identificador del Servicio Alojamiento
	 */
	private long idServicioAlojamiento;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ServicioAlojamientoHabitacion() 
	{
		this.idHabitacion = 0;
		this.idServicioAlojamiento = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la habitacion a relacionar
	 * @param nombre - El id del Servicio de Alojamiento a relacionar
	 */
	public ServicioAlojamientoHabitacion(long idHabitacion, long idServicioAlojamiento) 
	{
		this.idHabitacion = idHabitacion;
		this.idServicioAlojamiento = idServicioAlojamiento;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamientoHabitacion#getIdHabitacion()
	 */
	@Override
	public long getIdHabitacion() 
	{
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamientoHabitacion#setId(long)
	 */
	@Override
	public void setId(long id) 
	{
		this.idHabitacion = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamientoHabitacion#getIdServicioAlojamiento()
	 */
	@Override
	public long getIdServicioAlojamiento() 
	{
		return idServicioAlojamiento;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamientoHabitacion#setIdServicioAlojamiento(long)
	 */
	@Override
	public void setIdServicioAlojamiento(long idServicioAlojamiento) 
	{
		this.idServicioAlojamiento = idServicioAlojamiento;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamientoHabitacion#toString()
	 */
	@Override
	public String toString() 
	{
		return "Servicio Alojamiento Habitacion [idHabitacion=" + idHabitacion + ", idServicioAlojamiento=" + idServicioAlojamiento + "]";
	}

}