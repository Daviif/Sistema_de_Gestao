
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List <Livro> livros;
    private List<Usuario> usuarios;
    private List<Funcionario> funcionarios;
    Scanner ler = new Scanner(System.in);

    public Biblioteca(Cadastro cadastro){
        this.livros = new ArrayList<>();
        this.usuarios = cadastro.usuarios;
        this.funcionarios = cadastro.funcionarios;
    }
    
    public void AdicionarLivro(Livro NovoLivro){
        if (NovoLivro != null){
            livros.add(NovoLivro);
            System.out.println("Livro '"+ NovoLivro.getTitulo()+"'adicionado!");
        }
    }

    public String escolha;
    public int prazoEnt;

    public void ReservarLivro(String tituloLivro) throws LivroIndisponivelException, LivroNaoEncontradoException{
        Livro LivroDesejado = null;

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                LivroDesejado = livro;
                break;
            }
        }

        if (LivroDesejado == null) {
           throw new LivroNaoEncontradoException("Livro não encontrado!\nTente novamente.");
        }
        
        System.out.println("Informe quem deseja reservar(Funcionario/Usuario)");
        String choiceUser = ler.nextLine().trim();
        Funcionario showF = null;
        Usuario showU = null;

        if (choiceUser.equalsIgnoreCase("Funcionario")) {
            System.out.println("Informe o funcionario:");
            String nameF = ler.nextLine().trim();

            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nameF)) {
                    showF = funcionario;
                    break;
                }
            }

            if (showF == null) {
                System.out.println("Funcionário não encontrado.");
                return;
            }
        }
        else if (choiceUser.equalsIgnoreCase("Usuario")){
            System.out.println("Informe o usuario:");
            String nameU = ler.nextLine().trim();

            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equalsIgnoreCase(nameU)) {
                    showU = usuario;
                    break;
                }
            }

            if (showU == null) {
                System.out.println("Usuario não encontrado.");
                return;
            }
        }
        if (choiceUser.equalsIgnoreCase("Funcionarios")) {
            prazoEnt = 14;
        }
        else if (choiceUser.equalsIgnoreCase("Usuarios")) {
            prazoEnt = 7;
        }

        if (LivroDesejado != null && LivroDesejado.getDisponivel()){
            System.out.println("Você deseja reservar o livro " + LivroDesejado + "?");
            escolha = ler.nextLine().trim();

            if (escolha.equalsIgnoreCase("Sim")){
                LivroDesejado.setDisponivel(false);
                System.out.println(showF.getNome() + " reserva " + LivroDesejado.getTitulo() + " por " + prazoEnt + " dias.");
            }
            else{
                System.out.println("Reserva cancelada!");
            }
        }
        else{
            throw new LivroIndisponivelException("O livro" + LivroDesejado.getTitulo() + "não disponível para reserva!");
        }
        
    }

    public void DevolverLivro(String tituloLivro) throws LivroNaoEncontradoException, PrazoAtrasadoException {
        Livro LivroDesejado = null;

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                LivroDesejado = livro;
                break;
            }
        }

        if (LivroDesejado == null) {
            throw new LivroNaoEncontradoException("Livro não encontrado!\nTente novamente.");
         }

        if (livros.contains(LivroDesejado) && !LivroDesejado.getDisponivel()) {
            System.out.println("Livro devolvido com sucesso!");
            LivroDesejado.setDisponivel(true);
        }
        else{
            System.out.println("Livro não encontrado!");
        }
    }
}