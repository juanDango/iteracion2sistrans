package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar el concepto Plan del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class Plan implements VOPlan
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del Plan
	 */
	private long id;
	
	/**
	 * El nombre del Plan
	 */
	private String nombrePlan;
	
	/**
	 * El tipo del Plan
	 */
	private String tipo;
	
	/**
	 * la fecha inicial del Plan
	 */
	private Timestamp fechaInicial;
	
	/**
	 * la fecha final del Plan
	 */
	private Timestamp fechaFinal;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Plan() 
	{
		this.id = 0;
		this.nombrePlan = "";
		this.tipo = "";
		this.fechaFinal = new Timestamp(0);
		this.fechaFinal = new Timestamp(0);
	}

	/**
	 * Constructor con valores
	 * @param id - El id del Plan
	 * @param nombre - El nombre del Plan
	 * @param tipo - El tipo del plan
	 * @param fechaInicial - la fecha a la cual inicia el plan
	 * @param fechaFinal - la fecha a la cual termina el plan
	 */
	public Plan(long id, String nombre, String tipo, Timestamp fechaInicial, Timestamp fechaFinal) 
	{
		this.id = id;
		this.nombrePlan = nombre;
		this.tipo = tipo;
		this.fechaFinal = fechaFinal;
		this.fechaInicial = fechaInicial;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#getId()
	 */
	@Override
	public long getId() 
	{
		return id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#setId(long)
	 */
	@Override
	public void setId(long id) 
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#getNombrePlan()
	 */
	@Override
	public String getNombrePlan() 
	{
		return nombrePlan;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#setNombrePlan(java.lang.String)
	 */
	@Override
	public void setNombrePlan(String nombrePlan) 
	{
		this.nombrePlan = nombrePlan;
	}
	
	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#getTipo()
	 */
	@Override
	public String getTipo() {
		return tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#setTipo(java.lang.String)
	 */
	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#getFechaInicial()
	 */
	@Override
	public Timestamp getFechaInicial() {
		return fechaInicial;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#setFechaInicial(java.sql.Timestamp)
	 */
	@Override
	public void setFechaInicial(Timestamp fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#getFechaFinal()
	 */
	@Override
	public Timestamp getFechaFinal() {
		return fechaFinal;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#setFechaFinal(java.sql.Timestamp)
	 */
	@Override
	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOPlan#toString()
	 */
	@Override
	public String toString() 
	{
		return "Plan [id=" + id + ", nombre=" + nombrePlan + ", tipo="+ tipo +", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + "]";
	}

}
