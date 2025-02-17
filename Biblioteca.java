import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca(){
        this.livros = new ArrayList<>();
    }
    

    public void CadastrarLivro(Livro NovoLivro){
        if (NovoLivro != null){
            livros.add(NovoLivro);
            System.out.println("Livro '"+ livro.getTitulo()+"'adicionado!");
        }
    }

    public String escolha;

    public void ReservarLivro(Livro LivroDesejado){
        if (livros.contains(LivroDesejado) && LivroDesejado.getDisponivel()){
            System.out.println("Você deseja reservar o livro " + LivroDesejado + "?");

            if (escolha == "Sim" || Escolha == "sim"){
                LivroDesejado.setDisponivel(false);
                System.out.println("Livro reservado com sucesso.");

            }
        }
        else{
            System.out.println("Livro não disponível! Tente outro!");
        }
    }

    public void DevolverLivro(Livro LivroDesejado){
        if (livros.contains(LivroDesejado) && !LivroDesejado.getDisponivel()) {
            System.out.println("Livro devolvido com sucesso!");
        }
        else{
            System.out.println("Livro não encontrado!");
        }
    }
}