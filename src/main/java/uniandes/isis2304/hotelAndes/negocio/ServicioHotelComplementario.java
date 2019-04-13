package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto ServicioHotelComplementario del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class ServicioHotelComplementario implements VOServicioHotelComplementario
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del Servicio Hotel Complementario
	 */
	private long id;
	
	/**
	 * El nombre del Servicio  Hotel Complementario
	 */
	private String nombre;
	
	private long idHotel;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ServicioHotelComplementario() 
	{
		this.id = 0;
		this.nombre = "";
		this.idHotel = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id del Servicio Hotel Complementario
	 * @param nombre - El nombre del Servicio Hotel Complementario
	 */
	public ServicioHotelComplementario(long id, String nombre, long idHotel) 
	{
		this.id = id;
		this.nombre = nombre;
		this.idHotel = idHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioHotelComplementario#getId()
	 */
	@Override
	public long getId() 
	{
		return id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioHotelComplementario#setId(long)
	 */
	@Override
	public void setId(long id) 
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioHotelComplementario#getNombre()
	 */
	@Override
	public String getNombre() 
	{
		return nombre;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioHotelComplementario#setNombre(java.lang.String)
	 */
	@Override
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioHotelComplementario#getIdHotel()
	 */
	@Override
	public long getIdHotel() {
		return idHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioHotelComplementario#setIdHotel(long)
	 */
	@Override
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioHotelComplementario#toString()
	 */
	@Override
	public String toString() 
	{
		return "Servicio Hotel Complementario [id=" + id + ", nombre=" + nombre + ", idHotel=" + idHotel +"]";
	}

}
