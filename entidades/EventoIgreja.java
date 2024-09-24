package entidades;

public class EventoIgreja extends Evento {
    private String padre;

    public EventoIgreja(String nome, String data, String local, String padre) {
        super(nome, data, local);
        this.padre = padre;
    }

    public String getDenominação() {
        return padre;
    }

    public void setDenominação(String padre) {
        this.padre = padre;
    }
}
