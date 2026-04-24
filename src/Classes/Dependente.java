package Classes;

import Exceptions.DependenteException;

import java.time.LocalDate;
import java.time.Period;

public class Dependente extends Pessoa {
    private Parentesco parentesco;

    public Dependente(LocalDate dataNascimento, String cpf, String nome, Parentesco parentesco)
            throws DependenteException {
        super(dataNascimento, cpf, nome);
        this.parentesco = parentesco;

        // Exception para idade do dependente.
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade >= 18){
            throw new DependenteException("O dependente deve ter menos de 18 anos.");
        }

        if (getDataNascimento() == null) {
            throw new DependenteException("Data de nascimento do dependente não pode ser nula.");
        }

        if (parentesco == null) {
            throw new DependenteException(
                    "Parentesco do dependente não pode ser nulo. " + "Valores aceitos: Filho, Sobrinho, Outros.");
        }
    }

    // Getters ↓

    public Parentesco getParentesco() { return parentesco; }



    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }
}
