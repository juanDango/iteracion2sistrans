package uniandes.isis2304.hotelAndes.negocio;

public class ServicioIncluido extends ServicioHotelComplementario implements VOServicioIncluido {
	
	private String nombre;
	
	private long capacidad;


	public ServicioIncluido(long idSComplementario, String nombreServicio, long idHotel, String nombre,
			long capacidad) {
		super(idSComplementario, nombreServicio, idHotel);
		this.nombre = nombre;
		this.capacidad = capacidad;
	}

	public ServicioIncluido() {
		super();
		this.nombre = "";
		this.capacidad = 0;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}
	
	@Override
	public String toString() {
		return "ServicioIncluido "+ super.toStringTemporal()+", nombre="+nombre+", capacidad="+capacidad+"]";	
	}
}
