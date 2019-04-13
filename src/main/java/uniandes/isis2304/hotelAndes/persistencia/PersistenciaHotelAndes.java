/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: HotelAndesUniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.hotelAndes.persistencia;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import uniandes.isis2304.hotelAndes.negocio.CadenaHotelera;
import uniandes.isis2304.hotelAndes.negocio.CaracteristicaAdicional;
import uniandes.isis2304.hotelAndes.negocio.CaracteristicaServicio;
import uniandes.isis2304.hotelAndes.negocio.Cuenta;
import uniandes.isis2304.hotelAndes.negocio.CuentaAlojamiento;
import uniandes.isis2304.hotelAndes.negocio.CuentaServicio;
import uniandes.isis2304.hotelAndes.negocio.Dotacion;
import uniandes.isis2304.hotelAndes.negocio.DotacionHabitacion;
import uniandes.isis2304.hotelAndes.negocio.Habitacion;
import uniandes.isis2304.hotelAndes.negocio.Horario;
import uniandes.isis2304.hotelAndes.negocio.Hotel;
import uniandes.isis2304.hotelAndes.negocio.Plan;
import uniandes.isis2304.hotelAndes.negocio.PlanCaracteristicaAdicional;
import uniandes.isis2304.hotelAndes.negocio.Producto;
import uniandes.isis2304.hotelAndes.negocio.ProductoServicio;
import uniandes.isis2304.hotelAndes.negocio.Registro;
import uniandes.isis2304.hotelAndes.negocio.Reserva;
import uniandes.isis2304.hotelAndes.negocio.Salon;
import uniandes.isis2304.hotelAndes.negocio.ServicioAlimentacion;
import uniandes.isis2304.hotelAndes.negocio.ServicioAlojamiento;
import uniandes.isis2304.hotelAndes.negocio.ServicioAlojamientoHabitacion;
import uniandes.isis2304.hotelAndes.negocio.ServicioHotelComplementario;
import uniandes.isis2304.hotelAndes.negocio.ServicioIncluido;
import uniandes.isis2304.hotelAndes.negocio.ServicioLavanderia;
import uniandes.isis2304.hotelAndes.negocio.ServicioReservado;
import uniandes.isis2304.hotelAndes.negocio.TipoHabitacion;
import uniandes.isis2304.hotelAndes.negocio.Usuario;

public class PersistenciaHotelAndes
{
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
	
	private SQLCaracteristicaAdicional sqlCaracteristicaAdicional;
	
	private SQLCaracteristicaServicio sqlCaracteristicaServicio;
	
	private SQLCuenta sqlCuenta;
	
	private SQLCuentaAlojamiento sqlCuentaAlojamiento;
	
	private SQLCuentaServicio sqlCuentaServicio;
	
	private SQLDotacion sqlDotacion;
	
	private SQLDotacionHabitacion sqlDotacionHabitacion;
	
	private SQLHabitacion sqlHabitacion;
	
	private SQLHorario sqlHorario;
	
	private SQLHotel sqlHotel;
	
	private SQLPlan sqlPlan;
	
	private SQLPlanCaracteristicaAdicional sqlPlanCaracteristicaAdicional;
	
	private SQLProducto sqlProducto;
	
	private SQLProductoServicio sqlProductoServicio;
	
	private SQLRegistro sqlRegistro;
	
	private SQLReserva sqlReserva;
	
	private SQLSalon sqlSalon;
	
	private SQLServicioAlimentacion sqlServicioAlimentacion;
	
	private SQLServicioAlojamiento sqlServicioAlojamiento;
	
	private SQLServicioAlojamientoHabitacion sqlServicioAlojamientoHabitacion;
	
	private SQLServicioHotelComplementario sqlServicioHotelComplementario;
	
	private SQLServicioIncluido sqlServicioIncluido;
	
	private SQLServicioLavanderia sqlServicioLavanderia;
	
	private SQLServicioReservado sqlServicioReservado;
	
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
		sqlCaracteristicaAdicional = new SQLCaracteristicaAdicional(this);
		sqlCaracteristicaServicio = new SQLCaracteristicaServicio(this);
		sqlCuenta = new SQLCuenta(this);
		sqlCuentaAlojamiento = new SQLCuentaAlojamiento(this);
		sqlCuentaServicio = new SQLCuentaServicio (this);
		sqlDotacion = new SQLDotacion(this);		
		sqlDotacionHabitacion = new SQLDotacionHabitacion(this);
		sqlHabitacion = new SQLHabitacion(this);
		sqlHorario = new SQLHorario(this);
		sqlHotel = new SQLHotel(this);
		sqlPlan = new SQLPlan(this);
		sqlPlanCaracteristicaAdicional = new SQLPlanCaracteristicaAdicional(this);
		sqlProducto = new SQLProducto (this);
		sqlProductoServicio = new SQLProductoServicio(this);		
		sqlRegistro = new SQLRegistro(this);
		sqlReserva = new SQLReserva(this);
		sqlSalon = new SQLSalon(this);
		sqlServicioAlimentacion = new SQLServicioAlimentacion(this);
		sqlServicioAlojamiento = new SQLServicioAlojamiento(this);
		sqlServicioAlojamientoHabitacion = new SQLServicioAlojamientoHabitacion(this);
		sqlServicioHotelComplementario = new SQLServicioHotelComplementario(this);
		sqlServicioIncluido = new SQLServicioIncluido(this);		
		sqlServicioLavanderia = new SQLServicioLavanderia(this);
		sqlServicioReservado = new SQLServicioReservado(this);
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

	public String darTablaCaracteristicaServicio ()
	{
		return tablas.get (3);
	}

	public String darTablaCuenta ()
	{
		return tablas.get (4);
	}

	public String darTablaCuentaAlojamiento ()
	{
		return tablas.get (5);
	}

	public String darTablaCuentaServicio ()
	{
		return tablas.get (6);
	}
	
	public String darTablaDotacion ()
	{
		return tablas.get (7);
	}

	public String darTablaDotacionHabitacion ()
	{
		return tablas.get (8);
	}

	public String darTablaHabitacion ()
	{
		return tablas.get (9);
	}

	public String darTablaHorario ()
	{
		return tablas.get (10);
	}

	public String darTablaHotel ()
	{
		return tablas.get (11);
	}

	public String darTablaPlan ()
	{
		return tablas.get (12);
	}
	
	public String darTablaPlanCaracteristicaAdicional ()
	{
		return tablas.get (13);
	}

	public String darTablaProducto ()
	{
		return tablas.get (14);
	}

	public String darTablaProductoServicio ()
	{
		return tablas.get (15);
	}

	public String darTablaRegistro ()
	{
		return tablas.get (16);
	}

	public String darTablaReserva ()
	{
		return tablas.get (17);
	}

	public String darTablaSalon ()
	{
		return tablas.get (18);
	}
	
	public String darTablaServicioAlimentacion ()
	{
		return tablas.get (19);
	}

	public String darTablaSevicioAlojamiento ()
	{
		return tablas.get (20);
	}

	public String darTablaServicioAlojamientoHabitacion ()
	{
		return tablas.get (21);
	}

	public String darTablaServicioHotelComplementario ()
	{
		return tablas.get (22);
	}

	public String darTablaServicioIncluido ()
	{
		return tablas.get (23);
	}

	public String darTablaServicioLavanderia ()
	{
		return tablas.get (24);
	}
	
	public String darTablaServicioReservado ()
	{
		return tablas.get (25);
	}

	public String darTablaTipoHabitacion()
	{
		return tablas.get (26);
	}

	public String darTablaUsuario ()
	{
		return tablas.get (27);
	}
	
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
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

	public CadenaHotelera adicionarCadenaHotelera(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idCadena = nextval ();
            long tuplasInsertadas = sqlCadenaHotelera.adicionarCadenaHotelera(pm, idCadena, nombre);
            tx.commit();
            
            log.trace ("Inserción de tipo de bebida: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new CadenaHotelera (idCadena, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarCadenaHoteleraPorId (long idCadenaHotelera) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCadenaHotelera.eliminarCadenaHoteleraId(pm, idCadenaHotelera);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<CadenaHotelera> CadenasHoteleras ()
	{
		return sqlCadenaHotelera.darCadenaHotelera(pmf.getPersistenceManager());
	}
 
	public CadenaHotelera darCadenaHoteleraPorId (long idCadenaHotelera)
	{
		return sqlCadenaHotelera.darCadenaHoteleraPorId (pmf.getPersistenceManager(), idCadenaHotelera);
	}
 
	/* ****************************************************************
	 * 			Métodos para manejar las BEBIDAS
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre de la bebida
	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
	 * @return El objeto Bebida adicionado. null si ocurre alguna Excepción
	 */
	public CaracteristicaAdicional adicionarCaracteristicaAdicional(long limite, double dcto, String descrip, long idServicioComple, long idSerAloja) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();            
            long idCaracteristicaAdicional = nextval ();
            long tuplasInsertadas = sqlCaracteristicaAdicional.adicionarCaracteristicaAdicional(pm, idCaracteristicaAdicional, limite, dcto, descrip, idServicioComple, idSerAloja);
            tx.commit();
            
            log.trace ("Inserción CaracteristicaAdicional: " + descrip + ": " + tuplasInsertadas + " tuplas insertadas");
            return new CaracteristicaAdicional(idCaracteristicaAdicional, (int) limite, dcto, descrip, idServicioComple, idSerAloja);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Bebida, dado el identificador de la bebida
	 * Adiciona entradas al log de la aplicación
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarCaracteristicaAdicionalPorId (long idCaracteristicaAdicional) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCaracteristicaAdicional.eliminarCaracteristicaAdicionalPorId (pm, idCaracteristicaAdicional);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<CaracteristicaAdicional> darCaracteristicaAdicional ()
	{
		return sqlCaracteristicaAdicional.darCaracteristicaAdicional (pmf.getPersistenceManager());
	}
 
	public CaracteristicaAdicional darCaracAdPorId(long idCarac)
	{
		return sqlCaracteristicaAdicional.darCaracteristicaAdicionalPorId(pmf.getPersistenceManager(), idCarac);
	}

	public CaracteristicaServicio adicionarCaracteristicaServicio(long idServicio, String nombreCaracteristica, String descripcion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idCaracteristicaServicio = nextval ();
            long tuplasInsertadas = sqlCaracteristicaServicio.adicionarCaracteristicaServicio(pmf.getPersistenceManager(), idCaracteristicaServicio, idServicio, nombreCaracteristica, descripcion);
            tx.commit();

            log.trace ("Inserción de caracteristica servicio: " + nombreCaracteristica + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new CaracteristicaServicio (idCaracteristicaServicio, idServicio, nombreCaracteristica, descripcion);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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


	public long eliminarCaracteristicaServicioPorId (long idCaracteristicaServicio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCaracteristicaServicio.eliminarCaracteristicaServicioPorId (pm, idCaracteristicaServicio);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<CaracteristicaServicio> darCaracServ()
	{
		return sqlCaracteristicaServicio.darCaracteristicaServicio(pmf.getPersistenceManager());
	}
	
	public CaracteristicaServicio darCaracServicioPorId (long idCaracteristicaServicio) 
	{
		return (CaracteristicaServicio) sqlCaracteristicaServicio.darCaracteristicaServicioPorId (pmf.getPersistenceManager(), idCaracteristicaServicio);
	}
	

	public Cuenta adicionarCuenta(double valor, String metodoDePago, long idPlanConsumo, long idCliente, long idReserva) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idCuenta = nextval ();
            long tuplasInsertadas = sqlCuenta.adicionarCuenta(pm, idCuenta, valor, metodoDePago, idPlanConsumo, idCliente, idReserva);
            tx.commit();

            log.trace ("Inserción de Cuenta: " + idCuenta + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Cuenta (idCuenta, valor, metodoDePago, idCliente, idPlanConsumo, idReserva);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarCuentaPorId (long idCuenta) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCuenta.eliminarCuentaPorId (pm, idCuenta);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Cuenta> darCuentas ()
	{
		return sqlCuenta.darCuenta (pmf.getPersistenceManager());
	}
	
	public Cuenta darCuentaPorId (long idCuenta)
	{
		return sqlCuenta.darCuentaPorId (pmf.getPersistenceManager(), idCuenta);
	}
	
	//----------
	//Limpiar
	//----------
	public long [] limpiarHotelAndes()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarHotelAndes(pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
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
	
	public Dotacion adicionarDotacion(String nombreObjeto, char esCobrable, double valorObjeto) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idDotacion = nextval ();
            long tuplasInsertadas = sqlDotacion.adicionarDotacion(pm, idDotacion, nombreObjeto, esCobrable, valorObjeto);
            tx.commit();

            log.trace ("Inserción de Dotacion: " + idDotacion + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Dotacion (idDotacion, nombreObjeto, esCobrable, valorObjeto, 0);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarDotacionPorId (long idDotacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlDotacion.eliminarDotacionPorId (pm, idDotacion);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Dotacion> darDotacions ()
	{
		return sqlDotacion.darDotacion (pmf.getPersistenceManager());
	}
	
	public Dotacion darDotacionPorId (long idDotacion)
	{
		return sqlDotacion.darDotacionPorId (pmf.getPersistenceManager(), idDotacion);
	}
	
	

	public Habitacion adicionarHabitacion(String tipoHabitacion, double costoNoche, int capacidad, long idHotel) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idHabitacion = nextval ();
            long tuplasInsertadas = sqlHabitacion.adicionarHabitacion(pm, idHabitacion, tipoHabitacion, costoNoche, capacidad, idHotel);
            tx.commit();

            log.trace ("Inserción de Habitacion: " + idHabitacion + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Habitacion (idHabitacion, tipoHabitacion, costoNoche, capacidad, idHotel);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarHabitacionPorId (long idHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlHabitacion.eliminarHabitacionPorId (pm, idHabitacion);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Habitacion> darHabitacions ()
	{
		return sqlHabitacion.darHabitacion (pmf.getPersistenceManager());
	}
	
	public Habitacion darHabitacionPorId (long idHabitacion)
	{
		return sqlHabitacion.darHabitacionPorId (pmf.getPersistenceManager(), idHabitacion);
	}
	
	
	//--------Horario
	
	public Horario adicionarHorario(long horaInicio, long horaFinal, Timestamp fechaInicial, Timestamp fechaFinal) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idHorario = nextval ();
            long tuplasInsertadas = sqlHorario.adicionarHorario(pm, idHorario, horaInicio, horaFinal, fechaInicial, fechaFinal);
            tx.commit();

            log.trace ("Inserción de Horario: " + idHorario + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Horario (idHorario, fechaInicial, (int) horaInicio, fechaFinal, (int)horaFinal);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarHorarioPorId (long idHorario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlHorario.eliminarHorarioPorId (pm, idHorario);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Horario> darHorarios ()
	{
		return sqlHorario.darHorario (pmf.getPersistenceManager());
	}
	
	public Horario darHorarioPorId (long idHorario)
	{
		return sqlHorario.darHorarioId (pmf.getPersistenceManager(), idHorario);
	}
	
	//--------Hotel
	


	public Hotel adicionarHotel(String nombre, String ciudad, String pais, int estrellas, long cadenaHotelera) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idHotel = nextval ();
            long tuplasInsertadas = sqlHotel.adicionarHotel(pm, idHotel, nombre, ciudad, pais, estrellas, cadenaHotelera);
            tx.commit();

            log.trace ("Inserción de Hotel: " + idHotel + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Hotel (idHotel, nombre, estrellas, pais, ciudad, cadenaHotelera);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarHotelPorId (long idHotel) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlHotel.eliminarHotelPorId (pm, idHotel);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Hotel> darHotels ()
	{
		return sqlHotel.darHoteles (pmf.getPersistenceManager());
	}
	
	public Hotel darHotelPorId (long idHotel)
	{
		return sqlHotel.darHotelId (pmf.getPersistenceManager(), idHotel);
	}
	
	//------------Plan
	


	public Plan adicionarPlan(String nombrePlan, String tipo, Timestamp fechaInicial, Timestamp fechaFinal) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idPlan = nextval ();
            long tuplasInsertadas = sqlPlan.adicionarPlan(pm, idPlan, nombrePlan, tipo, fechaInicial, fechaFinal);
            tx.commit();

            log.trace ("Inserción de Plan: " + idPlan + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Plan (idPlan, nombrePlan, tipo, fechaInicial, fechaFinal);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarPlanPorId (long idPlan) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPlan.eliminarPlanPorId (pm, idPlan);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Plan> darPlans ()
	{
		return sqlPlan.darPlan (pmf.getPersistenceManager());
	}
	
	public Plan darPlanPorId (long idPlan)
	{
		return sqlPlan.darPlanPorId (pmf.getPersistenceManager(), idPlan);
	}
	
	//--------Producto
	
	public Producto adicionarProducto(String nombreProducto, double precio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idProducto = nextval ();
            long tuplasInsertadas = sqlProducto.adicionarProducto(pm, idProducto, nombreProducto, precio);
            tx.commit();

            log.trace ("Inserción de Producto: " + idProducto + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Producto (idProducto, nombreProducto, precio);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarProductoPorId (long idProducto) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlProducto.eliminarProductoPorId (pm, idProducto);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Producto> darProductos ()
	{
		return sqlProducto.darProducto (pmf.getPersistenceManager());
	}
	
	public Producto darProductoPorId (long idProducto)
	{
		return sqlProducto.darProductoPorId (pmf.getPersistenceManager(), idProducto);
	}
	
	//-------------Registro
	
	public Registro adicionarRegistro(long idReserva, char estadoCheckIn, char estadoCheckOut, long idRegistrador) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idRegistro = nextval ();
            long tuplasInsertadas = sqlRegistro.adicionarRegistro(pm, idRegistro, idReserva, estadoCheckIn, estadoCheckOut, idRegistrador);
            tx.commit();

            log.trace ("Inserción de Registro: " + idRegistro + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Registro (idRegistrador, idRegistro, idReserva, estadoCheckIn, estadoCheckOut);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarRegistroPorId (long idRegistro) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlRegistro.eliminarRegistroPorId (pm, idRegistro);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Registro> darRegistros ()
	{
		return sqlRegistro.darRegistro (pmf.getPersistenceManager());
	}
	
	public Registro darRegistroPorId (long idRegistro)
	{
		return sqlRegistro.darRegistroPorId (pmf.getPersistenceManager(), idRegistro);
	}
	
	public long updateCheckIn(long idRegistro){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlRegistro.updateCheckIn(pm, idRegistro);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1 ;
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
	
	//---------Reserva
	
	public Reserva adicionarReserva(long abono,long idHabitacion, long idHorario,long idCliente,long idHotel, long idCuenta) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idReserva = nextval ();
            long tuplasInsertadas = sqlReserva.adicionarReserva(pm, idReserva, abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta);
            tx.commit();

            log.trace ("Inserción de Reserva: " + idReserva + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Reserva (idReserva, abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarReservaPorId (long idReserva) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.eliminarReservaPorId (pm, idReserva);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Reserva> darReservas ()
	{
		return sqlReserva.darReserva (pmf.getPersistenceManager());
	}
	
	public Reserva darReservaPorId (long idReserva)
	{
		return sqlReserva.darReservaPorId (pmf.getPersistenceManager(), idReserva);
	}
	
	//---------Salon
	

	public Salon adicionarSalon(String nombre, long idHotel, String nombreSalon, int capacidad, double costoPorHora) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idSalon = nextval ();
            sqlServicioHotelComplementario.adicionarServicioHotelComplementario(pmf.getPersistenceManager(), idSalon, nombre, idHotel);
            long tuplasInsertadas = sqlSalon.adicionarSalon(pm, idSalon, nombreSalon, capacidad, costoPorHora);
            tx.commit();

            log.trace ("Inserción de Salon: " + idSalon + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Salon (idSalon, nombre, idHotel, nombreSalon, capacidad, costoPorHora);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarSalonPorId (long idSalon) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlSalon.eliminarSalonPorId (pm, idSalon);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Salon> darSalons ()
	{
		return sqlSalon.darSalon (pmf.getPersistenceManager());
	}
	
	public Salon darSalonPorId (long idSalon)
	{
		return sqlSalon.darSalonPorId (pmf.getPersistenceManager(), idSalon);
	}
	
	//-------------ServicioAlimentacion
	
	public ServicioAlimentacion adicionarServicioAlimentacion(String nombreServicio, long idHotel,String nombre, String estilo, long capacidad, String tipo, char esConsumo, long idHorario, String descripcion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicioAlimentacion = nextval ();
            sqlServicioHotelComplementario.adicionarServicioHotelComplementario(pmf.getPersistenceManager(), idServicioAlimentacion, nombreServicio, idHotel);
            long tuplasInsertadas = sqlServicioAlimentacion.adicionarServicioAlimentacion(pm, idServicioAlimentacion, nombre, estilo, capacidad, tipo, esConsumo, idHorario, descripcion);
            tx.commit();

            log.trace ("Inserción de ServicioAlimentacion: " + idServicioAlimentacion + ": " + tuplasInsertadas + " tuplas insertadas");

            return new ServicioAlimentacion (idServicioAlimentacion, nombre, idHotel, nombre, estilo, (int)capacidad, tipo, esConsumo, idHorario, descripcion);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarServicioAlimentacionPorId (long idServicioAlimentacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioAlimentacion.eliminarServicioAlimentacionPorId (pm, idServicioAlimentacion);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<ServicioAlimentacion> darServicioAlimentacions ()
	{
		return sqlServicioAlimentacion.darServicioAlimentacion (pmf.getPersistenceManager());
	}
	
	public ServicioAlimentacion darServicioAlimentacionPorId (long idServicioAlimentacion)
	{
		return sqlServicioAlimentacion.darServicioAlimentacionPorId (pmf.getPersistenceManager(), idServicioAlimentacion);
	}
	
	//-------ServicioAlojamiento
	
	public ServicioAlojamiento adicionarServicioAlojamiento(int cantidadPersonas, long idCuenta) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicioAlojamiento = nextval ();
            long tuplasInsertadas = sqlServicioAlojamiento.adicionarServicioAlojamiento(pm, idServicioAlojamiento, cantidadPersonas, idCuenta);
            tx.commit();

            log.trace ("Inserción de ServicioAlojamiento: " + idServicioAlojamiento + ": " + tuplasInsertadas + " tuplas insertadas");

            return new ServicioAlojamiento (idServicioAlojamiento, cantidadPersonas, idCuenta);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarServicioAlojamientoPorId (long idServicioAlojamiento) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioAlojamiento.eliminarServicioAlojamientoPorId (pm, idServicioAlojamiento);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<ServicioAlojamiento> darServicioAlojamientos ()
	{
		return sqlServicioAlojamiento.darServicioAlojamiento (pmf.getPersistenceManager());
	}
	
	public ServicioAlojamiento darServicioAlojamientoPorId (long idServicioAlojamiento)
	{
		return sqlServicioAlojamiento.darServicioAlojamientoPorId (pmf.getPersistenceManager(), idServicioAlojamiento);
	}
	
	//---------ServicioHotelComplementario
	

	public ServicioHotelComplementario adicionarServicioHotelComplementario(String nombreServicio, long idHotel) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicioHotelComplementario = nextval ();
            long tuplasInsertadas = sqlServicioHotelComplementario.adicionarServicioHotelComplementario(pm, idServicioHotelComplementario, nombreServicio, idHotel);
            tx.commit();

            log.trace ("Inserción de ServicioHotelComplementario: " + idServicioHotelComplementario + ": " + tuplasInsertadas + " tuplas insertadas");

            return new ServicioHotelComplementario (idServicioHotelComplementario, nombreServicio, idHotel);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarServicioHotelComplementarioPorId (long idServicioHotelComplementario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioHotelComplementario.eliminarServicioHotelComplementarioPorId (pm, idServicioHotelComplementario);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<ServicioHotelComplementario> darServicioHotelComplementarios ()
	{
		return sqlServicioHotelComplementario.darServicioHotelComplementario (pmf.getPersistenceManager());
	}
	
	public ServicioHotelComplementario darServicioHotelComplementarioPorId (long idServicioHotelComplementario)
	{
		return sqlServicioHotelComplementario.darServicioHotelComplementarioPorId (pmf.getPersistenceManager(), idServicioHotelComplementario);
	}
	
	//----------- ServicioIncluido
	
	public ServicioIncluido adicionarServicioIncluido(String nombreServicio, long idHotel, String nombre, long capacidad) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicioIncluido = nextval ();
            sqlServicioHotelComplementario.adicionarServicioHotelComplementario(pmf.getPersistenceManager(), idServicioIncluido, nombreServicio, idHotel);
            long tuplasInsertadas = sqlServicioIncluido.adicionarServicioIncluido(pm, idServicioIncluido, nombre, capacidad, idHotel);
            tx.commit();

            log.trace ("Inserción de ServicioIncluido: " + idServicioIncluido + ": " + tuplasInsertadas + " tuplas insertadas");

            return new ServicioIncluido (idServicioIncluido, nombre, idHotel, nombre, (int) capacidad);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarServicioIncluidoPorId (long idServicioIncluido) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioIncluido.eliminarServicioIncluidoPorId (pm, idServicioIncluido);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<ServicioIncluido> darServicioIncluidos ()
	{
		return sqlServicioIncluido.darServicioIncluido (pmf.getPersistenceManager());
	}
	
	public ServicioIncluido darServicioIncluidoPorId (long idServicioIncluido)
	{
		return sqlServicioIncluido.darServicioIncluidoPorId (pmf.getPersistenceManager(), idServicioIncluido);
	}
	
	//----------- ServicioReservado
	
	public ServicioLavanderia adicionarServicioLavanderia(String nombreServicio, long idHotel, String nombre, String nombreServicioS, String descripcion, String tipo, long costoUnitario, long cantUnidades) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicioLavanderia = nextval ();
            sqlServicioHotelComplementario.adicionarServicioHotelComplementario(pmf.getPersistenceManager(), idServicioLavanderia, nombreServicio, idHotel);
            long tuplasInsertadas = sqlServicioLavanderia.adicionarServicioLavanderia(pm, idServicioLavanderia, nombre, nombreServicioS, descripcion, tipo, costoUnitario, cantUnidades);
            tx.commit();

            log.trace ("Inserción de ServicioLavanderia: " + idServicioLavanderia + ": " + tuplasInsertadas + " tuplas insertadas");

            return new ServicioLavanderia (idServicioLavanderia, nombreServicio, idHotel, nombre, descripcion, tipo, costoUnitario, (int) cantUnidades);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarServicioLavanderiaPorId (long idServicioLavanderia) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioLavanderia.eliminarServicioLavanderiaPorId (pm, idServicioLavanderia);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<ServicioLavanderia> darServicioLavanderias ()
	{
		return sqlServicioLavanderia.darServicioLavanderia (pmf.getPersistenceManager());
	}
	
	public ServicioLavanderia darServicioLavanderiaPorId (long idServicioLavanderia)
	{
		return sqlServicioLavanderia.darServicioLavanderiaPorId (pmf.getPersistenceManager(), idServicioLavanderia);
	}
	
	//----------- ServicioReservado
	
	public ServicioReservado adicionarServicioReservado(String nombreServicio, long idHotel, String nombreEspecifico, String tipo, long duracion, double costo, String nombreServicioS, String descripcion, long idHorario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicioReservado = nextval ();
            sqlServicioHotelComplementario.adicionarServicioHotelComplementario(pmf.getPersistenceManager(), idServicioReservado, nombreServicio, idHotel);
            long tuplasInsertadas = sqlServicioReservado.adicionarServicioReservado(pm, idServicioReservado, nombreEspecifico, tipo, duracion, costo, nombreServicio, descripcion, idHorario);
            tx.commit();

            log.trace ("Inserción de ServicioReservado: " + idServicioReservado + ": " + tuplasInsertadas + " tuplas insertadas");

            return new ServicioReservado (idServicioReservado, nombreServicio, idHotel, nombreEspecifico, nombreServicioS, idHorario, descripcion, tipo, (int)duracion, costo);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarServicioReservadoPorId (long idServicioReservado) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioReservado.eliminarServicioReservadoPorId (pm, idServicioReservado);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<ServicioReservado> darServicioReservados ()
	{
		return sqlServicioReservado.darServicioReservado (pmf.getPersistenceManager());
	}
	
	public ServicioReservado darServicioReservadoPorId (long idServicioReservado)
	{
		return sqlServicioReservado.darServicioReservadoPorId (pmf.getPersistenceManager(), idServicioReservado);
	}
	
	//----------- Usuario
	public Usuario adicionarUsuario(String tipoDocumento, long numeroDocumento, String correoElectronico, String rol) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idUsuario = nextval ();
            long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, tipoDocumento, numeroDocumento, correoElectronico, rol, idUsuario);
            tx.commit();

            log.trace ("Inserción de Usuario: " + idUsuario + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Usuario (tipoDocumento, numeroDocumento, correoElectronico, rol, idUsuario);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarUsuarioPorId (long idUsuario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlUsuario.eliminarUsuarioPorId (pm, idUsuario);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<Usuario> darUsuarios ()
	{
		return sqlUsuario.darUsuario (pmf.getPersistenceManager());
	}
	
	public Usuario darUsuarioPorId (long idUsuario)
	{
		return sqlUsuario.darUsuarioPorId (pmf.getPersistenceManager(), idUsuario);
	}
	
	//----------TipoHabitacion
	
	public TipoHabitacion adicionarTipoHabitacion(String nombre, String descripcion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlTipoHabitacion.adicionarTipoHabitacion(pm, nombre, descripcion);
            tx.commit();

            log.trace ("Inserción de TipoHabitacion: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new TipoHabitacion (nombre, descripcion);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarTipoHabitacionPorId (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlTipoHabitacion.eliminarTipoHabitacionPorId (pm, nombre);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
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

	public List<TipoHabitacion> darTipoHabitacions ()
	{
		return sqlTipoHabitacion.darTipoHabitacion (pmf.getPersistenceManager());
	}
	
	public TipoHabitacion darTipoHabitacionPorId (String nombre)
	{
		return sqlTipoHabitacion.darTipoHabitacionPorId (pmf.getPersistenceManager(), nombre);
	}
	
	/////////////////
	//Asociaciones//
	///////////////
	
	public CuentaAlojamiento adicionarCuentaAlojamiento(long idCuenta, long idAlojamiento) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlCuentaAlojamiento.adicionarCuentaAlojamiento (pm, idCuenta, idAlojamiento);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idCuenta + ", " + idAlojamiento + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new CuentaAlojamiento (idCuenta, idAlojamiento);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarCuentaAlojamiento(long idCuenta, long idAlojamiento) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCuentaAlojamiento.eliminarCuentaAlojamientoPorId(pm, idAlojamiento, idCuenta);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
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

	public List<CuentaAlojamiento> darCuentaAlojamiento ()
	{
		return sqlCuentaAlojamiento.darCuentaAlojamiento (pmf.getPersistenceManager());
	}
 
	public CuentaAlojamiento darCuentaAlojId(long idCuentaAlojamiento, long idCuenta)
	{
		return sqlCuentaAlojamiento.darCuentaAlojamientoPorId(pmf.getPersistenceManager(), idCuentaAlojamiento, idCuenta);
	}
	
	//-------CuentaServicio
	public CuentaServicio adicionarCuentaServicio(long idCuenta, long idServicio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlCuentaServicio.adicionarCuentaServicio (pm, idCuenta, idServicio);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idCuenta + ", " + idServicio + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new CuentaServicio (idCuenta, idServicio);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarCuentaServicio(long idCuenta, long idServicio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCuentaServicio.eliminarCuentaServicioPorId(pm, idServicio, idCuenta);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
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

	public List<CuentaServicio> darCuentaServicio ()
	{
		return sqlCuentaServicio.darCuentaServicio (pmf.getPersistenceManager());
	}
 
	public CuentaServicio darCuentaServicioId(long idCuentaServicio, long idCuenta)
	{
		return sqlCuentaServicio.darCuentaServicioPorId(pmf.getPersistenceManager(), idCuentaServicio, idCuenta);
	}
	
	//----------DotacionHabitacion
	
	public DotacionHabitacion adicionarDotacionHabitacion(long idDotacion, long idHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlDotacionHabitacion.adicionarDotacionHabitacion (pm, idDotacion, idHabitacion);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idDotacion + ", " + idHabitacion + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new DotacionHabitacion (idDotacion, idHabitacion);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarDotacionHabitacion(long idDotacion, long idHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlDotacionHabitacion.eliminarDotacionHabitacionPorId(pm, idHabitacion, idDotacion);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
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

	public List<DotacionHabitacion> darDotacionHabitacion ()
	{
		return sqlDotacionHabitacion.darDotacionHabitacion (pmf.getPersistenceManager());
	}
 
	public DotacionHabitacion darDotacionHabitacionId(long idHabitacion, long idDotacion)
	{
		return sqlDotacionHabitacion.darDotacionHabitacionPorId(pmf.getPersistenceManager(), idHabitacion, idDotacion);
	}
	
	//---------PlanCaracteristicaAdicional
	

	public PlanCaracteristicaAdicional adicionarPlanCaracteristicaAdicional(long idPlan, long idCaracteristicaAdicional) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlPlanCaracteristicaAdicional.adicionarPlanCaracteristicaAdicional (pm, idPlan, idCaracteristicaAdicional);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idPlan + ", " + idCaracteristicaAdicional + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new PlanCaracteristicaAdicional (idPlan, idCaracteristicaAdicional);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarPlanCaracteristicaAdicional(long idPlan, long idCaracteristicaAdicional) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPlanCaracteristicaAdicional.eliminarPlanCaracteristicaAdicionalPorId(pm, idCaracteristicaAdicional, idPlan);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
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

	public List<PlanCaracteristicaAdicional> darPlanCaracteristicaAdicional ()
	{
		return sqlPlanCaracteristicaAdicional.darPlanCaracteristicaAdicional (pmf.getPersistenceManager());
	}
 
	public PlanCaracteristicaAdicional darPlanCaracteristicaAdicionalId(long idCaracteristicaAdicional, long idPlan)
	{
		return sqlPlanCaracteristicaAdicional.darPlanCaracteristicaAdicionalPorId(pmf.getPersistenceManager(), idCaracteristicaAdicional, idPlan);
	}
	
	//---------ProductoServicio
	
	public ProductoServicio adicionarProductoServicio(long idProducto, long idServicio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlProductoServicio.adicionarProductoServicio (pm, idProducto, idServicio);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idProducto + ", " + idServicio + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new ProductoServicio (idProducto, idServicio);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarProductoServicio(long idProducto, long idServicio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlProductoServicio.eliminarProductoServicioPorId(pm, idServicio, idProducto);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
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

	public List<ProductoServicio> darProductoServicio ()
	{
		return sqlProductoServicio.darProductoServicio (pmf.getPersistenceManager());
	}
 
	public ProductoServicio darProductoServicioId(long idServicio, long idProducto)
	{
		return sqlProductoServicio.darProductoServicioPorId(pmf.getPersistenceManager(), idServicio, idProducto);
	}
	
	//----------- ServicioAlojamientoHabitacion
	

	public ServicioAlojamientoHabitacion adicionarServicioAlojamientoHabitacion(long idServicioAlojamiento, long idHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlServicioAlojamientoHabitacion.adicionarServicioAlojamientoHabitacion (pm, idServicioAlojamiento, idHabitacion);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idServicioAlojamiento + ", " + idHabitacion + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new ServicioAlojamientoHabitacion (idServicioAlojamiento, idHabitacion);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
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

	public long eliminarServicioAlojamientoHabitacion(long idServicioAlojamiento, long idHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioAlojamientoHabitacion.eliminarServicioAlojamientoHabitacionPorId(pm, idHabitacion, idServicioAlojamiento);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
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

	public List<ServicioAlojamientoHabitacion> darServicioAlojamientoHabitacion ()
	{
		return sqlServicioAlojamientoHabitacion.darServicioAlojamientoHabitacion (pmf.getPersistenceManager());
	}
 
	public ServicioAlojamientoHabitacion darServicioAlojamientoHabitacionId(long idHabitacion, long idServicioAlojamiento)
	{
		return sqlServicioAlojamientoHabitacion.darServicioAlojamientoHabitacionPorId(pmf.getPersistenceManager(), idHabitacion, idServicioAlojamiento);
	}
 }
