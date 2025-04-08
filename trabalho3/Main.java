import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Rodízio de Veículos ===");
        System.out.println("Filtrar por:");
        System.out.println("1. Dia da semana");
        System.out.println("2. Final da placa");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        String criterio;
        if (opcao == 1) {
            System.out.print("Digite o dia da semana: ");
            criterio = scanner.nextLine();
        } else if (opcao == 2) {
            System.out.print("Digite o dígito final da placa: ");
            criterio = scanner.nextLine();
        } else {
            System.out.println("Opção inválida!");
            return;
        }

        lista.carregarArquivo(criterio, opcao);
        lista.exibirLista();
        lista.navegar();

        System.out.println("Encerrando o programa.");
    }
}
