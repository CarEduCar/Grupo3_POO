import java.time.LocalDate;
import java.time.Period;

public class Dependente extends Pessoa{
    protected Parentesco parentesco;

    public Dependente(LocalDate dataNascimento, String cpf, String nome, Parentesco parentesco) {
        super(dataNascimento, cpf, nome);
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade >= 18){
            throw new DependenteException("O dependente deve ter menos de 18 anos.");
        }

        this.parentesco = parentesco;
    }
}
