import java.util.Scanner;

public class ArenaMain {
    public static void main(String[] args) {
        Personagem guerreiro = new Guerreiro("Bárbaro");
        Personagem mago = new Mago("Gandolf");
        Personagem arqueiro = new Arqueiro("Arqueiro verde");
        /*instanciar os inimigos - quando tiver pronto */

        int turnos = 1;

        try (Scanner scanner = new Scanner(System.in)) {
            while (guerreiro.getVida() > 0 && mago.getVida() > 0 && arqueiro.getVida() > 0) {
                System.out.println("\n=== TURNO " + turnos + " ===");
                System.out.println("Escolha com quem atacar:");

                int escolha1 = scanner.nextInt();
                System.out.print("Escolha quem atacar:\n ");

                int escolha2 = scanner.nextInt();
                
                if (!scanner.hasNextInt()) {
                    if (!scanner.hasNext()) {
                        break;
                    }
                    scanner.next();
                    System.out.println("Entrada inválida. Digite 1, 2 ou 3.");                 
                    continue;
                }
             
                System.out.println("\n-- Situação atual --\n");
                guerreiro.mostraDados();
                System.out.println("--------------------------");
                mago.mostraDados();
                System.out.print("---------------------------");
                arqueiro.mostraDados();
                System.out.print("\n");
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

