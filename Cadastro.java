import java.util.Scanner;

public class Cadastro {
    public static Usuario CadastrarUsuario(){
        Scanner ler = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = ler.nextLine();
        System.out.println("Informe a rua: ");
        String rua = ler.nextLine();
        System.out.println("Informe a cidade: ");
        String cidade = ler.nextLine();

        return new Usuario(nome, rua, cidade);
    }

    public static Funcionario CadastrarFuncionario(){
        Scanner ler = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = ler.nextLine();
        System.out.println("Informe a rua: ");
        String rua = ler.nextLine();
        System.out.println("Informe a cidade: ");
        String cidade = ler.nextLine();
        System.out.println("Informe o cargo: ");
        String cargo = ler.nextLine();

        return new Funcionario(nome, rua, cidade, cargo);
    }
}
