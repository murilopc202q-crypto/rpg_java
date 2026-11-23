public class Orc extends Personagem {
        private int espinhosNoEscudo;
        private int ataquePesado;

    public Orc(String nome) {
        super(nome,10,27,30,0);

        this.espinhosNoEscudo = 15;
        this.ataquePesado = 20;
    } 


        @Override
    public void atacar(Personagem alvo) {
        if(this.getVida() <= 0 || alvo.getVida() <= 0 || alvo == this) {
            return;
        }
        
        int danoSomado = this.ataquePesado + this.getAtaque();
        System.out.println(this.getNome() + ": atacou com ataque de " + danoSomado +  
            " o " + alvo.getNome());
        alvo.receberDano(danoSomado, this);
    }


    @Override
    public void receberDano(int danoBruto, Personagem atacante) {
        super.receberDano(danoBruto);
        if (danoBruto <= 0 || this.espinhosNoEscudo <= 0) {
            return;
        }

        this.espinhosNoEscudo = Math.max(0, this.espinhosNoEscudo - 5);
        int danoEspinhos = this.espinhosNoEscudo;
        if (danoEspinhos <= 0) {
            System.out.println(this.getNome() + ": os espinhos do escudo se desgastaram.");
            return;
        }
        if (atacante == null || atacante == this || this.getVida() <= 0 || atacante.getVida() <= 0) {
            return;
        }

        System.out.println(this.getNome() + ": os espinhos do escudo revidam com "
                + danoEspinhos + " de dano!");
        atacante.receberDanoDeEspinhos(danoEspinhos);
    }
    

    @Override
    public String getResumoAtributosProprios() {
    return String.format("espinhosNoEscudo=%d; ataquePesado=%d",
            espinhosNoEscudo, ataquePesado);
    }
}
