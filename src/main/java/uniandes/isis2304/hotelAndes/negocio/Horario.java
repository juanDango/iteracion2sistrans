package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;

public class Horario implements VOHorario {

	//----------
	//Atributos
	//----------
	
	private long idHorario;
	
	private long horaInicio;
	
	private long horaFinal;
	
	private Timestamp fechaInicio;
	
	private Timestamp fechaFinal;
	
	//------------
	//Constructor
	//------------

	public Horario(long idHorario, long horaInicio, long horaFinal, Timestamp fechaInicio, Timestamp fechaFinal) {
		this.idHorario = idHorario;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}

	public Horario() {
		this.idHorario = 0;
		this.horaInicio = 0;
		this.horaFinal = 0;
		this.fechaInicio = new Timestamp(0);
		this.fechaFinal = new Timestamp(0);
	}
	
	//------------------
	//Getters y Setters
	//------------------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#getIdHorario()
	 */
	@Override
	public long getIdHorario() {
		return idHorario;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#setIdHorario(long)
	 */
	@Override
	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#getHoraInicio()
	 */
	@Override
	public long getHoraInicio() {
		return horaInicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#setHoraInicio(long)
	 */
	@Override
	public void setHoraInicio(long horaInicio) {
		this.horaInicio = horaInicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#getHoraFinal()
	 */
	@Override
	public long getHoraFinal() {
		return horaFinal;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#setHoraFinal(long)
	 */
	@Override
	public void setHoraFinal(long horaFinal) {
		this.horaFinal = horaFinal;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#getFechaInicio()
	 */
	@Override
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#setFechaInicio(java.sql.Timestamp)
	 */
	@Override
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#getFechaFinal()
	 */
	@Override
	public Timestamp getFechaFinal() {
		return fechaFinal;
	}

	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#setFechaFinal(java.sql.Timestamp)
	 */
	@Override
	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	//----------
	//toString
	//----------
	
	/* (non-Javadoc)
	 * @see uniandes.isis2304.hotelAndes.negocio.VOHorario#toString()
	 */
	@Override
	public String toString() {
		return "Horario [id=" + idHorario + ", hora inicio=" + horaInicio + ", hora final=" + horaFinal + ", fecha inicio=" + fechaInicio + ", fecha Final=" + fechaFinal + "]";
	}
	
}
