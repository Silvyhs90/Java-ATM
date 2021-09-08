package banco;

public class Cuenta
{
	//variables
	private int nCuenta;
	private int niPersonal;
	private double saldo;
	private int numTrans;
	
	//Constructores
	public Cuenta(int nCuenta, int niPersonal)
	{
		this.saldo= 0;
		numTrans=0;
		this.nCuenta= nCuenta;
		this.niPersonal= niPersonal;
		
	}
	 
	public Cuenta()
	 {
		 saldo=0;
		 numTrans=0;
	 }
	
	//getters
	public Transaccion verSaldo() 
	{
		SolicitudSaldo solicitud= new SolicitudSaldo();
		solicitud.ejecutarTransaccion(saldo,nCuenta);
		numTrans++;
		return(solicitud);
	}
	
	public int getCuenta() 
	{
		return nCuenta;
	}
	
	public int getniPersonal()
	{
		return niPersonal;
	}
	
	//setters
	public void setCuenta(int nCuenta)
	{
		this.nCuenta=nCuenta;
		
	}
	
	public void setniPersonal(int npersonal) 
	{
		this.niPersonal=npersonal;
		
	}
	
	//toString
	public String toString()
	{
		return " Numero de cuenta: " + nCuenta + " Su saldo final es "+ saldo + " Numero Personal: ****** " + " Cantidad de transacciones hechas: " +numTrans;
	}
	

	// metodos
	public Transaccion retirar(double monto, Cajero cajero ) 
	{
		if(saldo >= monto && cajero.getMontoCajero()>= monto ) // si el saldo es mayor o igual al monto que pide y ademas el dispensador tiene mas plata que lo que pide el cliente lo puede retirar 
		{
			
			double monto2=cajero.getMontoCajero() - monto;
			saldo = saldo-monto;
			cajero.setMontoCajero(monto2);
			Retiro retiro= new Retiro();
			retiro.ejecutarTransaccion(monto,nCuenta);
			numTrans++;
			return(retiro);
			
		}
		else if(monto >= saldo)
		{
			System.out.println(" ** Sin fondos disponibles en la cuenta , ingrese un monto menor ** ");
			return null;
		} 
		else
		{
			System.out.println(" ** No hay suficiente dinero en el cajero para retirar, ingrese un monto menor o intente en otro cajero ** ");
		return null;
		}
	}
	
	
	public Transaccion depositar(double monto)
	{
		Transaccion t;
		saldo= saldo+monto;
		Deposito deposito= new Deposito();
		deposito.ejecutarTransaccion(monto, nCuenta);
		t= deposito;
		numTrans++;
		return t;
	}
	

	
	
	public boolean VerificarCuenta(int ncuenta, int npersonal)
	{
		if(nCuenta == ncuenta && niPersonal == npersonal)
		{
			
			return true;
		}
		
		return false;
	}
	
	
}
