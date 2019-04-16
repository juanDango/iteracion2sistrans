package uniandes.isis2304.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelAndes.negocio.Cuenta;

public class SQLCuenta {

	//-----------
	//Constantes
	//-----------

	private final static String SQL = PersistenciaHotelAndes.SQL;

	//----------
	//Atributos
	//----------

	private PersistenciaHotelAndes pha;

	//------------
	//Constructor
	//------------

	public SQLCuenta(PersistenciaHotelAndes pha){
		this.pha = pha; 
	}

	//---------------------------------------
	//Metodos para manejo de cadena hotelera
	//---------------------------------------

	public long adicionarCuenta(PersistenceManager pm, long idCuenta, long valor, String metodoDePago, long idPlanConsumo, long idCliente, long idReserva)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pha.darTablaCuenta() + " (IDCUENTA, VALOR, METODODEPAGO, IDPLANCONSUMO, IDCLIENTE, IDRESERVA) VALUES (?, ?, ?, ?, ?, ?) ");
		q.setParameters(idCuenta, valor, metodoDePago, idPlanConsumo, idCliente, idReserva);
		return (long)q.executeUnique();
	}

	public Cuenta darCuentaPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pha.darTablaCuenta() + " WHERE IDCUENTA = ?");
		q.setResultClass(Cuenta.class);
		q.setParameters(id);
		return (Cuenta) q.executeUnique();
	}
	
	public long adicionarUnValorALaCuenta(PersistenceManager pm, long idCuenta, long valor)
	{
		Query q = pm.newQuery(SQL, "UPDATE REGISTRO SET VALOR = VALOR + ?  WHERE IDREGISTRO = ?");
		q.setParameters(valor, idCuenta);
		return (long)q.executeUnique();
	}
}
