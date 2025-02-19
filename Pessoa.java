
public class Pessoa{

    private String nome;
    private Endereco endereco;

    public Pessoa(String nome, String rua, String cidade){
        this.nome = nome;
        this.endereco = new Endereco (rua, cidade);
    }

    public String getNome(){
        return nome;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    @Override
    public String toString(){
        return this.getNome() + "Endereco: " + this.getEndereco();
    }

}