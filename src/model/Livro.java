package model;

public class Livro {
    public String nome;
    public String autor;
    public boolean emprestado;

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setEmprestado(){
        this.emprestado = false;
    }


    public void listarLivro(){
            System.out.println();
            System.out.println("Livro: " +this.nome);
            System.out.println("Autor: " +this.autor);
            if (this.emprestado) {
                System.out.println("Status: Alugado");
                System.out.println();
            } else {
                System.out.println("Status: Não alugado");
                System.out.println();
            }
    }

    public boolean buscarLivro(String buscar){
        if (this.nome.equalsIgnoreCase(buscar)) {
            System.out.println("Livro: " + this.nome);
            System.out.println("Autor: " + this.autor);
            if (this.emprestado) {
                System.out.println("Status: Alugado");
                System.out.println();
            } else {
                System.out.println("Status: Não alugado");
                System.out.println();
            }
            return true;
        }
        return false;
    }

    public boolean alugarLivro(String alugar){
            if (this.nome.equalsIgnoreCase(alugar)) {
                if (this.emprestado) {
                    System.out.println("Este livro já está alugado!");
                    System.out.println();
                } else {
                    this.emprestado = true;
                    System.out.println("Este livro foi alugado com sucesso!");
                    System.out.println();
                }
                return true;
            }
        return false;
    }

    public boolean devolucaoLivro(String devolucao){
        if (this.nome.equalsIgnoreCase(devolucao)) {
            if (this.emprestado) {
                this.emprestado = false;
                System.out.println("Livro devolvido com sucesso!");
                System.out.println();
            }else{
                System.out.println("Este livro não foi alugado, então não pode ser devolvido!");
                System.out.println();
            }
            return true;
        }
        return false;
    }
}
