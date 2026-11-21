import java.util.Scanner;

public class ArenaMain {
    public static void main(String[] args) {
        Personagem[] herois = {
            new Guerreiro("Barbaro"),
            new Mago("Gandolf"),
            new Arqueiro("Legolas")
        };
        Personagem[] inimigos = {
            new Orc("Azog"),
            new Goblin("Snaga"),
        };
         int turnos = 1;

        try (Scanner scanner = new Scanner(System.in)) {

            mostrarDadosColunas(herois, inimigos);

            while (temPersonagensVivos(herois) && temPersonagensVivos(inimigos)) {
                System.out.println("\n=== TURNO " + turnos + " ===");
                System.out.println("\n--- Escolha com quem atacar ---");
                for(int i = 0; i < herois.length; i++) {
                    System.out.println(i + " - " + herois[i].getNome());
                }

                System.out.println("Opção: ");
                if (!scanner.hasNextInt()) {
                    if (!scanner.hasNext()) {
                        break;
                    }
                    scanner.next();
                    System.out.println("Entrada inválida. Digite 0, 1 ou 2.");
                    continue;
                }

                int indiceHeroi = scanner.nextInt();
                if (indiceHeroi < 0 || indiceHeroi >= herois.length
                        || herois[indiceHeroi].getVida() <= 0) {
                    System.out.println("Herói inválido ou derrotado.");
                    continue;
                }

                System.out.print("\n --- Escolha quem atacar ---\n ");
                for (int i = 0; i < inimigos.length; i++) {
                    System.out.println(i + " - " + inimigos[i].getNome());
                }
                System.out.println("Opção: ");

                if (!scanner.hasNextInt()) {
                    if (!scanner.hasNext()) {
                        break;
                    }
                    scanner.next();
                    System.out.println("Entrada inválida. Digite um número da lista.");
                    continue;
                }

                int indiceInimigo = scanner.nextInt();
                if (indiceInimigo < 0 || indiceInimigo >= inimigos.length
                        || inimigos[indiceInimigo].getVida() <= 0) {
                    System.out.println("Inimigo inválido ou derrotado.");
                    continue;
                }

                Personagem heroiEscolhido = herois[indiceHeroi];
                Personagem inimigoEscolhido = inimigos[indiceInimigo];

                heroiEscolhido.atacar(inimigoEscolhido);
                if (temPersonagensVivos(inimigos)) {
                    inimigoEscolhido.atacar(heroiEscolhido);
                }

                System.out.println("\n-- Situação atual --\n");
                mostrarDadosColunas(herois, inimigos);
                turnos++;
            }
        }

        boolean heroisVivos = temPersonagensVivos(herois);
        boolean inimigosVivos = temPersonagensVivos(inimigos);
        System.out.println("\n--- FIM DA BATALHA ---");
        if (heroisVivos && !inimigosVivos) {
            System.out.println("Os heróis venceram a batalha!");
        } else if (!heroisVivos && inimigosVivos) {
            System.out.println("Os inimigos venceram a batalha!");
        } else if (heroisVivos) {
            System.out.println("A batalha foi interrompida antes de haver um vencedor.");
        } else {
            System.out.println("A batalha terminou em empate.");
        }
    }

    
    private static boolean temPersonagensVivos(Personagem[] personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.getVida() > 0) {
                return true;
            }
        }
        return false;
    }


    private static void mostrarDadosColunas(
            Personagem[] herois, Personagem[] inimigos) {
        System.out.printf("%-64s | %-64s%n", "\nHERÓIS", " INIMIGOS");

        int quantidade = Math.max(herois.length, inimigos.length);
        for (int i = 0; i < quantidade; i++) {
            Personagem heroi = i < herois.length ? herois[i] : null;
            Personagem inimigo = i < inimigos.length ? inimigos[i] : null;

            imprimirLinha(descreverPersonagem("Herói", i, heroi),
                    descreverPersonagem("Inimigo", i, inimigo));
            imprimirAtributos("Base", heroi, inimigo, false);
            imprimirAtributos("Próprios", heroi, inimigo, true);
            imprimirLinha("--------------------------------", "--------------------------------");
        }
    }

    private static String descreverPersonagem(
            String equipe, int indice, Personagem personagem) {
        if (personagem == null) {
            return "";
        }
        return equipe + " " + (indice + 1) + ": "
                + personagem.getNome() + " (" + personagem.getClass().getSimpleName() + ")";
    }

    private static void imprimirAtributos(
            String titulo, Personagem heroi, Personagem inimigo, boolean proprios) {
        String[] atributosHeroi = obterAtributos(heroi, proprios);
        String[] atributosInimigo = obterAtributos(inimigo, proprios);
        int quantidade = Math.max(atributosHeroi.length, atributosInimigo.length);

        for (int i = 0; i < quantidade; i++) {
            String atributoHeroi = i < atributosHeroi.length
                    ? titulo + ": " + atributosHeroi[i] : "";
            String atributoInimigo = i < atributosInimigo.length
                    ? titulo + ": " + atributosInimigo[i] : "";
            imprimirLinha(atributoHeroi, atributoInimigo);
        }
    }

    private static String[] obterAtributos(Personagem personagem, boolean proprios) {
        if (personagem == null) {
            return new String[0];
        }

        String resumo = proprios
                ? personagem.getResumoAtributosProprios()
                : personagem.getResumoAtributosBase();
        return resumo.split("; ");
    }

    private static void imprimirLinha(String herois, String inimigos) {
        System.out.printf("%-64s | %-64s%n", herois, inimigos);
    }
}