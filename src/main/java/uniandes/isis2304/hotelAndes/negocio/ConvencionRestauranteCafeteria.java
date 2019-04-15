package uniandes.isis2304.hotelAndes.negocio;

public class ConvencionRestauranteCafeteria implements VOConvencionRestauranteCafeteria {

	//----------
	//Atributos
	//----------
	
	private long idConvencion;
	
	private long idServicioI;
	
	//------------
	//Constructor
	//------------
	
	public ConvencionRestauranteCafeteria(long idConvencion, long idServicioI) {
		super();
		this.idConvencion = idConvencion;
		this.idServicioI = idServicioI;
	}

	public ConvencionRestauranteCafeteria() {
		super();
		this.idConvencion = 0;
		this.idServicioI = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionRestauranteCafeteria#getIdConvencion()
	 */
	@Override
	public long getIdConvencion() {
		return idConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionRestauranteCafeteria#setIdConvencion(long)
	 */
	@Override
	public void setIdConvencion(long idConvencion) {
		this.idConvencion = idConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionRestauranteCafeteria#getIdServicioI()
	 */
	@Override
	public long getIdServicioI() {
		return idServicioI;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionRestauranteCafeteria#setIdServicioI(long)
	 */
	@Override
	public void setIdServicioI(long idServicioI) {
		this.idServicioI = idServicioI;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionRestauranteCafeteria#toString()
	 */
	@Override
	public String toString() {
		return "Caracteristica Adicional [idConvencion=" + idConvencion + ", idServicio=" + idServicioI + "]";
	}
}
