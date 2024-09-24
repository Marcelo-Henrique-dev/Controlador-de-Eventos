import java.util.Scanner;

public class Main{

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opc;
        do{
            System.out.println("|======- Menu -======|");
            System.out.println("| 1 - Cadastra evento | 2 - Visualizar eventos | 3 - Editar Evento |");
            System.out.println("| 0 - Sair |");
            opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    System.out.println("Cadastrar menu");
                    break;
                case 2:
                    System.out.println("Vizualizar eventos");
                    break;
                case 3:
                    System.out.println("Editar Evento");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(opc != 0);



    }

}