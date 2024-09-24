package entidades;
import java.util.ArrayList;
import entidades.enums.TipoEvento;

public class EventoFormatura extends Evento {
    private ArrayList<Pessoa> vagasFormatura;
    private String curso;

    public EventoFormatura(String nome, String data, double valorIngresso, int quantidadeVagas, String curso) {
        super(nome, data, valorIngresso, quantidadeVagas, TipoEvento.EVENTOFORMATURA);
        this.curso = curso;
        this.vagasFormatura = new ArrayList<Pessoa>(this.getQuantidadeVagas());
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    public ArrayList<Pessoa> listarPessoas(){
        return this.vagasFormatura;
   }
}
