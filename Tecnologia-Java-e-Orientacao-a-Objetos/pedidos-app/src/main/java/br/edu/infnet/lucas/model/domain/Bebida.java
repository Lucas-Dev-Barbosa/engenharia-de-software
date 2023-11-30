package br.edu.infnet.lucas.model.domain;

public class Bebida extends Produto {

    private boolean gelada;
    private short tamanho;
    private String marca;

    public boolean isGelada() {
        return gelada;
    }

    public void setGelada(boolean gelada) {
        this.gelada = gelada;
    }

    public short getTamanho() {
        return tamanho;
    }

    public void setTamanho(short tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getDescricaoProduto() {
        return (this.gelada ? "A bebida e gelada" : "A bebida nao e gelada") + " de tamanho " + this.tamanho
                + " e marca " + this.marca;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "gelada=" + gelada +
                ", tamanho=" + tamanho +
                ", marca='" + marca + '\'' +
                '}';
    }
}
