package File;

import Classes.FolhaPagamento;
import Classes.Funcionario;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;

public class OutputFile {

    //Construtor ↓
    public OutputFile(){
    }

    //Metodo que recebe a folha de pagamento e um nome para o arquivo de saída CSV
    public void processarFolha(FolhaPagamento folha, String nomeArquivo){
        Locale padraoBR = new Locale("pt", "BR"); //Aqui garante o uso da virgula.
        // Adicionamos um 'true' na linha 20
        try(PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            //Cria uma instancia de Funcionario.
            Funcionario funcionario = folha.getFuncionario();

            double salarioLiquido = folha.getSalarioLiquido(); // Aqui a função é chamada para alimentar as variáveis DescontoINSS e DescontoIR previamente.

            //Monta toda a estrutura da String.
            String linha = String.format("%s;%s;%.2f;%.2f;%.2f",
                    funcionario.getNome(),
                    funcionario.getCpf(),
                    folha.getDescontoINSS(),
                    folha.getDescontoIR(),
                    salarioLiquido);

            writer.println(linha); //Imprimi no arquivo
            System.out.println("Arquivo CSV criado com Sucesso!");

        } catch (Exception exception) {
            System.err.println("Erro ao processar arquivo CSV, talvez seja problema de permissão de escrita no disco"
                    + exception.getMessage());
        }
    }
}