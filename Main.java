import java.util.Scanner;

import exceptions.InvalidEventoTypeException;
import servicos.EventosServices;

public class Main{
    
    public static Scanner scanner = new Scanner(System.in);
    public static EventosServices eventosServices = new EventosServices();
    public static void main(String[] args) throws InvalidEventoTypeException {
        int opc;
        do{
            System.out.println("|======- Menu -======|");
            System.out.println("| 1 - Cadastra evento | 2 - Visualizar eventos | 3 - Editar Evento | 4 - Cancelar Evento |");
            System.out.println("| 0 - Sair |");
            opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    eventosServices.cadastrarEventoNoRepositorio();
                    break;
                case 2:
                    eventosServices.listarEventos();
                    break;
                case 3:
                    eventosServices.editarEventos();
                    break;
                case 4:
                    eventosServices.apagarEvento();
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(opc != 0);



    }

}