package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto PlanCaracteristicaAdicional del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class PlanCaracteristicaAdicional implements VOPlanCaracteristicaAdicional
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del plan a asociar
	 */
	private long idPlan;
	
	/**
	 * El identidicador de la Caracteristica Adicional a asociar
	 */
	private long idCaracteristicaAd;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public PlanCaracteristicaAdicional() 
	{
		this.idPlan = 0;
		this.idCaracteristicaAd = 0;
	}

	/**
	 * Constructor con valores
	 * @param idPlan - El id de la Plan 
	 * @param idCaracteristicaAd - El id de la Caracteristica Adicional
	 */
	public PlanCaracteristicaAdicional(long idPlan, long idCaracteristicaAd) 
	{
		this.idPlan = idPlan;
		this.idCaracteristicaAd = idCaracteristicaAd;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlanCaracteristicaAdicional#getIdPlan()
	 */
	@Override
	public long getIdPlan() 
	{
		return idPlan;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlanCaracteristicaAdicional#setIdPlan(long)
	 */
	@Override
	public void setIdPlan(long id) 
	{
		this.idPlan = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlanCaracteristicaAdicional#getIdCaracteristicaAd()
	 */
	@Override
	public long getIdCaracteristicaAd() 
	{
		return idCaracteristicaAd;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlanCaracteristicaAdicional#setIdCaracteristicaAd(long)
	 */
	@Override
	public void setIdCaracteristicaAd(long idCaracteristicaAd) 
	{
		this.idCaracteristicaAd = idCaracteristicaAd;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlanCaracteristicaAdicional#toString()
	 */
	@Override
	public String toString() 
	{
		return "Plan Caracteristica Adicional [idPlan=" + idPlan + ", idCaracteristicaAd=" + idCaracteristicaAd + "]";
	}

}