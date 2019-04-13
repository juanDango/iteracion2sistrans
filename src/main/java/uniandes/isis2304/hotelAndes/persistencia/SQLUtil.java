/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: HotelAndes Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLUtil
{
	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes pp;

	public SQLUtil (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqHotelAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarHotelAndes (PersistenceManager pm)
	{
        Query qCadenaHotelera = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCadenaHotelera());          
        Query qCaracteristicaAdicional = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCaracteristicaAdicional ());
        Query qCaracteristicaServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCaracteristicaServicio());
        Query qCuenta = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCuenta());
        Query qCuentaAlojamiento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCuentaAlojamiento ());
        Query qCuentaServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCuentaServicio ());
        Query qDotacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaDotacion ());
        Query qDotacionHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaDotacionHabitacion ());          
        Query qHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion ());
        Query qHorario = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHorario());
        Query qHotel = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel ());
        Query qPlan = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlan ());
        Query qPlanCaracteristicaAdicional = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanCaracteristicaAdicional ());
        Query qProducto = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProducto());
        Query qProductoServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductoServicio ());          
        Query qRegistro = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRegistro ());
        Query qReserva = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva ());
        Query qSalon = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSalon ());
        Query qServicioAlimentacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioAlimentacion());
        Query qServicioAlojamiento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSevicioAlojamiento ());
        Query qServicioAlojamientoHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioAlojamientoHabitacion ());
        Query qServicioHotelComplementario = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioHotelComplementario ());
        Query qServicioIncluido = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioIncluido() );
        Query qServicioLavanderia = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioLavanderia ());
        Query qServicioReservado = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioReservado ());
        Query qTipoHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoHabitacion());
        Query qUsuario = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario ());


        long cadenaHoteleraEliminados = (long) qCadenaHotelera.executeUnique ();
        long caracAdicionalEliminados = (long) qCaracteristicaAdicional.executeUnique ();
        long caracServicioEliminadas = (long) qCaracteristicaServicio.executeUnique ();
        long cuentaEliminadas = (long) qCuenta.executeUnique ();
        long cuentaAlojamientoEliminados = (long) qCuentaAlojamiento.executeUnique ();
        long ctaServicioEliminados = (long) qCuentaServicio.executeUnique ();
        long dotacionEliminados = (long) qDotacion .executeUnique ();
        long dotacionHabEliminados = (long) qDotacionHabitacion.executeUnique ();
        long habitacionEliminados = (long) qHabitacion.executeUnique ();
        long horarioEliminadas = (long) qHorario.executeUnique ();
        long hotelEliminadas = (long) qHotel.executeUnique ();
        long planEliminados = (long) qPlan.executeUnique ();
        long planCaracterAdEliminados = (long) qPlanCaracteristicaAdicional.executeUnique ();
        long productoEliminados = (long) qProducto.executeUnique ();
        long productoServEliminados = (long) qProductoServicio.executeUnique ();
        long registroEliminados = (long) qRegistro.executeUnique ();
        long reservasEliminadas = (long) qReserva.executeUnique ();
        long salonEliminadas = (long) qSalon.executeUnique ();
        long servicioAlimentacionEliminados = (long) qServicioAlimentacion.executeUnique ();
        long serAlojaEliminados = (long) qServicioAlojamiento.executeUnique ();
        long serAlojaHabEliminados = (long) qServicioAlojamientoHabitacion.executeUnique ();
        long serCompEliminados = (long) qServicioHotelComplementario.executeUnique ();
        long serInclEliminados = (long) qServicioIncluido.executeUnique ();
        long serLavanEliminadas = (long) qServicioLavanderia.executeUnique ();
        long serReserEliminadas = (long) qServicioReservado.executeUnique ();
        long tipoHabitacionEliminados = (long) qTipoHabitacion.executeUnique ();
        long usuarioEliminados = (long) qUsuario.executeUnique ();
        return new long[] {cadenaHoteleraEliminados, caracAdicionalEliminados, 
        		caracServicioEliminadas, cuentaEliminadas, cuentaAlojamientoEliminados, 
        		ctaServicioEliminados, dotacionEliminados, dotacionHabEliminados, habitacionEliminados,
        		horarioEliminadas, hotelEliminadas, planEliminados, planCaracterAdEliminados,
        		productoEliminados, productoServEliminados, registroEliminados, reservasEliminadas,
        		salonEliminadas, servicioAlimentacionEliminados, serAlojaEliminados, serAlojaHabEliminados,
        		serCompEliminados, serInclEliminados, serLavanEliminadas, serReserEliminadas,
        		tipoHabitacionEliminados, tipoHabitacionEliminados, usuarioEliminados};
	}

}
