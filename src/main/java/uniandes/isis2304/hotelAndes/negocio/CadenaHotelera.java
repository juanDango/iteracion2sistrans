package uniandes.isis2304.hotelAndes.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para modelar el concepto CadenaHotelera del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class CadenaHotelera implements VOCadenaHotelera
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la cadena hotelera
	 */
	private long id;
	
	/**
	 * El nombre de la cadena hotelera
	 */
	private String nombre;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public CadenaHotelera() 
	{
		this.id = 0;
		this.nombre = "";
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la cadena hotelera
	 * @param nombre - El nombre de la cadena hotelera
	 */
	public CadenaHotelera(long id, String nombre) 
	{
		this.id = id;
		this.nombre = nombre;
		
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	


	@Override
	public String toString() 
	{
		return "Cadena Hotelera [id=" + id + ", nombre=" + nombre + "]";
	}

}
