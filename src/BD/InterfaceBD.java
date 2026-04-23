package BD;

import Classes.Dependente;
import Classes.FolhaPagamento;
import Classes.Funcionario;

import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceBD {

    // --- --- FUNÇÕES DE CONEXÃO COM O BANCO DE DADOS --- ---

    Connection loginBD(String senha) throws SQLException;

    void fecharBD () throws SQLException;

    // --- --- MÉTODOS DE FUNCIONÁRIO --- ---

    void inserirFuncionario(Funcionario funcionario) throws SQLException;

    void atualizarStatusFuncionario(Funcionario funcionario, String status) throws SQLException ;

    // --- --- MÉTODOS DE DEPENDENTE --- ---

    void inserirDependente(Funcionario funcionario, Dependente dependente) throws SQLException;

    void retirarDependente (Dependente dependente) throws SQLException;

    // --- --- MÉTODOS DE FOLHA DE PAGAMENTO --- ---

    void criarFolhaPagamento(FolhaPagamento pagamento) throws SQLException;
}
