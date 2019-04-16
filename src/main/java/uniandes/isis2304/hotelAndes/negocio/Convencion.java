package uniandes.isis2304.hotelAndes.negocio;

public class Convencion implements VOConvencion {

	//----------
	//Atributos
	//----------
	
	private long idConvencion;
	
	private long idHotel;
	
	private long numParticipantes;
	
	private String nombreConvencion;
	
	//------------
	//Constructor
	//------------
	
	public Convencion(long idConvencion, long idHotel, long numParticipantes, String nombreConvencion) {
		this.idConvencion = idConvencion;
		this.idHotel = idHotel;
		this.numParticipantes = numParticipantes;
		this.nombreConvencion = nombreConvencion;
	}
	
	public Convencion() {
		this.idConvencion = 0;
		this.idHotel = 0;
		this.numParticipantes = 0;
		this.nombreConvencion = "";
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#getIdConvencion()
	 */
	@Override
	public long getIdConvencion() {
		return idConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#setIdConvencion(long)
	 */
	@Override
	public void setIdConvencion(long idConvencion) {
		this.idConvencion = idConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#getIdHotel()
	 */
	@Override
	public long getIdHotel() {
		return idHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#setIdHotel(long)
	 */
	@Override
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#getNumParticipantes()
	 */
	@Override
	public long getNumParticipantes() {
		return numParticipantes;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#setNumParticipantes(long)
	 */
	@Override
	public void setNumParticipantes(long numParticipantes) {
		this.numParticipantes = numParticipantes;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#getNombreConvencion()
	 */
	@Override
	public String getNombreConvencion() {
		return nombreConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#setNombreConvencion(java.lang.String)
	 */
	@Override
	public void setNombreConvencion(String nombreConvencion) {
		this.nombreConvencion = nombreConvencion;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencion#toString()
	 */
	@Override
	public String toString() {
		return "Convencion [id=" + idConvencion + ", hotel=" + idHotel + ", numParticipantes=" + numParticipantes + ", nombre Convencion=" + nombreConvencion +"]";
	}
	
}
