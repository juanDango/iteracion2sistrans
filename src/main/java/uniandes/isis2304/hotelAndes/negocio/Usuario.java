package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto Usuario del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class Usuario implements VOUsuario
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Es el tipo de documento del usuario
	 */
	private String tipoDocumento;
	
	/**
	 * El numero de documento del usuario (numeroDocumento > 0)
	 */
	private long numeroDocumento;
	
	/**
	 * El correo electronico con el que el usuario vinculo la cuenta
	 */
	private String correoElectronico;
	
	/**
	 * Es el rol que tiene el usuario dentro de la aplicacion
	 */
	private String rol;
	
	private long idUsuario;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Usuario() 
	{
		this.tipoDocumento = "";
		this.numeroDocumento = 0;
		this.correoElectronico = "";
		this.rol = "";
		this.idUsuario = 0; 
	}
	
	/**
	 * Constructor con parametros
	 * @param tipoDocumento - el tipo de documento del usuario
	 * @param numeroDocumento - el numero de documento del usuario
	 * @param correoElectronico - el correo electronico vinculado
	 * @param rol - el rol del usuario en la app
	 */
	public Usuario(String tipoDocumento, long numeroDocumento, String correoElectronico, String rol, long idUsuario) {
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.correoElectronico = correoElectronico;
		this.rol = rol;
		this.idUsuario = idUsuario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#gettipoDocumento()
	 */
	@Override
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#settipoDocumento(java.lang.String)
	 */
	@Override
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#getnumeroDocumento()
	 */
	@Override
	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#setnumeroDocumento(long)
	 */
	@Override
	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#getCorreoElectronico()
	 */
	@Override
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#setCorreoElectronico(java.lang.String)
	 */
	@Override
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#getRol()
	 */
	@Override
	public String getRol() {
		return rol;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#setRol(java.lang.String)
	 */
	@Override
	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public long getIdUsuario() {
		return idUsuario;
	}

	@Override
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOUsuario#toString()
	 */
	@Override
	public String toString() 
	{
		return "Usuario [tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", correoElectronico=" + correoElectronico + ", rol=" + rol + ", idUsuario=" + idUsuario + "]";
	}

}
