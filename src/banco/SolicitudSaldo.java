package banco;

public class SolicitudSaldo extends Transaccion
{
		
	@Override
	public String getTransaccion() 
	{
		return mensaje;
	}

	@Override
	public void ejecutarTransaccion(double d, int cuenta) {
		mensaje = "Transaccion hecha por Cuenta n: "+ cuenta + " Solicitando saldo: $" +d;		
	}


}
