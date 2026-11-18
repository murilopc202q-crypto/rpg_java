public class Mago extends Personagem {
    private static final int DEFESA_BASE = 30; 

    private int danoMagico;
    private int defesaMagica;
    private int mana;

    public Mago(String nome) {
         super(nome, -30, 20, DEFESA_BASE);
         
         this.danoMagico = 30;
         this.defesaMagica = 25;
         this.mana = 20;
    }

    @Override 
    public void receberDano(int danoBruto) {
        int danoAbsorvido = Math.min(this.defesaMagica, danoBruto);
        this.defesaMagica -= danoAbsorvido;
        int danoRestante = danoBruto - danoAbsorvido;

        if (danoAbsorvido > 0 && this.defesaMagica == 0) {
            System.out.println(this.getNome() + ": A defesa mágica se esgotou! ");
        }
        if (danoRestante > 0) {
            super.receberDano(danoRestante);
        }
    }


    @Override
    public void atacar(Personagem alvo) {
      if(this.getVida() <= 0 || alvo.getVida() <= 0 || alvo == this) {
          return;
     }
      if(mana >= 10) {
            mana -=10;
            int danoSomado = (this.danoMagico + this.getAtaque());
            System.out.println(this.getNome() + ": lançou um ataque mágico no " + alvo.getNome() + "!");
            alvo.receberDano(danoSomado);
      } else {
            super.atacar(alvo);
      }      
    }


    @Override 
    public void mostraDados(){
        super.mostraDados();
        System.out.println("dano mágico: " + danoMagico);
        System.out.println("defesa mágica: " + defesaMagica);
        System.out.println("mana: " + mana);
    }
   
}
