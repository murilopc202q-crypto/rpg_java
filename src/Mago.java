public class Mago extends Personagem {

    private int danoMagico;
    private int defesaMagica;
    private int mana;

    public Mago(String nome) {
         super(nome,-25, 22,45, 25);
         
         this.danoMagico = 25;
         this.defesaMagica = super.getDefesaEspecial();
         this.mana = 20;
    }

    @Override 
    public void receberDano(int  danoBruto) {
        int danoAbsorvido = Math.min(this.defesaMagica, danoBruto);
        this.defesaMagica -= danoAbsorvido;
        int danoRestante = danoBruto - danoAbsorvido;

        if (danoAbsorvido > 0 && this.defesaMagica == 0) {
            System.out.println(this.getNome() + ": Usou toda a defesa mágica para se defender! ");
        }
        if (danoRestante > 0) {
            super.receberDano(danoRestante);
        }
    }

    @Override
    public void receberDanoDeEspinhos(int danoBruto) {
        if (danoBruto <= 0 || this.getVida() <= 0) {
            return;
        }

        int danoAbsorvido = Math.min(this.defesaMagica, danoBruto);
        this.defesaMagica -= danoAbsorvido;
        if (danoAbsorvido > 0) {
            System.out.println(this.getNome() + ": recebeu " + danoAbsorvido
                    + " de dano dos espinhos na defesa mágica!");
        }
        if (danoBruto > danoAbsorvido) {
            super.receberDanoDeEspinhos(danoBruto - danoAbsorvido);
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
            System.out.println(this.getNome() + ": lançou um ataque mágico no " 
                 + alvo.getNome() + " com " + danoSomado + " de dano!");
            alvo.receberDano(danoSomado, this);
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
