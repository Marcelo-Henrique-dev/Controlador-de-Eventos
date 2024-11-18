package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.Evento;
import interfaces.IClientesRepository;
import util.ConnectionSingleton;

public class RepositorioDeClientes implements IClientesRepository {

    private Connection connection;

    public RepositorioDeClientes(){
        try{
            this.connection = ConnectionSingleton.getInstance().conexao;
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void cadastroParticipanteSql(Evento evento, Cliente cliente) {
        String checkSql = "SELECT COUNT(*) FROM cliente WHERE cpf = ? AND idevento = ?";
        try(PreparedStatement checkStmt = connection.prepareStatement(checkSql)){
            checkStmt.setString(1, cliente.getCpf());
            checkStmt.setInt(2, cliente.getCodEvento());
            ResultSet rs = checkStmt.executeQuery();
            if(rs.next() && rs.getInt(1) > 0){
                System.out.println("Cliente já cadastrado neste evento!");
                return;
            }
        }catch(Exception e){
            System.out.println(e);
        }

        String insertCliente = "INSERT INTO cliente(cpf, nome, idade, dinheiro, idevento) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement insertStmt = connection.prepareStatement(insertCliente)){
            insertStmt.setString(1, cliente.getCpf());
            insertStmt.setString(2, cliente.getNome());
            insertStmt.setInt(3, cliente.getIdade());
            insertStmt.setDouble(4, cliente.getDinheiro());
            insertStmt.setInt(5, cliente.getCodEvento());
            insertStmt.executeUpdate();
            System.out.println("Cliente "+cliente.getNome()+" cadastrado em "+evento.getNome()+"!");
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void deletarClienteSql(int codEvento, String cpfCliente) {
        String deleteClienteSql = "DELETE FROM cliente WHERE idevento = ? AND cpf = ?";
        try(PreparedStatement stmtDeleteCliente = connection.prepareStatement(deleteClienteSql)){
            stmtDeleteCliente.setInt(1, codEvento);
            stmtDeleteCliente.setString(2, cpfCliente);
            stmtDeleteCliente.executeUpdate();
            System.out.println("Cliente deletado com sucesso!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void editarParticipanteSql(int idEvento, String cpfCliente, String nome, int idade, double dinheiro) {
        String sqlUpdateCliente = "UPDATE cliente SET nome = ?, idade = ?, dinheiro = ? WHERE idevento = ? AND cpf = ?";
        try(PreparedStatement stmtUpdateCliente = connection.prepareStatement(sqlUpdateCliente)){
            stmtUpdateCliente.setInt(4, idEvento);
            stmtUpdateCliente.setString(5, cpfCliente);
            stmtUpdateCliente.setString(1, nome);
            stmtUpdateCliente.setInt(2, idade);
            stmtUpdateCliente.setDouble(3, dinheiro);
            stmtUpdateCliente.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Cliente> listarParticipantesPorEventoSql(int codEvento, Evento eventoSelecionado) {
        String sqlSelecionarClientes = "SELECT * FROM cliente WHERE idevento = ?";
        ArrayList<Cliente> clientesSelecionados = new ArrayList<>();
        try(PreparedStatement stmtSelecionarClientes = connection.prepareStatement(sqlSelecionarClientes)){
            stmtSelecionarClientes.setInt(1, eventoSelecionado.getId());
            ResultSet rs = stmtSelecionarClientes.executeQuery();
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                double dinheiro = rs.getDouble("dinheiro");
                int idEvento = rs.getInt("idevento");
                Cliente cliente = new Cliente(cpf, nome, idade, dinheiro, idEvento);
                clientesSelecionados.add(cliente);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return clientesSelecionados;
    }
    
}
