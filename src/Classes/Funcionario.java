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

    public double calcularINSS(double salario) {
        if (salario <= 1518.00) {
            return salario * 0.075;
        } else if (salario <= 2793.88) {
            return salario * 0.09 - 22.77;
        } else if (salario <= 4190.83) {
            return salario * 0.12 - 106.60;
        } else if (salario <= 8157.41) {
            return salario * 0.14 - 190.42;
        } else {
            return 951.62;
        }
    }

    public double calcularIR(double salarioBruto, int dependentes) {
        double inss = calcularINSS(salarioBruto);
        double base = salarioBruto - inss - (dependentes * 189.59);

        if (base <= 2259.20) {
            return 0;
        } else if (base <= 2826.65) {
            return base * 0.075 - 169.44;
        } else if (base <= 3751.05) {
            return base * 0.15 - 381.44;
        } else if (base <= 4664.68) {
            return base * 0.225 - 662.77;
        } else {
            return base * 0.275 - 896.00;
        }
    }

    public double calcularSalarioLiquido(double salarioBruto, int dependentes) {
        double inss = calcularINSS(salarioBruto);
        double ir = calcularIR(salarioBruto, dependentes);
        return salarioBruto - inss - ir;
    }
}
