import java.util.Random;
import java.util.Scanner;

public class MergeSortParalelo {
    
    
static Scanner sc = new Scanner(System.in);
    static volatile boolean faltouMemoria = false;
 
    // rode com: java -Xmx8G MergeSortParalelo
    public static void main(String[] args) {
        try {
            // ===== Bloco 1: Tamanho limite do vetor =====
            int limite = calcularLimite();
 
            // ===== Bloco 2: Entrada de dados =====
            int tamanho = lerInt("\nQuantos elementos no vetor? (máx. " + String.format("%,d", limite) + "): ", 1, limite);
            int opcao = lerInt("1 - Digitar os valores | 2 - Gerar aleatoriamente: ", 1, 2);
 
            byte[] vetor = new byte[tamanho];
            if (opcao == 1) {
                for (int i = 0; i < tamanho; i++) {
                    vetor[i] = (byte) lerInt("Elemento " + i + " (-128 a 127): ", -128, 127);
                }
            } else {
                System.out.println("[LOG] Gerando valores aleatórios...");
                new Random().nextBytes(vetor); // valores de -128 a 127
            }
 
            // ===== Bloco 3: Ordenação =====
            int modo = lerInt("Modo: 1 - Paralelo | 2 - Sequencial | 3 - Ambos (comparar): ", 1, 3);
            byte[] vetorFinal = null;
            long tempoSeq = -1;
            long tempoPar = -1;
}

static int calcularLimite() {
        System.out.println("Estimando o maior tamanho possível de vetor em Java...");
        long inicio = System.currentTimeMillis();
 
        int tamanho = 1_000_000; // começa com 1 milhão
        int ultimoBemSucedido = 0;
 
        while (true) {
            try {
                byte[] vetor = new byte[tamanho];
                ultimoBemSucedido = tamanho;
                vetor = null; // libera
                System.gc();
 
                // aumenta o tamanho em 50% para a próxima tentativa
                if (tamanho > Integer.MAX_VALUE / 3 * 2) break;
 
                tamanho /= 2;
                tamanho *= 3;
 
                System.out.printf("Alocado com sucesso: %,d elementos%n", ultimoBemSucedido);
            } catch (OutOfMemoryError e) {
                System.out.printf("Falhou em %,d elementos%n", tamanho);
                break;
            }
        }
 
        long fim = System.currentTimeMillis();
        System.out.println("\nMaior vetor que coube (aproximadamente): " +
                String.format("%,d", ultimoBemSucedido));
        System.out.printf("Memória estimada: %.2f MB%n",
                ultimoBemSucedido * 1.0 / (1024 * 1024));
        System.out.printf("Tempo total: %.2f segundos%n", (fim - inicio) / 1000.0);
 
        return ultimoBemSucedido;
    }
}