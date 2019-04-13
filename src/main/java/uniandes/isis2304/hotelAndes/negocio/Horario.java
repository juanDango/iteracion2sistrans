package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar el concepto Horario del negocio de HotelAndes
 *
 * @author Juan Daniel Castrellon
 */
public class Horario implements VOHorario
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la Horario
	 */
	private long idHorario;
	
	/**
	 * La fecha inicial a la que empieza un servicio
	 */
	private Timestamp fechaInicial;
	
	/**
	 * La hora inicial a la que se inicia un servicio (horaInicial > 0)
	 */
	private int horaInicial;
	
	/**
	 * La fecha a la que termina el servicio
	 */
	private Timestamp fechaFinal;

	/**
	 * La hora a la que acaba el servicio (horaFinal > 0)
	 */
	private int horaFinal;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Horario() 
	{
		this.idHorario = 0;
		this.fechaInicial = new Timestamp(0);
		this.horaInicial = 0;
		this.fechaFinal = new Timestamp(0);
		this.horaFinal = 0;
	}

	/**
	 * Constructor con valores
	 * @param idHorario - El id del horario
	 * @param fechaInicial - la fecha a la que inicia
	 * @param horaInicial - la hora a la que inicia
	 * @param fechaFinal - La fecha a la que termina
	 * @param horaFinal - La hora a la que termina
	 */
	public Horario(long idHorario, Timestamp fechaInicial, int horaInicial, Timestamp fechaFinal, int horaFinal) {
		this.idHorario = idHorario;
		this.fechaInicial = fechaInicial;
		this.horaInicial = horaInicial;
		this.fechaFinal = fechaFinal;
		this.horaFinal = horaFinal;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#getIdHorario()
	 */
	@Override
	public long getIdHorario() {
		return idHorario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#setIdHorario(long)
	 */
	@Override
	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#getFechaInicial()
	 */
	@Override
	public Timestamp getFechaInicial() {
		return fechaInicial;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#setFechaInicial(java.sql.Timestamp)
	 */
	@Override
	public void setFechaInicial(Timestamp fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#getHoraInicial()
	 */
	@Override
	public int getHoraInicial() {
		return horaInicial;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#setHoraInicial(int)
	 */
	@Override
	public void setHoraInicial(int horaInicial) {
		this.horaInicial = horaInicial;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#getFechaFinal()
	 */
	@Override
	public Timestamp getFechaFinal() {
		return fechaFinal;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#setFechaFinal(java.sql.Timestamp)
	 */
	@Override
	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#getHoraFinal()
	 */
	@Override
	public int getHoraFinal() {
		return horaFinal;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#setHoraFinal(int)
	 */
	@Override
	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}

	/* (non-Javadoc)
	 * @see hotelAndes.negocio.VOHorario#toString()
	 */
	@Override
	public String toString() 
	{
		return "Horario [idHorario=" + idHorario + ", fechaInicial=" + fechaInicial + ", horaInicial=" + horaInicial + ", fechaFinal=" + fechaFinal + ", horaFinal=" + horaFinal + "]";
	}

}