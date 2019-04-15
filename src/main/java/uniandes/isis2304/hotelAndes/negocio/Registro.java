package uniandes.isis2304.hotelAndes.negocio;

public class Registro implements VORegistro {

	//----------
	//Atributos
	//----------
	
	private long idRegistro;
	
	private long idReserva;
	
	private char estadoCheckIn;
	
	private char estadoCheckOut;
	
	private long idRegistrador;
	
	//------------
	//Constructor
	//------------

	public Registro(long idRegistro, long idReserva, char estadoCheckIn, char estadoCheckOut, long idRegistrador) {
		this.idRegistro = idRegistro;
		this.idReserva = idReserva;
		this.estadoCheckIn = estadoCheckIn;
		this.estadoCheckOut = estadoCheckOut;
		this.idRegistrador = idRegistrador;
	}

	public Registro() {
		this.idRegistro = 0;
		this.idReserva = 0;
		this.estadoCheckIn = 0;
		this.estadoCheckOut = 0;
		this.idRegistrador = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#getIdRegistro()
	 */
	@Override
	public long getIdRegistro() {
		return idRegistro;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#setIdRegistro(long)
	 */
	@Override
	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#getIdReserva()
	 */
	@Override
	public long getIdReserva() {
		return idReserva;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#setIdReserva(long)
	 */
	@Override
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#getEstadoCheckIn()
	 */
	@Override
	public char getEstadoCheckIn() {
		return estadoCheckIn;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#setEstadoCheckIn(char)
	 */
	@Override
	public void setEstadoCheckIn(char estadoCheckIn) {
		this.estadoCheckIn = estadoCheckIn;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#getEstadoCheckOut()
	 */
	@Override
	public char getEstadoCheckOut() {
		return estadoCheckOut;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#setEstadoCheckOut(char)
	 */
	@Override
	public void setEstadoCheckOut(char estadoCheckOut) {
		this.estadoCheckOut = estadoCheckOut;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#getIdRegistrador()
	 */
	@Override
	public long getIdRegistrador() {
		return idRegistrador;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#setIdRegistrador(long)
	 */
	@Override
	public void setIdRegistrador(long idRegistrador) {
		this.idRegistrador = idRegistrador;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VORegistro#toString()
	 */
	@Override
	public String toString() {
		return "Registro [id=" + idRegistro + ", reserva=" + idReserva + ", check in=" + estadoCheckIn + ", check out=" + estadoCheckOut + ", registrador=" + idRegistrador +"]";
	}
	
}
