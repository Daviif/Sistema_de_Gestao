
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Cadastro {
    List<Usuario> usuarios;
    List<Funcionario> funcionarios;

    public Cadastro(){
        this.usuarios = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    Scanner ler = new Scanner(System.in);
    public Usuario CadastrarUsuario(){

        System.out.println("Informe o nome: ");
        String nome = ler.nextLine();
        System.out.println("Informe a rua: ");
        String rua = ler.nextLine();
        System.out.println("Informe a cidade: ");
        String cidade = ler.nextLine();

        Usuario novoUsuario = new Usuario(nome, rua, cidade);
        usuarios.add(novoUsuario);

        return novoUsuario;
    }

    public Funcionario CadastrarFuncionario(){
        
        System.out.println("Informe o nome: ");
        String nome = ler.nextLine();
        System.out.println("Informe a rua: ");
        String rua = ler.nextLine();
        System.out.println("Informe a cidade: ");
        String cidade = ler.nextLine();
        System.out.println("Informe o cargo: ");
        String cargo = ler.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, rua, cidade, cargo);
        funcionarios.add(novoFuncionario);

        return novoFuncionario;
}
    public void Exibir(){
        System.out.println("Deseja exibir a lista de Funcionarios ou Usuarios?");
        String show = ler.nextLine();

        if (show.equals("Funcionarios")){
            if (funcionarios.isEmpty()) {
                System.out.println("Nenhum funcionario cadastrado!");
            }
            else{
                for (Funcionario funcionario : funcionarios) {
                    System.out.println(funcionario);
                }
            }
        }
        else if (show.equals("Usuarios")){
            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuario cadastrado!");
            }
            else{
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                }
            }
        }
    }
    public Livro criarLivro(){
        System.out.println("Informe o titulo do livro");
        String Titulo = ler.nextLine();
        System.out.println("Informe o autor");
        String Autor = ler.nextLine();
        boolean Disponibilidade = true;

        Livro novoLivro = new Livro(Titulo, Autor, Disponibilidade);

        return novoLivro;
    }
}