package uniandes.isis2304.hotelAndes.negocio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.hotelAndes.persistencia.PersistenciaHotelAndes;

public class HotelAndes {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	
	private static Logger log = Logger.getLogger(HotelAndes.class.getName());

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public HotelAndes ()
	{
		pp = PersistenciaHotelAndes.getInstance ();
	}

	public HotelAndes (JsonObject tableConfig)
	{
		pp = PersistenciaHotelAndes.getInstance (tableConfig);
	}

	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	
	/* ****************************************************************
	 *          Metodos para el manejo de las cuentas
	 *****************************************************************/
	
	public Cuenta adicionarCuenta(long idCuenta, long valor, String metodoDePago, long idPlan, long idCliente, long idReserva){
		System.out.println("Adicionando cuenta : de " + idCliente);
		Cuenta cuen = pp.adicionarCuenta(idCuenta, valor, metodoDePago, idPlan, idCliente, idReserva);
		System.out.println("Adicionado " + cuen);
		return cuen;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de las cuentas-servicio
	 *****************************************************************/
	
	public CuentaServicio adicionarCuentaServicio(long idCuenta, long idServicioComplementario){
		System.out.println("Adicionando cuenta : de " + idCuenta + " " + idServicioComplementario);
		CuentaServicio cuen = pp.adicionarCuentaServicio(idCuenta, idServicioComplementario);
		System.out.println("Adicionado " + cuen);
		return cuen;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los habitacion
	 *****************************************************************/
	
	public Habitacion adicionaHabitacion(long idHabitacion, String tipoHabitacion, long costoNoche, long capacidadHabitacion, long idHotel, long numeroHabitacion,String disponible){
		System.out.println("Adicionando plan :" + idHabitacion);
		Habitacion us = pp.adicionarHabitacion(idHabitacion, tipoHabitacion, costoNoche, capacidadHabitacion, idHotel, numeroHabitacion, disponible);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	public long revisarCapacidad(long idHabitacion){
		System.out.println("revisando la capacidad de: " + idHabitacion);
		return pp.revisarCapacidad(idHabitacion);
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los horarios
	 *****************************************************************/
	
	public Horario adicionarHorario(long idHorario, long horaInicio, long horaFinal, Timestamp fechaInicio, Timestamp fechaFinal){
		System.out.println("Adicionando horario : de " + horaInicio + " " + fechaInicio + ", hasta " + horaFinal + " " + fechaFinal);
		Horario hor = pp.adicionarHorario(idHorario, horaInicio, horaFinal, fechaInicio, fechaFinal);
		System.out.println("Adicionado " + hor);
		return hor;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los planes
	 *****************************************************************/
	
	public Plan adicionarPlan(long idPlan, String nombrePlan, String tipo){
		System.out.println("Adicionando plan :" + nombrePlan);
		Plan us = pp.adicionarPlan(idPlan, nombrePlan, tipo);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de las registros
	 *****************************************************************/
	
	public Registro adicionarRegistro(long idRegistro, long idReserva, long idRegistrador){
		System.out.println("Adicionando reserva : de cliente " + idRegistro);
		Registro res = pp.adicionarRegistro(idRegistro, idReserva, idRegistrador);
		System.out.println("Adicionado " + res);
		return res;
	}
	
	public void modificarRegistro(long idRegistro){
		System.out.println("Adicionando reserva : de cliente " + idRegistro);
		pp.modificarRegistro(idRegistro);
		System.out.println("Modificado ");

	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de las reservas
	 *****************************************************************/
	
	public Reserva adicionarReserva(long idReserva, long abono, long idHabitacion, long idHorario, long idCliente, long idHotel, long idCuenta){
		System.out.println("Adicionando reserva : de cliente " + idCliente);
		Reserva res = pp.adicionarReserva(idReserva, abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta);
		System.out.println("Adicionado " + res);
		return res;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los planes
	 *****************************************************************/
	
	public ServicioAlojamiento adicionarServicioAlojamiento(long idServicioAlojamiento, long cantidadPersonas, long idCuenta){
		System.out.println("Adicionando plan :" + idServicioAlojamiento);
		ServicioAlojamiento us = pp.adicionarServicioAlojamiento(idServicioAlojamiento, cantidadPersonas, idCuenta);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	/* ****************************************************************
	 *  Metodos para el manejo de los servicio alojamiento habitacion
	 *****************************************************************/
	
	public ServicioAlojamientoHabitacion crearRelacionServHab(long idHabitacion, long idServicioAlojamiento){
		System.out.println("Adicionando plan :" + idServicioAlojamiento);
		ServicioAlojamientoHabitacion us = pp.crearRelacionServHab(idHabitacion, idServicioAlojamiento);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	public boolean disponibilidadHabitacion(long idHabitacion){
		System.out.println("Revisando idHabitacion: " + idHabitacion);
		return pp.buscarPorHabitacion(idHabitacion);
	}
	
	/* ****************************************************************
	 *  Metodos para el manejo de los servicio alojamiento habitacion
	 *****************************************************************/
	
	public ServicioHotelComplementario crearServicioHotel(long idSComplementario, String nombreServicio, long idHotel){
		System.out.println("Adicionando servicio : " + idSComplementario);
		ServicioHotelComplementario us = pp.adicionarServicioHotel(idSComplementario, nombreServicio, idHotel);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	public ServicioIncluido crearServicioIncluido(long idServicio, String nombreServicio, long idHotel, String nombre, long capacidad){
		System.out.println("Adicionando servicio : " + idServicio);
		ServicioIncluido us = pp.adicionarServicioIncluido(idServicio, nombreServicio, idHotel, nombre, capacidad);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	public ServicioAlimentacion crearServicioAlimentacion(long idServicio, long idHotel, String nombreSevicio, String estilo, long capacidad, String tipo, char esConsumoHabitacion, long idHorario, String descripcion){
		System.out.println("Adicionando servicio : " + idServicio);
		ServicioAlimentacion us = pp.adicionarServicioAlimentacion(idServicio, idHotel, nombreSevicio, estilo, capacidad, tipo, esConsumoHabitacion, idHorario, descripcion);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	public Salon crearSalon(long idServicio, String nombreServicio, long idHotel, String nombre, long capacidad, long costoPorHora, String tipo){
		System.out.println("Adicionando servicio : " + idServicio);
		Salon us = pp.adicionarSalon(idServicio, nombreServicio, idHotel, nombre, capacidad, costoPorHora, tipo);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	public ServicioLavanderia crearServicioLavanderia(long idServicio, String nombreServicio, long idHotel, String descripcion, String tipo, long costoUnitario, long cantUnidades){
		System.out.println("Adicionando servicio : " + idServicio);
		ServicioLavanderia us = pp.adicionarServicioLavanderia(idServicio, nombreServicio, idHotel, descripcion, tipo, costoUnitario, cantUnidades);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los tipos de habitacion
	 *****************************************************************/
	
	public TipoHabitacion adicionarTipoHabitacion(String nombreTipo, String descripcion){
		System.out.println("Adicionando tipo : " + nombreTipo);
		TipoHabitacion tipo = pp.adicionarTipoHabitacion(nombreTipo, descripcion);
		System.out.println("Adicionado " + tipo);
		return tipo;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los usuarios
	 *****************************************************************/
	
	public Usuario adicionarUsuario(long idUsuario,String tipoDocumento, long numeroDocumento, String correoElectronico, String rol){
		System.out.println("Adicionando cliente : cedula " + numeroDocumento);
		Usuario us = pp.adicionarUsuario(idUsuario, tipoDocumento, numeroDocumento, correoElectronico, rol);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	public Usuario darUsuarioPorId(long id){
		System.out.println("Adicionando cliente : cedula " + id);
		Usuario us = pp.darUsuarioPorId(id);
		System.out.println("Adicionado " + us);
		return us;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de consultas
	 *****************************************************************/
	
	public List<Object[]> darTop20(){
		System.out.println("Pruebas");
		List<Object[]> aRet = pp.top20Servicios();
		return aRet;
	}
	
	public List<Object[]> darpIndiceHabitaciones(){
		System.out.println("Pruebas");
		List<Object[]> aRet = pp.indiceOcupacion();
		return aRet;
	}
	
	/* ****************************************************************
	 *          Metodos auxiliares
	 *****************************************************************/
	
	public long darNumeroDisponiblePorTipo(String tipo){
		System.out.println("Pruebas");
		long aRet = pp.darAgruparPorTipo(tipo);
		return aRet;
	}
public Convencion adicionarConvencion(long idConvencion, long idHotel, long numparticipantes,
		String nombreConvencion, long idHorario) {
		System.out.println("Adicionando convencion " + nombreConvencion);
		Convencion us = pp.adicionarConvencion(idConvencion, idHotel, numparticipantes, nombreConvencion, idHorario);
		System.out.println("Adicionado " + us);
		return us;
	}

	public ConvencionRestauranteCafeteria adicionarConvencionrestbarcafeteria(long idServicioComplementario,
			long idConvencion) {
		
			System.out.println("Adicionando ConvencionRestauranteCafeteria " + idServicioComplementario + idConvencion);
			ConvencionRestauranteCafeteria us = pp.adicionarConvencionrestbarcafeteria(idConvencion, idServicioComplementario);
			System.out.println("Adicionado " + us);
			return us;
	}
	
	public Habitacion darHabitacion(String nit)
	{
		log.info ("Dando Habitacion :  " + nit);
		Habitacion clienEmp = pp.darHabitacion(nit);
		log.info ("Dando Habitacion :  " + clienEmp);
		return clienEmp;
	}

	public ArrayList<Habitacion> darHabitacionPorTipo(String nit)
	{
		log.info ("Dando Habitacion :  " + nit);
		ArrayList<Habitacion> clienEmp = pp.darHabitacionTipo(nit);
		log.info ("Dando Habitacion :  " + clienEmp);
		return clienEmp;
	}

	public void req12(long idConvencion, long idHotel, long numparticipantes, String nombreConvencion,
			Timestamp finicio, Timestamp ffinal, long idHorario, long idCliente, long idCuenta,
			ArrayList<Long> idsServicios, ArrayList<String> infoHabitaciones) {
		log.info ("Dando Convencion: "+idConvencion);
		pp.req12(idConvencion,idHotel,numparticipantes,nombreConvencion,finicio,ffinal,idHorario,idCliente,idCuenta,idsServicios,infoHabitaciones);
		log.info ("Dando Convencion :  " + idConvencion);
	}

	public void req13(long idConvencion, int canthabitacion, int cantServicios) {
		log.info ("Borrando habitaciones o servicios de Convencion: "+idConvencion);
		pp.req13(idConvencion,canthabitacion,cantServicios);
		log.info ("Borrando habitaciones o servicios de Convencion: "+idConvencion);

	}
	
	public void req14(long idConvencion) {
		log.info ("Finalizando Convencion: "+idConvencion);
		pp.req14(idConvencion);
		log.info ("Finalizo: "+idConvencion);

	}

	public void req15(ArrayList<Long> idHabitaciones, ArrayList<Long> idServicios) {
			log.info ("Realizando mantenimiento ");
			pp.req15(idHabitaciones,idServicios);
			log.info ("Se realizo mantenimiento ");		
	}

	public void req16(long idConvencion) {
		log.info ("Finalizando mantenimiento: ");
		pp.req16(idConvencion);
		log.info ("Finalizo: ");
		
	}
}
