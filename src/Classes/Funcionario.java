package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

public class Funcionario extends Pessoa {
    private double salarioBruto;
    //private double descontoInss;
    //private double descontoIR;
    private List<Dependente> dependentes;

    // Construtor ↓
    public Funcionario(LocalDate dataNascimento, String cpf, String nome, double salarioBruto) {
        super(dataNascimento, cpf, nome);
        this.salarioBruto = salarioBruto;
        dependentes = new ArrayList<>();

        //Validações de segurança ↓
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
    public void adicionarDP(Dependente dependente){
        dependentes.add(dependente);
    }

    // Getters ↓
    public double getSalarioBruto(){ return this.salarioBruto; }
    public List<Dependente> getDependente(){ return this.dependentes; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Funcionário: ")
                    .append(getNome())
                    .append("\nCPF: ")
                    .append(getCpf())
                    .append("\nSalário Bruto: R$ ")
                    .append(String.format("%,.2f", salarioBruto))
                    .append("\nDependentes: ")
                    .append(dependentes.size());
        return sb.toString();
    }
}
