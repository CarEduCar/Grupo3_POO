package Classes;
import java.time.LocalDate;

public class FolhaPagamento {
    //private int id;
    private Funcionario funcionario;
    private LocalDate dataPagamento;
    private double descontoINSS;
    private double descontoIR;
    private double salarioLiquido;

    // Construtor ↓
    public FolhaPagamento(Funcionario funcionario, LocalDate dataPagamento){
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
    }

    // Calculo INSS ↓
    private void calcularINSS(double salario) {
        if (salario <= 1518.00) {
            descontoINSS = salario * 0.075;
        }else if(salario <= 2793.88) {
            descontoINSS = salario * 0.09 - 22.77;
        }else if(salario <= 4190.83) {
            descontoINSS = salario * 0.12 - 106.60;
        }else if(salario <= 8157.41) {
            descontoINSS = salario * 0.14 - 190.42;
        }else{
            descontoINSS = 951.62;
        }
    }

    // Calculo IR ↓
    private void calcularIR(double salarioBruto, int dependentes) {
        double base = salarioBruto - descontoINSS - (dependentes * 189.59);

        if (base <= 2259.20) {
            descontoIR = 0;
        } else if (base <= 2826.65) {
            descontoIR = base * 0.075 - 169.44;
        } else if (base <= 3751.05) {
            descontoIR = base * 0.15 - 381.44;
        } else if (base <= 4664.68) {
            descontoIR = base * 0.225 - 662.77;
        } else {
            descontoIR = base * 0.275 - 896.00;
        }
    }

    // Calculo do salário líquido.
    public double getSalarioLiquido() {
        double salarioBruto = funcionario.getSalarioBruto();
        int dependentes = funcionario.getDependente().size();

        calcularINSS(salarioBruto);
        calcularIR(salarioBruto, dependentes);

        salarioLiquido = salarioBruto - descontoINSS - descontoIR;
        return this.salarioLiquido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== FOLHA DE PAGAMENTO ===\n")
                .append("Funcionário  : ")
                .append(funcionario.getNome())
                .append("\nCPF: ")
                .append(funcionario.getCpf())
                .append("\nData: ")
                .append(dataPagamento)
                .append("\nSalário Bruto: R$")
                .append(String.format("%,.2f", funcionario.getSalarioBruto()))
                .append("\nDesconto INSS: R$ ")
                .append(String.format("%,.2f", descontoINSS))
                .append("\nDesconto IR  : R$")
                .append(String.format("%,.2f", descontoIR))
                .append("\nSalário Líquido : R$")
                .append(String.format("%,.2f", salarioLiquido));
        return sb.toString();
    }
}