package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto ServicioReservado del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class ServicioReservado extends ServicioHotelComplementario implements VOServicioReservado
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El nombre especifico del Servicio Reservado
	 */
	private String nombreEspecifico;
	
	/**
	 * El nombre del Servicio Reservado
	 */
	private String nombreServicio;
	
	/**
	 * El id del horario que tiene el servicio
	 */
	private long idHorario;
	
	/**
	 * La descripcion del Servicio
	 */
	private String descripcion;
	
	/**
	 * El tipo del servicio
	 */
	private String tipo;
	
	/**
	 * Duracion estimada del servicio (duracion >0)
	 */
	private int duracion;
	
	/**
	 * El costo del Servicio Reservado (costo > 0) 
	 */
	private double costo;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ServicioReservado() 
	{
		super();
		this.nombreEspecifico = "";
		this.nombreServicio = "";
		this.idHorario = 0;
		this.descripcion = "";
		this.tipo = "";
		this.duracion = 0;
		this.costo = 0;
	}

	/**
	 * Constructor del servicio
	 * @param id - el id del servicio
	 * @param nombre - el nombre del servicio
	 * @param nombreEspecifico - el nombre especifico del servicio
	 * @param nombreServicio - el nombre del servicio
	 * @param idHorario - el id del horario que tiene
	 * @param descripcion - la descripcion del servicio
	 * @param tipo - el tipo del servicio
	 * @param duracion - la duracion del servicio (duracion > 0)
	 * @param costo - el costo del servicio (costo > 0)
	 */
	public ServicioReservado(long id, String nombre, long idHotel, String nombreEspecifico, String nombreServicio, long idHorario, String descripcion,
			String tipo, int duracion, double costo) {
		super(id, nombre, idHotel);
		this.nombreEspecifico = nombreEspecifico;
		this.nombreServicio = nombreServicio;
		this.idHorario = idHorario;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.duracion = duracion;
		this.costo = costo;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#getNombreEspecifico()
	 */
	@Override
	public String getNombreEspecifico() {
		return nombreEspecifico;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#setNombreEspecifico(java.lang.String)
	 */
	@Override
	public void setNombreEspecifico(String nombreEspecifico) {
		this.nombreEspecifico = nombreEspecifico;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#getNombreServicio()
	 */
	@Override
	public String getNombreServicio() {
		return nombreServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#setNombreServicio(java.lang.String)
	 */
	@Override
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#getIdHorario()
	 */
	@Override
	public long getIdHorario() {
		return idHorario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#setIdHorario(long)
	 */
	@Override
	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#getTipo()
	 */
	@Override
	public String getTipo() {
		return tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#setTipo(java.lang.String)
	 */
	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#getDuracion()
	 */
	@Override
	public int getDuracion() {
		return duracion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#setDuracion(int)
	 */
	@Override
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#getCosto()
	 */
	@Override
	public double getCosto() {
		return costo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#setCosto(double)
	 */
	@Override
	public void setCosto(double costo) {
		this.costo = costo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioReservado#toString()
	 */
	@Override
	public String toString() 
	{
		return "Servicio Reservado [nombreEspecifico=" + nombreEspecifico + ", nombreServicio=" + nombreServicio + ", idHorario=" + idHorario + ", descripcion=" + descripcion + ", tipo="+ tipo + ", duracion=" + duracion + ", costo=" + costo + "]";
	}

}