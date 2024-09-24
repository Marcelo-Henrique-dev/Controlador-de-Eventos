package entidades;

public class EventoPalestra extends Evento {
    private String palestrante;

    public EventoPalestra(String nome, String data, String local, String palestrante) {
        super(nome, data, local);
        this.palestrante = palestrante;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }
}
