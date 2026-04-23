import Classes.FolhaPagamento;
import Classes.Funcionario;
import File.OutputFile;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Cria um funcionário (Chamada de teste)
        Funcionario funcionario1 = new Funcionario(LocalDate.of(1990,5,5), "12345678911",
                "Rafael", 5000.0);

        //Cria uma folha
        FolhaPagamento folhaPagamento = new FolhaPagamento(funcionario1, LocalDate.now());

        //Cria o Arquivo de Saída.
        OutputFile outputFile = new OutputFile();
        outputFile.processarFolha(folhaPagamento,"ArquivoSaída.CSV");

    }
}