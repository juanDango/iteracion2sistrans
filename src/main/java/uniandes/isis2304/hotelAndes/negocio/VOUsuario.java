package uniandes.isis2304.hotelAndes.negocio;

public interface VOUsuario {

	/**
	 * @return el tipo de documento del usuario
	 */
	String getTipoDocumento();

	/**
	 * @param tipoDeDocumento - El nuevo tipo de documento del usuario
	 */
	void setTipoDocumento(String tipoDeDocumento);

	/**
	 * @return el Numero de documento del usuario
	 */
	long getNumeroDocumento();

	/**
	 * @param numeroDeDocumento - El nuevo numero de documento
	 */
	void setNumeroDocumento(long numeroDeDocumento);

	/**
	 * @return el correo electronico asociado
	 */
	String getCorreoElectronico();

	/**
	 * @param correoElectronico - el nuevo correo electronico a asociar
	 */
	void setCorreoElectronico(String correoElectronico);

	/**
	 * @return el rol del usuario dentro de la app
	 */
	String getRol();

	/**
	 * @param rol - El nuevo rol que el usuario asumira
	 */
	void setRol(String rol);

	/**
	 * @return Una cadena con la información básica del Usuario
	 */
	String toString();
	
	public long getIdUsuario();

	public void setIdUsuario(long idUsuario);

}