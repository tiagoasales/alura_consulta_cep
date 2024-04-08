public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int ano;
    
    public Titulo(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }

   @Override
   public String toString() {
       // TODO Auto-generated method stub
       return "Titulo: " + this.nome + " (" + this.ano + ")";
   }
}
