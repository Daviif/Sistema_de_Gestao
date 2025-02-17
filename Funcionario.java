public class Funcionario extends Pessoa{
    private String cargo;
    private double salario;


    public Funcionario(String nome, String rua, String cidade){
        super(nome, rua, cidade);
    }

    public String getCargo(){
        return cargo;
    }

    public double getSalario(){
        return salario;
    }


    public void definirPrazoReserva(){

    }
}