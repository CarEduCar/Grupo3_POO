package BD;

import Classes.Dependente;
import Classes.Funcionario;

import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceBD {

    Connection loginBD(String usuario, String senha) throws SQLException;

    void fecharBD (Connection conexao) throws SQLException;

    void inserirFuncionario(Funcionario funcionario) throws SQLException;

    void inserirDependente(Funcionario funcionario, Dependente dependente) throws SQLException;

    void deletarDependente(Dependente dependente) throws SQLException;
}
