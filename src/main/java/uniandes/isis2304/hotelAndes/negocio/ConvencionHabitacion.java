package uniandes.isis2304.hotelAndes.negocio;

public class ConvencionHabitacion implements VOConvencionHabitacion {
	
	//----------
	//Atributos
	//----------
	
	private long idConvencion;
	
	private long idHabitacion;
	
	//------------
	//Constructor
	//------------

	public ConvencionHabitacion(long idConvencion, long idHabitacion) {
		this.idConvencion = idConvencion;
		this.idHabitacion = idHabitacion;
	}
	
	public ConvencionHabitacion() {
		this.idConvencion = 0;
		this.idHabitacion = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionHabitacion#getIdConvencion()
	 */
	@Override
	public long getIdConvencion() {
		return idConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionHabitacion#setIdConvencion(long)
	 */
	@Override
	public void setIdConvencion(long idConvencion) {
		this.idConvencion = idConvencion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionHabitacion#getIdHabitacion()
	 */
	@Override
	public long getIdHabitacion() {
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionHabitacion#setIdHabitacion(long)
	 */
	@Override
	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOConvencionHabitacion#toString()
	 */
	@Override
	public String toString() {
		return "Convencion Habitacon [idConvencion=" + idConvencion + ", idHabitacion=" + idHabitacion + "]";
	}

}
