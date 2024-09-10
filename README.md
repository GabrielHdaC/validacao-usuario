# Projeto de Validação de Dados

Este projeto é uma aplicação Java que realiza a validação de dados como nomes, e-mails, datas e CPF. O objetivo é garantir que os dados inseridos estejam no formato correto e atender a critérios específicos.

## Funcionalidades

- **Validação de Nome**: Verifica se o nome está vazio, contém apenas espaços ou possui caracteres inválidos.
- **Validação de E-mail**: Confirma se o e-mail está no formato correto e se o comprimento do nome do usuário está entre 6 e 30 caracteres.
- **Validação de Data**: Aceita múltiplos formatos de data e verifica se a data está dentro da faixa de idade permitida (entre 18 e 125 anos).
- **Validação de CPF**: Valida o CPF garantindo que ele siga o formato correto e que seja um número válido.

## Tecnologias Utilizadas

- **Java**: JDK 22
- **Versão do Java**: 22.0.1
- **IDE**: IntelliJ IDEA Ultimate


## Requisitos

Certifique-se de ter o JDK 22 instalado para executar este projeto.

## Estrutura do Projeto

- **`src/org/example/Main.java`**: Contém a lógica principal da validação de dados.
- **`src/org/example/Testes.java`**: Contém os testes unitários para validar as funções.
- **`README.md`**: Documento com instruções sobre o projeto.

## Testes

A classe `Testes` contém métodos para testar as seguintes validações:

- `testNome()`: Testa a validação de nomes.
- `testEmail()`: Testa a validação de e-mails.
- `testData()`: Testa a validação de datas.
- `testCPF()`: Testa a validação de CPF.

## Observações

- **Referências**: O código foi baseado nas explicações fornecidas pelos seguintes recursos:
  - [Maxodidily](https://www.youtube.com/@maxodidily)
  - [DevMedia](https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097)
- **Comentários**: O código foi desenvolvido e testado na versão JDK 22 e na IDE IntelliJ IDEA Ultimate.

## Contribuição

https://github.com/AthosGuedes
https://github.com/EvelinPaola

## Licença

Este projeto é licenciado sob a [Licença MIT](LICENSE).
