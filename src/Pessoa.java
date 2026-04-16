import java.util.Date;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected Date dataNascimento;

    public Pessoa(Date dataNascimento, String cpf, String nome) {
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
}
