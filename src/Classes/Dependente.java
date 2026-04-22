package Classes;

import Exceptions.DependenteException;

import java.time.LocalDate;
import java.time.Period;

public class Dependente extends Pessoa {
    private Parentesco parentesco;
    private int id;

    public Dependente(LocalDate dataNascimento, String cpf, String nome, Parentesco parentesco)
            throws DependenteException {
        super(dataNascimento, cpf, nome);
        this.parentesco = parentesco;

        // Exception para idade do dependente.
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade >= 18){
            throw new DependenteException("O dependente deve ter menos de 18 anos.");
        }
    }

    // Getters ↓
    public int getId(){ return id; }
    public Parentesco getParentesco() { return parentesco; }
}
