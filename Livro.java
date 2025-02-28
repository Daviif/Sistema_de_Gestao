
import java.time.LocalDateTime;
import java.util.Scanner;
public class Livro {
    Scanner ler = new Scanner(System.in);

    private String titulo;
    private String autor;
    private boolean disponivel = true;
    private LocalDateTime dataReserva = null;
    private LocalDateTime prazoEnt = null;

    public Livro(String titulo, String autor, boolean disponivel){
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public LocalDateTime getDataReserva(){
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva){
        this.dataReserva = dataReserva;
    }

    public LocalDateTime getPrazoEnt(){
        return prazoEnt;
    }

    public void setPrazoEnt(LocalDateTime prazoEnt){
        this.prazoEnt = prazoEnt;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public String verificar(boolean disponivel){
        if (disponivel){
            return "Sim";
        }
        else{
            return "Não";
        }
    }
   
    @Override
    public String toString(){
        return "Livro: " + this.getTitulo() + ", Autor: " + this.getAutor() + ", Disponivel: " + verificar(getDisponivel());
    }

    
}