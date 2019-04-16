package uniandes.isis2304.hotelAndes.negocio;

public class Habitacion implements VOHabitacion {

	//----------
	//Atributos
	//----------
	
	private long idHabitacion;
	
	private String tipoHabitacion;
	
	private long costoNoche;
	
	private long capacidadHabitacion;
	
	private long idHotel;
	
	private long numeroHabitacion;
	
	private String disponible;
	//------------
	//Constructor
	//------------

	public Habitacion(long idHabitacion, String tipoHabitacion, long costoNoche, long capacidadHabitacion, long idHotel,
			long numeroHabitacion, String disponible) {
		this.idHabitacion = idHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.costoNoche = costoNoche;
		this.capacidadHabitacion = capacidadHabitacion;
		this.idHotel = idHotel;
		this.numeroHabitacion = numeroHabitacion;
		this.disponible = disponible;
	}

	public Habitacion() {
		this.idHabitacion = 0;
		this.tipoHabitacion = "";
		this.costoNoche = 0;
		this.capacidadHabitacion = 0;
		this.idHotel = 0;
		this.numeroHabitacion = 0;
		this.disponible = "S";
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#getIdHabitacion()
	 */
	@Override
	public long getIdHabitacion() {
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#setIdHabitacion(long)
	 */
	@Override
	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#getTipoHabitacion()
	 */
	@Override
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#setTipoHabitacion(java.lang.String)
	 */
	@Override
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#getCostoNoche()
	 */
	@Override
	public long getCostoNoche() {
		return costoNoche;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#setCostoNoche(long)
	 */
	@Override
	public void setCostoNoche(long costoNoche) {
		this.costoNoche = costoNoche;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#getCapacidadHabitacion()
	 */
	@Override
	public long getCapacidadHabitacion() {
		return capacidadHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#setCapacidadHabitacion(long)
	 */
	@Override
	public void setCapacidadHabitacion(long capacidadHabitacion) {
		this.capacidadHabitacion = capacidadHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#getIdHotel()
	 */
	@Override
	public long getIdHotel() {
		return idHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#setIdHotel(long)
	 */
	@Override
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#getNumeroHabitacion()
	 */
	@Override
	public long getNumeroHabitacion() {
		return numeroHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#setNumeroHabitacion(long)
	 */
	@Override
	public void setNumeroHabitacion(long numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHabitacion#toString()
	 */
	@Override
	public String toString() {
		return "Habitacion [id=" + idHabitacion + ", tipo=" + tipoHabitacion + ", costo noche=" + costoNoche + ", capacidad Habitacion=" + capacidadHabitacion + ", hotel=" + idHotel + ", numeroHabitacion=" + numeroHabitacion +"]";
	}
	
}
