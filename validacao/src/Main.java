import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.Period;

// Código baseado em vídeos e artigos sobre validação de dados em Java

// Versão: jdk22
// IDE utilizada: IntelliJ IDEA Ultimate

public class Main {

    // Método para validar o nome
    public static String nomeValido(String in) {

        // Remove espaços múltiplos internos e espaços no início e no fim do nome
        String nomeCorrigido = in.trim().replaceAll("\\s+", " ");

        // Verifica se o campo está vazio
        if (in.isEmpty()) {
            return "Nome Inválido! Campo vazio.";
        }

        // Verifica se o campo contém apenas espaços
        if (nomeCorrigido.isEmpty()) {
            return "Nome Inválido! Campo preenchido apenas com espaços ou espaço no início ou final do campo.";
        }

        // Verifica se havia espaços duplos no nome
        if (!in.equals(nomeCorrigido)) {
            return "Nome Inválido! Campo preenchido com espaços duplos.";
        }

        // Verifica se o nome contém apenas letras e espaços
        Pattern pattern = Pattern.compile("^[\\p{L} -]*$", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(nomeCorrigido);

        // Se o nome não corresponder ao padrão, retorna mensagem de erro
        if (!matcher.matches()) {
            return "Nome Inválido! Caracteres inválidos.";
        }

        return "Nome Válido!";
    }

    // Método para validar o e-mail
    public static String emailValido(String email) {

        // Verifica se o campo do e-mail está vazio
        if (email.isEmpty()) {
            return "E-mail Inválido! Campo vazio.";
        }

        // Expressão regular para validar e-mail com 6 a 30 caracteres antes do '@'
        String emailRegex = "^[A-Z0-9._-]{6,30}@[A-Z0-9.-]+\\.[A-Z.]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);

        // Se o e-mail não corresponder ao padrão, retorna mensagem de erro
        if (!matcher.matches()){
            return "E-mail Inválido! Formato inválido, tamanho inválido ou caracteres Inválidos.";
        }

        return "E-mail Válido!";
    }

    // Método para validar a data em múltiplos formatos
    public static String dataValida(String date) {
        // Verifica se o campo da data está vazio
        if (date.isEmpty()) {
            return "Data de Nascimento Inválida! Campo vazio.";
        }

        // Define os formatos de data aceitos
        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("ddMMyyyy"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("dd/MM/yy"),
                DateTimeFormatter.ofPattern("ddMMyy"),
                DateTimeFormatter.ofPattern("dd.MM.yy"),
                DateTimeFormatter.ofPattern("dd-MM-yy")
        };

        LocalDate dataNascimento = null;
        // Tenta analisar a data com os diferentes formatos
        for (DateTimeFormatter formatter : formatters) {
            try {
                dataNascimento = LocalDate.parse(date, formatter);
                break;
            } catch (DateTimeParseException e) {
                // Continua tentando os outros formatos se ocorrer exceção
            }
        }

        // Se a data não puder ser analisada, retorna mensagem de erro
        if (dataNascimento == null) {
            return "Data de Nascimento Inválida! Formato de data inválido.";
        }

        // Verifica se a idade está entre 18 e 125 anos
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);

        if (idade.getYears() < 18) {
            return "Idade Inválida! A idade tem que ser maior que 18 anos.";
        }

        if (idade.getYears() > 125) {
            return "Idade Inválida! A idade tem que ser menor que 125 anos.";
        }

        return "Data de Nascimento Válida!";
    }

    // Método para validar CPF
    public static String isCPF(String CPF) {

        // Verifica se o campo do CPF está vazio
        if (CPF.isEmpty()) {
            return "CPF Inválido! Campo vazio.";
        }

        // Remove espaços e caracteres não numéricos do CPF
        String cpfSemCaracteres = CPF.replaceAll("\\D", "");

        // Verifica se o CPF é uma sequência de números iguais ou tem um comprimento inválido
        if (cpfSemCaracteres.equals("00000000000") ||
                cpfSemCaracteres.equals("11111111111") ||
                cpfSemCaracteres.equals("22222222222") || cpfSemCaracteres.equals("33333333333") ||
                cpfSemCaracteres.equals("44444444444") || cpfSemCaracteres.equals("55555555555") ||
                cpfSemCaracteres.equals("66666666666") || cpfSemCaracteres.equals("77777777777") ||
                cpfSemCaracteres.equals("88888888888") || cpfSemCaracteres.equals("99999999999") ||
                (cpfSemCaracteres.length() != 11))
            return "CPF Inválido! O CPF não existe.";

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            // Calcula o primeiro dígito verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = cpfSemCaracteres.charAt(i) - 48; // Converte o i-ésimo caractere do CPF em um número
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // Converte no respectivo caractere numérico

            // Calcula o segundo dígito verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = cpfSemCaracteres.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os dígitos calculados conferem com os dígitos informados
            if (!(dig10 == cpfSemCaracteres.charAt(9)) && !(dig11 == cpfSemCaracteres.charAt(10)))
                return "CPF Inválido! O CPF não existe.";

        } catch (InputMismatchException erro) {
            // Trata exceções durante o cálculo
        }
        return "CPF Válido!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------");

        // Coleta os dados do usuário
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Data de Nascimento: ");
        String data = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("--------------------------");

        // Valida os dados e imprime os resultados
        if (nomeValido(nome).equals("Nome Válido!") && emailValido(email).equals("E-mail Válido!") && dataValida(data).equals("Data de Nascimento Válida!") && isCPF(cpf).equals("CPF Válido!")) {
            System.out.println("Todos os dados Válidos.");
        } else {
            System.out.println(nomeValido(nome));
            System.out.println(emailValido(email));
            System.out.println(dataValida(data));
            System.out.println(isCPF(cpf));
        }

        System.out.println("--------------------------");

        scanner.close();
    }
}