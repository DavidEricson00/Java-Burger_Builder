import java.util.Scanner;

public class Main {
    private static String[][] cardapio = {
        {"Pão Francês", "Pão Carteira", "Pão de Hambúrguer", "Pão Árabe"},
        {"Coalho", "Minas", "Muçarela", "Cream Cheese", "Gorgonzola"},
        {"Mortadela", "Apresuntado", "Bacon", "Presunto", "Pepperoni", "Salame"},
        {"Cebola", "Pimentão", "Tomate"},
        {"Maionese", "Ketchup", "Maionese Temperada", "Molho Tártaro", "Barbecue"},
        {"Batata Palha", "Ovo"}
    };

    private static double[][] precos = {
        {0.25, 0.30, 0.70, 1.30},
        {1.50, 1.80, 2.00, 3.00, 3.50},
        {0.50, 1.00, 1.30, 1.60, 1.80, 2.00},
        {0.30, 0.45, 0.50},
        {0.50, 0.50, 0.70, 1.00, 1.50},
        {1.00, 1.00}
    };
    
    public static void menuprincipal() {
        System.out.println("MENU DE OPÇÕES:");
        System.out.println("1. Pães");
        System.out.println("2. Queijos");
        System.out.println("3. Carnes");
        System.out.println("4. Verduras");
        System.out.println("5. Molhos");
        System.out.println("6. Outros");
        System.out.println("7. Sair");
    }
    
    public static void line() {
        System.out.println("----------------------------------");
        }
    
    public static void mostrarcardapio(int opcao) {
        if (opcao >= 1 && opcao <= 6) {
            System.out.println("Produtos:");
            for (int i = 0; i < cardapio[opcao - 1].length; i++) {
                System.out.printf("%d. %s - R$ %.2f%n",i+1, cardapio[opcao - 1][i], precos[opcao - 1][i]);
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }

    public static int input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Qual opção você deseja?: ");
        int opcao = input.nextInt();
        return opcao;
    }

    public static void main(String[] args) {
        int resposta = 0, produto = 0;
        double total = 0;
        
        int[] quantidade = new int[999];
        String[] nome = new String[999];
        double[] preco = new double[999];

        while (resposta != 7) {
            menuprincipal();
            resposta = input();
            
            if (resposta != 7) {
            	line();
	            mostrarcardapio(resposta);
	            produto = input();
	            total += precos[resposta - 1][produto - 1];
	            System.out.println(total);
	            line();
            }
        }
        line();
        System.out.println("Até logo!");
    }
}