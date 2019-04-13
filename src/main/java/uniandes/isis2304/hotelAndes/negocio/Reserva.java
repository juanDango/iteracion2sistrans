package uniandes.isis2304.hotelAndes.negocio;

public class Reserva {
	
	public Reserva(long idReserva, long abono,long idHabitacion, long idHorario,long idCliente,long idHotel, long idCuenta) {
		this.idReserva=idReserva;
		this.abono=abono;
		this.idHabitacion=idHabitacion;
		this.idHorario=idHorario;
		this.idCliente = idCliente;
		this.idHotel = idHotel;
		this.idCuenta = idCuenta;
	}
	public Reserva() {
		this.idReserva=0;
		this.abono=0;
		this.idHabitacion=0;
		this.idHorario=0;
		this.idCliente = 0;
		this.idHotel = 0;
		this.idCuenta = 0;
	}
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", abono=" + abono + ", idHabitacion=" + idHabitacion
				+ ", idHorario=" + idHorario + ", idCliente=" + idCliente + ", idHotel=" + idHotel + ", idCuenta="
				+ idCuenta + "]";
	}

	private long idReserva;
	
	private long abono;
	
	private long idHabitacion;

	private long idHorario;

	private long idCliente;

	private long idHotel;
	
	private long idCuenta;

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public long getAbono() {
		return abono;
	}

	public void setAbono(long abono) {
		this.abono = abono;
	}

	public long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	public long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}



	
}
