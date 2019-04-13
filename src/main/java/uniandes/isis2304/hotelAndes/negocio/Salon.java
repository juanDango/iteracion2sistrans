package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto Salon del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class Salon extends ServicioHotelComplementario implements VOSalon
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El nombre del Salon
	 */
	private String nombreSalon;
	
	/**
	 * La capacidad del Salon (capacidad > 0)
	 */
	private int capacidad;
	
	/**
	 * El costo que tiene el Salon por hora (costoPorHora > 0)
	 */
	private double costoPorHora;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Salon() 
	{
		super();
		this.nombreSalon = "";
		this.capacidad = 0;
		this.costoPorHora = 0.0;
	}

	/**
	 * Construye un nuevo servicio de Salon
	 * @param id - el id del servicio a usar
	 * @param nombre - el nombre del servicio
	 * @param nombreSalon - el nombre del salon
	 * @param capacidad - la capacidad del salon
	 * @param costoPorHora - el costo por hora del salon
	 */
	public Salon( long id, String nombre, long idHotel, String nombreSalon, int capacidad, double costoPorHora) {
		super(id, nombre, idHotel);
		this.nombreSalon = nombreSalon;
		this.capacidad = capacidad;
		this.costoPorHora = costoPorHora;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOSalon#getNombreSalon()
	 */
	@Override
	public String getNombreSalon() {
		return nombreSalon;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOSalon#setNombreSalon(java.lang.String)
	 */
	@Override
	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOSalon#getCapacidad()
	 */
	@Override
	public int getCapacidad() {
		return capacidad;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOSalon#setCapacidad(int)
	 */
	@Override
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOSalon#getCostoPorHora()
	 */
	@Override
	public double getCostoPorHora() {
		return costoPorHora;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOSalon#setCostoPorHora(double)
	 */
	@Override
	public void setCostoPorHora(double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOSalon#toString()
	 */
	@Override
	public String toString() 
	{
		return "Salon [nombreSalon=" + nombreSalon + ", capacidad=" + capacidad + ", costoPorHora=" + costoPorHora + "]";
	}

}