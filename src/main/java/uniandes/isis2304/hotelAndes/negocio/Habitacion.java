package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto Habitacion del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class Habitacion implements VOHabitacion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * es el código de la habitacion
	 */
	private long idHabitacion;
	
	/**
	 * El tipo de la habitacion a tomar
	 */
	private String tipoHabitacion;
	
	/**
	 * El costo por noche
	 */
	private double costoNoche;
	
	/**
	 * la capacidad que tiene la habitacion
	 */
	private int capacidad;
	
	/**
	 * El correo electronico con el que el Habitacion vinculo la cuenta
	 */
	private long idHotel;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Habitacion() 
	{
		this.idHabitacion = 0;
		this.tipoHabitacion = "";
		this.costoNoche = 0;
		this.capacidad = 0;
		this.idHotel = 0;
	}
	
	/**
	 * Constructor con parametros
	 * @param idHabitacion - el tipo de documento del Habitacion
	 * @param tipoHabitacion - el numero de documento del Habitacion
	 * @param idHotel - el correo electronico vinculado
	 * @param rol - el rol del Habitacion en la app
	 */
	public Habitacion(long idHabitacion, String tipoHabitacion, double costoNoche, int capacidad, long idHotel) {
		this.idHabitacion = idHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.costoNoche = costoNoche;
		this.capacidad = capacidad;
		this.idHotel = idHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#getIdHabitacion()
	 */
	@Override
	public long getIdHabitacion() {
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#setIdHabitacion(long)
	 */
	@Override
	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#getTipoHabitacion()
	 */
	@Override
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#setTipoHabitacion(java.lang.String)
	 */
	@Override
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#getIdHotel()
	 */
	@Override
	public long getIdHotel() {
		return idHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#setIdHotel(long)
	 */
	@Override
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#getCostoNoche()
	 */
	@Override
	public double getCostoNoche() {
		return costoNoche;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#setcostoNoche(double)
	 */
	@Override
	public void setcostoNoche(double costoNoche) {
		this.costoNoche = costoNoche;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#getCapacidad()
	 */
	@Override
	public int getCapacidad() {
		return capacidad;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#setCapacidad(int)
	 */
	@Override
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHabitacion#toString()
	 */
	@Override
	public String toString() 
	{
		return "Habitacion [tipoDocumento=" + idHabitacion + ", tipoHabitacion=" + tipoHabitacion + ", costoNoche=" + costoNoche + ", capacidad=" + capacidad + ", idHotel=" + idHotel + "]";
	}

}
