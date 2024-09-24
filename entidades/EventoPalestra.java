package entidades;
import java.util.ArrayList;
import entidades.enums.TipoEvento;

public class EventoPalestra extends Evento {
    private ArrayList<Pessoa> vagasPalestra;
    private String palestrante;

    public EventoPalestra(String nome, String data, double valorIngresso, int quantidadeVagas, String palestrante, Pessoa vagasPalestra) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOPALESTRA);
        this.palestrante = palestrante;
        this.vagasPalestra = new ArrayList<Pessoa>(this.getQuantidadeVagas());
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }
    public ArrayList<Pessoa> listarPessoas(){
        return this.vagasPalestra;
   }
}
