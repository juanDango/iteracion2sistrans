
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Hotel
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String nombreHotel;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int estrellas;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String direccion;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String pais;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String ciudad;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	protected ServiciosHotelComplementarios serviciosCuenta;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToMany 
	@javax.persistence.JoinTable 
	protected Set<ServicioDeAlojamiento> serviciosAlojamiento;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany 
	@javax.persistence.JoinTable 
	protected Set<Habitacion> habitacion;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Hotel(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private String getNombreHotel() {
		return this.nombreHotel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private int getEstrellas() {
		return this.estrellas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private String getDireccion() {
		return this.direccion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private String getPais() {
		return this.pais;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private String getCiudad() {
		return this.ciudad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public ServiciosHotelComplementarios getServiciosCuenta() {
		return this.serviciosCuenta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<ServicioDeAlojamiento> getServiciosAlojamiento() {
		if(this.serviciosAlojamiento == null) {
				this.serviciosAlojamiento = new HashSet<ServicioDeAlojamiento>();
		}
		return (Set<ServicioDeAlojamiento>) this.serviciosAlojamiento;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Habitacion> getHabitacion() {
		if(this.habitacion == null) {
				this.habitacion = new HashSet<Habitacion>();
		}
		return (Set<Habitacion>) this.habitacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllServiciosAlojamiento(Set<ServicioDeAlojamiento> newServiciosAlojamiento) {
		if (this.serviciosAlojamiento == null) {
			this.serviciosAlojamiento = new HashSet<ServicioDeAlojamiento>();
		}
		this.serviciosAlojamiento.addAll(newServiciosAlojamiento);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllHabitacion(Set<Habitacion> newHabitacion) {
		if (this.habitacion == null) {
			this.habitacion = new HashSet<Habitacion>();
		}
		this.habitacion.addAll(newHabitacion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllServiciosAlojamiento(Set<ServicioDeAlojamiento> newServiciosAlojamiento) {
		if(this.serviciosAlojamiento == null) {
			return;
		}
		
		this.serviciosAlojamiento.removeAll(newServiciosAlojamiento);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllHabitacion(Set<Habitacion> newHabitacion) {
		if(this.habitacion == null) {
			return;
		}
		
		this.habitacion.removeAll(newHabitacion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setNombreHotel(String myNombreHotel) {
		this.nombreHotel = myNombreHotel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setEstrellas(int myEstrellas) {
		this.estrellas = myEstrellas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setDireccion(String myDireccion) {
		this.direccion = myDireccion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setPais(String myPais) {
		this.pais = myPais;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setCiudad(String myCiudad) {
		this.ciudad = myCiudad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setServiciosCuenta(ServiciosHotelComplementarios myServiciosCuenta) {
		this.serviciosCuenta = myServiciosCuenta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addServiciosAlojamiento(ServicioDeAlojamiento newServiciosAlojamiento) {
		if(this.serviciosAlojamiento == null) {
			this.serviciosAlojamiento = new HashSet<ServicioDeAlojamiento>();
		}
		
		this.serviciosAlojamiento.add(newServiciosAlojamiento);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addHabitacion(Habitacion newHabitacion) {
		if(this.habitacion == null) {
			this.habitacion = new HashSet<Habitacion>();
		}
		
		this.habitacion.add(newHabitacion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetNombreHotel() {
		this.nombreHotel = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetEstrellas() {
		this.estrellas = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetDireccion() {
		this.direccion = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetPais() {
		this.pais = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetCiudad() {
		this.ciudad = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetServiciosCuenta() {
		this.serviciosCuenta = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeServiciosAlojamiento(ServicioDeAlojamiento oldServiciosAlojamiento) {
		if(this.serviciosAlojamiento == null)
			return;
		
		this.serviciosAlojamiento.remove(oldServiciosAlojamiento);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeHabitacion(Habitacion oldHabitacion) {
		if(this.habitacion == null)
			return;
		
		this.habitacion.remove(oldHabitacion);
	}

}

