package uniandes.isis2304.hotelAndes.test;

import static org.junit.Assert.fail;
import java.io.FileReader;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.hotelAndes.negocio.HotelAndes;

import org.junit.Test;

public class ConexionTest {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(ConexionTest.class.getName());
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos: La unidad de persistencia existe y el esquema de la BD también
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos: La unidad de persistencia NO existe
	 */
	private static final String CONFIG_TABLAS_ERR_DS = "./src/main/resources/config/TablasBD_ErrorDataStore.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos: La unidad de persistencia NO existe
	 */
	private static final String CONFIG_TABLAS_ERR_USER = "./src/main/resources/config/TablasBD_ErrorInvalidUser.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    
	/**
	 * La clase que se quiere probar
	 */
    private HotelAndes hotelAndes;
	
	/* ****************************************************************
	 * 			Métodos de prueba de acceso a la BD
	 *****************************************************************/  
    /**
     * Método de prueba para acceso correcto a una base de datos
     */
    @Test
    public void normalAccessTest ()
  	{
  	  	try
		{
			log.info ("Probando el acceso a la base de datos con datos válidos (BD, credenciales, esquema");
			hotelAndes = new HotelAndes (openConfig (CONFIG_TABLAS));
			log.info ("Conexión realizada correstamente");
			log.info ("Cerrando la conexión");
			
			hotelAndes.cerrarUnidadPersistencia ();
			log.info ("Conexión cerrada");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.info ("Prueba de acceso normal FALLÓ !!. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de acceso normal a la base de datos falló !! Revise persistence.xml.\n";
			msg += "Revise el log de hotelAndes y el de datanucleus para conocer el detalle de la excepción";
//			System.out.println (msg);
			e.printStackTrace();
			fail (msg);
		}
  	}
  	  
    /**
     * Método que prueba el intento de acceso a una base de datos inaccesible, por alguna de las siguientes causas:
     * 1. No existe la unidad de persistencia
     * 2. La unidad de persistencia está caida
     */
    @Test
    public void baseDatosInaccesible ()
    {
		try
		{
	    	log.info ("Probando el acceso a la base de datos con una base de datos que no existe");
			hotelAndes = new HotelAndes (openConfig (CONFIG_TABLAS_ERR_DS));
			fail ("Debería fallar. La base de datos no existe !!");
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.info ("Prueba realizada exitosamente. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de base de datos inaccesible correcta.\n";
			msg += "Revise el log de hotelAndes y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);
		}
    }
    
    /**
     * Método que prueba el intento de acceso a una base de datos inaccesible, por causa:
     * 1. Credenciales de usuario inválidas (nombre de usuario / contraseña)
     */
    @Test
    public void usuarioInvalidoTest ()
    {
		try
		{
	    	log.info ("Probando el acceso a la base de datos con datos de usuario incorrectos");
			hotelAndes = new HotelAndes (openConfig (CONFIG_TABLAS_ERR_USER));
			fail ("Debería fallar. Las credenciales del usuario no son válidas");
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.info ("Prueba realizada exitosamente. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de credenciales incorrectas correcta.\n";
			msg += "Revise el log de hotelAndes y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);
		}
    }


	/* ****************************************************************
	 * 			Métodos de configuración
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicación, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración de tablas válido");
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de tablas válido: ", "TipoBebidaTest", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }	

}