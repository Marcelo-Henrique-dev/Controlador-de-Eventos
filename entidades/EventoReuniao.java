package entidades;
import java.util.ArrayList;
import entidades.enums.TipoEvento;

public class EventoReuniao extends Evento {
    private ArrayList<Pessoa> vagasReuniao;
    private String assunto;

    public EventoReuniao(String nome, String data, double valorIngresso, int quantidadeVagas, String assunto, Pessoa vagasReuniao) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOREUNIAO);
        this.assunto = assunto;
        this.vagasReuniao = new ArrayList<Pessoa>(this.getQuantidadeVagas());
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public ArrayList<Pessoa> listarPessoas(){
        return this.vagasReuniao;
   }
}
