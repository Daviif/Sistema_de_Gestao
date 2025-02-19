public class Usuario extends Pessoa{

    public Usuario(String nome, String rua, String cidade){
        super(nome, rua, cidade);
    }

    @Override
    public String toString(){
        return getNome() + "(" + getEndereco() + ")";
    }

}
