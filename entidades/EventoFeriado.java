package entidades;
import java.util.ArrayList;
import entidades.enums.TipoEvento;

public class EventoFeriado extends Evento {
    private ArrayList<Pessoa> vagasFeriado;
    private String motivo;

    public EventoFeriado(String nome, String data, double valorIngresso, int quantidadeVagas, String motivo) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOFERIADO);
        this.motivo = motivo;
        this.vagasFeriado = new ArrayList<Pessoa>(this.getQuantidadeVagas());
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public ArrayList<Pessoa> listarPessoas(){
         return this.vagasFeriado;
    }


}
