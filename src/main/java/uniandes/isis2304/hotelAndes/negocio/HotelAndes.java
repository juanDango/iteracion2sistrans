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
	
	public Cuenta adicionarCuenta(long valor, String metodoDePago, long idPlan, long idCliente, long idReserva){
		System.out.println("Adicionando cuenta : de " + idCliente);
		Cuenta cuen = pp.adicionarCuenta(valor, metodoDePago, idPlan, idCliente, idReserva);
		System.out.println("Adicionado " + cuen);
		return cuen;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los horarios
	 *****************************************************************/
	
	public Horario adicionarHorario(long horaInicio, long horaFinal, Timestamp fechaInicio, Timestamp fechaFinal){
		System.out.println("Adicionando horario : de " + horaInicio + " " + fechaInicio + ", hasta " + horaFinal + " " + fechaFinal);
		Horario hor = pp.adicionarHorario(horaInicio, horaFinal, fechaInicio, fechaFinal);
		System.out.println("Adicionado " + hor);
		return hor;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de las reservas
	 *****************************************************************/
	
	public Reserva adicionarReserva(long abono, long idHabitacion, long idHorario, long idCliente, long idHotel, long idCuenta){
		System.out.println("Adicionando reserva : de cliente " + idCliente);
		Reserva res = pp.adicionarReserva(abono, idHabitacion, idHorario, idCliente, idHotel, idCuenta);
		System.out.println("Adicionado " + res);
		return res;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los tipos de habitacion
	 *****************************************************************/
	
	public TipoHabitacion adicionarTipoHabitacion(String nombreTipo, String descripcion){
		System.out.println("Adicionando tipo : " + nombreTipo);
		TipoHabitacion tipo = pp.adicionarTipoHabitacion(nombreTipo, descripcion)
		System.out.println("Adicionado " + tipo);
		return tipo;
	}
	
	/* ****************************************************************
	 *          Metodos para el manejo de los usuarios
	 *****************************************************************/
	
	public Usuario adicionarUsuario(String tipoDocumento, long numeroDocumento, String correoElectronico, String rol){
		System.out.println("Adicionando cliente : cedula " + numeroDocumento);
		Usuario us = pp.adicionarUsuario(tipoDocumento, numeroDocumento, correoElectronico, rol);
		System.out.println("Adicionado " + us);
		return us;
	}
}
