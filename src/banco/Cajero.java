package banco;

//Clase Singleton
public class Cajero 
{
	private static final Cajero instance = new Cajero();
	private double montoCajero;
	private Banco banco;
	private Transaccion[] trans;
	
	
	public static Cajero getInstance() 
	{
		return instance;
	}
	
	//Constructores
	private Cajero()
	{
		montoCajero= 10000;// monto que empieza el cajero automatico
		trans = new Transaccion[50]; // numero de transacciones que pueden hacer los clientes
	}
	
	private Cajero(String nombre)
	{
		this();
		banco= new Banco(nombre);
	}
	// setters
	public void setBanco(String nombre)
	{
		banco= new Banco(nombre);
	}
	
	public void setMontoCajero(double monto)
	{
		montoCajero= monto;
	}

	//getters
	public Banco getBanco() {
		return banco;
	}
	
	public double getMontoCajero()
	{
		return montoCajero;
	}
	
	//metodos
	public void mostrarTrans() 
	{
		int i;
		for(i=0; i<trans.length ; i++)
		{
			if(trans[i]!=null)
			{
				System.out.println(trans[i].getTransaccion());
				
			}
		}
	}
	
	
	public void depositar(Cliente cliente, double monto)
	{
		Transaccion t;
		int i;
		t= cliente.getCuenta().depositar(monto);
		if(t!=null)
		{
			for(i=0; i< trans.length; i++)
			{
				if(trans[i]==null)
				{
					trans[i]= t;
					System.out.println("Deposito exitoso ");
					return;
				}
			
			}// cierre for
		}// cierre null
			System.out.println("No se deposito");	
	}
	
	
	public double retirar(Cliente cliente, double monto, Cajero cajero)
	{
		Transaccion t;
		int i;
		t= cliente.getCuenta().retirar(monto, cajero);
		
		if(t!=null)
		{
			for(i=0; i< trans.length; i++)
			{
				if(trans[i]==null)
				{
					trans[i]= t;
					System.out.println("Retiro exitoso");
					return monto;
				}
				
			
			}// cierre for
			
			
		}// cierre null
		return 0;
	}
	
	
	public String verSaldo(Cliente cliente)
	{
		Transaccion t;
		int i;
		t= cliente.getCuenta().verSaldo();
		if(t!=null)
		{
			for(i=0; i< trans.length; i++)
			{
				if(trans[i]==null)
				{
					trans[i]= t;
					
					return trans[i].getTransaccion();
				}
						
			}// cierre for
		}// cierre null
		System.out.println("error de saldo");
		return "";
	}
	
	
}
