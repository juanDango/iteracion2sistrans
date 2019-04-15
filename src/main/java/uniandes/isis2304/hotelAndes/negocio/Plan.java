package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

public class Plan implements VOPlan {

	//----------
	//Atributos
	//----------
	
	private long idPlan;
	
	private String nombrePlan;
	
	private String tipo;
	
	private Timestamp fechaInicial;
	
	private Timestamp fechaFinal;
	
	//------------
	//Constructor
	//------------

	public Plan(long idPlan, String nombrePlan, String tipo, Timestamp fechaInicial, Timestamp fechaFinal) {
		this.idPlan = idPlan;
		this.nombrePlan = nombrePlan;
		this.tipo = tipo;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

	public Plan() {
		this.idPlan = 0;
		this.nombrePlan = "";
		this.tipo = "";
		this.fechaInicial = new Timestamp(0);
		this.fechaFinal = new Timestamp(0);
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#getIdPlan()
	 */
	@Override
	public long getIdPlan() {
		return idPlan;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#setIdPlan(long)
	 */
	@Override
	public void setIdPlan(long idPlan) {
		this.idPlan = idPlan;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#getNombrePlan()
	 */
	@Override
	public String getNombrePlan() {
		return nombrePlan;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#setNombrePlan(java.lang.String)
	 */
	@Override
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#getTipo()
	 */
	@Override
	public String getTipo() {
		return tipo;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#setTipo(java.lang.String)
	 */
	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#getFechaInicial()
	 */
	@Override
	public Timestamp getFechaInicial() {
		return fechaInicial;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#setFechaInicial(java.sql.Timestamp)
	 */
	@Override
	public void setFechaInicial(Timestamp fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#getFechaFinal()
	 */
	@Override
	public Timestamp getFechaFinal() {
		return fechaFinal;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#setFechaFinal(java.sql.Timestamp)
	 */
	@Override
	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlan#toString()
	 */
	@Override
	public String toString() {
		return "Plan [id=" + idPlan + ", nombre Plan=" + nombrePlan + ", tipo=" + tipo + ", fecha inicial=" + fechaInicial + ", fecha Final=" + fechaFinal + "]";
	}
	
}
