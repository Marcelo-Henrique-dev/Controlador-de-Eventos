package entidades;

public class EventoFormatura extends Evento {
    private String curso;

    public EventoFormatura(String nome, String data, String local, String curso) {
        super(nome, data, local);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
