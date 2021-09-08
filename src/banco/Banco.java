package banco;


public class Banco
{
	private Cliente[] clientes;
	private int numeroClientes;
	private String nombre;
	
	//Constructores
	public Banco(String nombre) 
	{	
		this.nombre=nombre;
		clientes = new Cliente[5]; // el banco ya tiene 5 clientes predeterminados
		numeroClientes = 0;
	}

	public Banco(Cliente clientes[]) 
	{
		this.clientes= clientes;
	}
	
	//metodos
	public void agregoClientes(String nombre,String apellido, String dni, String cbu, String cuil) 
	{
	       int i = numeroClientes++;
	        clientes[i] = new Cliente(nombre, apellido, dni, cbu, cuil);
	  }
	
	
	public Cliente verificarCliente(int nc, int nipersonal ) {
        int i=0;
        boolean client=false;

        System.out.println("Verificando si existe la cuenta...") ;

            for(i=0 ; i< clientes.length ; i++ )
            {

            	// si la posicion de cliente en I, es distinto de null, o sea si existe muestra la cuenta 
            	//y llama al metodo verificar cuenta que esta en la clase Cuenta del cliente y lo guarda en una variable que se llama client 
            	if(clientes[i]!=null) 
            {
                client=clientes[i].getCuenta().VerificarCuenta(nc, nipersonal);
            }

            	if(client==true) 
            	{
                    System.out.println("// ** Verificacion exitosa ** //");
                   
                    return(clientes[i]);
                   
                }

            }
            System.out.println("Error de ingreso, reintente nuevamente");
            return null;
    }

	
	public void mostrarClientes()
	{
		int i;
		for(i=0; i< clientes.length; i++)
		{
			System.out.println(clientes[i]);
		}
	}
	
	//getters
	public Cliente getCliente(int n_index)
	{
		return clientes[n_index];
	}
	
	public int getNumeroClientes()
	{
		return numeroClientes;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String toString()
	{
		return " ** Bienvenido  al banco " + getNombre() + " ** ";
	}

	//setters
	public void setNumeroClientes(int n) 
	{
		numeroClientes= n;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
