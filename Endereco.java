public class Endereco{
    private String rua;
    private String cidade;

    public Endereco(String rua, String cidade){
        this.rua = rua;
        this.cidade = cidade;
    }

    public String getRua{
        return rua;
    }

    public String getCidade{
        return cidade;
    }

    @Override
    public String toString(){
        return "Endereço:\nRua: " + this.getRua() + ", Cidade: " + this.getCidade();
    }
}