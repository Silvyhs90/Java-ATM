package banco;

public class Deposito extends Transaccion
{

	
	@Override
	public String getTransaccion() 
	{
		return mensaje;
	}

	@Override
	public void ejecutarTransaccion(double d, int cuenta) {
		mensaje= "Transaccion hecha por Cuenta n: "+ cuenta +" Depositar: $"+d;
	}



}
