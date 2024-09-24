package entidades;

public class EventoShow extends Evento {
    private String artista;

    public EventoShow(String nome, String data, String local, String artista) {
        super(nome, data, local);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
