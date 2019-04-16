package uniandes.isis2304.hotelAndes.negocio;

public interface VOUsuario {

	String toString();

	long getIdUsuario();

	void setIdUsuario(long idUsuario);

	String getRol();

	void setRol(String rol);

	long getNumeroDocumento();

	void setNumeroDocumento(long numeroDocumento);

	String getTipodocumento();

	void setTipodocumento(String tipodocumento);

	String getCorreoelectronico();

	void setCorreoelectronico(String correoelectronico);

}