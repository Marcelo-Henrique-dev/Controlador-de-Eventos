package entidades;
import java.util.ArrayList;
import entidades.enums.TipoEvento;

public class EventoIgreja extends Evento {
    private ArrayList<Pessoa> vagasIgreja;
    private String padre;

    public EventoIgreja(String nome, String data, double valorIngresso, int quantidadeVagas, String padre) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOIGREJA);
        this.padre = padre;
        this.vagasIgreja = new ArrayList<Pessoa>(this.getQuantidadeVagas());
    }

    public String getDenominação() {
        return padre;
    }

    public void setDenominação(String padre) {
        this.padre = padre;
    }
    public ArrayList<Pessoa> listarPessoas(){
        return this.vagasIgreja;
   }
}
