public class Orc extends Personagem {
        private int escudoComEspinhos;
        private int ataquePesado;

    public Orc(String nome) {
        super(nome,10,27,18);

        this.escudoComEspinhos = 15;
        this.ataquePesado = 20;
    } 

    public void receberDano(int danoBruto) {}
    
    
    public void atacar(Personagem alvo) {}


    public void mostraDados(){
        super.mostraDados();
        System.out.println("escudo com espinhos: " + this.escudoComEspinhos);
        System.out.println("ataque pesado: " + this.ataquePesado);
    }

}
