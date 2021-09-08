package banco;

//Clase padre abstracta Transaccion
public abstract class Transaccion 
{
	//variable protected, la heredan las clases hijas
	protected String mensaje= "";
	
	//metodos abstractos
	public abstract void ejecutarTransaccion(double m, int i);
	public abstract String getTransaccion();
	
}
