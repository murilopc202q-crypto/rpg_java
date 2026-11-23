public class Arqueiro extends Personagem{
        private int flecha;
        private int ataqueComArco;
        
    public Arqueiro(String nome) {
        super(nome,0,23,25,0);

        this.flecha = 5;
        this.ataqueComArco = 20;
    }


        @Override
    public void atacar(Personagem alvo) {
        if(this.getVida() <= 0 || alvo.getVida() <= 0 || alvo == this) {
            return;
        }
        if(this.flecha > 0) {
           this.flecha --;
            System.out.println(this.getNome() + ": Atacou com flechas o " + alvo.getNome() 
                + " causando " + this.getAtaque() + " de dano!");
            alvo.receberDano(this.getAtaque(), this);
        } else {
            System.out.println(this.getNome() + ": está sem flechas e ataca com arco o " 
                + alvo.getNome() + "causando " + this.ataqueComArco + " de dano!");
                alvo.receberDano(this.ataqueComArco, this);
        } 
    }


    @Override
    public void receberDano(int danoBruto) {
        if(this.flecha > 0 && danoBruto > 0 ) {
            System.out.println(this.getNome() + ": manteve distância e evitou o ataque!");
            return;
        } 
        super.receberDano(danoBruto);  
    }


    @Override 
    public void receberDano(int danoBruto, Personagem atacante) {
        receberDano(danoBruto);
    }


    @Override 
    public void receberDanoDeEspinhos(int danoBruto) {
        if(this.flecha > 0 && danoBruto > 0) {
            System.out.println(getNome() + ": manteve distância e evitou os espinhos!");
            return;
        }
        super.receberDanoDeEspinhos(danoBruto);
    }


    @Override
    public String getResumoAtributosProprios() {
    return String.format("flechas=%d; ataqueComArco=%d",
            flecha, ataqueComArco);
    }
}