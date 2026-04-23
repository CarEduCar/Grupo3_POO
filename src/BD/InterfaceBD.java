package BD;

import Classes.Dependente;
import Classes.Funcionario;

import java.sql.Connection;

public interface InterfaceBD {


    Connection LoginBD(String usuario, String senha);

    Connection FecharBD(Connection conexao);

    Integer IdFuncionario(Funcionario funcionario);

    Integer IdDependente(Dependente dependente);

    Connection InserirFuncionario(Funcionario funcionario);

    Connection InserirDependente(Funcionario funcionario, Dependente dependente);

}
