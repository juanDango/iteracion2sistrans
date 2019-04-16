package uniandes.isis2304.hotelAndes.negocio;

public class ServicioLavanderia implements VOServicioLavanderia {
	public ServicioLavanderia(long idServicio, String nombreServicio, String tipo, long cantuniandes,
			String nombreservicio2, String descripcion, long costounitario) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.tipo = tipo;
		this.cantuniandes = cantuniandes;
		nombreservicio = nombreservicio2;
		this.descripcion = descripcion;
		this.costounitario = costounitario;
	}
	private long idServicio;
	private String nombreServicio;
	private String tipo;
	private long cantuniandes;
	private String nombreservicio;
	private String descripcion;
	private long costounitario;
	public long getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getCantuniandes() {
		return cantuniandes;
	}
	public void setCantuniandes(long cantuniandes) {
		this.cantuniandes = cantuniandes;
	}
	public String getNombreservicio() {
		return nombreservicio;
	}
	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public long getCostounitario() {
		return costounitario;
	}
	public void setCostounitario(long costounitario) {
		this.costounitario = costounitario;
	}
	@Override
	public String toString() {
		return "ServicioLavanderia [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", tipo=" + tipo
				+ ", cantuniandes=" + cantuniandes + ", nombreservicio=" + nombreservicio + ", descripcion="
				+ descripcion + ", costounitario=" + costounitario + "]";
	}
}
