import java.io.*;
import java.util.Scanner;

public class ListaCircular {
    private Veiculo inicio = null;

    public void inserirVeiculo(String placa, String dia, String horario) {
        Veiculo novo = new Veiculo(placa, dia, horario);
        if (inicio == null) {
            inicio = novo;
            novo.prox = novo;
        } else {
            Veiculo temp = inicio;
            while (temp.prox != inicio) {
                temp = temp.prox;
            }
            temp.prox = novo;
            novo.prox = inicio;
        }
    }

    public void carregarArquivo(String criterio, int tipo) {
        try (BufferedReader br = new BufferedReader(new FileReader("rodizio_de_veiculos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String placa = partes[0];
                    String dia = partes[1];
                    String horario = partes[2];

                    if ((tipo == 1 && dia.equalsIgnoreCase(criterio)) ||
                        (tipo == 2 && placa.endsWith(criterio))) {
                        inserirVeiculo(placa, dia, horario);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void exibirLista() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Veiculo atual = inicio;
        do {
            System.out.println("Placa: " + atual.placa + " | Dia: " + atual.dia + " | Horário: " + atual.horario);
            atual = atual.prox;
        } while (atual != inicio);
    }

    public void navegar() {
        if (inicio == null) return;

        Scanner scanner = new Scanner(System.in);
        Veiculo atual = inicio;
        char comando;

        while (true) {
            System.out.println("\nAtual: " + atual.placa + " | " + atual.dia + " | " + atual.horario);
            System.out.print("Pressione 'n' para o próximo, 'q' para sair: ");
            comando = scanner.next().charAt(0);

            if (comando == 'q') break;
            else if (comando == 'n') atual = atual.prox;
            else System.out.println("Comando inválido!");
        }
    }
}
