package uniandes.isis2304.hotelAndes.negocio;

public class ServicioLavanderia extends ServicioHotelComplementario {
	
	private String descripcion;
	
	private String tipo;
	
	private long costoUnitario;
	
	private long cantUnidades;

	public ServicioLavanderia(long idSComplementario, String nombreServicio, long idHotel, String descripcion,
			String tipo, long costoUnitario, long cantUnidades) {
		super(idSComplementario, nombreServicio, idHotel);
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.costoUnitario = costoUnitario;
		this.cantUnidades = cantUnidades;
	}

	public ServicioLavanderia() {
		super();
		this.descripcion = "";
		this.tipo = "";
		this.costoUnitario = 0;
		this.cantUnidades = 0;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(long costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public long getCantUnidades() {
		return cantUnidades;
	}

	public void setCantUnidades(long cantUnidades) {
		this.cantUnidades = cantUnidades;
	}
	
	@Override
	public String toString() {
		return "ServicioLavanderia "+ super.toStringTemporal()+", descripcion="+descripcion+", tipo="+tipo+", costoUnitario="+costoUnitario+", cantUnidades="+cantUnidades+"]";	
	}
}
