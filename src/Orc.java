public class Orc extends Personagem {
        private int espinhosNoEscudo;
        private int ataquePesado;

    public Orc(String nome) {
        super(nome,10,27,30,0);

        this.espinhosNoEscudo = 15;
        this.ataquePesado = 20;
    } 


    @Override
    public void receberDano(int danoBruto) {
        int danoAbsorvido = Math.min(this.getDefesa(), danoBruto);
    }
    
    @Override
    public void atacar(Personagem alvo) {/*aqui dentro vai a lógica de poder atacar o arqueiro*/}

    @Override 
    public void mostraDados(){
        super.mostraDados();
        System.out.println("escudo com espinhos: " + this.espinhosNoEscudo);
        System.out.println("ataque pesado: " + this.ataquePesado);
    }

}
