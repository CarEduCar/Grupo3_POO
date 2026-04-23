package BD;

import Classes.Dependente;
import Classes.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDeDados {
    private Connection conexao;

    public Connection connection(Connection connection){
        return this.conexao = connection;
    }

    public void FecharBD(Connection conexao) throws SQLException {
        conexao.close();
    }

    public Integer IdFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "SELECT id_funcionario FROM funcionario WHERE CPF = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, funcionario.getCpf());

        try(ResultSet query = stmt.executeQuery()){
            if(query.next()){
                return query.getInt("id_funcionario");
            } else{
                return null;
            }
        }
    }

    public Integer IdDependente(Dependente dependente) throws SQLException {
        String sql = "SELECT id_funcionario FROM funcionario WHERE CPF = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, dependente.getCpf());

        try(ResultSet query = stmt.executeQuery()){
            if(query.next()){
                return query.getInt("id_funcionario");
            } else{
                return null;
            }
        }
    }

    public void InserirFuncionario (Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, data_nasc, CPF, salario_bruto)" +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, funcionario.getNome());
        stmt.setObject(2, funcionario.getDataNascimento());
        stmt.setString(3, funcionario.getCpf());
        stmt.setString(4, funcionario.salarioBruto());
        stmt.execute();
    }

    public void InserirDependente (Dependente dependente, Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO dependente (nome, data_nasc, CPF, id_funcionario, parestesco)" +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, dependente.getNome());
        stmt.setObject(2, dependente.getDataNascimento());
        stmt.setString(3, dependente.getCpf());
        stmt.setString(4, ());
        stmt.execute();
    }




}
