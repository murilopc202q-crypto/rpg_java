public class Guerreiro extends Personagem{ 
    private int armadura; 
    private int furia;
    private int danoFuria;

    public Guerreiro(String nome) {
        super(nome, 30, 35,50,20);

        this.armadura = super.getDefesaEspecial();
        this.furia = 20;
        this.danoFuria = 24;
    }

    
        @Override
    public void atacar(Personagem alvo) {
        if(this.getVida() <= 0 || alvo.getVida() <= 0 || alvo == this) {
            return;
        }
        if(furia >= 10) {
            furia -= 10;
            int danoSomado = (this.getAtaque() + this.danoFuria);
            System.out.println(this.getNome() + ": Atacou com fúria o " + alvo.getNome() 
                + " causando " + danoSomado + " de dano!");
            alvo.receberDano(danoSomado, this);
        } else {
           super.atacar(alvo);
        }
    }


    @Override
    public void receberDano(int danoBruto) {
        int danoAbsorvido = Math.min(this.armadura, danoBruto);
        this.armadura -= danoAbsorvido;
        int danoRestante = (danoBruto - danoAbsorvido);

        if(danoAbsorvido > 0 && this.armadura == 0) {
            System.out.println(this.getNome() + ": está sem armadura!");
        }
        if(danoRestante > 0) {
            super.receberDano(danoRestante);
        }  
    }

    
    @Override
    public void receberDanoDeEspinhos(int danoBruto) {
        if (danoBruto <= 0 || this.getVida() <= 0) {
            return;
        }

        int danoAbsorvido = Math.min(this.armadura, danoBruto);
        this.armadura -= danoAbsorvido;
        if (danoAbsorvido > 0) {
            System.out.println(this.getNome() + ": recebeu " + danoAbsorvido
                    + " de dano dos espinhos na armadura!");
        }
        if (danoBruto > danoAbsorvido) {
            super.receberDanoDeEspinhos(danoBruto - danoAbsorvido);
        }
    }


    @Override
    public String getResumoAtributosProprios() {
    return String.format("armadura=%d; furia=%d; danoFuria=%d",
              armadura, furia, danoFuria);
    }
}