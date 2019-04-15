package uniandes.isis2304.hotelAndes.negocio;

public class Cuenta implements VOCuenta {

	//----------
	//Atributos
	//----------
	
	private long idCuenta;
	
	private long valor;
	
	private String metodoDePago;
	
	private long idPlanConsumo;
	
	private long idCliente;
	
	private long idReserva;
	
	//------------
	//Constructor
	//------------

	public Cuenta(long idCuenta, long valor, String metodoDePago, long idPlanConsumo, long idCliente,
			long idReserva) {
		this.idCuenta = idCuenta;
		this.valor = valor;
		this.metodoDePago = metodoDePago;
		this.idPlanConsumo = idPlanConsumo;
		this.idCliente = idCliente;
		this.idReserva = idReserva;
	}

	public Cuenta() {
		this.idCuenta = 0;
		this.valor = 0;
		this.metodoDePago = "";
		this.idPlanConsumo = 0;
		this.idCliente = 0;
		this.idReserva = 0;
	}


	//------------------
	//Getters y Setters
	//------------------
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#getIdCuenta()
	 */
	@Override
	public long getIdCuenta() {
		return idCuenta;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#setIdCuenta(long)
	 */
	@Override
	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#getValor()
	 */
	@Override
	public long getValor() {
		return valor;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#setValor(long)
	 */
	@Override
	public void setValor(long valor) {
		this.valor = valor;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#getMetodoDePago()
	 */
	@Override
	public String getMetodoDePago() {
		return metodoDePago;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#setMetodoDePago(java.lang.String)
	 */
	@Override
	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#getIdPlanConsumo()
	 */
	@Override
	public long getIdPlanConsumo() {
		return idPlanConsumo;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#setIdPlanConsumo(long)
	 */
	@Override
	public void setIdPlanConsumo(long idPlanConsumo) {
		this.idPlanConsumo = idPlanConsumo;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#getIdCliente()
	 */
	@Override
	public long getIdCliente() {
		return idCliente;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#setIdCliente(long)
	 */
	@Override
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#getIdReserva()
	 */
	@Override
	public long getIdReserva() {
		return idReserva;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#setIdReserva(long)
	 */
	@Override
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOCuenta#toString()
	 */
	@Override
	public String toString() {
		return "Cuenta [id=" + idCuenta + ", valor=" + valor + ", metodo de pago=" + metodoDePago + ", plan consumo=" + idPlanConsumo+ ", cliente=" + idCliente + ", reserva=" + idReserva +"]";
	}
}
