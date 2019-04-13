
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Cuenta extends Usuario
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	protected double valor;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String metodoDePago;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany 
	@javax.persistence.JoinTable 
	protected Set<ServiciosHotelComplementarios> serviciosHotel;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	protected Plan planConsumo;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany 
	@javax.persistence.JoinTable 
	protected Set<Reserva> reservas;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected ServicioDeAlojamiento servicioAlojamiento;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Cuenta(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private double getValor() {
		return this.valor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private String getMetodoDePago() {
		return this.metodoDePago;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<ServiciosHotelComplementarios> getServiciosHotel() {
		if(this.serviciosHotel == null) {
				this.serviciosHotel = new HashSet<ServiciosHotelComplementarios>();
		}
		return (Set<ServiciosHotelComplementarios>) this.serviciosHotel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Plan getPlanConsumo() {
		return this.planConsumo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Reserva> getReservas() {
		if(this.reservas == null) {
				this.reservas = new HashSet<Reserva>();
		}
		return (Set<Reserva>) this.reservas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public ServicioDeAlojamiento getServicioAlojamiento() {
		return this.servicioAlojamiento;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllServiciosHotel(Set<ServiciosHotelComplementarios> newServiciosHotel) {
		if (this.serviciosHotel == null) {
			this.serviciosHotel = new HashSet<ServiciosHotelComplementarios>();
		}
		this.serviciosHotel.addAll(newServiciosHotel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllReservas(Set<Reserva> newReservas) {
		if (this.reservas == null) {
			this.reservas = new HashSet<Reserva>();
		}
		this.reservas.addAll(newReservas);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllServiciosHotel(Set<ServiciosHotelComplementarios> newServiciosHotel) {
		if(this.serviciosHotel == null) {
			return;
		}
		
		this.serviciosHotel.removeAll(newServiciosHotel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllReservas(Set<Reserva> newReservas) {
		if(this.reservas == null) {
			return;
		}
		
		this.reservas.removeAll(newReservas);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setValor(double myValor) {
		this.valor = myValor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setMetodoDePago(String myMetodoDePago) {
		this.metodoDePago = myMetodoDePago;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addServiciosHotel(ServiciosHotelComplementarios newServiciosHotel) {
		if(this.serviciosHotel == null) {
			this.serviciosHotel = new HashSet<ServiciosHotelComplementarios>();
		}
		
		this.serviciosHotel.add(newServiciosHotel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setPlanConsumo(Plan myPlanConsumo) {
		this.planConsumo = myPlanConsumo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addReservas(Reserva newReservas) {
		if(this.reservas == null) {
			this.reservas = new HashSet<Reserva>();
		}
		
		this.reservas.add(newReservas);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setServicioAlojamiento(ServicioDeAlojamiento myServicioAlojamiento) {
		this.servicioAlojamiento = myServicioAlojamiento;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetValor() {
		this.valor = 0.0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetMetodoDePago() {
		this.metodoDePago = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeServiciosHotel(ServiciosHotelComplementarios oldServiciosHotel) {
		if(this.serviciosHotel == null)
			return;
		
		this.serviciosHotel.remove(oldServiciosHotel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetPlanConsumo() {
		this.planConsumo = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeReservas(Reserva oldReservas) {
		if(this.reservas == null)
			return;
		
		this.reservas.remove(oldReservas);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetServicioAlojamiento() {
		this.servicioAlojamiento = new ServicioDeAlojamiento();
	}

}

