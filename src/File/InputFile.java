package File;

import Classes.Dependente;
import Classes.Funcionario;
import Classes.Parentesco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputFile{

    public void leitorCSV (String caminho) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(caminho);
        String linha;
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("yyyyMMdd");

        while((linha = br.readLine()) != null){
            String[] particoesFuncionario = linha.split(";");
            String nomeF = particoesFuncionario[0];
            String cpfF = particoesFuncionario[1];
            String dataStrF = particoesFuncionario[2];
            LocalDate data_nascF = LocalDate.parse(dataStrF, formatarData);
            Double salario = Double.parseDouble(particoesFuncionario[3]);

            while(!((linha = br.readLine()).isEmpty())){
                String[] particoesDependente = linha.split(";");
                String nomeD = particoesFuncionario[0];
                String cpfD = particoesFuncionario[1];
                String dataStrD = particoesFuncionario[2];
                LocalDate data_nascD = LocalDate.parse(dataStrD, formatarData);
                String parente = particoesDependente[3];
            }
        }
    }
}
