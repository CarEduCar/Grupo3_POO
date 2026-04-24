package BD;

import Classes.Dependente;
import Classes.FolhaPagamento;
import Classes.Funcionario;

import java.sql.*;

public class BancoDeDados implements InterfaceBD {

    private Connection conexao;

    public BancoDeDados(Connection conexao) {
        this.conexao = conexao;
    }

    // --- --- FUNÇÕES DE CONEXÃO COM O BANCO DE DADOS --- ---

    public Connection loginBD(String senha) {
        System.out.println("Conectando no banco de dados.....");
        try {
            // Alterei de "curso" para "poo_grupo3"
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/poo_grupo3?currentSchema=poo_grupo3", "postgres", senha);
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar...");
            return null;
        }
    }

    public void fecharBD() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }

    // --- --- MÉTODOS DE FUNCIONÁRIO --- ---

    public void inserirFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, data_nasc, CPF, salario_bruto) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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

    public void atualizarStatusFuncionario(Funcionario funcionario, String status) throws SQLException {
        String sql = "UPDATE funcionario SET situacao = ? WHERE id_funcionario = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, funcionario.getId());
            stmt.executeUpdate();
        }
    }

    // --- --- MÉTODOS DE DEPENDENTE --- ---

    public void inserirDependente(Funcionario funcionario, Dependente dependente) throws SQLException {
        String sql = "INSERT INTO dependente (nome, data_nasc, CPF, id_funcionario, parentesco) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, dependente.getNome());
            stmt.setObject(2, dependente.getDataNascimento());
            stmt.setString(3, dependente.getCpf());
            stmt.setInt(4, funcionario.getId());
            stmt.setString(5, dependente.getParentesco().name());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    dependente.setId(rs.getInt(1));
                }
            }
        }
    }

    public void retirarDependente(Dependente dependente) throws SQLException {
        String sql = "DELETE FROM dependente WHERE id_dependente = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, dependente.getId());
            stmt.execute();
        }
    }

    // --- --- MÉTODOS DE FOLHA DE PAGAMENTO --- ---

    public void criarFolhaPagamento(FolhaPagamento pagamento) throws SQLException {
        String sql = "INSERT INTO folha_de_pagamento (data_pagamento, descontoINSS, descontoIR, salario_Liquido, id_funcionario) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setObject(1, pagamento.getDataPagamento());
            stmt.setDouble(2, pagamento.getDescontoINSS());
            stmt.setDouble(3, pagamento.getDescontoIR());
            stmt.setDouble(4, pagamento.getSalarioLiquido());
            stmt.setInt(5, pagamento.getFuncionario().getId());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pagamento.setId(rs.getInt(1));
                }
            }
        }
    }
}