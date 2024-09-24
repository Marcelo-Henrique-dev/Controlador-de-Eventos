package entidades;

import entidades.enums.TipoEvento;

public class EventoShow extends Evento {
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
}
