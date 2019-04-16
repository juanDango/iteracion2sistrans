package uniandes.isis2304.hotelAndes.negocio;

public class TipoHabitacion implements VOTipoHabitacion {
	public TipoHabitacion(String nombretipo, String descripcion) {
		super();
		this.nombretipo = nombretipo;
		this.descripcion = descripcion;
	}
	private String nombretipo;
	private String descripcion;
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOTipoHabitacion#getNombretipo()
	 */
	@Override
	public String getNombreTipo() {
		return nombretipo;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOTipoHabitacion#setNombretipo(java.lang.String)
	 */
	@Override
	public void setNombreTipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOTipoHabitacion#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOTipoHabitacion#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOTipoHabitacion#toString()
	 */
	@Override
	public String toString() {
		return "TipoHabitacion [nombretipo=" + nombretipo + ", descripcion=" + descripcion + "]";
	}
}
