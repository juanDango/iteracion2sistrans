package uniandes.isis2304.hotelAndes.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para modelar el concepto ServicioAlojamiento del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class ServicioAlojamiento implements VOServicioAlojamiento
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la servicio alojamiento
	 */
	private long id;
	
	/**
	 * El numero de personas que incluye el servicio
	 */
	private int numeroDePersonas;
	
	/**
	 * La cuenta que esta asociada al servicio
	 */
	private long idCuenta;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	
	
	
	public ServicioAlojamiento() 
	{
		this.id = 0;
		this.numeroDePersonas = 0;
		idCuenta = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la servicio alojamiento
	 * @param numeroDePersonas - El numeroDePersonas del servicio alojamiento
	 * @param idCueta - El numero de la cuenta del servicio
	 */
	public ServicioAlojamiento(long id, int numeroDePersonas, long idCuenta) 
	{
		this.id = id;
		this.numeroDePersonas = numeroDePersonas;
		this.idCuenta = idCuenta;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamiento#getId()
	 */
	@Override
	public long getId() 
	{
		return id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamiento#setId(long)
	 */
	@Override
	public void setId(long id) 
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamiento#getNumeroDePersonas()
	 */
	@Override
	public int getNumeroDePersonas() 
	{
		return numeroDePersonas;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamiento#setNumeroDePersonas(int)
	 */
	@Override
	public void setNumeroDePersonas(int numeroDePersonas) 
	{
		this.numeroDePersonas = numeroDePersonas;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamiento#getIdCuenta()
	 */
	@Override
	public long getIdCuenta() {
		return idCuenta;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamiento#setIdCuenta(long)
	 */
	@Override
	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOServicioAlojamiento#toString()
	 */
	@Override
	public String toString() 
	{
		return "servicio alojamiento [id=" + id + ", numeroDePersonas=" + numeroDePersonas + ", idCuenta=" + idCuenta + "]";
	}

}
