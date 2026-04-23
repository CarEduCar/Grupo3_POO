package BD;

import Classes.Dependente;
import Classes.FolhaPagamento;
import Classes.Funcionario;

import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceBD {

    Connection loginBD(String senha) throws SQLException;

    void fecharBD () throws SQLException;

    void inserirFuncionario(Funcionario funcionario) throws SQLException;

    void atualizarStatusFuncionario(Funcionario funcionario, String status) throws SQLException ;

    void inserirDependente(Funcionario funcionario, Dependente dependente) throws SQLException;

    void retirarDependente (Dependente dependente) throws SQLException;

    void criarFolhaPagamento(FolhaPagamento pagamento) throws SQLException;
}
