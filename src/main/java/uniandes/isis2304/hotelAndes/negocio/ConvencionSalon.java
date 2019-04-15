package uniandes.isis2304.hotelAndes.negocio;

public class ConvencionSalon implements VOConvencionSalon {

	//----------
	//Atributos
	//----------
	
	private long idConvencion;
	
	private long idSalon;
	
	//------------
	//Constructor
	//------------

	public ConvencionSalon(long idConvencion, long idSalon) {
		this.idConvencion = idConvencion;
		this.idSalon = idSalon;
	}

	public ConvencionSalon() {
		this.idConvencion = 0;
		this.idSalon = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionSalon#getIdConvencion()
	 */
	@Override
	public long getIdConvencion() {
		return idConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionSalon#setIdConvencion(long)
	 */
	@Override
	public void setIdConvencion(long idConvencion) {
		this.idConvencion = idConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionSalon#getIdSalon()
	 */
	@Override
	public long getIdSalon() {
		return idSalon;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionSalon#setIdSalon(long)
	 */
	@Override
	public void setIdSalon(long idSalon) {
		this.idSalon = idSalon;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionSalon#toString()
	 */
	@Override
	public String toString() {
		return "Convencion salon [idConvencion=" + idConvencion + ", idSalon=" + idSalon + "]";
	}
}
