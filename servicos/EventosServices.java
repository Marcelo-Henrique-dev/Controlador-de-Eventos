package servicos;

import java.util.Scanner;

import entidades.Elemento;
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
import repositorios.ListaLigada;

public class EventosServices implements IEventoServices {

    private static Scanner scanner = new Scanner(System.in);
    private static ListaLigada eventos = new ListaLigada(); 

    @Override
    public void cadastrarEventoNoRepositorio() throws InvalidEventoTypeException{
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("Data:");
        String data = scanner.nextLine();
        System.out.println("Valor:");
        double valorIngresso = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Vagas:");
        int quantidadeVagas = scanner.nextInt();
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
        } else {
            throw new InvalidEventoTypeException(EnumEventoException.TIPO_INVALIDO.toString());
        }
        Elemento novoElemento = new Elemento();
        novoElemento.setValor(criarEvento(nome, data, valorIngresso, quantidadeVagas, tipoEvento, motivo, curso, padre, palestrante, assunto, artista));
        if(eventos.getPrimeiro() == null && eventos.getUltimo() == null){
            eventos.setPrimeiro(novoElemento);
            eventos.setUltimo(novoElemento);
            eventos.setTamanho(eventos.getTamanho()+1);
            System.out.println("Evento cadastrado com sucesso!");
        }else{
            eventos.getUltimo().setProximo(novoElemento);
            eventos.setUltimo(novoElemento);
            eventos.setTamanho(eventos.getTamanho()+1);
            System.out.println("Evento cadastrado com sucesso!");
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
        if(eventos.isEmpty()){
            System.out.println("Não exite nenhum evento cadastrado!");
        }else{
            Elemento atual = eventos.getPrimeiro();
            System.out.println("|-==============================-|");
            for(int i=0; i<eventos.getTamanho(); i++){
                String detalhes = "";
                System.out.println("ID: "+i+" | Tipo: "+atual.getValor().getTipoEvento().toString()+" | Título: "+atual.getValor().getNome());
                System.out.println("Vagas: "+atual.getValor().getQuantidadeVagas()+" | Ingresso: "+atual.getValor().getValorIngresso());
                System.out.println("Data: "+atual.getValor().getData());
                if (atual.getValor() instanceof EventoFeriado) {
                    EventoFeriado eventoFeriado = (EventoFeriado) atual.getValor();
                    detalhes = "Feriado: " + eventoFeriado.getMotivo();
                } else if (atual.getValor() instanceof EventoFormatura) {
                    EventoFormatura eventoFormatura = (EventoFormatura) atual.getValor();
                    detalhes = "Curso: " + eventoFormatura.getCurso();
                } else if (atual.getValor() instanceof EventoIgreja) {
                    EventoIgreja eventoIgreja = (EventoIgreja) atual.getValor();
                    detalhes = "Padre: " + eventoIgreja.getDenominação();
                } else if (atual.getValor() instanceof EventoPalestra) {
                    EventoPalestra eventoPalestra = (EventoPalestra) atual.getValor();
                    detalhes = "Palestrante: " + eventoPalestra.getPalestrante();
                } else if (atual.getValor() instanceof EventoReuniao) {
                    EventoReuniao eventoReuniao = (EventoReuniao) atual.getValor();
                    detalhes = "Assunto: " + eventoReuniao.getAssunto();
                } else if (atual.getValor() instanceof EventoShow) {
                    EventoShow eventoShow = (EventoShow) atual.getValor();
                    detalhes = "Artista: " + eventoShow.getArtista();
                } else {
                    detalhes = "Sem detalhes!";
                }
                System.out.println(detalhes);
                System.out.println("|-==============================-|");
                atual = atual.getProximo();
            }
        }
    }

    @Override
    public void editarEventos() {
        // TODO
    }

    @Override
    public void apagarEvento() {
        System.out.println("Qual Evento você deseja apagar? (pelo id)");
        int opc = scanner.nextInt();
        scanner.nextLine();
        Elemento anterior = null;
        Elemento atual = eventos.getPrimeiro();
        for(int i=0; i<eventos.getTamanho(); i++){
            if(atual.getValor() == eventos.get(opc).getValor()){
                if(eventos.getTamanho() == 1){
                    eventos.setPrimeiro(null);
                    eventos.setUltimo(null);
                }else if(atual == eventos.getPrimeiro()){
                    eventos.setPrimeiro(atual.getProximo());
                    atual.setProximo(null);
                }else if(atual == eventos.getUltimo()){
                    eventos.setUltimo(anterior);
                    anterior.setProximo(null);
                }else{
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }
                eventos.setTamanho(eventos.getTamanho()-1);
                System.out.println("Evento cancelado com sucesso!");
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    public void cadastrarParticipante() {
        System.out.println("Você deseja cadastrar em qual evento? (pelo id)");
        int opc = scanner.nextInt();
        scanner.nextLine();
        Evento eventoSelecionado = eventos.get(opc).getValor();
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
        Evento eventoSelecionado = eventos.get(opc).getValor();
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
        Evento eventoSelecionado = eventos.get(index).getValor();
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
        Evento eventoSelecionado = eventos.get(opc).getValor();
        mostrarParticipantes(opc);
        System.out.println("Qual o participante você deseja apagar? (pelo id)");
        int opcParticipante = scanner.nextInt();
        scanner.nextLine();
        Pessoa participante = eventoSelecionado.listarPessoas().get(opcParticipante);
        eventoSelecionado.listarPessoas().remove(participante);
        System.out.println("Participante apagado com sucesso!");
    }

}
