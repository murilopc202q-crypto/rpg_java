public abstract class Personagem {
    private static final int VIDA_BASE = 100;
    private static final int MAX_CURAS = 3;
    private final int vidaMaxima;
    private final int defesaBase = 0;

      private String nome;
      private int  vida;
      private int  ataque;
      private int  defesa;
      private int  defesaEspecial;
      private int curasUsadas;

     
      public Personagem(String nome, int bonusVida, int ataque, int defesa, int defesaEspecial){
            if(nome == null) {
                throw new IllegalArgumentException("Nome não pode ser vazio.");
            }
            if(ataque <= 0 || defesa <= 0 || defesaEspecial < 0) {
                throw new IllegalArgumentException("Ataque e defesa não podem ser negativos.");
            }

            this.nome = nome;
            this.vidaMaxima = Math.min(200, bonusVida + VIDA_BASE);
            this.vida = this.vidaMaxima;
            this.ataque = ataque;
            this.defesa = Math.min(100, defesaBase + defesa);
            this.defesaEspecial = defesaEspecial;
      }

      public String getNome(){
        return this.nome;
      }
      public int  getVida(){
        return this.vida; 
      }
      public int getAtaque(){
        return this.ataque;
      }
      public int getDefesa(){
        return this.defesa;
      }
      public int getDefesaEspecial(){
        return this.defesaEspecial;
      }

     
    public void receberDano(int danoBruto){
        int danoAbsorvido = Math.min(danoBruto, this.defesa);
        this.defesa -= danoAbsorvido; 

        if(this.defesa == 0){
            System.out.println(this.nome + ": Está sem defesa!" );
        }

        int danoNaVida = (danoBruto -  danoAbsorvido);
        this.vida = Math.max(0,this.vida - danoNaVida);   

        System.out.println( this.nome + ": recebeu " + danoNaVida + " de dano do ataque! ");

        if( this.vida == 0) {
            System.out.println( this.nome + ": Está morto! ");
        }
    }


    public void atacar(Personagem alvo){
            if(this.vida <= 0 || alvo.vida <= 0 || alvo == this) {
                return;
            }
        System.out.println(this.nome + ": atacou " + alvo.nome + " com " + this.ataque + " de ataque!");
        alvo.receberDano(this.ataque);
    }

    
    public void curar(int quantidade){
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de cura deve ser positiva.");
        }
        if (this.vida <= 0) {
           System.out.println(this.nome + ": não pode ser curado porque está derrotado.");
           return;
        }
        if (this.curasUsadas >= MAX_CURAS) {
            System.out.println(this.nome + ": atingiu o limite de " + MAX_CURAS + " curas.");
            return;
        }
        int vidaAnterior = this.vida;
        this.vida += Math.min(quantidade, this.vidaMaxima - this.vida);
        this.curasUsadas++;

        int vidaRecuperada = this.vida - vidaAnterior;
        System.out.println(this.nome + ": recuperou " + vidaRecuperada + " pontos de vida.");
    }

    public void mostraDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Defesa: " + this.defesa);
    }
}
