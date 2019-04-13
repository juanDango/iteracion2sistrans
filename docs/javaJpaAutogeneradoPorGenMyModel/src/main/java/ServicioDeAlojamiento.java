
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class ServicioDeAlojamiento
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String codigoAlojamiento;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int cantidadPersonas;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany 
	@javax.persistence.JoinTable 
	@javax.persistence.JoinColumn(nullable = false) 
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
	public ServicioDeAlojamiento(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private String getCodigoAlojamiento() {
		return this.codigoAlojamiento;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private int getCantidadPersonas() {
		return this.cantidadPersonas;
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
	private void setCodigoAlojamiento(String myCodigoAlojamiento) {
		this.codigoAlojamiento = myCodigoAlojamiento;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setCantidadPersonas(int myCantidadPersonas) {
		this.cantidadPersonas = myCantidadPersonas;
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
	private void unsetCodigoAlojamiento() {
		this.codigoAlojamiento = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetCantidadPersonas() {
		this.cantidadPersonas = 0;
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

