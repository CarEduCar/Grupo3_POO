# Grupo 3 - Projeto Final de POO Java

## Integrantes
- Carlos Eduardo Carvalho
- Rafael Albino
- Caio Dias
- Marcos Paulo Mello
- Wallace Ildefonso
- Breno França

## Sobre o projeto
Sistema de folha de pagamento desenvolvido em Java com orientação a objetos. O sistema recebe um arquivo CSV contendo dados de funcionários e seus dependentes, realiza o cálculo automático dos descontos de INSS e Imposto de Renda com base em faixas de salário, armazena os dados em um banco PostgreSQL e gera um relatório de saída em CSV com todas as informações do funcionário.

## Funcionalidades e responsáveis

**Banco de dados** - Carlos Eduardo Carvalho  
Criação do schema, tabelas e configuração do PostgreSQL.

**Modelagem das classes** - Caio Dias e Rafael Albino  
Classes Pessoa, Funcionario, Dependente e FolhaPagamento com herança e encapsulamento.

**Leitura do CSV de entrada** - Rafael Albino e Breno França  
Leitura do arquivo de entrada e instanciação dos objetos.

**Validações** - Rafael Albino, Caio Dias e Marcos Paulo Mello  
Tratamento de erros e validação dos dados lidos.

**Cálculo de INSS, IR e salário líquido** - Marcos Paulo Mello  
Cálculo dos descontos por faixas progressivas e salário líquido final.

**Classe Main** - Wallace Ildefonso  
Fluxo principal do sistema e conexão com o banco.

**Geração do CSV de saída** - Rafael Albino  
Escrita do relatório final com os dados processados.
