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
            System.out.println("| 5 - Cadastrar Participante | 6 - Listar Participantes | 7 - Editar Participantes | 8 - Apagar Participantes |");
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
                    break;
                case 5:
                    eventosServices.cadastrarParticipante();
                    break;
                case 6:
                    System.out.println("Qual evento você deseja ver os participantes?");
                    eventosServices.listarEventos();
                    int opcEvento = scanner.nextInt();
                    scanner.nextLine();
                    eventosServices.mostrarParticipantes(opcEvento);
                    break;
                case 7:
                    eventosServices.editarParticipante();
                    break;
                case 8:
                    eventosServices.apagarParticipante();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(opc != 0);
    }

}