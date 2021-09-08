package banco;

public class Cliente 
{
	//atributos
	private Cuenta cuenta;
	private String nombre;
	private String apellido;
	private String cbu;
	private String cuil;
	private String dni;
	
	//Constructor
	public Cliente(String nombre,String apellido, String dni, String cbu, String cuil)
	{
		setNombre(nombre);
		setApellido(apellido);
		setCbu(cbu);
		setCuil(cuil);
		setDni(dni);
		cuenta = new Cuenta(); // el cliente empieza con una cuenta
	}
	
	//Getters
	public Cuenta getCuenta()
	{
		return cuenta;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public String getDni() 
	{
		return dni;
	}

	public String getApellido() 
	{
		return apellido;
	}
	

	public String getCbu() {
		return cbu;
	}

	public String getCuil() {
		return cuil;
	}
	
	//Setters
	public Cuenta setnCuenta(Cuenta cuenta)
	{
		return this.cuenta = cuenta;
	} 
	
	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	
	public void setCuil(String cuil) 
	{
		this.cuil = cuil;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

		//toString
	public String toString()
	{
		return(" Nombre: "+nombre+ " Apellido" + apellido +" Dni: "+dni+ " Cbu de la cuenta: "+ cbu + " Numero cuil: "+ cuil);
	}


	
}
