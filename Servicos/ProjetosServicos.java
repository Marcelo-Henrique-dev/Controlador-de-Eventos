package servicos;

import entidades.Evento;
import entidades.EventoFeriado;
import entidades.EventoFormatura;
import entidades.EventoIgreja;
import entidades.EventoPalestra;
import entidades.EventoReuniao;
import entidades.EventoShow;
import interfaces.IEventoServices;
import repositorios.RepositorioDeEventos;

public class ProjetosServicos implements IEventoServices {

    private RepositorioDeEventos eventos = new RepositorioDeEventos();

    @Override
    public void cadastrarEventoNoRepositorio() {
        // TODO
    }

    @Override
    public void listarEventos() {
        if(eventos.ListarEventos().isEmpty()){
            System.out.println("Não existe nenum evento cadastrado!");
        }else{
            for(int i=0; i<eventos.ListarEventos().size(); i++){
                Evento evento = eventos.ListarEventos().get(i);
                String detalhes = "";
                System.out.println("Id: "+i+" | Tipo: "+evento.getTipoEvento().toString()+" | Título: "+evento.getNome());
                System.out.println("Vagas: "+evento.getQuantidadeVagas()+" | Ingresso (R$): "+evento.getValorIngresso());
                System.out.println("Data: "+evento.getData());
                if(evento instanceof EventoFeriado){
                    EventoFeriado eventoFeriado = (EventoFeriado) evento;
                    detalhes = "Feriado: "+eventoFeriado.getMotivo();
                }else if(evento instanceof EventoFormatura){
                    EventoFormatura eventoFormatura = (EventoFormatura) evento;
                    detalhes = "Curso: "+eventoFormatura.getCurso();
                }else if(evento instanceof EventoIgreja){
                    EventoIgreja eventoIgreja = (EventoIgreja) evento;
                    detalhes = "Padre: "+eventoIgreja.getDenominação();
                }else if(evento instanceof EventoPalestra){
                    EventoPalestra eventoPalestra = (EventoPalestra) evento;
                    detalhes = "Palestrante: "+eventoPalestra.getPalestrante();
                }else if(evento instanceof EventoReuniao){
                    EventoReuniao eventoReuniao = (EventoReuniao) evento;
                    detalhes = "Assunto: "+eventoReuniao.getAssunto();
                }else if(evento instanceof EventoShow){
                    EventoShow eventoShow = (EventoShow) evento;
                    detalhes = "Artista: "+eventoShow.getArtista();
                }else{
                    detalhes = "Sem detalhes!";
                }
                System.out.println(detalhes);
                System.out.println("|-=======================================-|");
            }
        }
    }

    @Override
    public void editarEventos() {
        // TODO
    }

    @Override
    public void apagarEvento() {
        // TODO
    }
    
}
