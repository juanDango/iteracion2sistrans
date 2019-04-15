package uniandes.isis2304.hotelAndes.negocio;

public interface VOCaracteristicaAdicional {

	long getIdCaracteristicaAdicional();

	void setIdCaracteristicaAdicional(long idCaracteristicaAdicional);

	long getLimite();

	void setLimite(long limite);

	long getDcto();

	void setDcto(long dcto);

	String getDescripcion();

	void setDescripcion(String descripcion);

	long getIdServicioComplementario();

	void setIdServicioComplementario(long idServicioComplementario);

	long getIdServicioAlojamiento();

	void setIdServicioAlojamiento(long idServicioAlojamiento);

	String toString();

}