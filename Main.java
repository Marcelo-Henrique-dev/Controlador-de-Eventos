import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc;
        do{
            System.out.println("|======- Menu -======|");
            System.out.println("| 1 - Cadastra evento | 2 - Visualizar eventos | 3 - Editar Evento |");
            System.out.println("| 0 - Sair |");
            opc = scanner.nextInt();
            scanner.nextLine();
        }while(opc != 0);
    }

}