package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.hotelAndes.persistencia.PersistenciaHotelAndes;

public class HotelAndes {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(HotelAndes.class.getName());

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public HotelAndes ()
	{
		pp = PersistenciaHotelAndes.getInstance ();
	}

	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public HotelAndes (JsonObject tableConfig)
	{
		pp = PersistenciaHotelAndes.getInstance (tableConfig);
	}

	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	/* ****************************************************************
	 * 			Métodos para manejar las CADENASHOTELERAS
	 *****************************************************************/

	public CadenaHotelera adicionarCadenaHotelera(String nombre)
	{
		log.info ("Adicionando cadenaHotelera :  " + nombre);
		CadenaHotelera cadHot = pp.adicionarCadenaHotelera(nombre);
		log.info ("Adicionando cadenaHotelera :  " + cadHot);
		return cadHot;
	}
	/**
	 * Método que elimina una CadenaHotelera, dado el nombre del CadenaHotelera
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarCadenaHoteleraPorId(long idCadenaHotelera) 
	{
		log.info ("Eliminando cadenaHotelera :  " + idCadenaHotelera);
		long ll = pp.eliminarCadenaHoteleraPorId(idCadenaHotelera);
		log.info ("Eliminando cadenaHotelera :  " + ll + "tuplas eliminadas");
		return ll;
	}
	/**
	 * Método que consulta todas las tuplas en la tabla CadenaHotelera que tienen el nombre dado
	 * @return La lista de objetos CadenaHotelera, construidos con base en las tuplas de la tabla CadenaHotelera
	 */
	public CadenaHotelera darCadenaHoteleraPorId (long idCadena) 
	{
		log.info ("Dando cadenasHoteleras :  " + idCadena);
		CadenaHotelera liCadHot = pp.darCadenaHoteleraPorId(idCadena);
		return liCadHot;
	}
	/**
	 * Método que consulta todas las tuplas en la tabla CadenaHotelera
	 * @return La lista de objetos CadenaHotelera, construidos con base en las tuplas de la tabla CadenaHotelera
	 */
	public List<CadenaHotelera> darCadenasHoteleras ()
	{
		log.info ("Dando cadenasHoteleras");
		List<CadenaHotelera> liCadHot = pp.CadenasHoteleras();
		log.info ("Dando cadenasHoteleras" + liCadHot.size() +  " número de cadenasHoteleras");
		return liCadHot;
	}
	
	/**
	 * Encuentra todos los CaracteristicasServicios en HotelAndes y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos CadenaHotelera con todos las cadenasHoteleras que conoce la aplicación, llenos con su información básica
	 */
	public List<VOCadenaHotelera> darVOCadenaHotelera()
	{
		
		log.info ("Generando los VO de CadenaHotelera");
		List<VOCadenaHotelera> voCadenasHoteleras = new LinkedList<VOCadenaHotelera> ();
		for (CadenaHotelera CadenaHotelera: pp.CadenasHoteleras())
		{
			voCadenasHoteleras.add (CadenaHotelera);
		}
		log.info ("Generando los VO de cadenasHoteleras: " + voCadenasHoteleras.size () + " cadenasHoteleras existentes");
		return voCadenasHoteleras;
	}
	/* ****************************************************************
	 * 			Métodos para manejar las CARACTERISTICA ADICIONAL
	 *****************************************************************/
	public CaracteristicaAdicional adicionarCaracteristicaAdicional(long limite, double dcto, String descrip, long idServicioComple, long idSerAloja)
	{
		log.info ("Adicionando CaracteristicaAdicional :  " +  limite +"---"+ dcto +"---"+  descrip +"---"+  idServicioComple +"---"+  idSerAloja);
		CaracteristicaAdicional caractAd = pp.adicionarCaracteristicaAdicional( limite,  dcto,  descrip,  idServicioComple,  idSerAloja);
		log.info ("Adicionando CaracteristicaAdicional :  " + caractAd);
		return caractAd;
	}
	/**
	 * Método que elimina una CaracteristicaAdicional, dado el nombre del CaracteristicaAdicional
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarCaracteristicaAdicionalPorId(long idCaracteristicaAdicional) 
	{
		log.info ("Eliminando CaracteristicaAdicional :  " + idCaracteristicaAdicional);
		long ll = pp.eliminarCaracteristicaAdicionalPorId(idCaracteristicaAdicional);
		log.info ("Eliminando CaracteristicaAdicional :  " + ll + "tuplas eliminadas");
		return ll;
	}
	/**
	 * Método que consulta todas las tuplas en la tabla CaracteristicaAdicional
	 * @return La lista de objetos CaracteristicaAdicional, construidos con base en las tuplas de la tabla CaracteristicaAdicional
	 */
	public List<CaracteristicaAdicional> darCaracteristicaAdicional ()
	{
		log.info ("Dando CategoriaProductos");
		List<CaracteristicaAdicional> licaract = pp.darCaracteristicaAdicional();
		log.info ("Dando CategoriaProductos" + licaract.size() +  " número de CategoriaProductos");
		return licaract;
	}
	/**
	 * Método que consulta el CaracteristicaAdicional CaracteristicaAdicional
	 * @return El objeto CaracteristicaAdicional con dicho id.
	 */
	public CaracteristicaAdicional darCaracAdPorId(long idCarac)
	{
		log.info ("Dando CaracteristicaAdicional :  " + idCarac);
		CaracteristicaAdicional caractAd = pp.darCaracAdPorId(idCarac);
		log.info ("Dando CaracteristicaAdicional :  " + caractAd);
		return caractAd;
	}
	/**
	 * Encuentra todos los caracteristicasAdicionales en HotelAndes y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos categoria con todos las caracteristicasAdicionales que conoce la aplicación, llenos con su información básica
	 */
	public List<VOCaracteristicaAdicional> darVOCaracteristicaAdicional ()
	{
		log.info ("Generando los VO de CaracteristicaAdicional");
		List<VOCaracteristicaAdicional> vocaracteristicasAdicionales = new LinkedList<VOCaracteristicaAdicional> ();
		for (CaracteristicaAdicional Caract: pp.darCaracteristicaAdicional())
		{
			vocaracteristicasAdicionales.add (Caract);
		}
		log.info ("Generando los VO de caracteristicasAdicionales: " + vocaracteristicasAdicionales.size () + " caracteristicasAdicionales existentes");
		return vocaracteristicasAdicionales;
	}

	/* ****************************************************************
	 * 			Métodos para manejar las CARACTERISTICA SERVICIO
	 *****************************************************************/
	
	
	public CaracteristicaServicio adicionarCaracteristicaServicio(long idServicio, String nombreCaracteristica, String descripcion)
	{
		log.info ("Adicionando caracteristicaServicio :  " +  idServicio +"---"+ nombreCaracteristica +"---"+ descripcion);
		CaracteristicaServicio caract = pp.adicionarCaracteristicaServicio( idServicio,  nombreCaracteristica,  descripcion);
		log.info ("Adicionando caracteristicaServicio :  " + caract);
		return caract;
	}
	/**
	 * Método que elimina una CaracteristicaServicio, dado el nombre del CaracteristicaServicio
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarCaracteristicaServicioPorId(long id) 
	{
		log.info ("Eliminando caracteristicaServicio :  " + id);
		long ll = pp.eliminarCaracteristicaServicioPorId(id);
		log.info ("Eliminando caracteristicaServicio :  " + ll + "tuplas eliminadas");
		return ll;
	}
	/**
	 * Método que consulta todas las tuplas en la tabla CaracteristicaServicio que tienen el nombre dado
	 * @return La lista de objetos CaracteristicaServicio, construidos con base en las tuplas de la tabla CaracteristicaServicio
	 */
	public CaracteristicaServicio darCaracServPorId (long idCaracteristicaServicio) 
	{
		log.info ("Dando caracteristicasServicios :  " + idCaracteristicaServicio);
		CaracteristicaServicio liBod = pp.darCaracServicioPorId(idCaracteristicaServicio);
		return liBod;
	}
	/**
	 * Método que consulta todas las tuplas en la tabla CaracteristicaServicio
	 * @return La lista de objetos CaracteristicaServicio, construidos con base en las tuplas de la tabla CaracteristicaServicio
	 */
	public List<CaracteristicaServicio> darCaracServ ()
	{
		log.info ("Dando caracteristicasServicios");
		List<CaracteristicaServicio> liBod = pp.darCaracServ();
		log.info ("Dando caracteristicasServicios" + liBod.size() +  " número de caracteristicasServicios");
		return liBod;
	}

	/**
	 * Encuentra todos los CaracteristicasServicios en HotelAndes y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos CaracteristicaServicio con todos las caracteristicasServicios que conoce la aplicación, llenos con su información básica
	 */
	public List<VOCaracteristicaServicio> darVOCaracteristicaServicio ()
	{
		log.info ("Generando los VO de CaracteristicaServicio");
		List<VOCaracteristicaServicio> vocaracteristicasServicios = new LinkedList<VOCaracteristicaServicio> ();
		for (CaracteristicaServicio CaracteristicaServicio: pp.darCaracServ())
		{
			vocaracteristicasServicios.add (CaracteristicaServicio);
		}
		log.info ("Generando los VO de caracteristicasServicios: " + vocaracteristicasServicios.size () + " caracteristicasServicios existentes");
		return vocaracteristicasServicios;
	}

	/* ****************************************************************
	 * 			Métodos para manejar las CUENTAS
	 *****************************************************************/

	public Cuenta adicionarCuenta(double valor, String metodoDePago, long idPlanConsumo, long idCliente, long idReserva)
	{
		log.info ("Adicionando cuenta :  " +  valor + "---" +   metodoDePago + "---" +   idPlanConsumo + "---" +  idCliente + "---" +   idReserva );
		Cuenta bod = pp.adicionarCuenta( valor,  metodoDePago,  idPlanConsumo,  idCliente,  idReserva);
		log.info ("Adicionando cuenta :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Cuenta, dado el nombre del Cuenta
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarCuentaPorId(long id) 
	{
		log.info ("Eliminando cuenta :  " + id);
		long ll = pp.eliminarCuentaPorId(id);
		log.info ("Eliminando cuenta :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Cuenta
	 * @return La lista de objetos Cuenta, construidos con base en las tuplas de la tabla Cuenta
	 */
	public List<Cuenta> darCuentas ()
	{
		log.info ("Dando cuentas");
		List<Cuenta> liBod = pp.darCuentas();
		log.info ("Dando cuentas" + liBod.size() +  " número de cuentas");
		return liBod;
	}
	
	public Cuenta darCuentaPorId (long idCuenta) 
	{
		log.info ("Dando cuenta por id :  " + idCuenta);
		Cuenta liBod = pp.darCuentaPorId(idCuenta);
		return liBod;
	}

	/**
	 * Encuentra todos los Cuentas en HotelAndes y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Cuenta con todos las cuentas que conoce la aplicación, llenos con su información básica
	 */
	public List<VOCuenta> darVOCuenta ()
	{
		log.info ("Generando los VO de Cuenta");
		List<VOCuenta> vocuentas = new LinkedList<VOCuenta> ();
		for (Cuenta Cuenta: pp.darCuentas())
		{
			vocuentas.add (Cuenta);
		}
		log.info ("Generando los VO de cuentas: " + vocuentas.size () + " cuentas existentes");
		return vocuentas;
	}


	

	public long [] limpiarHotelAndes ()
	{
		log.info ("Limpiando la BD de HotelAndes");
		long [] borrrados = pp.limpiarHotelAndes();
		log.info ("Limpiando la BD de HotelAndes: Listo!");
		return borrrados;

	}

	/* ****************************************************************
	 * 			Métodos para manejar las DOTACION
	 *****************************************************************/

	public Dotacion adicionarDotacion(String nombreObjeto, char esCobrable, double valorObjeto)
	{
		log.info ("Adicionando dotacion :  " + nombreObjeto +"---" + esCobrable +"---" +valorObjeto);
		Dotacion bod = pp.adicionarDotacion( nombreObjeto,  esCobrable,  valorObjeto);
		log.info ("Adicionando dotacion :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Dotacion, dado el nombre del Dotacion
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarDotacionPorId(long id) 
	{
		log.info ("Eliminando dotacion :  " + id);
		long ll = pp.eliminarDotacionPorId(id);
		log.info ("Eliminando dotacion :  " + ll + "tuplas eliminadas");
		return ll;
	}
	/**
	 * Método que consulta todas las tuplas en la tabla Dotacion que tienen el nombre dado
	 * @return La lista de objetos Dotacion, construidos con base en las tuplas de la tabla Dotacion
	 */
	public List<Dotacion> darDotacions ( ) 
	{
		log.info ("Dando dotaciones ");
		List<Dotacion> liBod = pp.darDotacions();
		log.info ("Dando dotaciones:  " + liBod.size() +  " número de dotaciones");
		return liBod;
	}
	
	public Dotacion darDotacionPorId(long id) 
	{
		log.info ("Dar dotacion :  " + id);
		Dotacion ll = pp.darDotacionPorId(id);
		log.info ("Dar dotacion :  " + ll + "tuplas eliminadas");
		return ll;
	}

	/* ****************************************************************
	 * 			Métodos para manejar las HABITACIONES
	 *****************************************************************/

	public Habitacion adicionarHabitacion(String tipoHabitacion, double costoNoche, int capacidad, long idHotel)
	{
		log.info ("Adicionando habitacion :  " + tipoHabitacion + "," + costoNoche + "," + capacidad);
		Habitacion bod = pp.adicionarHabitacion( tipoHabitacion,  costoNoche,  capacidad,  idHotel);
		log.info ("Adicionando habitacion :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Habitacion, dado el nombre del Habitacion
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarHabitacionPorId(long id) 
	{
		log.info ("Eliminando habitacion :  " + id);
		long ll = pp.eliminarHabitacionPorId(id);
		log.info ("Eliminando habitacion :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Habitacion
	 * @return La lista de objetos Habitacion, construidos con base en las tuplas de la tabla Habitacion
	 */
	public List<Habitacion> darHabitacions ()
	{
		log.info ("Dando habitaciones");
		List<Habitacion> liBod = pp.darHabitacions();
		log.info ("Dando habitaciones" + liBod.size() +  " número de habitaciones");
		return liBod;
	}
	
	public Habitacion darHabitacionPorId(long id) 
	{
		log.info ("Dar dotacion :  " + id);
		Habitacion ll = pp.darHabitacionPorId(id);
		log.info ("Dar dotacion :  " + ll + "tuplas eliminadas");
		return ll;
	}

	/* ****************************************************************
	 * 			Métodos para manejar las HORARIO
	 *****************************************************************/

	public Horario adicionarHorario(long horaInicio, long horaFinal, Timestamp fechaInicial, Timestamp fechaFinal)
	{
		log.info ("Adicionando horario :  " +  horaInicio + "---" + horaFinal + "---" + fechaInicial + "---" +  fechaFinal);
		Horario bod = pp.adicionarHorario( horaInicio,  horaFinal,  fechaInicial, fechaFinal);
		log.info ("Adicionando horario :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Horario, dado el nombre del Horario
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarHorarioPorId(long id) 
	{
		log.info ("Eliminando horario :  " + id);
		long ll = pp.eliminarHorarioPorId(id);
		log.info ("Eliminando horario :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	public List<Horario> darHorarios ()
	{
		log.info ("Dando horarios");
		List<Horario> liBod = pp.darHorarios();
		log.info ("Dando horarios" + liBod.size() +  " número de horarios");
		return liBod;
	}
	
	public Horario darHorarioPorId(long id) 
	{
		log.info ("Dar horario :  " + id);
		Horario ll = pp.darHorarioPorId(id);
		log.info ("Dar horario :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar las HOTELES
	 *****************************************************************/

	public Hotel adicionarHotel(String nombre, String ciudad, String pais, int estrellas, long cadenaHotelera)
	{
		log.info ("Adicionando hotel :  " + nombre);
		Hotel bod = pp.adicionarHotel( nombre,  ciudad,  pais,  estrellas,  cadenaHotelera);
		log.info ("Adicionando hotel :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Hotel, dado el nombre del Hotel
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarHotelPorId(long id) 
	{
		log.info ("Eliminando hotel :  " + id);
		long ll = pp.eliminarHotelPorId(id);
		log.info ("Eliminando hotel :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Hotel
	 * @return La lista de objetos Hotel, construidos con base en las tuplas de la tabla Hotel
	 */
	public List<Hotel> darHotels ()
	{
		log.info ("Dando hoteles");
		List<Hotel> liBod = pp.darHotels();
		log.info ("Dando hoteles" + liBod.size() +  " número de hoteles");
		return liBod;
	}
	
	public Hotel darHotelPorId(long id) 
	{
		log.info ("Dar hotel :  " + id);
		Hotel ll = pp.darHotelPorId(id);
		log.info ("Dar hotel :  " + ll + "tuplas eliminadas");
		return ll;
	}

	/* ****************************************************************
	 * 			Métodos para manejar las BODEGAS
	 *****************************************************************/

	public Plan adicionarPlan(String nombrePlan, String tipo, Timestamp fechaInicial, Timestamp fechaFinal)
	{
		log.info ("Adicionando plan :  " + nombrePlan);
		Plan bod = pp.adicionarPlan( nombrePlan,  tipo,  fechaInicial,  fechaFinal);
		log.info ("Adicionando plan :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Plan, dado el nombre del Plan
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarPlanPorId(long id) 
	{
		log.info ("Eliminando plan :  " + id);
		long ll = pp.eliminarPlanPorId(id);
		log.info ("Eliminando plan :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Plan
	 * @return La lista de objetos Plan, construidos con base en las tuplas de la tabla Plan
	 */
	public List<Plan> darPlans ()
	{
		log.info ("Dando plans");
		List<Plan> liBod = pp.darPlans();
		log.info ("Dando plans" + liBod.size() +  " número de plans");
		return liBod;
	}
	
	public Plan darPlanPorId(long id) 
	{
		log.info ("Dar plan :  " + id);
		Plan ll = pp.darPlanPorId(id);
		log.info ("Dar plan :  " + ll + "tuplas eliminadas");
		return ll;
	}

	/* ****************************************************************
	 * 			Métodos para manejar las PRODUTOS
	 *****************************************************************/

	public Producto adicionarProducto(String nombreProducto, double precio)
	{
		log.info ("Adicionando producto :  " + nombreProducto);
		Producto bod = pp.adicionarProducto( nombreProducto,  precio);
		log.info ("Adicionando producto :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Producto, dado el nombre del Producto
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarProductoPorId(long id) 
	{
		log.info ("Eliminando producto :  " + id);
		long ll = pp.eliminarProductoPorId(id);
		log.info ("Eliminando producto :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<Producto> darProductos ()
	{
		log.info ("Dando productos");
		List<Producto> liBod = pp.darProductos();
		log.info ("Dando productos" + liBod.size() +  " número de productos");
		return liBod;
	}
	
	public Producto darProductoPorId(long id) 
	{
		log.info ("Dar productos :  " + id);
		Producto ll = pp.darProductoPorId(id);
		log.info ("Dar productos :  " + ll + "tuplas eliminadas");
		return ll;
	}
	

	/* ****************************************************************
	 * 			Métodos para manejar las REGISTRO
	 *****************************************************************/
	public Registro adicionarRegistro( 	long idReserva, char estadoCheckIn, char estadoCheckOut, long idRegistrador)
	{
		log.info ("Adicionando registro :  " + idReserva + "---" + estadoCheckIn + "---" + estadoCheckOut  + "---" + idRegistrador);
		Registro bod = pp.adicionarRegistro( idReserva,  estadoCheckIn,  estadoCheckOut,  idRegistrador);
		log.info ("Adicionando registro :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Registro, dado el nombre del Registro
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarRegistroPorId(long id) 
	{
		log.info ("Eliminando registro :  " + id);
		long ll = pp.eliminarRegistroPorId(id);
		log.info ("Eliminando registro :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<Registro> darRegistros ()
	{
		log.info ("Dando registros");
		List<Registro> liBod = pp.darRegistros();
		log.info ("Dando registros" + liBod.size() +  " número de registros");
		return liBod;
	}
	
	public Registro darRegistroPorId(long id) 
	{
		log.info ("Dar registros :  " + id);
		Registro ll = pp.darRegistroPorId(id);
		log.info ("Dar registros :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar las RESERVA
	 *****************************************************************/

	public Reserva adicionarReserva(long abono,long idHabitacion, long idHorario,long idCliente,long idHotel, long idCuenta)
	{
		log.info ("Adicionando reserva :  "  +abono +"---"+ idHabitacion +"---"+ idHorario +"---"+ idCliente);
		Reserva bod = pp.adicionarReserva(  abono, idHabitacion,  idHorario, idCliente, idHotel,  idCuenta);
		log.info ("Adicionando reserva :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarReservaPorId(long id) 
	{
		log.info ("Eliminando reserva :  " + id);
		long ll = pp.eliminarReservaPorId(id);
		log.info ("Eliminando reserva :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<Reserva> darReservas ()
	{
		log.info ("Dando reservas");
		List<Reserva> liBod = pp.darReservas();
		log.info ("Dando reservas" + liBod.size() +  " número de reservas");
		return liBod;
	}
	
	public Reserva darReservaPorId(long id) 
	{
		log.info ("Dar reservas :  " + id);
		Reserva ll = pp.darReservaPorId(id);
		log.info ("Dar reservas :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar las SALON
	 *****************************************************************/

	public Salon adicionarSalon(String nombre, long idHotel, String nombreSalon, int capacidad, double costoPorHora) 
	{
		log.info ("Adicionando salon :  "  +nombre);
		Salon bod = pp.adicionarSalon( nombre,  idHotel,  nombreSalon,  capacidad,  costoPorHora) ;
		log.info ("Adicionando salon :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarSalonPorId(long id) 
	{
		log.info ("Eliminando salon :  " + id);
		long ll = pp.eliminarSalonPorId(id);
		log.info ("Eliminando salon :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<Salon> darSalons ()
	{
		log.info ("Dando salones");
		List<Salon> liBod = pp.darSalons();
		log.info ("Dando salones" + liBod.size() +  " número de salones");
		return liBod;
	}
	
	public Salon darSalonPorId(long id) 
	{
		log.info ("Dar salones :  " + id);
		Salon ll = pp.darSalonPorId(id);
		log.info ("Dar salones :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	//-------

		public ServicioAlimentacion adicionarServicioAlimentacion(String nombreServicio, long idHotel,String nombre, String estilo, long capacidad, String tipo, char esConsumo, long idHorario, String descripcion) 
	{
		log.info ("Adicionando ServicioAlimentacion :  "  +nombre);
		ServicioAlimentacion bod = pp.adicionarServicioAlimentacion( nombreServicio,  idHotel, nombre,  estilo,  capacidad,  tipo,  esConsumo,  idHorario,  descripcion) ;
		log.info ("Adicionando ServicioAlimentacion :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarServicioAlimentacionPorId(long id) 
	{
		log.info ("Eliminando ServiciosAlimentacion :  " + id);
		long ll = pp.eliminarServicioAlimentacionPorId(id);
		log.info ("Eliminando ServiciosAlimentacion :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<ServicioAlimentacion> darServicioAlimentacions ()
	{
		log.info ("Dando ServiciosAlimentacion");
		List<ServicioAlimentacion> liBod = pp.darServicioAlimentacions();
		log.info ("Dando ServiciosAlimentacion" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public ServicioAlimentacion darServicioAlimentacionPorId(long id) 
	{
		log.info ("Dar ServiciosAlimentacion :  " + id);
		ServicioAlimentacion ll = pp.darServicioAlimentacionPorId(id);
		log.info ("Dar ServiciosAlimentacion :  " + ll + "tuplas eliminadas");
		return ll;
	}

	//-------

		public ServicioAlojamiento adicionarServicioAlojamiento(int cantidadPersonas, long idCuenta)
	{
		log.info ("Adicionando ServicioHotelComplementario :  "  +cantidadPersonas +"---"+  idCuenta);
		ServicioAlojamiento bod = pp.adicionarServicioAlojamiento( cantidadPersonas,  idCuenta);
		log.info ("Adicionando ServicioHotelComplementario :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarServicioAlojamientoPorId(long id) 
	{
		log.info ("Eliminando ServicioHotelComplementario :  " + id);
		long ll = pp.eliminarServicioAlojamientoPorId(id);
		log.info ("Eliminando ServicioHotelComplementario :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<ServicioAlojamiento> darServicioAlojamientos ()
	{
		log.info ("Dando ServicioHotelComplementario");
		List<ServicioAlojamiento> liBod = pp.darServicioAlojamientos();
		log.info ("Dando ServicioHotelComplementario" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public ServicioAlojamiento darServicioAlojamientoPorId(long id) 
	{
		log.info ("Dar ServicioHotelComplementario :  " + id);
		ServicioAlojamiento ll = pp.darServicioAlojamientoPorId(id);
		log.info ("Dar ServicioHotelComplementario :  " + ll + "tuplas eliminadas");
		return ll;
	}

	//-------

		public ServicioHotelComplementario adicionarServicioHotelComplementario(String nombreServicio, long idHotel) 
	{
		log.info ("Adicionando salon :  "  + nombreServicio   );
		ServicioHotelComplementario bod = pp.adicionarServicioHotelComplementario( nombreServicio,  idHotel)  ;
		log.info ("Adicionando salon :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarServicioHotelComplementarioPorId(long id) 
	{
		log.info ("Eliminando ServicioHotelComplementario :  " + id);
		long ll = pp.eliminarServicioHotelComplementarioPorId(id);
		log.info ("Eliminando ServicioHotelComplementario :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<ServicioHotelComplementario> darServicioHotelComplementarios ()
	{
		log.info ("Dando ServicioHotelComplementario");
		List<ServicioHotelComplementario> liBod = pp.darServicioHotelComplementarios();
		log.info ("Dando ServicioHotelComplementario" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public ServicioHotelComplementario darServicioHotelComplementarioPorId(long id) 
	{
		log.info ("Dar ServicioHotelComplementario :  " + id);
		ServicioHotelComplementario ll = pp.darServicioHotelComplementarioPorId(id);
		log.info ("Dar ServicioHotelComplementario :  " + ll + "tuplas eliminadas");
		return ll;
	}

	//-------

		public Usuario adicionarUsuario(String tipoDocumento, long numeroDocumento, String correoElectronico, String rol)  
	{
		log.info ("Adicionando Usuario :  "  +numeroDocumento+"--"+tipoDocumento );
		Usuario bod = pp.adicionarUsuario( tipoDocumento,  numeroDocumento,  correoElectronico,  rol)  ;
		log.info ("Adicionando Usuario :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarUsuarioPorId(long id) 
	{
		log.info ("Eliminando Usuario :  " + id);
		long ll = pp.eliminarUsuarioPorId(id);
		log.info ("Eliminando Usuario :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<Usuario> darUsuarios ()
	{
		log.info ("Dando Usuario");
		List<Usuario> liBod = pp.darUsuarios();
		log.info ("Dando Usuario" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public Usuario darUsuarioPorId(long id) 
	{
		log.info ("Dar Usuario :  " + id);
		Usuario ll = pp.darUsuarioPorId(id);
		log.info ("Dar Usuario :  " + ll + "tuplas eliminadas");
		return ll;
	}

		//-------

		public ServicioIncluido adicionarServicioIncluido(String nombreServicio, long idHotel, String nombre, long capacidad) 
	{
		log.info ("Adicionando ServicioIncluido :  "  +nombreServicio +"---"+ idHotel +"---"+ nombre +"---"+ capacidad) ;
		ServicioIncluido bod = pp.adicionarServicioIncluido( nombreServicio,  idHotel,  nombre,  capacidad)   ;
		log.info ("Adicionando ServicioIncluido :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarServicioIncluidoPorId(long id) 
	{
		log.info ("Eliminando ServicioIncluido :  " + id);
		long ll = pp.eliminarServicioIncluidoPorId(id);
		log.info ("Eliminando ServicioIncluido :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<ServicioIncluido> darServicioIncluidos ()
	{
		log.info ("Dando ServicioIncluido");
		List<ServicioIncluido> liBod = pp.darServicioIncluidos();
		log.info ("Dando ServicioIncluido" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public ServicioIncluido darServicioIncluidoPorId(long id) 
	{
		log.info ("Dar ServicioIncluido :  " + id);
		ServicioIncluido ll = pp.darServicioIncluidoPorId(id);
		log.info ("Dar ServicioIncluido :  " + ll + "tuplas eliminadas");
		return ll;
	}

			//-------

		public ServicioLavanderia adicionarServicioLavanderia(String nombreServicio, long idHotel, String nombre, String nombreServicioS, String descripcion, String tipo, long costoUnitario, long cantUnidades) 
	{
		log.info ("Adicionando ServicioLavanderia :  "  +  nombreServicio) ;
		ServicioLavanderia bod = pp.adicionarServicioLavanderia( nombreServicio,  idHotel , nombre, nombreServicioS,  descripcion,  tipo,  costoUnitario,  cantUnidades)   ;
		log.info ("Adicionando ServicioLavanderia :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarServicioLavanderiaPorId(long id) 
	{
		log.info ("Eliminando ServicioLavanderia :  " + id);
		long ll = pp.eliminarServicioLavanderiaPorId(id);
		log.info ("Eliminando ServicioLavanderia :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<ServicioLavanderia> darServicioLavanderias ()
	{
		log.info ("Dando ServicioLavanderia");
		List<ServicioLavanderia> liBod = pp.darServicioLavanderias();
		log.info ("Dando ServicioLavanderia" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public ServicioLavanderia darServicioLavanderiaPorId(long id) 
	{
		log.info ("Dar ServicioLavanderia :  " + id);
		ServicioLavanderia ll = pp.darServicioLavanderiaPorId(id);
		log.info ("Dar ServicioLavanderia :  " + ll + "tuplas eliminadas");
		return ll;
	}

	//-------

		public TipoHabitacion adicionarTipoHabitacion(String nombre, String descripcion) 
	{
		log.info ("Adicionando TipoHabitacion :  "  + nombre );
		TipoHabitacion bod = pp.adicionarTipoHabitacion( nombre,  descripcion) ;
		log.info ("Adicionando TipoHabitacion :  " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarTipoHabitacionPorId(String id) 
	{
		log.info ("Eliminando TipoHabitacion :  " + id);
		long ll = pp.eliminarTipoHabitacionPorId(id);
		log.info ("Eliminando TipoHabitacion :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<TipoHabitacion> darTipoHabitacions ()
	{
		log.info ("Dando TipoHabitacion");
		List<TipoHabitacion> liBod = pp.darTipoHabitacions();
		log.info ("Dando TipoHabitacion" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public TipoHabitacion darTipoHabitacionPorId(String id) 
	{
		log.info ("Dar TipoHabitacion :  " + id);
		TipoHabitacion ll = pp.darTipoHabitacionPorId(id);
		log.info ("Dar TipoHabitacion :  " + ll + "tuplas eliminadas");
		return ll;
	}

	/////////////////
	//Asociaciones//
	///////////////

	//-------

		public CuentaAlojamiento adicionarCuentaAlojamiento(long idCuenta, long idAlojamiento) 
	{
		log.info ("Adicionando CuentaAlojamiento   " );
		CuentaAlojamiento bod = pp.adicionarCuentaAlojamiento( idCuenta,  idAlojamiento)  ;
		log.info ("Adicionando CuentaAlojamiento   " + bod);
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarCuentaAlojamiento(long idCuenta, long idAlojamiento) 
	{
		log.info ("Eliminando CuentaAlojamiento :  " );
		long ll = pp.eliminarCuentaAlojamiento( idCuenta,  idAlojamiento) ;
		log.info ("Eliminando CuentaAlojamiento :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<CuentaAlojamiento> darCuentaAlojamiento ()
	{
		log.info ("Dando CuentaAlojamiento");
		List<CuentaAlojamiento> liBod = pp.darCuentaAlojamiento();
		log.info ("Dando CuentaAlojamiento" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public CuentaAlojamiento darCuentaAlojId(long idCuentaAlojamiento, long idCuenta)
	{
		log.info ("Dar CuentaAlojamiento :  " );
		CuentaAlojamiento ll = pp.darCuentaAlojId( idCuentaAlojamiento,  idCuenta) ;
		log.info ("Dar CuentaAlojamiento :  " + ll + "tuplas eliminadas");
		return ll;
	}

	//-------

		public CuentaServicio adicionarCuentaServicio(long idCuenta, long idServicio) 
	{
		log.info ("Adicionando CuentaServicio   "  );
		CuentaServicio bod = pp.adicionarCuentaServicio( idCuenta,  idServicio)  ;
		log.info ("Adicionando CuentaServicio   " );
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarCuentaServicio(long idCuenta, long idServicio)  
	{
		log.info ("Eliminando CuentaServicio :  " );
		long ll = pp.eliminarCuentaServicio( idCuenta,  idServicio) ;
		log.info ("Eliminando CuentaServicio :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<CuentaServicio> darCuentaServicio ()
	{
		log.info ("Dando CuentaServicio");
		List<CuentaServicio> liBod = pp.darCuentaServicio();
		log.info ("Dando CuentaServicio" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public CuentaServicio darCuentaServicioId(long idCuenta, long idServicio)
	{
		log.info ("Dar CuentaServicio :  " );
		CuentaServicio ll = pp.darCuentaServicioId( idCuenta,  idServicio);
		log.info ("Dar CuentaServicio :  " + ll + "tuplas eliminadas");
		return ll;
	}

	//-------

		public DotacionHabitacion adicionarDotacionHabitacion(long idDotacion, long idHabitacion) 
	{
		log.info ("Adicionando DotacionHabitacion   "  );
		DotacionHabitacion bod = pp.adicionarDotacionHabitacion( idDotacion,  idHabitacion)  ;
		log.info ("Adicionando DotacionHabitacion   " );
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarDotacionHabitacion(long idDotacion, long idHabitacion) 
	{
		log.info ("Eliminando DotacionHabitacion :  ");
		long ll = pp.eliminarDotacionHabitacion( idDotacion,  idHabitacion);
		log.info ("Eliminando DotacionHabitacion :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<DotacionHabitacion> darDotacionHabitacion ()
	{
		log.info ("Dando DotacionHabitacion");
		List<DotacionHabitacion> liBod = pp.darDotacionHabitacion();
		log.info ("Dando DotacionHabitacion" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public DotacionHabitacion darDotacionHabitacionId(long idHabitacion, long idDotacion)
	{
		log.info ("Dar PlanCaracteristicaAdicional :  ");
		DotacionHabitacion ll = pp.darDotacionHabitacionId( idHabitacion,  idDotacion);
		log.info ("Dar PlanCaracteristicaAdicional :  " + ll + "tuplas eliminadas");
		return ll;
	}
	//-------

		public PlanCaracteristicaAdicional adicionarPlanCaracteristicaAdicional(long idPlan, long idCaracteristicaAdicional) 
	{
		log.info ("Adicionando PlanCaracteristicaAdicional   "  );
		PlanCaracteristicaAdicional bod = pp.adicionarPlanCaracteristicaAdicional( idPlan,  idCaracteristicaAdicional)  ;
		log.info ("Adicionando PlanCaracteristicaAdicional   " );
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarPlanCaracteristicaAdicional(long idPlan, long idCaracteristicaAdicional) 
	{
		log.info ("Eliminando PlanCaracteristicaAdicional :  " );
		long ll = pp.eliminarPlanCaracteristicaAdicional( idPlan,  idCaracteristicaAdicional) ;
		log.info ("Eliminando PlanCaracteristicaAdicional :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<PlanCaracteristicaAdicional> darPlanCaracteristicaAdicional ()
	{
		log.info ("Dando PlanCaracteristicaAdicional");
		List<PlanCaracteristicaAdicional> liBod = pp.darPlanCaracteristicaAdicional();
		log.info ("Dando PlanCaracteristicaAdicional" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public PlanCaracteristicaAdicional darPlanCaracteristicaAdicionalId(long idCaracteristicaAdicional, long idPlan)
	{
		log.info ("Dar PlanCaracteristicaAdicional :  " );
		PlanCaracteristicaAdicional ll = pp.darPlanCaracteristicaAdicionalId(idCaracteristicaAdicional,  idPlan);
		log.info ("Dar PlanCaracteristicaAdicional :  " + ll + "tuplas eliminadas");
		return ll;
	}

	//-------

		public ProductoServicio adicionarProductoServicio(long idProducto, long idServicio) 
	{
		log.info ("Adicionando ProductoServicio   "  );
		ProductoServicio bod = pp.adicionarProductoServicio( idProducto,  idServicio)  ;
		log.info ("Adicionando ProductoServicio   " );
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarProductoServicio(long idProducto, long idServicio) 
	{
		log.info ("Eliminando ProductoServicio :  " );
		long ll = pp.eliminarProductoServicio( idProducto,  idServicio );
		log.info ("Eliminando ProductoServicio :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<ProductoServicio> darProductoServicio ()
	{
		log.info ("Dando ProductoServicio");
		List<ProductoServicio> liBod = pp.darProductoServicio();
		log.info ("Dando ProductoServicio" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public ProductoServicio darProductoServicioId(long idServicio, long idProducto)
	{
		log.info ("Dar ProductoServicio :  " );
		ProductoServicio ll = pp.darProductoServicioId( idServicio,  idProducto);
		log.info ("Dar ProductoServicio :  " + ll + "tuplas eliminadas");
		return ll;
	}

	//-------

		public ServicioAlojamientoHabitacion adicionarServicioAlojamientoHabitacion(long idServicioAlojamiento, long idHabitacion) 
	{
		log.info ("Adicionando ServicioAlojamientoHabitacion   "  );
		ServicioAlojamientoHabitacion bod = pp.adicionarServicioAlojamientoHabitacion( idServicioAlojamiento,  idHabitacion) ;
		log.info ("Adicionando ServicioAlojamientoHabitacion   " );
		return bod;
	}
	/**
	 * Método que elimina una Reserva, dado el nombre del Reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarServicioAlojamientoHabitacion(long idServicioAlojamiento, long idHabitacion) 
	{
		log.info ("Eliminando ServicioAlojamientoHabitacion :  " );
		long ll = pp.eliminarServicioAlojamientoHabitacion( idServicioAlojamiento,  idHabitacion) ;
		log.info ("Eliminando ServicioAlojamientoHabitacion :  " + ll + "tuplas eliminadas");
		return ll;
	}

	public List<ServicioAlojamientoHabitacion> darServicioAlojamientoHabitacion ()
	{
		log.info ("Dando ServicioAlojamientoHabitacion");
		List<ServicioAlojamientoHabitacion> liBod = pp.darServicioAlojamientoHabitacion();
		log.info ("Dando ServicioAlojamientoHabitacion" + liBod.size() +  " número servs");
		return liBod;
	}
	
	public ServicioAlojamientoHabitacion  darServicioAlojamientoHabitacionId(long idHabitacion, long idServicioAlojamiento)
	{
		log.info ("Dar ServicioAlojamientoHabitacion :  " );
		ServicioAlojamientoHabitacion ll = pp. darServicioAlojamientoHabitacionId( idHabitacion,  idServicioAlojamiento);
		log.info ("Dar ServicioAlojamientoHabitacion :  " + ll + "tuplas eliminadas");
		return ll;
	}
	
	public Long UpdateCheckIn(long idRegistro){
		log.info ("Update :  " );
		long ll = pp.updateCheckIn(idRegistro);
		log.info ("Update");
		return ll;
	}
	
	public ServicioReservado adicionarServicioReserva(String nombreServicio, long idHotel, String nombreEspecifico, String tipo, int duracion, double costo, String nombreServicioS, String descripcion, long idHorario) 
	{
	ServicioReservado bod = pp.adicionarServicioReservado(nombreServicio, idHotel, nombreEspecifico, tipo, duracion, costo, nombreServicioS, descripcion, idHorario);
	return bod;
	}
	
	public ServicioReservado darServicioReservadoPorId(long id) 
	{
		log.info ("Dar ServicioIncluido :  " + id);
		ServicioReservado ll = pp.darServicioReservadoPorId(id);
		log.info ("Dar ServicioIncluido :  " + ll + "tuplas eliminadas");
		return ll;
	}
}
	