package uniandes.isis2304.hotelAndes.negocio;

public class DotacionHabitacion implements VODotacionHabitacion {

	//----------
	//Atributos
	//----------
	
	private long idDotacion;
	
	private long idHabitacion;
	
	//------------
	//Constructor
	//------------
	
	public DotacionHabitacion(long idDotacion, long idHabitacion) {
		this.idDotacion = idDotacion;
		this.idHabitacion = idHabitacion;
	}
	
	public DotacionHabitacion() {
		super();
		this.idDotacion = 0;
		this.idHabitacion = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacionHabitacion#getIdDotacion()
	 */
	@Override
	public long getIdDotacion() {
		return idDotacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacionHabitacion#setIdDotacion(long)
	 */
	@Override
	public void setIdDotacion(long idDotacion) {
		this.idDotacion = idDotacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacionHabitacion#getIdHabitacion()
	 */
	@Override
	public long getIdHabitacion() {
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacionHabitacion#setIdHabitacion(long)
	 */
	@Override
	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacionHabitacion#toString()
	 */
	@Override
	public String toString() {
		return "Dotacion Habitacion [dotacion=" + idDotacion + ", habitacion=" + idHabitacion + "]";
	}
}
