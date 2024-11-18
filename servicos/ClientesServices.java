package servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Evento;
import interfaces.IClientesServices;
import repositorios.RepositorioDeClientes;
import repositorios.RepositorioDeEventos;

public class ClientesServices implements IClientesServices {

    private Scanner scanner = new Scanner(System.in);

    private RepositorioDeEventos eventos = new RepositorioDeEventos();

    private RepositorioDeClientes clientes = new RepositorioDeClientes();

    @Override
    public void cadastrarCliente() throws SQLException {
        System.out.println("Você deseja cadastrar o cliente em qual evento? (pelo id)");
        int opc = scanner.nextInt();
        scanner.nextLine();
        Evento eventoSelecionado = eventos.listarEventos().get(opc);
        System.out.println("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Dinheiro do cliente: ");
        double dinheiro = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(cpf, nome, idade, dinheiro, eventoSelecionado.getId());
        clientes.cadastroParticipanteSql(eventoSelecionado, cliente);
    }

    @Override
    public void deletarCliente() throws SQLException {
        System.out.println("De qual evento você quer retirar um cliente? (pelo id)");
        int opcEvento = scanner.nextInt();
        scanner.nextLine();
        Evento eventoSelecionado = eventos.listarEventos().get(opcEvento);
        System.out.println("Qual cliente você deseja retirar do evento? (pelo cpf)");
        String cpfCliente = scanner.nextLine();
        clientes.deletarClienteSql(eventoSelecionado.getId(), cpfCliente);
    }

    @Override
    public void editarCliente() throws SQLException {
        System.out.println("Em qual evento está o participante? (Por id)");
        int opc = scanner.nextInt();
        scanner.nextLine();
        Evento eventoSelecionado = eventos.listarEventos().get(opc);
        System.out.println("Qual participante deseja editar? (pelo CPF)");
        String opcParticipante = scanner.nextLine();
        System.out.println("Qual novo nome? ");
        String nome = scanner.nextLine();
        System.out.println("Qual nova idade? ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quanto ele tem agora? ");
        double dinheiro = scanner.nextDouble();
        scanner.nextLine();
        clientes.editarParticipanteSql(eventoSelecionado.getId(), opcParticipante, nome, idade, dinheiro);
    }

    @Override
    public void listarClientesPorEvento() throws SQLException {
        System.out.println("Qual evento você quer ver os clientes? (pelo id)");
        int opcEvento = scanner.nextInt();
        scanner.nextLine();
        if (eventos.listarEventos().size() - 1 == opcEvento) {
            Evento eventoSelecionado = eventos.listarEventos().get(opcEvento);
            ArrayList<Cliente> clientesSql = clientes.listarParticipantesPorEventoSql(opcEvento, eventoSelecionado);
            if (clientesSql.isEmpty()) {
                System.out.println("Nenhum cliente no evento");
            } else {
                for (Cliente cliente : clientesSql) {
                    System.out.println("==============================");
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("Dinheiro: " + cliente.getDinheiro());
                    System.out.println("==============================");
                }
            }
        } else {
            System.out.println("Evento não encontrado");
        }
    }

}
