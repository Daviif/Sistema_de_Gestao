public class Funcionario extends Pessoa{
    private String cargo;


    public Funcionario(String nome, String cargo, String rua, String cidade){
        super(nome, rua, cidade);
        this.cargo = cargo;
    }

    public String getCargo(){
        return cargo;
    }

    public void definirPrazoReserva(){

    }

    @Override
    public String toString(){
        return getNome() + "(Cargo: " + getCargo() + ", " + getEndereco() + ")";
                
    }
}