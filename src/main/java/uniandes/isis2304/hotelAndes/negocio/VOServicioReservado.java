package uniandes.isis2304.hotelAndes.negocio;

public interface VOServicioReservado {

	/**
	 * @return el nombre especifico del servicio
	 */
	String getNombreEspecifico();

	/**
	 * @param nombreEspecifico - Nuevo nombre especifico
	 */
	void setNombreEspecifico(String nombreEspecifico);

	/**
	 * @return nombre del servicio
	 */
	String getNombreServicio();

	/**
	 * @param nombreServicio - el nuevo nombre del servicio
	 */
	void setNombreServicio(String nombreServicio);

	/**
	 * @return el id del horario que tiene
	 */
	long getIdHorario();

	/**
	 * @param idHorario - el nuevo horario del servicio
	 */
	void setIdHorario(long idHorario);

	/**
	 * @return la descripcion del servicio
	 */
	String getDescripcion();

	/**
	 * @param descripcion - La nueva descripcion del servicio
	 */
	void setDescripcion(String descripcion);

	/**
	 * @return el tipo del servicio
	 */
	String getTipo();

	/**
	 * @param tipo - el nuevo tipo del servicio
	 */
	void setTipo(String tipo);

	/** 
	 * @return la duracion del servicio
	 */
	int getDuracion();

	/**
	 * @param duracion - La nueva duracion del servicio
	 */
	void setDuracion(int duracion);

	/**
	 * @return el nuevo nombre del servicio
	 */
	double getCosto();

	/**
	 * @param costo - El nuevo costo del servicio
	 */
	void setCosto(double costo);

	/**
	 * @return Una cadena con la información básica de la Servicio Reservado
	 */
	String toString();

}