package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

public class Funcionario extends Pessoa {
    protected double salarioBruto;
    protected double descontoInss;
    protected double descontoIR;
    protected List<Dependente> dependente;

    public Funcionario(LocalDate dataNascimento, String cpf, String nome, double salarioBruto) {
        super(dataNascimento, cpf, nome);
        this.salarioBruto = salarioBruto;
        dependente = new ArrayList<>();

        //Validações de segurança.
        if(this.salarioBruto <= 0.0) throw new IllegalArgumentException("Salário não pode ser <= que 0!");
        if(nome.isEmpty() || nome.isBlank()) throw new IllegalArgumentException("Nome está vazio!");
        if(cpf.isEmpty() || cpf.isBlank()) throw new IllegalArgumentException("CPF está vazio!");
        if(cpf.length() != 11) throw new IllegalArgumentException("CPF inválido ou menor/maior que 11 Digitos!");

        // ↓ Aqui o '\\d' significa que aceita de 0-9 e o '+' que aceita um ou mais de um número ↓
        if(!cpf.matches("\\d+")) throw new IllegalArgumentException("CPF deve conter apenas números!");
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if(idade >= 0 && idade < 18) throw new IllegalArgumentException("Data de nascimento (Menor de Idade)!");
        if(idade < 0 || idade > 120) throw new IllegalArgumentException
                ("Data de nascimento inválida (Fora da faixa válida 'MENOR que 0 ou MAIOR que 120 anos'!");
    }

    public double getSalarioBruto() {
        return salarioBruto;
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
