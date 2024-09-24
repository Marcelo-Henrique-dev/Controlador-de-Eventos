package entidades;
import java.util.ArrayList;
import entidades.enums.TipoEvento;

public class EventoShow extends Evento {
    private ArrayList<Pessoa> vagasShow;
    private String artista;

    public EventoShow(String nome, String data, double valorIngresso, int quantidadeVagas, String artista) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOSHOW);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    public ArrayList<Pessoa> listarPessoas(){
        return this.vagasShow;
   }
}
