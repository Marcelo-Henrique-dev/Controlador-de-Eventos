package interfaces;

import java.util.ArrayList;

import entidades.Cliente;
import entidades.Evento;

public interface IClientesRepository {
    public void cadastroParticipanteSql(Evento evento, Cliente cliente);
    public void editarParticipanteSql(int idEvento, String cpfCliente, String nome, int idade, double dinheiro);
    public ArrayList<Cliente> listarParticipantesPorEventoSql(int codEvento, Evento eventoSelecionado);
    public void deletarClienteSql(int codEvento, String cpfCliente);
}
