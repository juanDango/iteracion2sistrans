package uniandes.isis2304.hotelAndes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.hotelAndes.negocio.*;

/**
 * Clase principal de la interfaz
 * @author Juan Daniel Castrellon y Maria Camila Londoño
 */
@SuppressWarnings("serial")

public class InterfazHotelAndesApp extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazHotelAndesApp.class.getName());

	/**
	 * Ruta al archivo de configuración de la interfaz PARA LOS CLIENTES
	 */
	private static final String CONFIG_INTERFAZ_CLIENTES = "./src/main/resources/config/interfaceConfigAppCliente.json"; 

	/**
	 * Ruta al archivo de configuración de la interfaz PARA LOS RECEPCIONISTAS
	 */
	private static final String CONFIG_INTERFAZ_RECEPCIONISTA = "./src/main/resources/config/interfaceConfigAppRecepcionista.json"; 

	/**
	 * Ruta al archivo de configuración de la interfaz PARA LOS USUARIOS DE EMPLEADOS
	 */
	private static final String CONFIG_INTERFAZ_HOTELANDES = "./src/main/resources/config/interfaceConfigAppEmpleado.json"; 

	/**
	 * Ruta al archivo de configuración de la interfaz PARA LOS ADMINISTRADORES
	 */
	private static final String CONFIG_INTERFAZ_ADMIN = "./src/main/resources/config/interfaceConfigAppAdministrador.json";
	
	/**
	 * Ruta al archivo de configuración de la interfaz PARA LOS GERENTES
	 */
	private static final String CONFIG_INTERFAZ_GERENTES = "./src/main/resources/config/interfaceConfigAppAndes.json";
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD.json"; 


	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
	 */
	private JsonObject tableConfig;

	/**
	 * Asociación a la clase principal del negocio.
	 */
	private HotelAndes hotelAndes;

	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
	/**
	 * Objeto JSON con la configuración de interfaz de la app.
	 */
	private JsonObject guiConfig;

	/**
	 * Panel de despliegue de interacción para los requerimientos
	 */
	private PanelDatos panelDatos;

	/**
	 * Menú de la aplicación
	 */
	private JMenuBar menuBar;

	/**
	 * En caso de ser un cliente, se representa con su identificador
	 */
	private long identificacionCliente;

	/**
	 * Representa el tipo de persona que esta usando la app en su ejecucion {1 = natural, 2 = empresa, 3 = UsuarioPersonal, 4 = hotelAndes}
	 */
	private int estadoAplicacion;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Construye la ventana principal de la aplicación. <br>
	 * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
	 */
	public InterfazHotelAndesApp( )
	{
		tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
		hotelAndes = new HotelAndes (tableConfig);

		Object[] options = {"Cliente","Recepcionista","Empleado","Administrador", "Gerente"};
		int n = JOptionPane.showOptionDialog(this,"Como desea ingresar?","hotelAndes",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
		if(n == 0)
		{
			String cedula = JOptionPane.showInputDialog(this, "Digite su id", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
			if(cedula.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Por favor ingrese un id valido", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			int ced = Integer.parseInt(cedula);
			if(hotelAndes.darUsuarioPorId(ced) == null)
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, su id no se encuentra en nuestros registros", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else if(!hotelAndes.darUsuarioPorId(ced).getRol().equals("Cliente"))
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, usted no es un cliente", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else{
				estadoAplicacion = 1;
				identificacionCliente = ced;
				guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_CLIENTES);
			}
		}
		if(n == 1)
		{
			String id = JOptionPane.showInputDialog(this, "Digite su id", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
			if(id.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Por favor ingrese un id valido", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			int idInt = Integer.parseInt(id);
			if(hotelAndes.darUsuarioPorId(idInt) == null)
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, su ID no se encuentra en nuestros registros", "hotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else if(!hotelAndes.darUsuarioPorId(idInt).getRol().equals("Recepcionista"))
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, usted no es un recepcionista", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else
			{
				estadoAplicacion = 2;
				identificacionCliente = idInt;
				guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_RECEPCIONISTA);
			}
		}
		if(n == 2)
		{
			String id = JOptionPane.showInputDialog(this, "Digite su id", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
			if(id.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Por favor ingrese un id valido", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			int idInt = Integer.parseInt(id);
			if(hotelAndes.darUsuarioPorId(idInt) == null)
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, su ID no se encuentra en nuestros registros", "hotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else if(!hotelAndes.darUsuarioPorId(idInt).getRol().equals("Empleado"))
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, usted no es un empleado", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else
			{
				estadoAplicacion = 3;
				identificacionCliente = idInt;
				guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_HOTELANDES);
			}
		}
		if(n == 4)
		{
			String id = JOptionPane.showInputDialog(this, "Digite su id", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
			if(id.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Por favor ingrese un id valido", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			int idInt = Integer.parseInt(id);
			if(hotelAndes.darUsuarioPorId(idInt) == null)
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, su ID no se encuentra en nuestros registros", "hotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else if(!hotelAndes.darUsuarioPorId(idInt).getRol().equals("Administrador"))
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, usted no es un Administrador", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else
			{
				estadoAplicacion = 4;
				identificacionCliente = idInt;
				guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_GERENTES);
			}
			
		}

		// Configura la apariencia del frame que contiene la interfaz gráfica
		configurarFrame ( );
		if (guiConfig != null) 	   
		{
			crearMenu( guiConfig.getAsJsonArray("menuBar") );
		}

		String path = guiConfig.get("bannerPath").getAsString();
		panelDatos = new PanelDatos ( );

		setLayout (new BorderLayout());
		add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
		add( panelDatos, BorderLayout.CENTER );        
	}

	/* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
	/**
	 * Lee datos de configuración para la aplicació, a partir de un archivo JSON o con valores por defecto si hay errores.
	 * @param tipo - El tipo de configuración deseada
	 * @param archConfig - Archivo Json que contiene la configuración
	 * @return Un objeto JSON con la configuración del tipo especificado
	 * 			NULL si hay un error en el archivo.
	 */
	private JsonObject openConfig (String tipo, String archConfig)
	{
		JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
			//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
		return config;
	}

	/**
	 * Método para configurar el frame principal de la aplicación
	 */
	private void configurarFrame(  )
	{
		int alto = 0;
		int ancho = 0;
		String titulo = "";	

		if ( guiConfig == null )
		{
			log.info ( "Se aplica configuración por defecto" );			
			titulo = "Parranderos APP Default";
			alto = 300;
			ancho = 500;
		}
		else
		{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
			titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
		}

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocation (50,50);
		setResizable( true );
		setBackground( Color.WHITE );

		setTitle( titulo );
		setSize ( ancho, alto);        
	}

	/**
	 * Método para crear el menú de la aplicación con base em el objeto JSON leído
	 * Genera una barra de menú y los menús con sus respectivas opciones
	 * @param jsonMenu - Arreglo Json con los menùs deseados
	 */
	private void crearMenu(  JsonArray jsonMenu )
	{    	
		// Creación de la barra de menús
		menuBar = new JMenuBar();       
		for (JsonElement men : jsonMenu)
		{
			// Creación de cada uno de los menús
			JsonObject jom = men.getAsJsonObject(); 

			String menuTitle = jom.get("menuTitle").getAsString();        	
			JsonArray opciones = jom.getAsJsonArray("options");

			JMenu menu = new JMenu( menuTitle);

			for (JsonElement op : opciones)
			{       	
				// Creación de cada una de las opciones del menú
				JsonObject jo = op.getAsJsonObject(); 
				String lb =   jo.get("label").getAsString();
				String event = jo.get("event").getAsString();

				JMenuItem mItem = new JMenuItem( lb );
				mItem.addActionListener( this );
				mItem.setActionCommand(event);

				menu.add(mItem);
			}       
			menuBar.add( menu );
		}        
		setJMenuBar ( menuBar );	
	}

	//-----------
	//Cliente
	//-----------
	public void servicioAlojamiento()
	{
		try 
		{
			if(estadoAplicacion == 1)
			{
				String abono = JOptionPane.showInputDialog(this, "Ingrese cuanto desea abonar");
				String idHabitacion = JOptionPane.showInputDialog(this, "Ingrese que habitacion desea");
				//Creacion de horario
				String fechaInicio = JOptionPane.showInputDialog(this, "Ingrese la fecha a la que desea llegar", "dd/MM/yyyy");
				Timestamp inicio = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio).getTime());
				String fechaFin = JOptionPane.showInputDialog(this, "Ingrese la fecha desea dejar el hotel", "dd/MM/yyyy");
				Timestamp fin = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin).getTime());
				Horario a = hotelAndes.adicionarHorario(0, 0, inicio, fin);
				
				String idHotel = JOptionPane.showInputDialog(this, "id del hotel en que desea");
				String idPlanConsumo = JOptionPane.showInputDialog(this, "Ingrese el plan de consumo");
				
				//Creacion de la cuenta
				String idCliente = JOptionPane.showInputDialog(this, "Ingrese el id del cliente");
				String[] options = {"Efectivo","Tarjeta","Electronico"};
				int n = JOptionPane.showOptionDialog(this,"Como desea pagar?","hotelAndes",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
				if(hotelAndes.darUsuarioPorId(Long.parseLong(idCliente))!=null)
				{
					if(hotelAndes.darUsuarioPorId(Long.parseLong(idCliente)).equals("Cliente"))
					{
						Cuenta b = hotelAndes.adicionarCuenta(0, options[n], Long.parseLong(idPlanConsumo), Long.parseLong(idCliente), 0);
						Reserva res = hotelAndes.adicionarReserva(Long.parseLong(abono), Long.parseLong(idHabitacion), a.getIdHorario(), Long.parseLong(idCliente), Long.parseLong(idHotel), b.getIdCliente());
						String rta = "Se agrego la reserva: \n";
						rta += res.toString();
						panelDatos.actualizarInterfaz(rta);
					}
				}
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	
	public void servicioComplementario()
	{
		try 
		{
			if(estadoAplicacion == 1)
			{
				String idServicio = JOptionPane.showInputDialog(this, "El id del servicio que desea");
				ServicioReservado servicio = hotelAndes.darServicioReservadoPorId(Long.parseLong(idServicio));
				//Creacion de horario
				String fechaInicio = JOptionPane.showInputDialog(this, "Ingrese la fecha a la que desea tener su servicio", "dd/MM/yyyy");
				Timestamp inicio = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio).getTime());
				String horaInicio = JOptionPane.showInputDialog(this, "Ingrese la hora de inicio");
				Horario a = hotelAndes.adicionarHorario(Integer.parseInt(horaInicio), Integer.parseInt(horaInicio) + servicio.getDuracion(), inicio, inicio);
				
				//Creacion de la cuenta
				String idNumeroDeCuenta = JOptionPane.showInputDialog(this, "Ingrese el id numeroDeLaCuenta");
				ServicioReservado ser = hotelAndes.adicionarServicioReserva(servicio.getNombre(), servicio.getIdHotel(), servicio.getNombreEspecifico(), servicio.getNombreEspecifico(), servicio.getDuracion(), servicio.getCosto(), servicio.getNombreServicio(), servicio.getDescripcion(), a.getIdHorario());
				hotelAndes.adicionarCuentaServicio(Long.parseLong(idNumeroDeCuenta), ser.getId());
				String rta = "Se agrego la reserva: \n";
				rta += ser.toString();
				panelDatos.actualizarInterfaz(rta);
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

	
	//------------
	//Registrador
	//------------
	public void checkIn()
	{
		try 
		{
			if(estadoAplicacion == 2)
			{
				String idReserva = JOptionPane.showInputDialog(this, "Ingrese el numero de reserva");
				Registro res = hotelAndes.adicionarRegistro(Long.parseLong(idReserva), 'E', 'F', identificacionCliente);
				String rta = "Se agrego el registro: \n";
				rta += res.toString();
				panelDatos.actualizarInterfaz(rta);
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	
	public void checkOut()
	{
		try 
		{
			if(estadoAplicacion == 2)
			{
				String idRegistro = JOptionPane.showInputDialog(this, "Ingrese el numero del registro");
				long reg = hotelAndes.UpdateCheckIn(Long.parseLong(idRegistro));
				String rta = "Se cambio el estado del registro: \n";
				panelDatos.actualizarInterfaz(rta);
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

	//--------------
	//empleado
	//--------------

	public void registrarConsumo()
	{
		try{
			String idCuenta = JOptionPane.showInputDialog(this, "Ingrese el numero de cuenta");
			String idServicio = JOptionPane.showInputDialog(this, "Ingrese el id del servicio a registrar");
			hotelAndes.adicionarCuentaServicio(Long.parseLong(idCuenta), Long.parseLong(idServicio));
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Ocurrio un error en el proceso: " + e.getMessage(), "hotelAndes", JOptionPane.PLAIN_MESSAGE);
		}
	}

	///////////////
	//HotelAndes//
	/////////////
	
	public void registrarUsuario()
	{
		String tipoDocumento = JOptionPane.showInputDialog(this, "Ingrese el tipo de Documento");
		long numeroDocumento =  Long.parseLong(JOptionPane.showInputDialog(this, "Ingrese el numeroDocumento"));
		String correoElectronico = JOptionPane.showInputDialog(this, "Ingrese el correo electronico");
		String rol = JOptionPane.showInputDialog(this, "Ingrese el rol");

		Usuario usuario = hotelAndes.adicionarUsuario(tipoDocumento, numeroDocumento, correoElectronico, rol);
		if(usuario == null)
		{
			JOptionPane.showMessageDialog(this, "No fue posible agregar al usuario","hotelAndes", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String rta = "Se agrego el usuario: \n";
		rta += usuario.toString();
		panelDatos.actualizarInterfaz(rta);
	}

	
	public void registrarTipoDeHabitacion()
	{
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre");
		String descripcion = JOptionPane.showInputDialog(this, "Ingrese la descripcion");

		TipoHabitacion tipoHabitacion = hotelAndes.adicionarTipoHabitacion(nombre, descripcion);
		if(tipoHabitacion == null)
		{
			JOptionPane.showMessageDialog(this, "No fue posible agregar al tipo de Habitacion","hotelAndes", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String rta = "Se agrego el tipo de Habitacion: \n";
		rta += tipoHabitacion.toString();
		panelDatos.actualizarInterfaz(rta);
	}
	
	public void registrarHabitacion()
	{
		String tipoHabitacion = JOptionPane.showInputDialog(this, "Ingrese el nombre del tipo De Habitacion");
		Double costoNoche = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el costo por nochen"));
		int capacidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la capacidad"));
		int idHotel = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el idHotel"));

		Habitacion habitacion = hotelAndes.adicionarHabitacion(tipoHabitacion, costoNoche, capacidad, idHotel);
		if(habitacion == null)
		{
			JOptionPane.showMessageDialog(this, "No fue posible agregar la Habitacion","hotelAndes", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String rta = "Se agrego la Habitacion: \n";
		rta += habitacion.toString();
		panelDatos.actualizarInterfaz(rta);
	}
	
	public void registrarServicioLavanderia()
	{
		String tipo = JOptionPane.showInputDialog(this, "Ingrese el tipo");
		String descripcion = JOptionPane.showInputDialog(this, "Ingrese la descripcion");
		String nombreServicio = JOptionPane.showInputDialog(this, "Ingrese el nombre del servicio");
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre");
		int capacidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la capacidad"));
		int idHotel = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el idHotel"));
		long costoUnitario =  Long.parseLong(JOptionPane.showInputDialog(this, "Ingrese el costoUnitario"));
		int cantUnidades = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantUnidades"));
		ServicioLavanderia serv = hotelAndes.adicionarServicioLavanderia(nombreServicio, idHotel, "", "", descripcion, tipo, costoUnitario, cantUnidades);
		if(serv == null)
		{
			JOptionPane.showMessageDialog(this, "No fue posible agregar el servicio","hotelAndes", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String rta = "Se agrego el servicio: \n";
		rta += serv.toString();
		panelDatos.actualizarInterfaz(rta);
	}
	
	public void registrarServicioAlimentacion()
	{
		String nombreServicio = JOptionPane.showInputDialog(this, "Ingrese el nombre del servicio");
		String tipo = JOptionPane.showInputDialog(this, "Ingrese el tipo");
		String estilo = JOptionPane.showInputDialog(this, "Ingrese el estilo");
		String descripcion = JOptionPane.showInputDialog(this, "Ingrese la descripcion");
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre");
		char esConsumo = JOptionPane.showInputDialog(this, "Ingrese la letra S si es conumo a la habitacion, N de lo contrario").charAt(0);
		int capacidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la capacidad"));
		int idHotel = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el idHotel"));
		long costoUnitario =  Long.parseLong(JOptionPane.showInputDialog(this, "Ingrese el costoUnitario"));
		int cantUnidades = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantUnidades"));
		int h1 = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la hora a la que abre el servicio"));
		int h2 = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la hora a la que cierro el servicio"));

		Horario a = hotelAndes.adicionarHorario(h1, h2, null, null);
		ServicioAlimentacion serv = hotelAndes.adicionarServicioAlimentacion(nombreServicio, idHotel, nombreServicio, estilo, capacidad, tipo, esConsumo, a.getIdHorario(), descripcion);
		if(serv == null)
		{
			JOptionPane.showMessageDialog(this, "No fue posible agregar el servicio","hotelAndes", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String rta = "Se agrego el servicio: \n";
		rta += serv.toString();
		panelDatos.actualizarInterfaz(rta);
	}
	
	public void registrarServicioSalon()
	{
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del servicio");
		String nombreSalon = JOptionPane.showInputDialog(this, "Ingrese el nombre del salon");
		int capacidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la capacidad"));
		int idHotel = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el idHotel"));
		Double costoPorHora = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el costo por hora"));
		Salon serv = hotelAndes.adicionarSalon(nombre, idHotel, nombreSalon, capacidad, costoPorHora);
		if(serv == null)
		{
			JOptionPane.showMessageDialog(this, "No fue posible agregar el servicio","hotelAndes", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String rta = "Se agrego el servicio: \n";
		rta += serv.toString();
		panelDatos.actualizarInterfaz(rta);
	}
	
	
	
	public void registrarPlanConsumo()
	{
		try{
			String nombrePlan = JOptionPane.showInputDialog(this, "Ingrese el nombre del plan");
			String tipo = JOptionPane.showInputDialog(this, "Ingrese el tipo");
			String fechaInicio = JOptionPane.showInputDialog(this, "Ingrese la fecha a la que desea llegar", "dd/MM/yyyy");
			Timestamp inicio = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio).getTime());
			String fechaFin = JOptionPane.showInputDialog(this, "Ingrese la fecha desea dejar el hotel", "dd/MM/yyyy");
			Timestamp fin = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin).getTime());
			Plan serv = hotelAndes.adicionarPlan(nombrePlan, tipo, inicio, fin);
			if(serv == null)
			{
				JOptionPane.showMessageDialog(this, "No fue posible agregar el plan","hotelAndes", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			String rta = "Se agrego el plan: \n";
			rta += serv.toString();
			panelDatos.actualizarInterfaz(rta);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void registrarReservaAlojamiento()
	{
		try{
			long idCliente =  Long.parseLong(JOptionPane.showInputDialog(this, "Ingrese el idCliente"));
			int cantidadPersonas = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de Personas"));
			int idHabitacion = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el IdDeLaHabitacion"));
			int idHotel = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el idHotel"));
			long abono =  Long.parseLong(JOptionPane.showInputDialog(this, "Ingrese el monto a abonar"));

			String tipo = JOptionPane.showInputDialog(this, "Ingrese el tipo");
			String fechaInicio = JOptionPane.showInputDialog(this, "Ingrese la fecha a la que desea llegar", "dd/MM/yyyy");
			Timestamp inicio = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio).getTime());
			String fechaFin = JOptionPane.showInputDialog(this, "Ingrese la fecha desea dejar el hotel", "dd/MM/yyyy");
			Timestamp fin = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin).getTime());
			Horario a = hotelAndes.adicionarHorario(0, 0, inicio, fin);
			Reserva resv = hotelAndes.adicionarReserva(abono, idHabitacion, a.getIdHorario(), idCliente, idHotel,0);
			Cuenta cuenta = hotelAndes.adicionarCuenta(0, "Efectivo", 0 , idCliente, resv.getIdReserva());
			resv.setIdCuenta(cuenta.getIdCuenta());
			ServicioAlojamiento  serv = hotelAndes.adicionarServicioAlojamiento(cantidadPersonas, cuenta.getIdCuenta());
			ServicioAlojamientoHabitacion servhab = hotelAndes.adicionarServicioAlojamientoHabitacion(serv.getId(), idHabitacion);
			if(resv == null)
			{
				JOptionPane.showMessageDialog(this, "No fue posible agregar la reserva","hotelAndes", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			String rta = "Se agrego la reserva: \n";
			rta += serv.toString();
			panelDatos.actualizarInterfaz(rta);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void registrarReservaDeServicio()
	{
		
		int idCuenta = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el id de su cuenta de consumo"));
		int idServicio = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el id del servicio"));

		CuentaServicio serv = hotelAndes.adicionarCuentaServicio(idCuenta, idServicio);
		if(serv == null)
		{
			JOptionPane.showMessageDialog(this, "No fue posible agregar la reserva del servicio","hotelAndes", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String rta = "Se agrego la reserva del servicio: \n";
		rta += serv.toString();
		panelDatos.actualizarInterfaz(rta);
	}
	
	public void registrarConsumoServicio()
	{
		
		int idCuenta = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el id de su cuenta de consumo"));
		int idServicio = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el id del servicio que consume"));

		CuentaServicio serv = hotelAndes.adicionarCuentaServicio(idCuenta, idServicio);
		if(serv == null)
		{
			JOptionPane.showMessageDialog(this, "No fue posible agregar la reserva del servicio","hotelAndes", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		String rta = "Se agrego la reserva del servicio: \n";
		rta += serv.toString();
		panelDatos.actualizarInterfaz(rta);
	}
	
	
	public void registrarLlegadaCliente()
	{
		try 
		{
			if(estadoAplicacion == 2)
			{
				String idReserva = JOptionPane.showInputDialog(this, "Ingrese el numero de reserva");
				hotelAndes.adicionarRegistro(Long.parseLong(idReserva), 'E', 'F', identificacionCliente);
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	
	public void registrarSalidaCliente()
	{
		try 
		{
			if(estadoAplicacion == 2)
			{
				String idRegistro = JOptionPane.showInputDialog(this, "Ingrese el numero del registro");
				hotelAndes.UpdateCheckIn(Long.parseLong(idRegistro));
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	
	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de hotelandes
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD ()
	{
		try 
		{
			// Ejecución de la demo y recolección de los resultados
			long eliminados [] = hotelAndes.limpiarHotelAndes();

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado += "Se limpiaron " + eliminados.length + " tablas";
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}

	/**
	 * Muestra la información acerca del desarrollo de esta apicación
	 */
	public void acercaDe ()
	{
		String resultado = "Proyecto #1 Sistemas Transaccionales \n"
				+ "Juan Daniel Castrellon - 201729285"
				+ "Maria Camila Londoño - 201713178";

		panelDatos.actualizarInterfaz(resultado);		
	}
	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
	 * Invoca al método correspondiente según el evento recibido
	 * @param pEvento - El evento del usuario
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
		try 
		{
			Method req = InterfazHotelAndesApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}

	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
	/**
	 * Este método ejecuta la aplicación, creando una nueva interfaz
	 * @param args Arreglo de argumentos que se recibe por línea de comandos
	 */
	public static void main( String[] args )
	{
		try
		{
			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
			InterfazHotelAndesApp interfaz = new InterfazHotelAndesApp( );
			interfaz.setVisible( true );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}
}
