
import java.util.Scanner;

import Exceptions.LivroDisponivelException;
import Exceptions.LivroIndisponivelException;
import Exceptions.LivroNaoEncontradoException;
import Exceptions.PrazoAtrasadoException;

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
        
        System.out.println("Informe quem deseja reservar Funcionario/Usuario(F/U)");
        char choiceUser = ler.next().charAt(0);
        ler.nextLine();
        Funcionario showF = null;
        Usuario showU = null;

        if (Character.toUpperCase(choiceUser) == 'F') {
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
        else if (Character.toUpperCase(choiceUser) == 'U'){
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
        else{
            System.out.println("Comando invalido. Tente novamente\n");
            return;
        }
        
        if (LivroDesejado != null && LivroDesejado.getDisponivel()){
            System.out.println("Você deseja reservar o livro " + LivroDesejado);
            escolha = ler.nextLine().trim();

            if (escolha.equalsIgnoreCase("Sim")){
                LivroDesejado.setDisponivel(false);

                if (showF != null) {
                    int prazoEntF = 14;
                    System.out.println(showF.getNome() + " reserva " + LivroDesejado.getTitulo() + " por " + prazoEntF + " dias.");
                }
                else if (showU != null) {
                    int prazoEntU = 7;
                    System.out.println(showU.getNome() + " reserva " + LivroDesejado.getTitulo() + " por " + prazoEntU + " dias.");
                }
                
            }
            else{
                System.out.println("Reserva cancelada!");
            }
        }
        else{
            throw new LivroIndisponivelException("O livro" + LivroDesejado.getTitulo() + "não disponível para reserva!");
        }
        
    }

    public void DevolverLivro(String tituloLivro) throws LivroDisponivelException, LivroNaoEncontradoException, PrazoAtrasadoException {
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
        
         System.out.println("Informe quem deseja devolver - Funcionario/Usuario(F/U)");
         char choiceUser = ler.next().charAt(0);
         ler.nextLine();
         Funcionario showF = null;
         Usuario showU = null;
         
         if (Character.toUpperCase(choiceUser) == 'F') {
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
         else if (Character.toUpperCase(choiceUser) == 'U'){
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
         else{
             System.out.println("Comando invalido. Tente novamente\n");
             return;
         }
        
         if (livros.contains(LivroDesejado) && !LivroDesejado.getDisponivel()){
            if (showF != null) {
                System.out.println(showF.getNome() + " devolve o " + LivroDesejado.getTitulo() + "!");
            LivroDesejado.setDisponivel(true);
            }
            else if(showU != null){
                System.out.println(showU.getNome() + " devolve o " + LivroDesejado.getTitulo() + "!");
                LivroDesejado.setDisponivel(true);
            }
        }
        else{
            throw new LivroDisponivelException("Você esta tentando devolver um livro que não foi reservado!");
        }

    }

    public void ExibirBiblioteca(){
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro na biblioteca!");
        }
        else{                
            for (Livro livro : livros) {
              System.out.println(livro);
            }
        }
        
    }
    public void ExibirLivros(){
        System.out.println("Deseja ver os livros: ");
        System.out.println("1 - Disponiveis\n2 - Indisponveis\n3 - Todos");
        int filter = ler.nextInt();

        if (livros.isEmpty()) {
            System.out.println("Ainda não há livros no momento.");
        }

        switch (filter) {
            case 1:
                boolean searchAvailable = false;
                for (Livro livro : livros) {
                    if (livro.getDisponivel()) {
                        System.out.println(livro);
                        searchAvailable = true;
                    }
                }
                if (!searchAvailable) {
                    System.out.println("Não há livros que estejam disponiveis.");
                }
                break;
            case 2:
                boolean searchUnavailable = false;
                for (Livro livro : livros) {
                    if (!livro.getDisponivel()) {
                        System.out.println(livro);
                        searchUnavailable = true;
                    }
                }
                if (!searchUnavailable) {
                    System.out.println("Todos os livros estão disponiveis!");
                }
                break;
            case 3:
                for (Livro livro : livros) {
                    System.out.println(livro);
                }
            break;
            default:
                System.out.println("Option invalid");
                break;
        }
    }

    public void GestaoPrazo(){
        
    }
}