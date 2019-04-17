package uniandes.isis2304.hotelAndes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.jdo.Query;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.media.sound.FFT;

import uniandes.isis2304.hotelAndes.negocio.CadenaHotelera;
import uniandes.isis2304.hotelAndes.negocio.CaracteristicaAdicional;
import uniandes.isis2304.hotelAndes.negocio.CaracteristicaServicio;
import uniandes.isis2304.hotelAndes.negocio.Convencion;
import uniandes.isis2304.hotelAndes.negocio.ConvencionRestauranteCafeteria;
import uniandes.isis2304.hotelAndes.negocio.Cuenta;
import uniandes.isis2304.hotelAndes.negocio.CuentaAlojamiento;
import uniandes.isis2304.hotelAndes.negocio.CuentaServicio;
import uniandes.isis2304.hotelAndes.negocio.Dotacion;
import uniandes.isis2304.hotelAndes.negocio.DotacionHabitacion;
import uniandes.isis2304.hotelAndes.negocio.Habitacion;
import uniandes.isis2304.hotelAndes.negocio.Horario;
import uniandes.isis2304.hotelAndes.negocio.Hotel;
import uniandes.isis2304.hotelAndes.negocio.Plan;
import uniandes.isis2304.hotelAndes.negocio.PlanServicioAdicional;
import uniandes.isis2304.hotelAndes.negocio.Producto;
import uniandes.isis2304.hotelAndes.negocio.ProductoServicio;
import uniandes.isis2304.hotelAndes.negocio.Registro;
import uniandes.isis2304.hotelAndes.negocio.Reserva;
import uniandes.isis2304.hotelAndes.negocio.Salon;
import uniandes.isis2304.hotelAndes.negocio.ServicioAlimentacion;
import uniandes.isis2304.hotelAndes.negocio.ServicioAlojamiento;
import uniandes.isis2304.hotelAndes.negocio.ServicioAlojamientoHabitacion;
//import uniandes.isis2304.hotelAndes.negocio.ServicioAlojamientoHabitacion;
import uniandes.isis2304.hotelAndes.negocio.ServicioHotelComplementario;
import uniandes.isis2304.hotelAndes.negocio.ServicioIncluido;
import uniandes.isis2304.hotelAndes.negocio.ServicioLavanderia;
import uniandes.isis2304.hotelAndes.negocio.ServicioReservado;
import uniandes.isis2304.hotelAndes.negocio.TipoHabitacion;
import uniandes.isis2304.hotelAndes.negocio.Usuario;
import uniandes.isis2304.hotelAndes.negocio.VOServicioIncluido;


public class PersistenciaHotelAndes {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/

	private static Logger log = Logger.getLogger(PersistenciaHotelAndes.class.getName());

	public final static String SQL = "javax.jdo.query.SQL";

	private static PersistenciaHotelAndes instance;

	private PersistenceManagerFactory pmf;

	private List <String> tablas;

	private SQLUtil sqlUtil;

	private SQLCadenaHotelera sqlCadenaHotelera;

	//private SQLCaracteristicaAdicional sqlCaracteristicaAdicional;

	//private SQLCaracteristicaServicio sqlCaracteristicaServicio;
	
	private SQLConvencion sqlConvencion;
	
	private SQLConvencionHabitacion sqlConvencionHabitacion;
	
	private SQLConvencionrestbarcafeteria sqlConvencionRestBarCafeteria;
	
	//private SQLConvencionSalon sqlConvencionSalon;

	private SQLCuenta sqlCuenta;

	//private SQLCuentaAlojamiento sqlCuentaAlojamiento;

	private SQLCuentaServicio sqlCuentaServicio;

	//private SQLDotacion sqlDotacion;

	//private SQLDotacionHabitacion sqlDotacionHabitacion;

	private SQLHabitacion sqlHabitacion;

	private SQLHorario sqlHorario;

	//private SQLHotel sqlHotel;

	private SQLPlan sqlPlan;

	//private SQLPlanCaracteristicaAdicional sqlPlanCaracteristicaAdicional;

	//private SQLProducto sqlProducto;

	//private SQLProductoServicio sqlProductoServicio;

	private SQLRegistro sqlRegistro;

	private SQLReserva sqlReserva;

	private SQLSalon sqlSalon;

	private SQLServicioAlimentacion sqlServicioAlimentacion;

	private SQLServicioAlojamiento sqlServicioAlojamiento;

	private SQLServicioAlojamientoHabitacion sqlServicioAlojamientoHabitacion;
	
	//private SQLServicioArreglos sqlServicioArreglos;

	private SQLServicioHotelComplementario sqlServicioHotelComplementario;

	private SQLServicioIncluido sqlServicioIncluido;

	private SQLServicioLavanderia sqlServicioLavanderia;

	//private SQLServicioReservado sqlServicioReservado;

	private SQLTipoHabitacion sqlTipoHabitacion;

	private SQLUsuario sqlUsuario;

	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaHotelAndes()
	{
		//TODO revisar que es esto
		pmf = JDOHelper.getPersistenceManagerFactory("HotelAndes");		
		crearClasesSQL ();

		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("HotelAndes_sequence");
		tablas.add ("CADENAHOTELERA");
		tablas.add ("CARACTERISTICAADICIONAL");
		tablas.add ("CARACTERISTICASERVICIO");
		tablas.add ("CONVENCION");
		tablas.add ("CONVENCIONHABITACION");
		tablas.add ("CONVENCIONRESTBARCAFETERIA");
		tablas.add ("CONVENCIONSALON");
		tablas.add ("CUENTA");
		tablas.add ("CUENTAALOJAMIENTO");
		tablas.add ("CUENTASERVICIO");
		tablas.add ("DOTACION");
		tablas.add ("DOTACIONHABITACION");
		tablas.add ("HABITACION");
		tablas.add ("HORARIO");
		tablas.add ("HOTEL");
		tablas.add ("PLAN");
		tablas.add ("PLANCARACTERISTICAADICIONAL");
		tablas.add ("PRODUCTO");
		tablas.add ("PRODUCTOSERVICIO");
		tablas.add ("REGISTRO");
		tablas.add ("RESERVA");
		tablas.add ("SALON");
		tablas.add ("SERVICIOALIMENTACION");
		tablas.add ("SERVICIOALOJAMIENTO");
		tablas.add ("SERVICIOALOJAMIENTOHABITACION");
		tablas.add ("SERVICIOARREGLO");
		tablas.add ("SERVICIOHOTELCOMPLEMENTARIO");
		tablas.add ("SERVICIOINCLUIDO");
		tablas.add ("SERVICIOLAVANDERIA");
		tablas.add ("SERVICIORESERVADO");
		tablas.add ("TIPOHABITACION");
		tablas.add ("USUARIO");
	}

	//TODO Entender este metodo y que hace todo
	private PersistenciaHotelAndes(JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);

		for (int i = 0; i < tablas.size(); i++) {
			System.out.println(tablas.get(i));
		}
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	public static PersistenciaHotelAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaHotelAndes();
		}
		return instance;
	}

	public static PersistenciaHotelAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaHotelAndes(tableConfig);
		}
		return instance;
	}

	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}

	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}

		return resp;
	}

	private void crearClasesSQL ()
	{
		sqlCadenaHotelera = new SQLCadenaHotelera(this);
		//sqlCaracteristicaAdicional = new SQLCaracteristicaAdicional(this);
		//sqlCaracteristicaServicio = new SQLCaracteristicaServicio(this);
		//sqlConvencion = new SQLConvencion(this);
		//sqlConvencionHabitacion = new SQLConvencionHabitacion(this);
		//sqlConvencionRestBarCafeteria = new SQLConvencionRestBarCafeteria(this);
		//sqlConvencionSalon = new SQLConvencionSalon(this);
		sqlCuenta = new SQLCuenta(this);
		//sqlCuentaAlojamiento = new SQLCuentaAlojamiento(this);
		sqlCuentaServicio = new SQLCuentaServicio (this);
		//sqlDotacion = new SQLDotacion(this);		
		//sqlDotacionHabitacion = new SQLDotacionHabitacion(this);
		sqlHabitacion = new SQLHabitacion(this);
		sqlHorario = new SQLHorario(this);
		//sqlHotel = new SQLHotel(this);
		sqlPlan = new SQLPlan(this);
		//sqlPlanCaracteristicaAdicional = new SQLPlanCaracteristicaAdicional(this);
		//sqlProducto = new SQLProducto (this);
		//sqlProductoServicio = new SQLProductoServicio(this);		
		sqlRegistro = new SQLRegistro(this);
		sqlReserva = new SQLReserva(this);
		sqlSalon = new SQLSalon(this);
		sqlServicioAlimentacion = new SQLServicioAlimentacion(this);
		sqlServicioAlojamiento = new SQLServicioAlojamiento(this);
		sqlServicioAlojamientoHabitacion = new SQLServicioAlojamientoHabitacion(this);
		//sqlServicioArreglos = new SQLServicioArreglos(this);
		sqlServicioHotelComplementario = new SQLServicioHotelComplementario(this);
		sqlServicioIncluido = new SQLServicioIncluido(this);		
		sqlServicioLavanderia = new SQLServicioLavanderia(this);
		//sqlServicioReservado = new SQLServicioReservado(this);
		sqlTipoHabitacion = new SQLTipoHabitacion(this);
		sqlUsuario = new SQLUsuario(this);
		sqlUtil = new SQLUtil(this);
	}

	public String darSeqHotelAndes()
	{
		return tablas.get (0);
	}

	public String darTablaCadenaHotelera ()
	{
		return tablas.get (1);
	}

	public String darTablaCaracteristicaAdicional ()
	{
		return tablas.get (2);
	}
	
	public String darTablaConvencion ()
	{
		return tablas.get (3);
	}
	
	public String darTablaConvencionHabitacion ()
	{
		return tablas.get (4);
	}
	
	public String darTablaConvencionRestBarCafeteria ()
	{
		return tablas.get (5);
	}
	
	public String darTablaConvencionSalon ()
	{
		return tablas.get (6);
	}
	
	public String darTablaCaracteristicaServicio ()
	{
		return tablas.get (7);
	}

	public String darTablaCuenta ()
	{
		return tablas.get (8);
	}

	public String darTablaCuentaAlojamiento ()
	{
		return tablas.get (9);
	}

	public String darTablaCuentaServicio ()
	{
		return tablas.get (10);
	}

	public String darTablaDotacion ()
	{
		return tablas.get (11);
	}

	public String darTablaDotacionHabitacion ()
	{
		return tablas.get (12);
	}

	public String darTablaHabitacion ()
	{
		return tablas.get (13);
	}

	public String darTablaHorario ()
	{
		return tablas.get (14);
	}

	public String darTablaHotel ()
	{
		return tablas.get (15);
	}

	public String darTablaPlan ()
	{
		return tablas.get (16);
	}

	public String darTablaPlanCaracteristicaAdicional ()
	{
		return tablas.get (17);
	}

	public String darTablaProducto ()
	{
		return tablas.get (18);
	}

	public String darTablaProductoServicio ()
	{
		return tablas.get (19);
	}

	public String darTablaRegistro ()
	{
		return tablas.get (20);
	}

	public String darTablaReserva ()
	{
		return tablas.get (21);
	}

	public String darTablaSalon ()
	{
		return tablas.get (22);
	}

	public String darTablaServicioAlimentacion ()
	{
		return tablas.get (23);
	}

	public String darTablaSevicioAlojamiento ()
	{
		return tablas.get (24);
	}

	public String darTablaServicioAlojamientoHabitacion ()
	{
		return tablas.get (25);
	}
	
	public String darTablaServicioArreglo ()
	{
		return tablas.get (26);
	}

	public String darTablaServicioHotelComplementario ()
	{
		return tablas.get (27);
	}

	public String darTablaServicioIncluido ()
	{
		return tablas.get (28);
	}

	public String darTablaServicioLavanderia ()
	{
		return tablas.get (29);
	}

	public String darTablaServicioReservado ()
	{
		return tablas.get (30);
	}

	public String darTablaTipoHabitacion()
	{
		return tablas.get (31);
	}

	public String darTablaUsuario ()
	{
		return tablas.get (32);
	}

	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	//------------------
	//Metodos de cuenta
	//------------------
	
	public Cuenta adicionarCuenta(long idCuenta, long valor, String metodoDePago, long idPlan, long idCliente, long idReserva) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlCuenta.adicionarCuenta(pmf.getPersistenceManager(), idCuenta, valor, metodoDePago, idPlan, idCliente, idReserva);
			tx.commit();

			System.out.println("Inserción de cuenta: " + idCuenta + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Cuenta(idCuenta, valor, metodoDePago, idPlan, idCliente, idReserva);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//--------------------------------
	//Metodo para cuenta servicio
	//--------------------------------

	public CuentaServicio adicionarCuentaServicio(long idCuenta, long idServicioComplementario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlCuentaServicio.adicionarCuentaServicio(pmf.getPersistenceManager(), idCuenta, idServicioComplementario);
			tx.commit();

			System.out.println("Inserción de Plan: " + idCuenta + ": " + tuplasInsertadas + " tuplas insertadas");

			return new CuentaServicio(idCuenta, idServicioComplementario);


		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	
	//----------------------
	//Metodos de habitacion
	//----------------------

	public Habitacion adicionarHabitacion( long idHabitacion, String tipoHabitacion, long costoNoche, long capacidadHabitacion, long idHotel, long numeroHabitacion,String disponible) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlHabitacion.adicionarHabitacion(pmf.getPersistenceManager(), idHabitacion, tipoHabitacion, costoNoche, capacidadHabitacion, idHotel, numeroHabitacion,disponible);
			tx.commit();

			System.out.println("Inserción de horario: " + idHabitacion + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Habitacion(idHabitacion, tipoHabitacion, costoNoche, capacidadHabitacion, idHotel, numeroHabitacion, "S");


		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public long revisarCapacidad( long idHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			Habitacion hab = sqlHabitacion.darHabitacionPorId(pmf.getPersistenceManager(), idHabitacion);
			tx.commit();
			return hab.getCapacidadHabitacion();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return 0;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//-------------------
	//Metodos de horario
	//-------------------
	
	public Horario adicionarHorario(long idHorario,long horaInicio, long horaFinal, Timestamp fechaInicio, Timestamp fechaFinal) 
	{

		try
		{
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlHorario.adicionarHorario(pmf.getPersistenceManager(), idHorario, horaInicio, horaFinal, fechaInicio, fechaFinal);

			System.out.println("Inserción de horario: " + idHorario + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Horario(idHorario, horaInicio, horaFinal, fechaInicio, fechaFinal);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		
	}
	
	//--------------------------------
	//Metodo para servicio alojamiento
	//--------------------------------

	public Registro adicionarRegistro(long idRegistro, long idReserva, long idRegistrador) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlRegistro.adicionarRegistro(pmf.getPersistenceManager(), idRegistro, idReserva, idRegistrador);
			tx.commit();

			System.out.println("Inserción de Plan: " + idRegistro + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Registro(idRegistro, idReserva, 'E', 'F', idRegistrador);


		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public void modificarRegistro( long idRegistro)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			sqlRegistro.modificarRegistro(pm, idRegistro);
			tx.commit();
		}
		catch(Exception e)
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	
	//-------------------
	//Metodos de reserva
	//-------------------
	
	public Reserva adicionarReserva(long idReserva,long abono, long idHabitacion, long idHorario, long idCliente, long idHotel, long idCuenta) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlReserva.adicionarReserva(pmf.getPersistenceManager(), idCliente, abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta);
			tx.commit();

			System.out.println("Inserción de cuenta: " + idCuenta + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Reserva(idReserva, abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//--------------------------
	//Metodos de tipoHabitacion
	//--------------------------

	public TipoHabitacion adicionarTipoHabitacion(String nombreTipo, String descripcion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlTipoHabitacion.adicionarTipoHabitacion(pmf.getPersistenceManager(), nombreTipo, descripcion);
			tx.commit();

			System.out.println("Inserción de cuenta: " + nombreTipo + ": " + tuplasInsertadas + " tuplas insertadas");

			return new TipoHabitacion(nombreTipo, descripcion);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//-------------------
	//Metodos de usuario
	//-------------------
		
	public Usuario adicionarUsuario(long idUsuario, String tipoDocumento, long numeroDocumento, String correoElectronico, String rol) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlUsuario.adicionarUsuario(pmf.getPersistenceManager(), tipoDocumento, numeroDocumento, correoElectronico, rol, idUsuario);
			tx.commit();

			System.out.println("Inserción de cuenta: " + idUsuario + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Usuario(tipoDocumento, numeroDocumento, correoElectronico, rol, idUsuario);


		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public Usuario darUsuarioPorId(long id)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			Usuario rta = sqlUsuario.darUsuarioPorId(pm, id);
			tx.commit();
			System.out.println("Obtencion de un usuario: " + id + ": " + rta!=null?1:0 + " tuplas encontradas");

			return rta;
		}
		catch (Exception e)
		{
			        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//----------------
	//Metodos de plan
	//----------------
	
	public Plan adicionarPlan(long idPlan, String nombrePlan, String tipo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlPlan.adicionarPlan(pmf.getPersistenceManager(), idPlan, nombrePlan, tipo);
			tx.commit();

			System.out.println("Inserción de Plan: " + idPlan + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Plan(idPlan, nombrePlan, tipo, new Timestamp(0), new Timestamp(0));


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
		
	
	//--------------------------------
	//Metodo para servicio alojamiento
	//--------------------------------
	
	public ServicioAlojamiento adicionarServicioAlojamiento(long idServicioAlojamiento, long cantidadPersonas, long idCuenta) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlServicioAlojamiento.adicionarServicioAloja(pmf.getPersistenceManager(), idServicioAlojamiento, cantidadPersonas, idCuenta);
			tx.commit();

			System.out.println("Inserción de Plan: " + idServicioAlojamiento + ": " + tuplasInsertadas + " tuplas insertadas");

			return new ServicioAlojamiento(idServicioAlojamiento, cantidadPersonas, idCuenta);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public ServicioAlojamientoHabitacion crearRelacionServHab(long idHabitacion, long idServicioAlojamiento){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			ServicioAlojamientoHabitacion ser = sqlServicioAlojamientoHabitacion.darRelacionPorHabitacion(pm, idHabitacion);
			if(ser == null){
				tuplasInsertadas = sqlServicioAlojamientoHabitacion.adicionar(pm, idHabitacion, idServicioAlojamiento);
			}
			tx.commit();

			System.out.println("Inserción de Plan: " + idServicioAlojamiento + ": " + tuplasInsertadas + " tuplas insertadas");

			if(tuplasInsertadas == 0)
			{
				return null;
			}
			return new ServicioAlojamientoHabitacion(idHabitacion, idServicioAlojamiento);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public boolean buscarPorHabitacion(long idHabitacion){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			ServicioAlojamientoHabitacion ser = sqlServicioAlojamientoHabitacion.darRelacionPorHabitacion(pm, idHabitacion);
			tx.commit();

			System.out.println(ser);
			return ser != null;


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return false;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//-------------------------------------------
	//Metodos para los servicios complementarios
	//-------------------------------------------
	
	public ServicioHotelComplementario adicionarServicioHotel(long idSComplementario, String nombreServicio, long idHotel) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlServicioHotelComplementario.adicionarServHotelComplementario(pm, idSComplementario, nombreServicio, idHotel);
			tx.commit();

			System.out.println("Inserción de Plan: " + idSComplementario + ": " + tuplasInsertadas + " tuplas insertadas");

			return new ServicioHotelComplementario(idSComplementario, nombreServicio, idHotel);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//Servicio incluido
	public ServicioIncluido adicionarServicioIncluido(long idServicio, String nombreServicio, long idHotel, String nombre,
			long capacidad) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlServicioIncluido.adicionarServIncluido(pm, idServicio, nombre, capacidad, idHotel);
			tx.commit();

			System.out.println("Inserción de Plan: " + idServicio + ": " + tuplasInsertadas + " tuplas insertadas");

			return new ServicioIncluido(idServicio, nombreServicio, idHotel, nombre, capacidad);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//Servicio alimentacion
	public ServicioAlimentacion adicionarServicioAlimentacion(long idServicio, long idHotel, String nombreSevicio, String estilo, long capacidad, String tipo, char esConsumoHabitacion, long idHorario, String descripcion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlServicioAlimentacion.adicionarServAlimentacion(pm, idServicio, nombreSevicio, estilo, capacidad, tipo, esConsumoHabitacion, idHorario, descripcion);
			tx.commit();

			System.out.println("Inserción de Plan: " + idServicio + ": " + tuplasInsertadas + " tuplas insertadas");

			return new ServicioAlimentacion(idServicio, nombreSevicio, idHotel, estilo, capacidad, tipo, esConsumoHabitacion, idHorario, descripcion);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//Salon
	public Salon adicionarSalon(long idServicio, String nombreServicio, long idHotel, String nombre, long capacidad, long costoPorHora, String tipo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlSalon.adicionarServAlimentacion(pm, idServicio, nombre, capacidad, costoPorHora);
			tx.commit();

			System.out.println("Inserción de Plan: " + idServicio + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Salon(idServicio, nombreServicio, idHotel, nombre, capacidad, costoPorHora, tipo);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//ServicioLavanderia
	public ServicioLavanderia adicionarServicioLavanderia(long idServicio, String nombreServicio, long idHotel, String descripcion, String tipo, long costoUnitario, long cantUnidades) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlServicioLavanderia.adicionarServLavanderia(pm, idServicio, nombreServicio, descripcion, tipo, costoUnitario);
			tx.commit();

			System.out.println("Inserción de Plan: " + idServicio + ": " + tuplasInsertadas + " tuplas insertadas");

			return new ServicioLavanderia(idServicio, nombreServicio, idHotel, descripcion, tipo, costoUnitario, cantUnidades);


		}
		catch (Exception e)
		{
        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//-----------------------
	//Metodos para consultas
	//-----------------------

	// req 1
	public List<Object[]> dineroRecolectado(Timestamp fechaInicio, Timestamp fechaFinal){

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			String sql = "SELECT ha.idhabitacion AS \"NumeroHabitacion\" , SUM(cu.valor) AS \"DineroRecolectado\" " +
					"FROM " + darTablaCuenta() + " cu " + 
					"INNER JOIN CUENTAALOJAMIENTO ca ON cu.idcuenta = ca.idcuenta " +
					"INNER JOIN SERVICIOALOJAMIENTO sa ON sa.idservicioalojamiento = ca.idservicioalojamiento" +
					"INNER JOIN HABITACION ha ON re.idhabitacion = ha.idhabitacion " +
					"INNER JOIN RESERVA re ON re.idCuenta = cu.idCuenta AND su.id = es.idsucursal " +
					"INNER JOIN HORARIO ho ON re.idhorario = ho.idhorario " +
					"GROUP BY ha.idhabitacion HAVING ho.fechainicio BETWEEN ? AND ?;";
			Query q = pm.newQuery(SQL, sql);
			q.setParameters(fechaInicio, fechaFinal);
			List<Object[]> l = (List<Object[]>)q.executeList();
			tx.commit();


			return l;			
		}
		catch(Exception e)
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	//req 2
	public List<Object[]> top20Servicios(){

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();

			String sql = "SELECT idserviciocomplementario, count(idserviciocomplementario) FROM CUENTASERVICIO WHERE ROWNUM <= 20 GROUP BY idServicioComplementario ORDER BY count(idserviciocomplementario) desc";
			Query q = pm.newQuery(SQL,sql);
			List<Object[]> l = (List<Object[]>)q.executeList();
			tx.commit();

			System.out.println(l.getClass());
			return l;			
		}
		catch(Exception e)
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	// req 3
	public List<Object[]> indiceOcupacion(){

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();

			String sql = "SELECT tablita1.IDHABITACION AS NUMHABITACION, (sa.CANTIDADPERSONAS/tablita1.CAPACIDADHABITACION) AS INDICE " +
					"FROM (SELECT ha.idhabitacion, ha.capacidadhabitacion, sah.idservicioalojamiento " +
					"FROM HABITACION ha " +
					"INNER JOIN SERVICIOALOJAMIENTOHABITACION sah " +
					"ON sah.IDHABITACION = ha.IDHABITACION) tablita1 " +
					"INNER JOIN SERVICIOALOJAMIENTO sa ON sa.IDSERVICIOALOJAMIENTO = tablita1.IDSERVICIOALOJAMIENTO";
			Query q = pm.newQuery(SQL, sql);
			List<Object[]> l = (List<Object[]>) q.executeList();
			tx.commit();
			System.out.println(l.getClass());
			System.out.println(l.get(0)[0]);


			return l;			
		}
		catch(Exception e)
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	// req 4
	public List<Object[]> servicioYCaracteristica(long id, long valorMax, long valorMin, Timestamp fechaInicio, Timestamp fechaFinal, long idRegistrador){	
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();

			String sql = "SELECT shc.idscomplementario, shc.nombreservicio, cu.valor, COUNT(cs.IDSERVICIOCOMPLEMENTARIO) AS CANTVECES, hor.FECHAINICIO, hor.FECHAFINAL, reg.IDREGISTRADOR FROM SERVICIOHOTELCOMPLEMENTARIO shc INNER JOIN CUENTASERVICIO cs ON  shc.IDSCOMPLEMENTARIO = cs.IDSERVICIOCOMPLEMENTARIO INNER JOIN CUENTA cu ON cs.IDCUENTA = cu.IDCUENTA  INNER JOIN RESERVA re ON re.IDRESERVA = cu.IDRESERVA INNER JOIN HORARIO hor ON hor.IDHORARIO = re.IDHORARIO   INNER JOIN REGISTRO reg ON reg.IDRESERVA = re.IDRESERVA  WHERE COUNT(cs.IDSERVICIOCOMPLEMENTARIO) > ? AND shc.NOMBRESERVICIO = ? AND cu.VALOR > ? AND cu.VALOR < ? AND hor.FECHAINICIO < ? AND hor.FECHAFINAL > ? AND reg.IDREGISTRADOR = ?";
			Query q = pm.newQuery(SQL,sql);
			q.setParameters(id, valorMax, valorMin, fechaInicio, fechaFinal, idRegistrador);
			List<Object[]> l = (List<Object[]>)q.executeList();
			tx.commit();


			return l;			
		}
		catch(Exception e)
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	//Req 5
	public List<Object[]> gastoCliente(long idCliente, Timestamp fechaInicio, Timestamp fechaFinal){	
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();

			String sql = "SELECT SUM(cu.VALOR) FROM CLIENTE cli INNER JOIN cu ON cli.IDCLIENTE = cu.IDCLIENTE INNER JOIN RESERVA ON re.IDCUENTA = cu.IDCUENTA INNER JOIN HORARIO ON hor.IDHORARIO = re.IDHORARIO WHERE IDCLIENTE = ? AND hor.FECHAINICIO <= ? AND hor.FECHAFINAL >= ?";
			Query q = pm.newQuery(SQL,sql);
			q.setParameters(idCliente, fechaInicio, fechaFinal);
			List<Object[]> l = (List<Object[]>)q.executeList();
			tx.commit();


			return l;			
		}
		catch(Exception e)
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//-------------------
	//Metodos auxiliares
	//-------------------
	
	public long darAgruparPorTipo(String tipo){

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();

			Query q = pm.newQuery(SQL, "SELECT * FROM (SELECT TIPOHABITACION, COUNT(TIPOHABITACION) FROM HABITACION WHERE DISPONIBLE = 'S' GROUP BY TIPOHABITACION) WHERE TIPOHABITACION = '?'");
			q.setResultClass(Habitacion.class);
			q.setParameters(tipo);
			List<Object[]> lista = q.executeList();
			tx.commit();


			return (long)lista.get(0)[1];			
		}
		catch(Exception e)
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			e.printStackTrace();
			return 0;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
		
	}

public Convencion adicionarConvencion(long idConvencion, long idHotel, long numparticipantes,
			String nombreConvencion, long idHorario) {
		
		try
		{
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlConvencion.adicionarConvencion(pmf.getPersistenceManager(), idConvencion, idHotel, numparticipantes, nombreConvencion, idHorario);

		
			return new Convencion(idConvencion, idHotel, numparticipantes, nombreConvencion, idHorario);
	
	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		
	}

	public ConvencionRestauranteCafeteria adicionarConvencionrestbarcafeteria(long idConvencion, long idServicioComplementario) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
	
		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlConvencionRestBarCafeteria.adicionarConvencionrestbarcafeteria(pm, idConvencion, idServicioComplementario);
			tx.commit();
	
			System.out.println("Inserción de convencion: " + idConvencion + ": " + tuplasInsertadas + " tuplas insertadas");
	
			return new ConvencionRestauranteCafeteria(idConvencion, idServicioComplementario);
	
	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public String darTablaConvencionrestbarcafeteria() {
		return tablas.get (34);

	}

	public Habitacion darHabitacion(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			Habitacion resp = sqlHabitacion.darHabitacionPorId(pm, Long.valueOf(id));
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public ArrayList<Habitacion> darHabitacionTipo(String tipo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			
			ArrayList<Habitacion> resp = sqlHabitacion.darHabitacionesPorTipo(pm, tipo);
			
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public ArrayList<Habitacion> darHabitacionesConConvencion(long idConvencion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			

			Query q = pm.newQuery(SQL, "SELECT * FROM HABITACION INNER JOIN (SELECT IDHABITACION AS ELID FROM CONVENCIONHABITACION WHERE IDCONVENCION = ?)T1  ON T1.ELID = IDHABITACION" );
			q.setParameters(idConvencion );
			ArrayList<Habitacion> resp = (ArrayList<Habitacion>) q.executeUnique();
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public Convencion darConvencion(long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			Convencion rta = sqlConvencion.darConvencionPorId(pm, id);
			tx.commit();

			log.trace ("Consulta de Convencion: " + id + ": " + rta!=null?1:0 +" tuplas encontradas");

			return rta; 
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	///////////////////REQUERIMIENTO 12///////////////////////

	public void req12(long idConvencion, long idHotel, long numparticipantes, String nombreConvencion,
			Timestamp finicio,Timestamp ffinal, long idHorario, long idCliente, long idCuenta,
			ArrayList<Long> idsServicios, ArrayList<String> infoHabitaciones) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{

			tx.begin();
			long tuplasInsertadas = sqlConvencion.adicionarConvencion(pmf.getPersistenceManager(), idConvencion, idHotel, numparticipantes, nombreConvencion, idHorario);
			adicionarHorario(idHorario, 0,0,finicio, ffinal);
			adicionarConvencion(idConvencion, idHotel, numparticipantes, nombreConvencion, idHorario);
			adicionarCuenta(idCuenta, 0, "", 0, idCliente, 0);
			for (int i = 0; i < infoHabitaciones.size(); i++) {
				String[] info = infoHabitaciones.get(i).split(",");
				 ArrayList<Habitacion> habs = darHabitacionesLibresPorTipo(info[1]);
				if(habs.size()<Integer.parseInt(info[0])) 
					tx.rollback();
				else {
					for (int j = 0; j < Integer.parseInt(info[0]); j++) {
						Habitacion hab = habs.get(j);
						adicionarHabitacion(hab.getIdHabitacion(),hab.getTipoHabitacion(),hab.getCostoNoche(),hab.getCapacidadHabitacion(),idHotel,hab.getNumeroHabitacion(),"N");
						adicionarServicioAlojamiento(j+1000,1,idCuenta);
						adicionarServicioAlojamientoHabitacion(j+1000,hab.getIdHabitacion());
						adicionarConvencionHabitacion(idConvencion,hab.getIdHabitacion());
						adicionarReserva(j+1000,0,hab.getIdHabitacion(),idHorario,idCliente, idHotel,idCuenta);
					}
				}
			}	
			for (int i = 0; i < idsServicios.size(); i++) {
				adicionarConvencionRestBarCafeteria(idConvencion,idsServicios.get(i));
			}
			tx.commit();


		}
		catch (Exception e)
		{
			//e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	

	public void req13(long idConvencion, int canthabitacion, int cantServicios) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			ArrayList<Habitacion> habs = darHabitacionesConConvencion(idConvencion);
			for (int i = 0; i < canthabitacion; i++) {
				Query q = pm.newQuery(SQL, "DELETE FROM " + darTablaConvencionHabitacion() + " WHERE IDCONVENCION = ?  AND idhabitacion = ?" );
				q.setParameters(idConvencion, habs.get(i));
				q.executeUnique();
			}
			
				Query q = pm.newQuery(SQL, "DELETE FROM " + darTablaConvencionrestbarcafeteria() + " WHERE IDCONVENCION = ?" );
				q.setParameters(idConvencion);
				q.executeUnique();
			
				tx.commit();

		}
		catch (Exception e)
		{
			        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
	}

	public void req14(long idConvencion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			Query q = pm.newQuery(SQL, " UPDATE (SELECT * FROM HABITACION INNER JOIN (SELECT IDHABITACION AS HAB FROM " + darTablaConvencionHabitacion() + " WHERE IDCONVENCION = ?)T1 ON T1.HAB = IDHABITACION ) SET DISPONIBLE = 'S'" );
			q.setParameters(idConvencion);
			q.executeUnique();
			
			q = pm.newQuery(SQL, "DELETE FROM " + darTablaConvencionHabitacion() + " WHERE IDCONVENCION = ?" );
			q.setParameters(idConvencion);
			q.executeUnique();

			q= pm.newQuery(SQL, "DELETE FROM " + darTablaConvencionrestbarcafeteria() + " WHERE IDCONVENCION = ?" );
			q.setParameters(idConvencion);
			q.executeUnique();
			
			q= pm.newQuery(SQL, "DELETE FROM " + darTablaConvencionrestbarcafeteria() + " WHERE IDCONVENCION = ?" );
			q.setParameters(idConvencion);
			q.executeUnique();
			tx.commit();

		}
		catch (Exception e)
		{
			        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
	}

	 
	public void req15(ArrayList<Long> idHabitaciones) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			for (int i = 0; i < idHabitaciones.size(); i++) {
				adicionarServicioArregloH(idHabitaciones.get(i),Long.valueOf((i+2000)/3));
			}
			
			tx.commit();

		}
		catch (Exception e)
		{
			//e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	private void adicionarServicioArregloH(long idHabitacion, long idserv) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			Query q = pm.newQuery(SQL, "INSERT INTO SERVICIOARREGLO (IDSERVICIO,TIPOARREGLO,IDHABITACION,IDDOTACION)VALUES (?,?,?,?)" );
			q.setParameters(idserv,"Mantenimiento",idHabitacion,0);
			q.executeUnique();
			
			tx.commit();

		}
		catch (Exception e)
		{
			        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}		
	}

	public void req16(long idMantenimiento) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			
			tx.commit();

		}
		catch (Exception e)
		{
			//e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	private void adicionarConvencionRestBarCafeteria(long idConvencion, Long long1) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();

			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlConvencionRestBarCafeteria.adicionarConvencionrestbarcafeteria(pm, idConvencion, long1);
			tx.commit();

		}
		catch (Exception e)
		{
			        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		
	}
	
	private void adicionarConvencionHabitacion(long idConvencion, long idHabitacion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();

			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlConvencionHabitacion.adicionar(pm, idConvencion, idHabitacion);
			tx.commit();

		}
		catch (Exception e)
		{
			        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		} 
	}

	private void adicionarServicioAlojamientoHabitacion(int i, long idHabitacion) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = 0;
			tuplasInsertadas = sqlServicioAlojamientoHabitacion.adicionar(pm, idHabitacion, i);
			tx.commit();

		}
		catch (Exception e)
		{
			        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
				
	}

	public ArrayList<Habitacion> darHabitacionesLibresPorTipo (String nombreTipo){
		ArrayList<Habitacion> lasHabitaciones = new ArrayList<Habitacion>();
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			lasHabitaciones = sqlHabitacion.darHabitacionesLibresPorTipo(pm, nombreTipo);
			tx.commit();

		}
		catch (Exception e)
		{
			        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
		
		return lasHabitaciones;
	}

	

}
