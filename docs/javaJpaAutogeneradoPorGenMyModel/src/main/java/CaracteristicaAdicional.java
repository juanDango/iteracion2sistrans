
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class CaracteristicaAdicional
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int limite;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	protected double dcto;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String descripcion;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany 
	@javax.persistence.JoinTable 
	protected Set<Plan> caracteristicaAdicional;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	protected ServiciosHotelComplementarios serviciosHotelComplementarios;

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
	public CaracteristicaAdicional(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private int getLimite() {
		return this.limite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private double getDcto() {
		return this.dcto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Plan> getCaracteristicaAdicional() {
		if(this.caracteristicaAdicional == null) {
				this.caracteristicaAdicional = new HashSet<Plan>();
		}
		return (Set<Plan>) this.caracteristicaAdicional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public ServiciosHotelComplementarios getServiciosHotelComplementarios() {
		return this.serviciosHotelComplementarios;
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
	public void addAllCaracteristicaAdicional(Set<Plan> newCaracteristicaAdicional) {
		if (this.caracteristicaAdicional == null) {
			this.caracteristicaAdicional = new HashSet<Plan>();
		}
		this.caracteristicaAdicional.addAll(newCaracteristicaAdicional);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllCaracteristicaAdicional(Set<Plan> newCaracteristicaAdicional) {
		if(this.caracteristicaAdicional == null) {
			return;
		}
		
		this.caracteristicaAdicional.removeAll(newCaracteristicaAdicional);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setLimite(int myLimite) {
		this.limite = myLimite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setDcto(double myDcto) {
		this.dcto = myDcto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setDescripcion(String myDescripcion) {
		this.descripcion = myDescripcion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addCaracteristicaAdicional(Plan newCaracteristicaAdicional) {
		if(this.caracteristicaAdicional == null) {
			this.caracteristicaAdicional = new HashSet<Plan>();
		}
		
		this.caracteristicaAdicional.add(newCaracteristicaAdicional);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setServiciosHotelComplementarios(ServiciosHotelComplementarios myServiciosHotelComplementarios) {
		this.serviciosHotelComplementarios = myServiciosHotelComplementarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetLimite() {
		this.limite = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetDcto() {
		this.dcto = 0.0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetDescripcion() {
		this.descripcion = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeCaracteristicaAdicional(Plan oldCaracteristicaAdicional) {
		if(this.caracteristicaAdicional == null)
			return;
		
		this.caracteristicaAdicional.remove(oldCaracteristicaAdicional);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetServiciosHotelComplementarios() {
		this.serviciosHotelComplementarios = null;
	}

}

