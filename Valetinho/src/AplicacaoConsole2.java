/**
 * TSI - POO - Prof fausto Ayres
 * Teste da classe Estacionamento
 */
public class AplicacaoConsole2 {

	public static void main(String[] args) {
		Estacionamento estacionamento = null;
		try {
			estacionamento = new Estacionamento(10);	//10 vagas
			new Estacionamento(0);
		}catch (Exception e) {System.out.println("exce��o--->"+e.getMessage());}

		System.out.println("\n-------TESTE EXCE��ES LAN�ADAS--------");
		try {
			estacionamento.entrar("AAA1111",1);
			estacionamento.entrar("XXX1111",1);
			System.out.println("*************1--->Nao lan�ou exce��o para: entrar 1"); 
		}catch (Exception e) {System.out.println("exce��o1--->"+e.getMessage());}

		try {
			estacionamento.sair(2);
			System.out.println("*************2--->Nao lan�ou exce��o para: sair 2"); 
		}catch (Exception e) {System.out.println("exce��o2--->"+e.getMessage());}

		try {
			estacionamento.consultarPlaca("XXX0000");
			System.out.println("*************4--->Nao lan�ou exce��o para: consultarPlaca XXX "); 
		}
		catch (Exception e) {System.out.println("exce��o4--->"+e.getMessage());}

		try {
			estacionamento.transferir(1,1);
			System.out.println("*************5--->Nao lan�ou exce��o para: transferir 1"); 
		}
		catch (Exception e) {System.out.println("exce��o5--->"+e.getMessage());}

		try {
			estacionamento.transferir(2,1);
			System.out.println("*************6--->Nao lan�ou exce��o para: transferir 2"); 
		}
		catch (Exception e) {System.out.println("exce��o6--->"+e.getMessage());}

		try {
			estacionamento.transferir(3,2);
			System.out.println("*************7--->Nao lan�ou exce��o para: transferir 3 "); 
		}
		catch (Exception e) {System.out.println("exce��o7--->"+e.getMessage());}

		System.out.println("\n------------------------");
		System.out.println("listagem geral");
		System.out.println("------------------------");
		for(String s : estacionamento.listarGeral()) {
			System.out.println(s);
		}

	}

}
