package uniandes.isis2304.hotelAndes.negocio;

public class Hotel implements VOHotel {

	//----------
	//Atributos
	//----------
	
	private String nombreHotel;
	
	private long estrellas;
	
	private String ciudad;
	
	private String pais;
	
	private long idCadenaHotelera;
	
	private long idHotel;
	
	private long cantHabitaciones;
	
	//------------
	//Constructor
	//------------

	public Hotel(String nombreHotel, long estrellas, String ciudad, String pais, long idCadenaHotelera, long idHotel,
			long cantidadHabitaciones) {
		this.nombreHotel = nombreHotel;
		this.estrellas = estrellas;
		this.ciudad = ciudad;
		this.pais = pais;
		this.idCadenaHotelera = idCadenaHotelera;
		this.idHotel = idHotel;
		this.cantHabitaciones = cantidadHabitaciones;
	}

	public Hotel() {
		this.nombreHotel = "";
		this.estrellas = 0;
		this.ciudad = "";
		this.pais = "";
		this.idCadenaHotelera = 0;
		this.idHotel = 0;
		this.cantHabitaciones = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#getNombreHotel()
	 */
	@Override
	public String getNombreHotel() {
		return nombreHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#setNombreHotel(java.lang.String)
	 */
	@Override
	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#getEstrellas()
	 */
	@Override
	public long getEstrellas() {
		return estrellas;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#setEstrellas(long)
	 */
	@Override
	public void setEstrellas(long estrellas) {
		this.estrellas = estrellas;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#getCiudad()
	 */
	@Override
	public String getCiudad() {
		return ciudad;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#setCiudad(java.lang.String)
	 */
	@Override
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#getPais()
	 */
	@Override
	public String getPais() {
		return pais;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#setPais(java.lang.String)
	 */
	@Override
	public void setPais(String pais) {
		this.pais = pais;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#getIdCadenaHotelera()
	 */
	@Override
	public long getIdCadenaHotelera() {
		return idCadenaHotelera;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#setIdCadenaHotelera(long)
	 */
	@Override
	public void setIdCadenaHotelera(long idCadenaHotelera) {
		this.idCadenaHotelera = idCadenaHotelera;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#getIdHotel()
	 */
	@Override
	public long getIdHotel() {
		return idHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#setIdHotel(long)
	 */
	@Override
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#getCantidadHabitaciones()
	 */
	@Override
	public long getCantidadHabitaciones() {
		return cantHabitaciones;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#setCantidadHabitaciones(long)
	 */
	@Override
	public void setCantidadHabitaciones(long cantidadHabitaciones) {
		this.cantHabitaciones = cantidadHabitaciones;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHotel#toString()
	 */
	@Override
	public String toString() {
		return "Hotel [nombre Hotel=" + nombreHotel + ", estrellas=" + estrellas + ", ciudad=" + ciudad + ", pais=" + pais + ", cadena hotelera=" + idCadenaHotelera + ", idHotel=" + idHotel + ", cantidad Habitacionesl=" + cantHabitaciones + "]";
	}
	
}
