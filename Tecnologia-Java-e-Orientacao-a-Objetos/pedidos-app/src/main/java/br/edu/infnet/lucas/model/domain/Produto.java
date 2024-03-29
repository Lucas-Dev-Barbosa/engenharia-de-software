package br.edu.infnet.lucas.model.domain;

import br.edu.infnet.lucas.file.json.deserializer.ProdutoDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ProdutoDeserializer.class)
public abstract class Produto {
    
    private String nome;
    private double valor;
    private int codigo;
    private char tipo;

    private byte[] foto;

    public abstract String getDescricaoProduto();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", codigo=" + codigo +
                ", tipo=" + tipo +
                '}';
    }
}
