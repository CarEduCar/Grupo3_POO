package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
    protected double salarioBruto;
    protected double descontoInss;
    protected double descontoIR;
    protected List<Dependente> dependente;

    public Funcionario(LocalDate dataNascimento, String cpf, String nome, double salarioBruto) {
        super(dataNascimento, cpf, nome);
        this.salarioBruto = salarioBruto;
        dependente = new ArrayList<>();
    }

    public double salarioLiquido(double salarioBruto){
        return
    }
}
