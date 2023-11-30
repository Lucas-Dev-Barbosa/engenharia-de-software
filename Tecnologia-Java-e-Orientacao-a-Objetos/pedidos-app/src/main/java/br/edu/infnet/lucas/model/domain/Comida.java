package br.edu.infnet.lucas.model.domain;

public class Comida extends Produto {
    
    private float peso;
    private boolean vegano;
    private String[] ingredientes;

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String getDescricaoProduto() {
        return "O peso da comida e de " + this.peso + "KG."
                + (this.vegano ? "A comida e vegana" : "A comida nao e vegana"
                + " e possui os seguintes ingredientes: " + this.ingredientes);
    }

    @Override
    public String toString() {
        return "Comida{" +
                "peso=" + peso +
                ", vegano=" + vegano +
                ", ingredientes='" + ingredientes + '\'' +
                '}';
    }
}
