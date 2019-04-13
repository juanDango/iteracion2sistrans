package uniandes.isis2304.hotelAndes.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para modelar el concepto Hotel del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class Hotel implements VOHotel
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del Hotel
	 */
	private long id;
	
	/**
	 * El nombre del Hotel
	 */
	private String nombre;

	
	/**
	 * Estrellas de calidad del Hotel
	 */
	private int estrellas;
	
	/**
	 * Pais donde esta ubicado el Hotel
	 */
	private String pais;
	
	/**
	 * Ciudad donde se ubica el Hotel
	 */
	private String ciudad;
	
	/**
	 * ID Unico de la cadena hotelera a la que pertence
	 */
	private long idCadenaHotelera;
	


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Hotel() 
	{
		this.id = 0;
		this.nombre = "";
		this.estrellas = 0;
		this.pais = "";
		this.ciudad = "";
		this.idCadenaHotelera = 0;

	}

	/**
	 * Constructor con valores
	 * @param id - El id del Hotel
	 * @param nombre - El nombre del Hotel
	 * @param estrellas - El numero de estrellas del Hotel
	 * @param pais - El pais en el cual esta ubicado el Hotel
	 * @param ciudad - La ciudad en la cual esta ubicado el Hotel
	 * @param idCadenaHotelera - El id de la cadena hotelera del Hotel
	 */
	public Hotel(long id, String nombre,  int estrellas, String pais, String ciudad, long idCadenaHotelera) 
	{
		this.id = id;
		this.nombre = nombre;
		this.estrellas = estrellas;
		this.pais = pais;
		this.ciudad = ciudad;
		this.idCadenaHotelera = idCadenaHotelera;

	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getId()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getId()
	 */
	@Override
	public long getId() 
	{
		return id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setId(long)
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setId(long)
	 */
	@Override
	public void setId(long id) 
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getNombre()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getNombre()
	 */
	@Override
	public String getNombre() 
	{
		return nombre;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setNombre(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setNombre(java.lang.String)
	 */
	@Override
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getDireccion()
	 */


	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getEstrellas()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getEstrellas()
	 */
	@Override
	public int getEstrellas() {
		return estrellas;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setEstrellas(int)
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setEstrellas(int)
	 */
	@Override
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getPais()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getPais()
	 */
	@Override
	public String getPais() {
		return pais;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setPais(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setPais(java.lang.String)
	 */
	@Override
	public void setPais(String pais) {
		this.pais = pais;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getCiudad()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getCiudad()
	 */
	@Override
	public String getCiudad() {
		return ciudad;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setCiudad(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setCiudad(java.lang.String)
	 */
	@Override
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getIdCadenaHotelera()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#getIdCadenaHotelera()
	 */
	@Override
	public long getIdCadenaHotelera() {
		return idCadenaHotelera;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setIdCadenaHotelera(long)
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#setIdCadenaHotelera(long)
	 */
	@Override
	public void setIdCadenaHotelera(long idCadenaHotelera) {
		this.idCadenaHotelera = idCadenaHotelera;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#toString()
	 */
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHotel#toString()
	 */
	@Override
	public String toString() 
	{
		return "Hotel [id=" + id + ", nombre=" + nombre +", estrellas=" + estrellas + ", pais=" + pais + ", ciudad="+ ciudad + ", idCadenaHotelera=" + idCadenaHotelera + "]";
	}

}
