package entidades;

public class EventoFeriado extends Evento {
    private String motivo;

    public EventoFeriado(String nome, String data, String local, String motivo) {
        super(nome, data, local);
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
