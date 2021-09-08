package MainBanco;

import java.util.Scanner;

import banco.Cajero;
import banco.Cliente;
import banco.Cuenta;

public class AtmMain 
{

	public static void main(String[] args) 
	{	
	
		Cajero cajero = Cajero.getInstance();
		cajero.setBanco("Cajero del Sol");
		InicializarCliente(cajero);
		Menu(cajero);
	          
		
}
	
	public static void InicializarCliente(Cajero cajero)
	{
		Cliente cliente;
		
		// Agrego Clientes
  	    // llamo a mi cajero, el get banco(de clase Banco, llama al metodo agregar clientes que cree en la clase banco) 
     cajero.getBanco().agregoClientes("Silvina"," Saucedo ", " 39.284.456 ","1890004546684726485832","27-39284456-8");
     cliente = cajero.getBanco().getCliente(0);
      cliente.setnCuenta(new Cuenta(123456789, 5455));
     

      cajero.getBanco().agregoClientes("Laura"," Ramirez ","12.994.885","7583745683446657463599","27-12994885-8");
      cliente = cajero.getBanco().getCliente(1);
       cliente.setnCuenta(new Cuenta(6060221, 5456));

       cajero.getBanco().agregoClientes("Fabian"," Gomez ", "35.909.555","5746395846579900374658","20-35909555-0");
       cliente = cajero.getBanco().getCliente(2);
        cliente.setnCuenta(new Cuenta(12881615, 5457));
        
        cajero.getBanco().agregoClientes("Carlos"," Gonzalez ", "27.888.999","374857368834782094857","20-17888999-0");
        cliente = cajero.getBanco().getCliente(3);
         cliente.setnCuenta(new Cuenta(12345678, 5458));

         cajero.getBanco().agregoClientes("Marina"," Perez", "39.282.444","8576847586349285746353","27-39282444-8");
         cliente = cajero.getBanco().getCliente(4);
          cliente.setnCuenta(new Cuenta(431108, 5459));
     
	}
	
	public static void Menu(Cajero cajero) // Menu general del banco
	{
		Scanner sc = new Scanner(System.in);
		   int menuPrincipal=0;
		   Cliente n= null;
		    boolean error= true;
	  	    boolean error2= true;
	  	    int lecturaNC=0;
	  	    int lecturaNip=0; 
       
       while(menuPrincipal!=10) 
       {
     	  
      	 System.out.println("// ** Bienvenido  ** //");
		
      	 while(n==null) 
      	 {
      		
			
          try
          {
      System.out.println("ingrese su numero de cuenta: ");
      lecturaNC = sc.nextInt();
      
      System.out.println("Ingrese su numero personal: ");
      lecturaNip = sc.nextInt();
      
      error=true;
      }catch(Exception InputMismatchException) {
              error=false;
              System.out.println("ingrese datos validos ");
          }
         if(error!=false) 
          {
              
       //cliente
      	   n= cajero.getBanco().verificarCliente(lecturaNC, lecturaNip);
            }
          else 
          {
             sc.nextLine();
           }

		} // cierre del login

		int leermenu =0;
		double leermonto=0;

		while(leermenu!=4) // inicio del menu del cajero
				{
					
				System.out.println("Ingrese accion: 1-Retirar  2-Depositar  3-Ver saldo  4-Salir");
				leermenu= sc.nextInt();
		
				Cliente cli;
	  			cli = n;
    	
			if(error2!=false)
			{	
				System.out.println("Datos cliente: " + cli.toString() + " ");
				
			switch(leermenu)
			{
			case 1:  
				System.out.println("Introduzca el monto que desea retirar: ");
				leermonto = sc.nextInt();
				double retiro;
				retiro= cajero.retirar(cli,leermonto, cajero);
				if(retiro!=0) 
				{
					System.out.println("Usted retiro: "+ retiro); 
				}
			break;
			
			case 2: 
				System.out.println("Introduzca el monto a depositar: ");
			 	leermonto = sc.nextInt();
				cajero.depositar(cli, leermonto);
				
			break;
			
			case 3: 
			 	System.out.println(cajero.verSaldo(cli));
			 	
			break;
			
			case 4: 
				System.out.println(cli.getCuenta());
				System.out.println("Gracias por utilizar nuestros servicios");
				n=null;
			 	cli=null;
			break;
			case 404: // cuanto dinero quedo en el cajero
			 System.out.println("Dinero disponible en cajero: "+cajero.getMontoCajero());
			break;
			case 10:
				
				menuPrincipal=10;
				leermenu=4;
				
				break;
			
			} // cierre switch
			
			}else
				{
					sc.nextLine();
				
				}
		}// cierre while menu
		
       }
       sc.close();	    
       
}
	}
	

