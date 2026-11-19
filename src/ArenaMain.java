import java.util.Scanner;

public class ArenaMain {
    public static void main(String[] args) {
        Personagem guerreiro = new Guerreiro("Bárbaro");
        Personagem mago = new Mago("Gandolf");
        Personagem arqueiro = new Arqueiro("Arqueiro verde");
        int turnos = 1;

        try (Scanner scanner = new Scanner(System.in)) {
            while (guerreiro.getVida() > 0 && mago.getVida() > 0 && arqueiro.getVida() > 0) {
                System.out.println("\n=== TURNO " + turnos + " ===");
                System.out.println("Escolha com quem atacar:");
                System.out.println(" 1: " + guerreiro.getNome());
                System.out.println(" 2: " + mago.getNome());
                System.out.print(" 3: " + arqueiro.getNome());
                System.out.print("\nOpção: \n");
                System.out.print("Escolha quem atacar:\n ");
                System.out.print("4: ");

                if (!scanner.hasNextInt()) {
                    if (!scanner.hasNext()) {
                        break;
                    }
                    scanner.next();
                    System.out.println("Entrada inválida. Digite 1, 2 ou 3.");
                    continue;
                }
System.out.println("\n");
                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        guerreiro.atacar(mago);
                        break;
                    case 2:
                        mago.atacar(mago);
                        break;
                    default:
                        System.out.println("Opção inválida. Digite 1, 2 ou 3.");
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

