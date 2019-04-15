package uniandes.isis2304.hotelAndes.negocio;

public interface VOCuenta {

	//------------------
	//Getters y Setters
	//------------------
	long getIdCuenta();

	void setIdCuenta(long idCuenta);

	long getValor();

	void setValor(long valor);

	String getMetodoDePago();

	void setMetodoDePago(String metodoDePago);

	long getIdPlanConsumo();

	void setIdPlanConsumo(long idPlanConsumo);

	long getIdCliente();

	void setIdCliente(long idCliente);

	long getIdReserva();

	void setIdReserva(long idReserva);

	String toString();

}