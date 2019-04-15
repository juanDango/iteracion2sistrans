package uniandes.isis2304.hotelAndes.negocio;

public class Salon extends ServicioHotelComplementario{
	
	//----------
	//Atributos
	//----------
	
	
	private String nombre;
	
	private long capacidad;
	
	private long costoPorHora;
	
	private String tipo;
	
	//------------
	//Constructor
	//------------
	
	public Salon(long idSComplementario, String nombreServicio, long idHotel, String nombre, long capacidad,
			long costoPorHora, String tipo) {
		super(idSComplementario, nombreServicio, idHotel);
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.costoPorHora = costoPorHora;
		this.tipo = tipo;
	}

	public Salon() {
		super();
		this.nombre = "";
		this.capacidad = 0;
		this.costoPorHora = 0;
		this.tipo = "";
	}
	
	//------------------
	//Getters y Setters
	//------------------

	public long getIdSComplementario() {
		return idSComplementario;
	}
	
	public void setIdSComplementario(long idSComplementario){
		this.idSComplementario=idSComplementario;
	}

	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}

	public long getCostoPorHora() {
		return costoPorHora;
	}

	public void setCostoPorHora(long costoPorHora) {
		this.costoPorHora = costoPorHora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//----------
	//toString
	//----------
	
	@Override
	public String toString() {
		return "Salon "+ super.toStringTemporal()+", nombre="+nombre+", capacidad="+capacidad+", costoPorHora="+costoPorHora+", tipo=" + tipo + "]";	
	}

}
