public class Goblin extends Personagem {
    private static final int BONUS_ATAQUE_SURPRESA = 15;
    private boolean ataqueSurpresaDisponivel = true;

    public Goblin(String nome) {
        super(nome, -10, 24, 48, 0);
    }

    @Override
    public void atacar(Personagem alvo) {
        if (this.getVida() <= 0 || alvo == null || alvo.getVida() <= 0 || alvo == this) {
            return;
        }

        if (this.ataqueSurpresaDisponivel) {
            this.ataqueSurpresaDisponivel = false;
            int dano = this.getAtaque() + BONUS_ATAQUE_SURPRESA;
            System.out.println(this.getNome() + ": realizou um ataque surpresa contra "
                    + alvo.getNome() + " causando " + dano + " de dano!");
            alvo.receberDano(dano, this);
            return;
        }

        super.atacar(alvo);
    }

    @Override
    public void mostraDados() {
        super.mostraDados();
        System.out.println("Ataque surpresa disponível: " + this.ataqueSurpresaDisponivel);
    }
}
