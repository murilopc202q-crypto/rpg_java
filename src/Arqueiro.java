public class Arqueiro extends Personagem{
        private int flexa;
        private int ataqueComArco;
        
    public Arqueiro(String nome) {
        super(nome,0,23,25,0);

        this.flexa = 20;
        this.ataqueComArco = 20;
    }


    @Override
    public void receberDano(int danoBruto) {
        super.receberDano(danoBruto);
    }


    @Override
    public void atacar(Personagem alvo) {
        if(this.getVida() <= 0 || alvo.getVida() <= 0 || alvo == this) {
            return;
        }
        if(this.flexa > 0) {
           this.flexa --;
            System.out.println(this.getNome() + ": Atacou com flechas o " + alvo.getNome() 
                + " causando " + this.getAtaque() + " de dano!");
            alvo.receberDano(this.getAtaque(), this);
        } else {
            System.out.println(this.getNome() + ": está sem flexas e ataca com arco o " 
                + alvo.getNome() + "causando " + this.ataqueComArco + " de dano!");
                alvo.receberDano(this.ataqueComArco, this);
        } 
    }


    @Override
    public String getResumoAtributosProprios() {
    return String.format("flechas=%d; ataqueComArco=%d",
            flexa, ataqueComArco);
    }
}