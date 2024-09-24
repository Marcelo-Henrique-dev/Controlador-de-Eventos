package entidades;

public class EventoReuniao extends Evento {
    private String assunto;

    public EventoReuniao(String nome, String data, String local, String assunto) {
        super(nome, data, local);
        this.assunto = assunto;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
