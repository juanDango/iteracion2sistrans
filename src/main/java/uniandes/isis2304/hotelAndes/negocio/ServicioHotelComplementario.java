package uniandes.isis2304.hotelAndes.negocio;

public class ServicioHotelComplementario implements VOServicioHotelComplementario {
	
	//----------
	//Atributos
	//----------
	
	protected long idSComplementario;
	
	private String nombreServicio;
	
	private long idHotel;
	
	private long idHorario;

	//------------
	//Constructor
	//------------

	public ServicioHotelComplementario(long idSComplementario, String nombreServicio, long idHotel) {
		this.idSComplementario = idSComplementario;
		this.nombreServicio = nombreServicio;
		this.idHotel = idHotel;
	}

	public ServicioHotelComplementario() {
		this.idSComplementario = 0;
		this.nombreServicio = "";
		this.idHotel = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioHotelComplementario#getIdSComplementario()
	 */
	@Override
	public long getIdSComplementario() {
		return idSComplementario;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioHotelComplementario#setIdSComplementario(long)
	 */
	@Override
	public void setIdSComplementario(long idSComplementario) {
		this.idSComplementario = idSComplementario;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioHotelComplementario#getNombreServicio()
	 */
	@Override
	public String getNombreServicio() {
		return nombreServicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioHotelComplementario#setNombreServicio(java.lang.String)
	 */
	@Override
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioHotelComplementario#getIdHotel()
	 */
	@Override
	public long getIdHotel() {
		return idHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioHotelComplementario#setIdHotel(long)
	 */
	@Override
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOServicioHotelComplementario#toString()
	 */
	@Override
	public String toString() {
		return "Servicio Complementario [id=" + idSComplementario + ", nombre=" + nombreServicio + ", hotel=" + idHotel + "]";
	}

	public String toStringTemporal() { 
		return "[id=" + idSComplementario + ", nombre=" + nombreServicio + ", hotel=" + idHotel ;
	}

	public long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}
}
