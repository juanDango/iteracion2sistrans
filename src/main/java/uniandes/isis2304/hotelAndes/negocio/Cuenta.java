package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar el concepto Cuenta del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class Cuenta implements VOCuenta
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del Cuenta
	 */
	private long idCuenta;
	
	/**
	 * El valor a pagar del Cuenta
	 */
	private double valor;
	
	/**
	 * El tipo de pago de la cuenta
	 */
	private String metodoPago;
	
	/**
	 * lLa cedula de identificacion del cliente dueño de la cuenta (cedula > 0)
	 */
	private long cedula;
	
	/**
	 * El id del plan de cosumo si existe
	 */
	private long idPlanConsumo;
	
	private long idCliente;
	
	private long idReserva;

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Cuenta() 
	{
		this.idCuenta = 0;
		this.valor= 0;
		this.metodoPago = "";
		this.cedula = 0;
		this.idReserva=0;
		this.idPlanConsumo = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id del Cuenta
	 * @param valor - El valor del Cuenta
	 * @param metodoPago - Describe como se va a pagar la cuenta
	 * @param cedula - La cedula del propietario de la cuenta
	 * @param idPlan - El id del plan
	 */
	public Cuenta(long id, double valor, String tipo, long cedula, long idPlan, long idReserva) 
	{
		this.idCuenta = id;
		this.valor = valor;
		this.metodoPago = tipo;
		this.cedula = cedula;
		this.idPlanConsumo = idPlan;
		this.idReserva=idReserva;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#getIdCuenta()
	 */
	@Override
	public long getIdCuenta() 
	{
		return idCuenta;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#setIdCuenta(long)
	 */
	@Override
	public void setIdCuenta(long id) 
	{
		this.idCuenta = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#getValor()
	 */
	@Override
	public double getValor() 
	{
		return valor;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#setValor(int)
	 */
	@Override
	public void setValor(int valor) 
	{
		this.valor = valor;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#getmetodoPago()
	 */
	@Override
	public String getmetodoPago() {
		return metodoPago;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#setmetodoPago(java.lang.String)
	 */
	@Override
	public void setmetodoPago(String tipo) {
		this.metodoPago = tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#getCedula()
	 */
	@Override
	public long getCedula() {
		return cedula;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#setCedula(long)
	 */
	@Override
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#getIdPlanConsumo()
	 */
	@Override
	public long getIdPlanConsumo() {
		return idPlanConsumo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#setIdPlanConsumo(long)
	 */
	@Override
	public void setIdPlanConsumo(long IdPlanConsumo) {
		this.idPlanConsumo = IdPlanConsumo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuenta#toString()
	 */
	@Override
	public String toString() 
	{
		return "Cuenta [idCuenta=" + idCuenta + ", valor=" + valor + ", metodoPago="+ metodoPago +", cedula=" + cedula + ", idPlanConsumo=" + idPlanConsumo + "]";
	}

}