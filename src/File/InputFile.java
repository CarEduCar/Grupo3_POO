package File;

import Classes.Dependente;
import Classes.Funcionario;
import Classes.Parentesco;
import Exceptions.DependenteException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InputFile{

    public List<Funcionario> leitorCSV (String caminho) throws IOException, DependenteException {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("yyyyMMdd");
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        while((linha = br.readLine()) != null){
            String[] particoesFuncionario = linha.split(";");
            String nomeF = particoesFuncionario[0];
            String cpfF = particoesFuncionario[1];
            String dataStrF = particoesFuncionario[2];
            LocalDate data_nascF = LocalDate.parse(dataStrF, formatarData);
            Double salario = Double.parseDouble(particoesFuncionario[3]);

            Funcionario funcionario = new Funcionario(data_nascF, cpfF,nomeF, salario);
            listaFuncionarios.add(funcionario);

            while(true){
                linha = br.readLine();
                if (linha == null || linha.trim().isEmpty() ){
                    break;
                }

                String[] particoesDependente = linha.split(";");
                String nomeD = particoesDependente[0];
                String cpfD = particoesDependente[1];
                String dataStrD = particoesDependente[2];
                LocalDate data_nascD = LocalDate.parse(dataStrD, formatarData);
                String parente = particoesDependente[3].trim().toUpperCase();
                Parentesco parentesco = Parentesco.valueOf(parente);

                Dependente dependente= new Dependente(data_nascD, cpfD, nomeD, parentesco);
                funcionario.adicionarDP(dependente);
            }
        }
        return listaFuncionarios;
    }
}
