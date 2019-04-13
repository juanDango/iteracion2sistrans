package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto CaracteristicaAdicional del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class CaracteristicaAdicional implements VOCaracteristicaAdicional
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la Caracteristica Adicional
	 */
	private long idCaracteristica;
	
	/**
	 * El nombre de la Caracteristica Adicional (CK > 0)
	 */
	private int limite;
	
	/**
	 * El descuento de la caracteristica adicional
	 */
	private double dcto;
	
	/**
	 * La descripcion de la caracteristica adicional
	 */
	private String descripcion;
	
	/**
	 * El id del plan de consumo al cual esta asociado
	 */
	private long planDeConsumoId;
	
	/**
	 * El id del servicio al cual esta asociado
	 */
	private long idServicioHotel;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public CaracteristicaAdicional() 
	{
		this.idCaracteristica = 0;
		this.limite = 0;
		this.dcto = 0.0;
		this.descripcion = "";
		this.planDeConsumoId = 0;
		this.idServicioHotel = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la Caracteristica Adicional
	 * @param limite - El limite de la Caracteristica Adicional
	 * @param dcto - El descuento de la Caracteristica
	 * @param descripcion - La descripcion de la Caracteristica
	 * @param planDeConsumoId - El plan de consumo al cual esta asociada la Caracteristica
	 * @param idServicioHotel - El servicio al cual esta asociada la Caracteristica
	 */
	public CaracteristicaAdicional(long idCaracteristica, int limite, double dcto, String descripcion, long planDeConsumoId, long idServicioHotel) {
		this.idCaracteristica = idCaracteristica;
		this.limite = limite;
		this.dcto = dcto;
		this.descripcion = descripcion;
		this.planDeConsumoId = planDeConsumoId;
		this.idServicioHotel = idServicioHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#getIdCaracteristica()
	 */
	@Override
	public long getIdCaracteristica() 
	{
		return idCaracteristica;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#setIdCaracteristica(long)
	 */
	@Override
	public void setIdCaracteristica(long id) 
	{
		this.idCaracteristica = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#getLimite()
	 */
	@Override
	public int getLimite() 
	{
		return limite;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#setLimite(int)
	 */
	@Override
	public void setLimite(int limite) 
	{
		this.limite = limite;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#getDcto()
	 */
	@Override
	public double getDcto() {
		return dcto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#setDcto(double)
	 */
	@Override
	public void setDcto(double dcto) {
		this.dcto = dcto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#getPlanDeConsumoId()
	 */
	@Override
	public long getPlanDeConsumoId() {
		return planDeConsumoId;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#setPlanDeConsumoId(long)
	 */
	@Override
	public void setPlanDeConsumoId(long planDeConsumoId) {
		this.planDeConsumoId = planDeConsumoId;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#getIdServicioHotel()
	 */
	@Override
	public long getIdServicioHotel() {
		return idServicioHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#setIdServicioHotel(long)
	 */
	@Override
	public void setIdServicioHotel(long idServicioHotel) {
		this.idServicioHotel = idServicioHotel;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCarateristicaAdicional#toString()
	 */
	@Override
	public String toString() 
	{
		return "Caracteristica Adicional [id=" + idCaracteristica + ", limite=" + limite + ", dcto=" + dcto + ", descripcion=" + descripcion + ", planDeConsumoId="+planDeConsumoId + ", idServicioHotel=" + idServicioHotel + "]";
	}

}
