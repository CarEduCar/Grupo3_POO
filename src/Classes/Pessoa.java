package Classes;

import java.time.LocalDate;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Pessoa(LocalDate dataNascimento, String cpf, String nome) {
       if(cpf == null){
           throw new IllegalArgumentException("CPF não pode ser nulo.");
       }

       cpf = cpf.replaceAll("\\D", "");

        if(!cpf.matches("\\d{11}")){
            throw new IllegalArgumentException("CPF inválido! Deve conter 11 dígitos.");
        }
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }

    public String getCpfFormatado(){
        return cpf.substring(0,3) + "." +
                cpf.substring(3,6) + "." +
                cpf.substring(6,9) + "-" +
                cpf.substring(9,11);
    }

    // Getters
    public String getCpf() {
        return cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public int getId() { return this.id; }

    // Setters
    public void setId(int id){
        this.id = id;
    }
}
