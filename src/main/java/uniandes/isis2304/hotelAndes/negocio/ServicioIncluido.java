package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto ServicioIncluido del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class ServicioIncluido extends ServicioHotelComplementario implements VOServicioIncluido
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El nombre de la Servicio Incluido
	 */
	private String nombreServicio;
	
	/**
	 * @return the idHotel
	 */
	public long getIdHotel() {
		return idHotel;
	}

	/**
	 * @param idHotel the idHotel to set
	 */
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	private long idHotel;
	/**
	 * La capacidad que tiene el lugar del servicio (capacidad > 0)
	 */
	private int capacidad;
	


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ServicioIncluido() 
	{
		super();
		this.nombreServicio = "";
		this.capacidad = 0;
		this.idHotel = 0;
	}

	/**
	 * Construye un servicio complementario
	 * @param id - el id del servicio 
	 * @param nombre - el nombre del servicio
	 * @param nombreServicio - el nombre del servicio incluido
	 * @param capacidad - la capacidad del lugar
	 * @param idServicio - id del servicio comp
	 */
	public ServicioIncluido(long id, String nombre, long idHotel, String nombreServicio, int capacidad) {
		super(id, nombre, idHotel);
		this.nombreServicio = nombreServicio;
		this.capacidad = capacidad;
		this.idHotel = idHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioIncluido#getNombreServicio()
	 */
	@Override
	public String getNombreServicio() {
		return nombreServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioIncluido#setNombreServicio(java.lang.String)
	 */
	@Override
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioIncluido#getCapacidad()
	 */
	@Override
	public int getCapacidad() {
		return capacidad;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioIncluido#setCapacidad(int)
	 */
	@Override
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioIncluido#toString()
	 */
	@Override
	public String toString() 
	{
		return "Servicio Incluido [nombreServicio=" + nombreServicio + ", capacidad=" + capacidad +"]";
	}

}