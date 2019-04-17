package uniandes.isis2304.hotelAndes.interfazDemo;

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
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import uniandes.isis2304.hotelAndes.negocio.VOConvencion;

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
	
	private static final String CONFIG_INTERFAZ_ORGANIZADOREVENTOS = "./src/main/resources/config/interfaceConfigAppOrganizadorEventos.json";

	
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

		Object[] options = {"Cliente","Recepcionista","Empleado","Administrador", "Gerente","OrganizadorEventos"};
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
		if(n == 3)
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
				guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_ADMIN);
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
			else if(!hotelAndes.darUsuarioPorId(idInt).getRol().equals("Gerente"))
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
		if(n == 5)
		{
			String id = JOptionPane.showInputDialog(this, "Digite su id Ej.4545", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
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
			else if(!hotelAndes.darUsuarioPorId(idInt).getRol().equals("OrganizadorEventos"))
			{
				JOptionPane.showMessageDialog(this, "Lo sentimos, usted no es un Administrador", "HotelAndes", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			else
			{
				estadoAplicacion = 4;
				identificacionCliente = idInt;
				guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_ORGANIZADOREVENTOS);
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
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "hotelAndes App", JOptionPane.ERROR_MESSAGE);
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
			titulo = "hotelAndes APP Default";
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

	
	//--------
	//Admin
	//--------
	
	
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

	
	/*
	public void req12(){
		try {
			long idConvencion = Long.parseLong(JOptionPane.showInputDialog(this, "Id de la convencion"));
			long idHotel = Long.parseLong(JOptionPane.showInputDialog(this, "Id del hotel. Ej: 123"));
			long numparticipantes  = Long.parseLong(JOptionPane.showInputDialog(this, "Numero de participantes"));
			String nombreConvencion = JOptionPane.showInputDialog(this, "Nombre Convencion");
	
			String fechaInicio = JOptionPane.showInputDialog(this, "Ingrese la fecha de inicio dd/MM/yy ", "dd/MM/yy");
			
			String fechaFinal = JOptionPane.showInputDialog(this, "Ingrese la fecha final dd/MM/yy ", "dd/MM/yy");
			
		
			Timestamp finicio = new Timestamp(new SimpleDateFormat("dd/MM/yy").parse(fechaInicio).getTime());

			Timestamp ffinal = new Timestamp(new SimpleDateFormat("dd/MM/yy").parse(fechaFinal).getTime());
			Random r = new Random();
			long idHorario = r.nextInt((1000 - 3) + 1) + 3;
		
			long idCliente = Long.parseLong(JOptionPane.showInputDialog(this, "id del organizador de eventos ej:4545"));
	
			long idCuenta = Long.parseLong(JOptionPane.showInputDialog(this, "id de la cuenta"));
			// servicios
			int cantServicios = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad de servicios"));
			ArrayList<Long> idsServicios = new ArrayList<>();

			for (int i = 0; i < cantServicios; i++) {
				long idServicioComplementario = Long.parseLong(JOptionPane.showInputDialog(this, "id del servicio"));
				idsServicios.add(idServicioComplementario);
			}
			// tipos de habitaciones
			int cantTipoHabitacion = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad de tipos de habitacion"));
			ArrayList<String> infoHabitaciones = new ArrayList<>();
			for (int i = 0; i < cantTipoHabitacion; i++) {
				String infoHabitacion = JOptionPane.showInputDialog(this, "Nombre habitacion separado por una coma de la cantidad de habitaciones .Ej: 4,Sencilla");
				infoHabitaciones.add(infoHabitacion);
			}
			
			
			hotelAndes.req12(idConvencion,idHotel,numparticipantes,nombreConvencion,finicio,ffinal,idHorario,idCliente,idCuenta,idsServicios,infoHabitaciones);
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelDatos.actualizarInterfaz("se ha insertado la convecion " );
	}
	
	/**
	 * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
	 * Invoca al método correspondiente según el evento recibido
	 * @param pEvento - El evento del usuario
	 */
	/*
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

	public void req13(){
		long idConvencion = Long.parseLong(JOptionPane.showInputDialog(this, "Id de la convencion"));
		int canthabitacion = Integer.parseInt(JOptionPane.showInputDialog(this, "De cantidad de habitaciones a borrar"));
		int cantServicios = Integer.parseInt(JOptionPane.showInputDialog(this, "De cantidad de servicios a borrar"));

		try {
			hotelAndes.req13(idConvencion,canthabitacion,cantServicios);

		}catch (Exception e) {
			e.printStackTrace( );
		}

	}
	
	public void req15(){
		int cantTipoHabitacion = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad de tipos de habitacion"));
		ArrayList<Long> idHabitaciones = new ArrayList<>();
		for (int i = 0; i < cantTipoHabitacion; i++) {
			long infoHabitacion = Long.parseLong(JOptionPane.showInputDialog(this, "idHabitacion"));
			idHabitaciones.add(infoHabitacion);
		}
		
		try {
			hotelAndes.req15(idHabitaciones);

		}catch (Exception e) {
			e.printStackTrace( );
		}
	}
	
	public void req14(){
		long idConvencion = Long.parseLong(JOptionPane.showInputDialog(this, "Id de la convencion"));
		
		try {
			hotelAndes.req14(idConvencion);

		}catch (Exception e) {
			e.printStackTrace( );
		}
	}
	
	public void req16(){
		long idConvencion = Long.parseLong(JOptionPane.showInputDialog(this, "Id de la convencion"));
		
		try {
			hotelAndes.req16(idConvencion);

		}catch (Exception e) {
			e.printStackTrace( );
		}
	}
	
	public void reqC1()
	{
		String[] options = {"mes","anio"};
		int tipo = JOptionPane.showOptionDialog(this,"En que unidades desea?","HotelAndes",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		String estado = JOptionPane.showInputDialog(this, "Por favor ingrese el tipo de habitacion", "HotelAndes", JOptionPane.INFORMATION_MESSAGE);
		List<Object[]>[] arr = null;
		if(tipo == 0)
		{
			String mes = JOptionPane.showInputDialog(this, "Ingrese el mes");
			String anio = JOptionPane.showInputDialog(this, "Ingrese el anio");
			arr = hotelAndes.analisisOperacionHotelAndes(estado, options[tipo], mes+"-"+anio);
		}
		if(tipo == 1)
		{
			String anio = JOptionPane.showInputDialog(this, "Ingrese el anio");
			arr = hotelAndes.analisisOperacionHotelAndes(estado, options[tipo], anio);
		}
		
		System.out.println(arr[0].size()+" --- " + arr[1].size()+" ---- " + arr[2].size());
		
		if(tipo == 1)
		{
			String texto = "Mayor demanda \n";
			for (int i = 0; i < arr[0].size(); i++) 
			{
				String a = "HABITACION " + (BigDecimal)arr[0].get(i)[0] + " ";
				String b = "DIA " + (BigDecimal)arr[0].get(i)[1] + " ";
				String c = "MES " + (BigDecimal)arr[0].get(i)[2] + " ";
				String d = "DEMANDA " + (BigDecimal)arr[0].get(i)[3] + " ";
				texto += (a + b + c + d + "\n");
			}
			
			texto += "Menor demanda \n";
			for (int i = 0; i < arr[1].size(); i++) 
			{
				String a = "HABITACION " + (BigDecimal)arr[1].get(i)[0] + " ";
				String b = "DIA " + (BigDecimal)arr[1].get(i)[1] + " ";
				String c = "MES " + (BigDecimal)arr[1].get(i)[2] + " ";
				String d = "DEMANDA " + (BigDecimal)arr[1].get(i)[3] + " ";
				texto += (a + b + c + d + "\n");
			}
			
			texto += "Mayores ingresos \n";
			for (int i = 0; i < arr[2].size(); i++) 
			{
				String a = "HABITACION " + (BigDecimal)arr[2].get(i)[0] + " ";
				String b = "DIA " + (BigDecimal)arr[2].get(i)[1] + " ";
				String c = "MES " + (BigDecimal)arr[2].get(i)[2] + " ";
				String d = "INGRESOS " + (BigDecimal)arr[2].get(i)[3] + " ";
				texto += (a + b + c + d + "\n");
			}
			panelDatos.actualizarInterfaz(texto);
		}
		
		else
		{
			String texto = "Mayor demanda \n";
			for (int i = 0; i < arr[0].size(); i++) 
			{
				String a = "HABITACION " + (BigDecimal)arr[0].get(i)[0] + " ";
				String b = "DIA " + (BigDecimal)arr[0].get(i)[1] + " ";
				String c = "DEMANDA " + (BigDecimal)arr[0].get(i)[2] + " ";
				texto += (a + b + c + "\n");
			}
			
			texto += "Menor demanda \n";
			for (int i = 0; i < arr[1].size(); i++) 
			{
				String a = "HABITACION " + (BigDecimal)arr[1].get(i)[0];
				String b = "DIA " + (BigDecimal)arr[1].get(i)[1];
				String c = "DEMANDA " + (BigDecimal)arr[1].get(i)[2];
				texto += (a + b + c + "\n");
			}
			
			for (int i = 0; i < arr[2].size(); i++) 
			{
				String a = "HABITACION " + (BigDecimal)arr[2].get(i)[0] + " ";
				String b = "DIA " + (BigDecimal)arr[2].get(i)[1] + " ";
				String c = "INGRESO " + (BigDecimal)arr[2].get(i)[2] + " ";
				texto += (a + b + c + "\n");
			}
			panelDatos.actualizarInterfaz(texto);
		}
	}
	
	//Req 7
	public void darMejoresClientes()
	{
		List<BigDecimal> aMostrar = hotelAndes.buenosClientes();

		String aRevelar = "";
		int i = 1;
		for (BigDecimal objects : aMostrar) {
			aRevelar+= "El cliente " + objects + " es un buen cliente";
			i++;
		}
		panelDatos.actualizarInterfaz(aRevelar);
	}
	
	
	/* ****************************************************************
	 * 			Demos de Convencion
	 *****************************************************************/
    /**
     * Demostración de creación, consulta y borrado de convencion
     * Muestra la traza de la ejecución en el panelDatos
     * 
     * Pre: La base de datos está vacía
     * Post: La base de datos está vacía
     */
    public void demoConvencion( )
    {
    	try 
    	{
    		// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			String nombreConvencion = "Filbo";
			boolean errorTipoBebida = false;
			//Creacion de horario
			String fechaInicio =  "04/04/2019";
			Timestamp inicio = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio).getTime());
			String fechaFin =  "09/04/2019";
			Timestamp fin = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin).getTime());
			Horario a = hotelAndes.adicionarHorario(0, 0, inicio, fin);
			
			VOConvencion convencion = hotelAndes.adicionarConvencion(005, 123, 10, nombreConvencion, a.getIdHorario());
			if (convencion == null)
			{
				convencion = hotelAndes.darConvencionPorId (convencion.getIdConvencion());
				errorTipoBebida = true;
			}
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Convencion\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorTipoBebida)
			{
				resultado += "*** Exception creando convencion !!\n";
				resultado += "*** Es probable que ese convencion ya existiera y hay restricción de UNICIDAD sobre el nombre del tipo de bebida\n";
				resultado += "*** Revise el log de hotelAndes para más detalles\n";
			}
			resultado += "Adicionado la convencion con nombre: " + nombreConvencion + "\n";
			
			int numeroDeTiposHab = 2;
			String[] tipos = {"Sencilla","Doble"};
			for (int i = 0; i < numeroDeTiposHab; i++) {
				int numeroHabs = 3;
				for (int j = 0; j < numeroHabs; j++) {
					Habitacion h = hotelAndes.darHabitacionPorTipo(tipos[i]).get(j);
					hotelAndes.adicionaHabitacion(h.getIdHabitacion(), h.getTipoHabitacion(), h.getCostoNoche(), h.getCapacidadHabitacion(), h.getIdHotel(), h.getNumeroHabitacion(), "S");
					resultado += "Adicionando habitacion " + h.getIdHabitacion() + "\n";

				}
				
			}
			
			int numeroServs = 3;

			for (int i = 952; i < 955; i++) {
				hotelAndes.adicionarConvencionrestbarcafeteria(i, convencion.getIdConvencion());
				resultado += "Adicionando servicio " + i + "\n";

			}
			
			
			//////////////CANCELAR CONVENCION
			hotelAndes.req13(convencion.getIdConvencion(), numeroDeTiposHab, numeroServs);
			resultado += "Convencion cancelada " +"\n";
			resultado += "Se crea de nuevo la convencion " +"\n";

			 nombreConvencion = "Filbo";
			 errorTipoBebida = false;
			//Creacion de horario
			 fechaInicio =  "04/04/2019";
			 inicio = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio).getTime());
			 fechaFin =  "09/04/2019";
			 fin = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin).getTime());
			 a = hotelAndes.adicionarHorario(0, 0, inicio, fin);
			
			 convencion = hotelAndes.adicionarConvencion(005, 123, 10, nombreConvencion, a.getIdHorario());
			if (convencion == null)
			{
				convencion = hotelAndes.darConvencionPorId (convencion.getIdConvencion());
				errorTipoBebida = true;
			}
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			 resultado += "Demo de creación y listado de Convencion\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorTipoBebida)
			{
				resultado += "*** Exception creando convencion !!\n";
				resultado += "*** Es probable que ese convencion ya existiera y hay restricción de UNICIDAD sobre el nombre del tipo de bebida\n";
				resultado += "*** Revise el log de hotelAndes para más detalles\n";
			}
			resultado += "Adicionado la convencion con nombre: " + nombreConvencion + "\n";
			
			numeroDeTiposHab = 2;
			for (int i = 0; i < numeroDeTiposHab; i++) {
				int numeroHabs = 3;
				for (int j = 0; j < numeroHabs; j++) {
					Habitacion h = hotelAndes.darHabitacionPorTipo(tipos[i]).get(j);
					hotelAndes.adicionaHabitacion(h.getIdHabitacion(), h.getTipoHabitacion(), h.getCostoNoche(), h.getCapacidadHabitacion(), h.getIdHotel(), h.getNumeroHabitacion(), "S");
					resultado += "Adicionando habitacion " + h.getIdHabitacion() + "\n";

				}
				
			}
			
			 numeroServs = 3;

			for (int i = 952; i < 955; i++) {
				hotelAndes.adicionarConvencionrestbarcafeteria(i, convencion.getIdConvencion());
				resultado += "Adicionando servicio " + i + "\n";

			}
			
			////////////// CONVENCION FINALIZADA
			hotelAndes.req14(convencion.getIdConvencion());
			resultado += "Convencion finalizada " +"\n";
			panelDatos.actualizarInterfaz(resultado);
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
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

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
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

