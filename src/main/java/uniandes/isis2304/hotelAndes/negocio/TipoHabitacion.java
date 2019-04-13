package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto TipoHabitacion del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class TipoHabitacion implements VOTipoHabitacion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El nombreTipoentificador ÚNICO de la Tipo Habitacion
	 */
	private String nombreTipo;
	
	/**
	 * El descripcion de la Tipo Habitacion
	 */
	private String descripcion;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public TipoHabitacion() 
	{
		this.nombreTipo = "";
		this.descripcion = "";
	}

	/**
	 * Constructor con valores
	 * @param nombreTipo - El nombreTipo de la Tipo Habitacion
	 * @param descripcion - El descripcion de la Tipo Habitacion
	 */
	public TipoHabitacion(String nombreTipo, String descripcion) 
	{
		this.nombreTipo = nombreTipo;
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOTipoHabitacion#getnombreTipo()
	 */
	@Override
	public String getnombreTipo() 
	{
		return nombreTipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOTipoHabitacion#setnombreTipo(java.lang.String)
	 */
	@Override
	public void setnombreTipo(String nombreTipo) 
	{
		this.nombreTipo = nombreTipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOTipoHabitacion#getdescripcion()
	 */
	@Override
	public String getdescripcion() 
	{
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOTipoHabitacion#setdescripcion(java.lang.String)
	 */
	@Override
	public void setdescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOTipoHabitacion#toString()
	 */
	@Override
	public String toString() 
	{
		return "Tipo Habitacion [nombreTipo=" + nombreTipo + ", descripcion=" + descripcion + "]";
	}

}