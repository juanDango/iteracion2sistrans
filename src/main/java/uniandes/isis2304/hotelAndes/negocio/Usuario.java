package uniandes.isis2304.hotelAndes.negocio;

public class Usuario implements VOUsuario {
	public Usuario(String tipoDocumento, long numeroDocumento, String correoElectronico, String rol, long idUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.rol = rol;
		this.numeroDocumento = numeroDocumento;
		this.tipodocumento = tipoDocumento;
		this.correoelectronico = correoElectronico;
	}
	
	public Usuario() {
		super();
		this.idUsuario = 0;
		this.rol = "";
		this.numeroDocumento = 0;
		this.tipodocumento = "";
		this.correoelectronico = "";
	}
	
	private long idUsuario;
	private String rol;
	private long numeroDocumento;
	private String tipodocumento;

	private String correoelectronico;
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#toString()
	 */
	@Override
	public String toString() {
		return "Caracteristica Adicional [id=" + idUsuario + ", rol=" + rol + ", correoelectronico=" + correoelectronico + ", numeroDocumento=" + numeroDocumento + ", tipodocumento=" + tipodocumento +"]";
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#getIdUsuario()
	 */
	@Override
	public long getIdUsuario() {
		return idUsuario;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#setIdUsuario(long)
	 */
	@Override
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#getRol()
	 */
	@Override
	public String getRol() {
		return rol;
	}

	@Override
	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public long getNumeroDocumento() {
		return numeroDocumento;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#setNumeroDocumento(long)
	 */
	@Override
	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#getTipodocumento()
	 */
	@Override
	public String getTipodocumento() {
		return tipodocumento;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#setTipodocumento(long)
	 */
	@Override
	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#getCorreoelectronico()
	 */
	@Override
	public String getCorreoelectronico() {
		return correoelectronico;
	}
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOUsuario#setCorreoelectronico(java.lang.String)
	 */
	@Override
	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}
}
