package servicos;

import java.util.Scanner;

import entidades.Evento;
import entidades.EventoFeriado;
import entidades.EventoFormatura;
import entidades.EventoIgreja;
import entidades.EventoPalestra;
import entidades.EventoReuniao;
import entidades.EventoShow;
import entidades.Pessoa;
import entidades.enums.EnumEventoException;
import entidades.enums.TipoEvento;
import exceptions.InvalidEventoTypeException;
import interfaces.IEventoServices;
import repositorios.RepositorioDeEventos;

public class EventosServices implements IEventoServices {

    private static Scanner scanner = new Scanner(System.in);

    private RepositorioDeEventos eventos = new RepositorioDeEventos();

    @Override
    public void cadastrarEventoNoRepositorio() throws InvalidEventoTypeException {
        System.out.println("Nome do evento:");
        String nome = scanner.nextLine();
        System.out.println("Data do evento:");
        String data = scanner.nextLine();
        System.out.println("Valor do ingresso:");
        double valorIngresso = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Quantidade de vagas:");
        int quantidadeVagas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Tipo do Evento:");
        System.out.println("| 1 - Feriado | 2 - Formatura | 3 - Igreja | 4 - Palestra | 5 - Reunião | 6 - Show |");
        int tipoOpc = scanner.nextInt();
        scanner.nextLine();
        TipoEvento tipoEvento = tiparEvento(tipoOpc);
        String motivo = "";
        String curso = "";
        String padre = "";
        String palestrante = "";
        String assunto = "";
        String artista = "";
        if (tipoOpc == 1) {
            System.out.println("Motivo:");
            motivo = scanner.nextLine();
        } else if (tipoOpc == 2) {
            System.out.println("Curso:");
            curso = scanner.nextLine();
        } else if (tipoOpc == 3) {
            System.out.println("Padre:");
            padre = scanner.nextLine();
        } else if (tipoOpc == 4) {
            System.out.println("Palestrante:");
            palestrante = scanner.nextLine();
        } else if (tipoOpc == 5) {
            System.out.println("Assunto:");
            assunto = scanner.nextLine();
        } else if (tipoOpc == 6) {
            System.out.println("Artista:");
            artista = scanner.nextLine();
        }
        Evento evento = criarEvento(nome, data, valorIngresso, quantidadeVagas, tipoEvento, motivo, curso, padre,
                palestrante, assunto, artista);
        if (evento != null) {
            eventos.ListarEventos().add(evento);
            System.out.println("Evento agendado com sucesso!");
            System.out.println("=============================================");
        } else {
            throw new InvalidEventoTypeException(EnumEventoException.TIPO_INVALIDO.toString());
        }
    }

    private Evento criarEvento(String nome, String data, double valorIngresso, int quantidadeVagas,
            TipoEvento tipoEvento, String motivo, String curso, String padre, String palestrante, String assunto,
            String artista) {
        switch (tipoEvento) {
            case EVENTOFERIADO:
                return new EventoFeriado(nome, data, valorIngresso, quantidadeVagas, motivo);
            case EVENTOFORMATURA:
                return new EventoFormatura(nome, data, valorIngresso, quantidadeVagas, curso);
            case EVENTOIGREJA:
                return new EventoIgreja(nome, data, valorIngresso, quantidadeVagas, padre);
            case EVENTOPALESTRA:
                return new EventoPalestra(nome, data, valorIngresso, quantidadeVagas, palestrante);
            case EVENTOREUNIAO:
                return new EventoReuniao(nome, data, valorIngresso, quantidadeVagas, assunto);
            case EVENTOSHOW:
                return new EventoShow(nome, data, valorIngresso, quantidadeVagas, artista);
            default:
                return null;
        }
    }

    private TipoEvento tiparEvento(int opc) {
        switch (opc) {
            case 1:
                return TipoEvento.EVENTOFERIADO;
            case 2:
                return TipoEvento.EVENTOFORMATURA;
            case 3:
                return TipoEvento.EVENTOIGREJA;
            case 4:
                return TipoEvento.EVENTOPALESTRA;
            case 5:
                return TipoEvento.EVENTOREUNIAO;
            case 6:
                return TipoEvento.EVENTOSHOW;
            default:
                return null;
        }
    }

    @Override
    public void listarEventos() {
        if (eventos.ListarEventos().isEmpty()) {
            System.out.println("Não existe nenum evento cadastrado!");
        } else {
            System.out.println("|-=======================================-|");
            for (int i = 0; i < eventos.ListarEventos().size(); i++) {
                Evento evento = eventos.ListarEventos().get(i);
                String detalhes = "";
                System.out.println("Id: " + i + " | Tipo: " + evento.getTipoEvento().toString() + " | Título: "
                        + evento.getNome());
                System.out.println(
                        "Vagas: " + evento.getQuantidadeVagas() + " | Ingresso (R$): " + evento.getValorIngresso());
                System.out.println("Data: " + evento.getData());
                if (evento instanceof EventoFeriado) {
                    EventoFeriado eventoFeriado = (EventoFeriado) evento;
                    detalhes = "Feriado: " + eventoFeriado.getMotivo();
                } else if (evento instanceof EventoFormatura) {
                    EventoFormatura eventoFormatura = (EventoFormatura) evento;
                    detalhes = "Curso: " + eventoFormatura.getCurso();
                } else if (evento instanceof EventoIgreja) {
                    EventoIgreja eventoIgreja = (EventoIgreja) evento;
                    detalhes = "Padre: " + eventoIgreja.getDenominação();
                } else if (evento instanceof EventoPalestra) {
                    EventoPalestra eventoPalestra = (EventoPalestra) evento;
                    detalhes = "Palestrante: " + eventoPalestra.getPalestrante();
                } else if (evento instanceof EventoReuniao) {
                    EventoReuniao eventoReuniao = (EventoReuniao) evento;
                    detalhes = "Assunto: " + eventoReuniao.getAssunto();
                } else if (evento instanceof EventoShow) {
                    EventoShow eventoShow = (EventoShow) evento;
                    detalhes = "Artista: " + eventoShow.getArtista();
                } else {
                    detalhes = "Sem detalhes!";
                }
                System.out.println(detalhes);
                System.out.println("|-=======================================-|");
            }
        }
    }

    @Override
    public void editarEventos() {
        System.out.println("Qual evento? (por id)");
        int idEvento = scanner.nextInt();
        scanner.nextLine();
        Evento eventoEscolhido = eventos.ListarEventos().get(idEvento);
        System.out.println("Novo nome: ");
        String novoNome = scanner.nextLine();
        eventoEscolhido.setNome(novoNome);
        System.out.println("Nova data: ");
        String novaData = scanner.nextLine();
        eventoEscolhido.setData(novaData);
        System.out.println("Novo valor:");
        double novoValor = scanner.nextDouble();
        scanner.nextLine();
        eventoEscolhido.setValorIngresso(novoValor);
        System.out.println("Nova quantidade de vagas:");
        int novaVagas = scanner.nextInt();
        scanner.nextLine();
        eventoEscolhido.setQuantidadeVagas(novaVagas);
        if (eventoEscolhido instanceof EventoFeriado) {
            EventoFeriado evendoFeriado = (EventoFeriado) eventoEscolhido;
            System.out.println("Novo feriado:");
            String novoFeriado = scanner.nextLine();
            evendoFeriado.setMotivo(novoFeriado);
        } else if (eventoEscolhido instanceof EventoFormatura) {
            EventoFormatura eventoFormatura = (EventoFormatura) eventoEscolhido;
            System.out.println("Novo curso:");
            String novoCurso = scanner.nextLine();
            eventoFormatura.setCurso(novoCurso);
        } else if (eventoEscolhido instanceof EventoIgreja) {
            EventoIgreja eventoIgreja = (EventoIgreja) eventoEscolhido;
            System.out.println("Novo padre:");
            String novoPadre = scanner.nextLine();
            eventoIgreja.setDenominação(novoPadre);
        } else if (eventoEscolhido instanceof EventoPalestra) {
            EventoPalestra eventoPalestra = (EventoPalestra) eventoEscolhido;
            System.out.println("Novo palestrante:");
            String novoPalestrante = scanner.nextLine();
            eventoPalestra.setPalestrante(novoPalestrante);
        } else if (eventoEscolhido instanceof EventoReuniao) {
            EventoReuniao eventoReuniao = (EventoReuniao) eventoEscolhido;
            System.out.println("Novo assunto:");
            String novoAssunto = scanner.nextLine();
            eventoReuniao.setAssunto(novoAssunto);
        } else if (eventoEscolhido instanceof EventoShow) {
            EventoShow eventoShow = (EventoShow) eventoEscolhido;
            System.out.println("Novo Artista:");
            String novoArtista = scanner.nextLine();
            eventoShow.setArtista(novoArtista);
        }
    }

    @Override
    public void apagarEvento() {
        System.out.println("Qual evento você deseja apagar? (por id)");
        int opc = scanner.nextInt();
        Evento eventoSelecionado = eventos.ListarEventos().get(opc);
        System.out.println("Evento " + eventoSelecionado.getNome() + " Cancelado com sucesso!");
        eventos.ListarEventos().remove(eventoSelecionado);
    }

    // INSTÂNCIA DO REPOSITÓRIO DE PARTICIPANTES

    public void cadastrarParticipante() {
        System.out.println("Você deseja cadastrar em qual evento? (pelo id)");
        int opc = scanner.nextInt();
        scanner.nextLine();
        Evento eventoSelecionado = eventos.ListarEventos().get(opc);
        System.out.println("Nome do participante : ");
        String nome = scanner.nextLine();
        System.out.println("Idade do participante : ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Dinheiro do participante : ");
        double dinheiro = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("CPF do participante : ");
        String cpf = scanner.nextLine();
        Pessoa pessoa = new Pessoa(nome, idade, dinheiro, cpf);
        eventoSelecionado.listarPessoas().add(pessoa);
    }

    public void editarParticipante() {
        listarEventos();
        System.out.println("Em qual evento está o participante? (Por id)");
        int opc = scanner.nextInt();
        scanner.nextLine();
        Evento eventoSelecionado = eventos.ListarEventos().get(opc);
        mostrarParticipantes(opc);
        System.out.println("Qual participante deseja editar? (Por id)");
        int opcParticipante = scanner.nextInt();
        scanner.nextLine(); 
        Pessoa pessoa = eventoSelecionado.listarPessoas().get(opcParticipante);
        System.out.println("Qual novo nome ? ");
        String novoNome = scanner.nextLine();
        pessoa.setNome(novoNome);
        System.out.println("Qual nova idade ? ");
        int novaIdade = scanner.nextInt();
        scanner.nextLine();
        pessoa.setIdade(novaIdade);
        System.out.println("Qual novo dinheiro ? ");
        double novoDinheiro = scanner.nextDouble();
        scanner.nextLine();
        pessoa.setDinheiro(novoDinheiro);
        System.out.println("Qual novo CPF ? ");
        String novoCpf = scanner.nextLine();
        scanner.nextLine();
        pessoa.setCpf(novoCpf);
    }

    public void mostrarParticipantes(int index) {
        Evento eventoSelecionado = eventos.ListarEventos().get(index);
        System.out.println("========================");
        for (int i = 0; i < eventoSelecionado.listarPessoas().size(); i++) {
            Pessoa pessoa = eventoSelecionado.listarPessoas().get(i);
            System.out.println("Id: " + i);
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println("Cpf: " + pessoa.getCpf());
            System.out.println("Dinheiro: " + pessoa.getDinheiro());
            System.out.println("========================");
        }
    }

    public void apagarParticipante() {
        listarEventos();
        System.out.println("Qual evento o participante está cadastrado? (pelo id)");
        int opc = scanner.nextInt();
        scanner.nextLine();
        Evento eventoSelecionado = eventos.ListarEventos().get(opc);
        mostrarParticipantes(opc);
        System.out.println("Qual o participante você deseja apagar? (pelo id)");
        int opcParticipante = scanner.nextInt();
        scanner.nextLine();
        Pessoa participante = eventoSelecionado.listarPessoas().get(opcParticipante);
        eventoSelecionado.listarPessoas().remove(participante);
        System.out.println("Participante apagado com sucesso!");
    }

}
