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
        
        System.out.println("- - - Seja Bem-Vindo ao Sistema de Gestão de Bibliotecas - - -");


    }
}