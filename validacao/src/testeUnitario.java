public class testeUnitario {
    public static void main(String[] args) {
            // Executa todos os testes definidos nos métodos abaixo
            testNome();
            testEmail();
            testData();
            testCPF();
        }

        // Método para testar a validação de nomes
        public static void testNome() {
            // Testa um nome válido e imprime o resultado
            String resultado = Main.nomeValido("João Silva");
            System.out.println("Teste de nome válido: " + resultado);

            // Testa um nome que contém apenas espaços e imprime o resultado
            resultado = Main.nomeValido(" ");
            System.out.println("Teste de nome vazio ou com espaços: " + resultado);

            // Testa um nome com caracteres inválidos e imprime o resultado
            resultado = Main.nomeValido("João123");
            System.out.println("Teste de nome com caracteres inválidos: " + resultado);
        }

        // Método para testar a validação de e-mails
        public static void testEmail() {
            // Testa um e-mail válido e imprime o resultado
            String resultado = Main.emailValido("exemplo@dominio.com");
            System.out.println("Teste de e-mail válido: " + resultado);

            // Testa um e-mail sem o formato adequado e imprime o resultado
            resultado = Main.emailValido("exemplo");
            System.out.println("Teste de e-mail inválido: " + resultado);
        }

        // Método para testar a validação de datas
        public static void testData() {
            // Testa uma data válida no formato "dd/MM/yyyy" e imprime o resultado
            String resultado = Main.dataValida("15/08/1990");
            System.out.println("Teste de data válida: " + resultado);

            // Testa uma data válida com formato diferente "dd-MM-yyyy" e imprime o resultado
            resultado = Main.dataValida("15-08-1990");
            System.out.println("Teste de data válida com formato diferente: " + resultado);

            // Testa uma data válida sem separadores "ddMMyyyy" e imprime o resultado
            resultado = Main.dataValida("15081990");
            System.out.println("Teste de data válida sem separadores: " + resultado);

            // Testa uma data futura inválida e imprime o resultado
            resultado = Main.dataValida("15/08/2025");
            System.out.println("Teste de data futura inválida: " + resultado);
        }

        // Método para testar a validação de CPF
        public static void testCPF() {
            // Testa um CPF inválido e imprime o resultado
            String resultado = Main.isCPF("123.456.789-09");
            System.out.println("Teste de CPF inválido: " + resultado);

            // Testa um CPF válido e imprime o resultado
            resultado = Main.isCPF("111.444.777-35");
            System.out.println("Teste de CPF válido: " + resultado);
        }
}

