package br.edu.infnet.lucas.model.domain;

public class Sobremesa extends Produto {

    private long quantidade;
    private boolean doce;
    private String informacao;

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDoce() {
        return doce;
    }

    public void setDoce(boolean doce) {
        this.doce = doce;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    @Override
    public String getDescricaoProduto() {
        return "Esta sobremesa tem a quantidade de " + this.quantidade + "."
                + (this.doce ? "Ela e doce" : "Ela nao e doce")
                + "Sua informacao e " + this.informacao;
    }

    @Override
    public String toString() {
        return "Sobremesa{" +
                "quantidade=" + quantidade +
                ", doce=" + doce +
                ", informacao='" + informacao + '\'' +
                '}';
    }
}
