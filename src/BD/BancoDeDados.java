package BD;

import Classes.Dependente;
import Classes.Funcionario;

import java.sql.*;

public class BancoDeDados implements InterfaceBD{
    private Connection conexao;

    public Connection connection(Connection connection){
        return this.conexao = connection;
    }

    public Connection loginBD(String usuario,String senha) {
        System.out.println("Conectando no banco de dados.....");
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/curso", usuario, senha);
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar...");
            return null;
        }
    }

    public void fecharBD(Connection conexao) throws SQLException {
        conexao.close();
    }

    public void inserirDependente (Funcionario funcionario, Dependente dependente) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, data_nasc, CPF, id_funcionario, parentesco)" +
                "VALUES (?, ?, ?, ?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, dependente.getNome());
            stmt.setObject(2, dependente.getDataNascimento());
            stmt.setString(3, dependente.getCpf());
            stmt.setDouble(4, funcionario.getId());
            stmt.setObject(4, dependente.getParentesco());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    dependente.setId(rs.getInt(1));
                }
            }
        }
    }

    public void inserirFuncionario (Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, data_nasc, CPF, salario_bruto)" +
                "VALUES (?, ?, ?, ?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, funcionario.getNome());
            stmt.setObject(2, funcionario.getDataNascimento());
            stmt.setString(3, funcionario.getCpf());
            stmt.setDouble(4, funcionario.getSalarioBruto());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    funcionario.setId(rs.getInt(1));
                }
            }
        }
    }

    public void deletarDependente (Dependente dependente) throws SQLException {
        String sql = "DELETE FROM dependente WHERE id_dependente = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, dependente.getId());
        stmt.execute();
    }


}
