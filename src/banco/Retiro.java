package banco;

public class Retiro extends Transaccion
{
	
	
	@Override
	public String getTransaccion() 
	{
		return mensaje;
	}

	@Override
	public void ejecutarTransaccion(double d, int cuenta) {
		mensaje= "Transaccion hecha por Cuenta n: "+ cuenta +" Retirar: $"+d;
	}




}
