package uniandes.isis2304.hotelAndes.negocio;

public class PlanServicioAdicional implements VOPlanServicioAdicional {

	//----------
	//Atributos
	//----------
	
	private long idPlan;
	
	private long idCaracteristica;
	
	//------------
	//Constructor
	//------------
	
	public PlanServicioAdicional(long idPlan, long idCaracteristica) {
		this.idPlan = idPlan;
		this.idCaracteristica = idCaracteristica;
	}
	
	public PlanServicioAdicional() {
		this.idPlan = 0;
		this.idCaracteristica = 0;
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlanServicioAdicional#getIdPlan()
	 */
	@Override
	public long getIdPlan() {
		return idPlan;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlanServicioAdicional#setIdPlan(long)
	 */
	@Override
	public void setIdPlan(long idPlan) {
		this.idPlan = idPlan;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlanServicioAdicional#getIdCaracteristica()
	 */
	@Override
	public long getIdCaracteristica() {
		return idCaracteristica;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlanServicioAdicional#setIdCaracteristica(long)
	 */
	@Override
	public void setIdCaracteristica(long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOPlanServicioAdicional#toString()
	 */
	@Override
	public String toString() {
		return "Plan servicio adicional [plan=" + idPlan + ", servicio adicional=" + idCaracteristica + "]";
	}
	
}
