public class Livro {

    private String titulo;
    private String autor;
    private boolean disponivel = true;

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
        return "Livro: " + this.getTitulo() + ", Autor: " + this.getAutor() + this.getDisponivel();
    }

}