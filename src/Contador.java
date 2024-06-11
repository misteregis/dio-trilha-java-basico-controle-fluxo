import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int primeiroNumero = Integer.parseInt(solicitarInformacao(scanner, "Digite o primeiro número:"));
            int segundoNumero = Integer.parseInt(solicitarInformacao(scanner, "Digite o segundo número:"));

            if (primeiroNumero >= segundoNumero) {
                throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
            }

            contar(primeiroNumero, segundoNumero);
        } catch (ParametrosInvalidosException e) {
            limparConsole();

            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void contar(int primeiroNumero, int segundoNumero) throws ParametrosInvalidosException {
        limparConsole();

        for (int i = 1; i <= (segundoNumero - primeiroNumero); i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }

    private static String solicitarInformacao(Scanner scanner, String message) {
        limparConsole();

        System.out.println(message);

        return scanner.nextLine();
    }

    private static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
