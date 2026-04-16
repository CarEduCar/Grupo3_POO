import java.util.Date;

public class Dependente extends Pessoa{

    protected Parentesco parentesco;

     public Dependente(Date dataNascimento, String cpf, String nome) {
        super(dataNascimento, cpf, nome);
    }

}
