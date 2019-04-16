package uniandes.isis2304.hotelAndes.negocio;

public class ServicioArreglo implements VOServicioArreglo {
	public ServicioArreglo(long idServicio, String tipoarreglo, long idhabitacion, long iddotacion) {
		super();
		this.idServicio = idServicio;
		this.tipoarreglo = tipoarreglo;
		this.idhabitacion = idhabitacion;
		this.iddotacion = iddotacion;
	}
	private long idServicio;
	private String tipoarreglo;
	private long idhabitacion;
	private long iddotacion;
	public long getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	public String getTipoarreglo() {
		return tipoarreglo;
	}
	public void setTipoarreglo(String tipoarreglo) {
		this.tipoarreglo = tipoarreglo;
	}
	public long getIdhabitacion() {
		return idhabitacion;
	}
	public void setIdhabitacion(long idhabitacion) {
		this.idhabitacion = idhabitacion;
	}
	public long getIddotacion() {
		return iddotacion;
	}
	public void setIddotacion(long iddotacion) {
		this.iddotacion = iddotacion;
	}
	@Override
	public String toString() {
		return "ServicioArreglo [idServicio=" + idServicio + ", tipoarreglo=" + tipoarreglo + ", idhabitacion="
				+ idhabitacion + ", iddotacion=" + iddotacion + "]";
	}
}
