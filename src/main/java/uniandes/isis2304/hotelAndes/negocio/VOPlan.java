package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

public interface VOPlan {

	long getIdPlan();

	void setIdPlan(long idPlan);

	String getNombrePlan();

	void setNombrePlan(String nombrePlan);

	String getTipo();

	void setTipo(String tipo);

	Timestamp getFechaInicial();

	void setFechaInicial(Timestamp fechaInicial);

	Timestamp getFechaFinal();

	void setFechaFinal(Timestamp fechaFinal);

	String toString();

}