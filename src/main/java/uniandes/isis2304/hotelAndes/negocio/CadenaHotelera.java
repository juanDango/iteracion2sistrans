package uniandes.isis2304.hotelAndes.negocio;

public class CadenaHotelera implements VOCadenaHoletelera {
	
	
	//----------
	//Atributos
	//----------
	private long idCadenaHotelera;
	
	private String nombreCadenaHotelera;

	//-------------
	//Constructores
	//-------------
	public CadenaHotelera(long idCadenaHotelera, String nombreCadenaHotelera) {
		this.idCadenaHotelera = idCadenaHotelera;
		this.nombreCadenaHotelera = nombreCadenaHotelera;
	}
	
	public CadenaHotelera() {
		this.idCadenaHotelera = 0;
		this.nombreCadenaHotelera = "";
	}

	//------------------
	//Getters y setters
	//------------------
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCadenaHoletelera#getIdCadenaHotelera()
	 */
	@Override
	public long getIdCadenaHotelera() {
		return idCadenaHotelera;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCadenaHoletelera#setIdCadenaHotelera(long)
	 */
	@Override
	public void setIdCadenaHotelera(long idCadenaHotelera) {
		this.idCadenaHotelera = idCadenaHotelera;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCadenaHoletelera#getNombreCadenaHotelera()
	 */
	@Override
	public String getNombreCadenaHotelera() {
		return nombreCadenaHotelera;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCadenaHoletelera#setNombreCadenaHotelera(java.lang.String)
	 */
	@Override
	public void setNombreCadenaHotelera(String nombreCadenaHotelera) {
		this.nombreCadenaHotelera = nombreCadenaHotelera;
	}
	
	//---------
	//toString
	//---------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCadenaHoletelera#toString()
	 */
	@Override
	public String toString() {
		return "Cadena Hotelera [id=" + idCadenaHotelera + ", nombreCadenaHotelera=" + nombreCadenaHotelera +"]";
	}

}
