package uniandes.isis2304.hotelAndes.negocio;

public class Registro implements VORegistro {

	private long idRegistro;
	
	private long idRegistrador;

	
	private long idReserva;
	
	private char checkIn;
	
	private char checkOut;
	
	public Registro (){
		idRegistro = 0;
		idReserva = 0;
		checkIn = ' ';
		checkOut = ' ';
		idRegistrador = 0;
	}

	public Registro(long idRegistrador, long idRegistro, long idReserva, char checkIn, char checkOut) {
		super();
		this.idRegistro = idRegistro;
		this.idReserva = idReserva;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.idRegistrador = idRegistrador;
	}

	/**
	 * @return the idRegistrador
	 */
	public long getIdRegistrador() {
		return idRegistrador;
	}

	/**
	 * @param idRegistrador the idRegistrador to set
	 */
	public void setIdRegistrador(long idRegistrador) {
		this.idRegistrador = idRegistrador;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#getIdRegistro()
	 */
	@Override
	public long getIdRegistro() {
		return idRegistro;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#setIdRegistro(long)
	 */
	@Override
	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#getIdReserva()
	 */
	@Override
	public long getIdReserva() {
		return idReserva;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#setIdReserva(long)
	 */
	@Override
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#getCheckIn()
	 */
	@Override
	public char getCheckIn() {
		return checkIn;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#setCheckIn(char)
	 */
	@Override
	public void setCheckIn(char checkIn) {
		this.checkIn = checkIn;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#getCheckOut()
	 */
	@Override
	public char getCheckOut() {
		return checkOut;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#setCheckOut(char)
	 */
	@Override
	public void setCheckOut(char checkOut) {
		this.checkOut = checkOut;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VORegistro#toString()
	 */
	@Override
	public String toString() 
	{
		return "Registro [idRegistro=" + idRegistro + ", idReserva=" + idReserva + ", checkIn=" + checkIn + ", checkOut" + checkOut + "]";
	}
}
