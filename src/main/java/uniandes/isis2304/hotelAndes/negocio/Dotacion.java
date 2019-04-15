package uniandes.isis2304.hotelAndes.negocio;

public class Dotacion implements VODotacion {

	//----------
	//Atributos
	//----------
	
	private long idDotacion;
	
	private String nombreObjeto;
	
	private char esCobrable;
	
	private long valorObjeto;
	
	private long idHabitacion;
	
	//------------
	//Constructor
	//------------

	public Dotacion(long idDotacion, String nombreObjeto, char esCobrable, long valorObjeto, long idHabitacion) {
		this.idDotacion = idDotacion;
		this.nombreObjeto = nombreObjeto;
		this.esCobrable = esCobrable;
		this.valorObjeto = valorObjeto;
		this.idHabitacion = idHabitacion;
	}

	public Dotacion() {
		this.idDotacion = 0;
		this.nombreObjeto = "";
		this.esCobrable = 0;
		this.valorObjeto = 0;
		this.idHabitacion = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#getIdDotacion()
	 */
	@Override
	public long getIdDotacion() {
		return idDotacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#setIdDotacion(long)
	 */
	@Override
	public void setIdDotacion(long idDotacion) {
		this.idDotacion = idDotacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#getNombreObjeto()
	 */
	@Override
	public String getNombreObjeto() {
		return nombreObjeto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#setNombreObjeto(java.lang.String)
	 */
	@Override
	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#getEsCobrable()
	 */
	@Override
	public char getEsCobrable() {
		return esCobrable;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#setEsCobrable(char)
	 */
	@Override
	public void setEsCobrable(char esCobrable) {
		this.esCobrable = esCobrable;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#getValorObjeto()
	 */
	@Override
	public long getValorObjeto() {
		return valorObjeto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#setValorObjeto(long)
	 */
	@Override
	public void setValorObjeto(long valorObjeto) {
		this.valorObjeto = valorObjeto;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#getIdHabitacion()
	 */
	@Override
	public long getIdHabitacion() {
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#setIdHabitacion(long)
	 */
	@Override
	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VODotacion#toString()
	 */
	@Override
	public String toString() {
		return "Dotacion [idDotacion=" + idDotacion + ", nombre Objero=" + nombreObjeto + ", es Cobrable=" + esCobrable + ", valor Objeto=" + valorObjeto + ", habitacion=" + idHabitacion + "]";
	}
	
}
