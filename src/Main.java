import BD.BancoDeDados;
import Classes.FolhaPagamento;
import Classes.Funcionario;
import Classes.Dependente;
import File.InputFile;
import File.OutputFile;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        InputFile leitor = new InputFile();
        OutputFile gravador = new OutputFile();

        // 1. Início: Pedir nomes dos arquivos via console
        System.out.println("===== SISTEMA DE FOLHA DE PAGAMENTO =====");
        System.out.print("Digite o nome do arquivo de entrada: ");
        String caminhoInput = teclado.nextLine();

        System.out.print("Digite o nome do arquivo de saída: ");
        String caminhoOutput = teclado.nextLine();

        // Senha do banco
        System.out.print("Digite a senha do banco de dados: ");
        String senhaBD = teclado.nextLine();

        Connection conexao = null;
        BancoDeDados bd = null;

        try {
            // 2. Conectar ao Banco de Dados
            // Usando um objeto temporário para pegar a conexão
            BancoDeDados helper = new BancoDeDados(null);
            conexao = helper.loginBD(senhaBD);

            if (conexao == null) {
                return;
            }

            bd = new BancoDeDados(conexao);
            System.out.println("Conexão com o banco estabelecida!");

            // 3. Ler o arquivo de entrada
            System.out.println("Lendo arquivo de entrada...");
            // Variavel com "s" pra diferenciar da classe
            List<Funcionario> funcionarios = leitor.leitorCSV(caminhoInput);

            // 4. Processamento Principal
            for (Funcionario f : funcionarios) {
                try {
                    // 4a. Inserir Funcionário no Banco
                    bd.inserirFuncionario(f);

                    // 4b. Inserir Dependentes no Banco
                    for (Dependente d : f.getDependente()) {
                        bd.inserirDependente(f, d);
                    }

                    // 4c. Gerar Folha de Pagamento
                    FolhaPagamento folha = new FolhaPagamento(f, java.time.LocalDate.now());

                    // 4d. Exportar para arquivo de saída
                    gravador.processarFolha(folha, caminhoOutput);

                    // 4e. Salvar Folha no Banco de Dados
                    bd.criarFolhaPagamento(folha);

                    System.out.println("Processado: " + f.getNome());

                } catch (Exception e) {
                    System.err.println("Erro ao processar o funcionário " + f.getNome() + ": " + e.getMessage());
                }
            }

            System.out.println("\nProcessamento concluído com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro inesperado no fluxo principal: " + e.getMessage());
        } finally {
            // 5. Fechar recursos
            try {
                if (bd != null) bd.fecharBD();
                teclado.close();
            } catch (Exception e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}