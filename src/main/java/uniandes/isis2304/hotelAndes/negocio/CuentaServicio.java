package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto CuentaServicio del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class CuentaServicio implements VOCuentaServicio
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del plan a asociar
	 */
	private long idCuenta;
	
	/**
	 * El identidicador de la Caracteristica Adicional a asociar
	 */
	private long idServicioComplementario;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public CuentaServicio() 
	{
		this.idCuenta = 0;
		this.idServicioComplementario = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la cadena hotelera
	 * @param nombre - El nombre de la cadena hotelera
	 */
	public CuentaServicio(long idCuenta, long idServicioComplementario) 
	{
		this.idCuenta = idCuenta;
		this.idServicioComplementario = idServicioComplementario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaServicio#getidCuenta()
	 */
	@Override
	public long getidCuenta() 
	{
		return idCuenta;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaServicio#setidCuenta(long)
	 */
	@Override
	public void setidCuenta(long id) 
	{
		this.idCuenta = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaServicio#getidServicioComplementario()
	 */
	@Override
	public long getidServicioComplementario() 
	{
		return idServicioComplementario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaServicio#setidServicioComplementario(long)
	 */
	@Override
	public void setidServicioComplementario(long idServicioComplementario) 
	{
		this.idServicioComplementario = idServicioComplementario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOCuentaServicio#toString()
	 */
	@Override
	public String toString() 
	{
		return "Cuenta Servicio [idCuenta=" + idCuenta + ", idServicioComplementario=" + idServicioComplementario + "]";
	}

}