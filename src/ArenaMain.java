import java.util.Scanner;

public class ArenaMain {
    public static void main(String[] args) {
        Personagem guerreiro = new Guerreiro("Bárbaro");
        Personagem mago = new Mago("Gandolf");
        int turnos = 1;

        try (Scanner scanner = new Scanner(System.in)) {
            while (guerreiro.getVida() > 0 && mago.getVida() > 0) {
                System.out.println("\n=== TURNO " + turnos + " ===");
                System.out.println("Escolha sua ação:");
                System.out.println(" 1: Atacar!");
                System.out.println(" 2: Se curar");
                System.out.print("Opção:  " );

                if (!scanner.hasNextInt()) {
                    if (!scanner.hasNext()) {
                        break;
                    }
                    scanner.next();
                    System.out.println("Entrada inválida. Digite 1, 2 ou 3.");
                    continue;
                }

                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        guerreiro.atacar(mago);
                        break;
                    case 2:
                        guerreiro.curar(30);
                        break;
                    default:
                        System.out.println("Opção inválida. Digite 1, 2 ou 3.");
                        continue;
                }

                if (mago.getVida() > 0) {
                    mago.atacar(guerreiro);
                }
                System.out.println("\n-- Situação atual --\n");
                guerreiro.mostraDados();
                System.out.println("--------------------------");
                mago.mostraDados();
                turnos++;
            }
        }
        
        
        System.out.println("\n--- FIM DA BATALHA ---\n");
        if (guerreiro.getVida() <= 0) {
            System.out.println(mago.getNome() + " é o vencedor!");
        } else if (mago.getVida() <= 0) {
            System.out.println(guerreiro.getNome() + " é o vencedor!");
        } else {
            System.out.println("A batalha foi interrompida antes de haver um vencedor.");
        }
    }
}

