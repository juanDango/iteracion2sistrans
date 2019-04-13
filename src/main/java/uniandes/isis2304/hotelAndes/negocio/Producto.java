package uniandes.isis2304.hotelAndes.negocio;

/**
 * Clase para modelar el concepto Producto del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class Producto implements VOProducti
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la Producto
	 */
	private long id;
	
	/**
	 * El nombre de la Producto
	 */
	private String nombreProducto;
	
	/**
	 * El precio del producto (precio > 0)
	 */
	private double precio;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Producto() 
	{
		this.id = 0;
		this.nombreProducto = "";
		this.precio = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id del Producto
	 * @param nombre - El nombre de la Producto
	 */
	public Producto(long id, String nombre, double precio) 
	{
		this.id = id;
		this.nombreProducto = nombre;
		this.precio = precio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProducti#getId()
	 */
	@Override
	public long getId() 
	{
		return id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProducti#setId(long)
	 */
	@Override
	public void setId(long id) 
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProducti#getNombreProducto()
	 */
	@Override
	public String getNombreProducto() 
	{
		return nombreProducto;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProducti#setNombreProducto(java.lang.String)
	 */
	@Override
	public void setNombreProducto(String nombre) 
	{
		this.nombreProducto = nombre;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProducti#getPrecio()
	 */
	@Override
	public double  getPrecio()
	{
		return precio;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProducti#setPrecio(double)
	 */
	@Override
	public void setPrecio(double precio)
	{
		this.precio = precio;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOProducti#toString()
	 */
	@Override
	public String toString() 
	{
		return "Producto [id=" + id + ", nombre=" + nombreProducto + ", precio=" + precio + "]";
	}

}