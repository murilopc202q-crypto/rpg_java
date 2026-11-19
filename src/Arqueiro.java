public class Arqueiro extends Personagem{
        private int flexa;
        private int ataqueComArco;
        
    public Arqueiro(String nome) {
        super(nome,0,15,20);

        this.flexa = 20;
        this.ataqueComArco = 15;
    }

    @Override
    public void atacar(Personagem alvo) {
        if(this.getVida() <= 0 || alvo.getVida() <= 0 || alvo == this) {
            return;
        }
        if(flexa >= 4) {
            flexa -= 4;
            System.out.println(this.getNome() + ": Atacou com flechas o " + alvo.getNome() + " causando " + this.getAtaque() + " de dano!");
            alvo.receberDano(this.getAtaque());
        } else {
            System.out.println(this.getNome() + ": está sem flexas e ataca com arco o " + alvo.getNome() + "causando " + this.ataqueComArco + " de dano!");
                alvo.receberDano(ataqueComArco);
        } 
    }


}
