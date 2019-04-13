package uniandes.isis2304.hotelAndes.negocio;

public class Dotacion implements VODotacion {

	private long idDotacion;
	
	private String nombreObjeto;
	
	private char esCobrable;
	
	private double valorObjeto;
	
	private int idHabitacion;
	
	public Dotacion(){
		this.idDotacion = 0;
		this.nombreObjeto = "";
		this.esCobrable = 0;
		this.valorObjeto = 0;
		this.idHabitacion = 0;
	}

	public Dotacion(long idDotacion, String nombreObjeto, char esCobrable, double valorObjeto, int idHabitacion) {
		this.idDotacion = idDotacion;
		this.nombreObjeto = nombreObjeto;
		this.esCobrable = esCobrable;
		this.valorObjeto = valorObjeto;
		this.idHabitacion = idHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#getIdDotacion()
	 */
	@Override
	public long getIdDotacion() {
		return idDotacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#setIdDotacion(long)
	 */
	@Override
	public void setIdDotacion(long idDotacion) {
		this.idDotacion = idDotacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#getNombreObjeto()
	 */
	@Override
	public String getNombreObjeto() {
		return nombreObjeto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#setNombreObjeto(java.lang.String)
	 */
	@Override
	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#getEsCobrable()
	 */
	@Override
	public char getEsCobrable() {
		return esCobrable;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#setEsCobrable(int)
	 */
	@Override
	public void setEsCobrable(char esCobrable) {
		this.esCobrable = esCobrable;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#getValorObjeto()
	 */
	@Override
	public double getValorObjeto() {
		return valorObjeto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#setValorObjeto(double)
	 */
	@Override
	public void setValorObjeto(double valorObjeto) {
		this.valorObjeto = valorObjeto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#getIdHabitacion()
	 */
	@Override
	public int getIdHabitacion() {
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#setIdHabitacion(int)
	 */
	@Override
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#toString()
	 */
	@Override
	public String toString(){
		return "Dotacion [idDotacion=" + idDotacion + ", nombreObjeto=" + nombreObjeto + ", esCobrable=" + esCobrable + ", valorObjeto=" + valorObjeto + ", idHabitacion=" + idHabitacion + "]";
	}
	
}
