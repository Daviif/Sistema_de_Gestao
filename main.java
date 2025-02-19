import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        LocalDateTime atual = LocalDateTime.now();
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(atual);

        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(atual);
        
        System.out.println("Data: " + dataFormatada + "\nHora: " + horaFormatada);

        System.out.println("- - - Seja Bem-Vindo ao Sistema de Gestão de Bibliotecas - - -");
        System.out.println("O que você deseja fazer agora?");

        Cadastro cadastro = new Cadastro();
        
        Biblioteca biblioteca = new Biblioteca(cadastro);

        boolean exit = false;
        int option; 
        char option_user;

        do{
            System.out.println("1 - Cadastrar Pessoa\n2 - Cadastrar Livro\n3 - Reservar Livro\n4 - Devolver Livro");
            option = ler.nextInt();

            switch (option) {

                case 1:
                    System.out.println("Deseja cadastrar um funcionário?(Y/N)");
                    option_user = ler.next().charAt(0);
                    if(option_user == 'y' || option_user == 'Y'){
                        Funcionario novoFuncionario = cadastro.CadastrarFuncionario();
                        System.out.println("Funcionario '" + novoFuncionario.getNome() + "' cadastrado com sucesso!");
                    }
                    else if (option_user == 'n' || option_user == 'N') {
                        System.out.println("Deseja cadastrar um usuario novo?(Y/N)");
                        option_user = ler.next().charAt(0);
                        if (option_user == 'y' || option_user == 'Y') {
                            Usuario novoUsuario = cadastro.CadastrarUsuario();
                            System.out.println("Usuario '" + novoUsuario.getNome() + "' usuario cadastrado com sucesso"); 
                        }
                        else{
                            System.out.println("Voltando ao menu...");
                        }
                    }
                    break;
                case 2:
                    Livro novoLivro = cadastro.criarLivro();
                    System.out.println("Livro " + novoLivro.getTitulo() + " criado com sucesso!");
                    biblioteca.AdicionarLivro(novoLivro);
                    System.out.println("Livro adicionado na biblioteca!");
                    break;
                case 3:
                    ler.nextLine();
                    System.out.println("Informe o titulo do Livro desejado: ");
                    String TituloLivro = ler.nextLine();

                    try {
                        biblioteca.ReservarLivro(TituloLivro);
                    } catch (LivroIndisponivelException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (LivroNaoEncontradoException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    ler.nextLine();
                    System.out.println("Informe o titulo do livro para a devolução: ");
                    String TituloLivroD = ler.nextLine();

                    try {
                        biblioteca.DevolverLivro(TituloLivroD);
                    } catch (Exception e) {
                       System.out.println("Error: " + e.getMessage());
                    }
                    break;
            }

        }while(exit != true);

        ler.close();
    }

   
}