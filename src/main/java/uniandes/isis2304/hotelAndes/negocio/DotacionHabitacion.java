package uniandes.isis2304.hotelAndes.negocio;

public class DotacionHabitacion implements VODotacionHabitacion {

	private long idDotacion;
	
	private long idHabitacion;
	
	public DotacionHabitacion(){
		this.idDotacion = 0;

		this.idHabitacion = 0;
	}

	public DotacionHabitacion(long idDotacion, long idHabitacion) {
		this.idDotacion = idDotacion;
		this.idHabitacion = idHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#getIdDotacion()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VO_DotacionHabitacion#getIdDotacion()
	 */
	@Override
	public long getIdDotacion() {
		return idDotacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#setIdDotacion(long)
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VO_DotacionHabitacion#setIdDotacion(long)
	 */
	@Override
	public void setIdDotacion(long idDotacion) {
		this.idDotacion = idDotacion;
	}

	

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#getIdHabitacion()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VO_DotacionHabitacion#getIdHabitacion()
	 */
	@Override
	public long getIdHabitacion() {
		return idHabitacion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#setIdHabitacion(int)
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VO_DotacionHabitacion#setIdHabitacion(int)
	 */
	@Override
	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VODotacion#toString()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VO_DotacionHabitacion#toString()
	 */
	@Override
	public String toString(){
		return "Dotacion [idDotacion=" + idDotacion + ", idHabitacion=" + idHabitacion + "]";
	}
	
}
