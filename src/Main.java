import java.util.Scanner;

public class Main{
	public static int input(int opcao) { // Classe do Input
		Scanner input = new Scanner(System.in);
		System.out.print("Qual opção você deseja?: ");
		opcao = input.nextInt();
		return opcao;
	}
	
	public static void menuprincipal() { // Classe do Menu
		System.out.println("MENU DE OPÇÕES:");
		System.out.println("1. Pães");
		System.out.println("2. Queijos");
		System.out.println("3. Carnes");
		System.out.println("4. Verduras");
		System.out.println("5. Molhos");
		System.out.println("6. Outros");
		System.out.println("7. Sair");
	}
	
	

	public static void main(String[] args) { // Classe Principal
	int resposta = 0;

		
	while (resposta!=7) {
		menuprincipal();
		resposta = input(resposta);
		}
	
	System.out.println("Até logo!");
	}
	
	

}
