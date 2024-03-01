package br.edu.infnet.lucas.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "b")
public class Bebida extends Produto {

    private boolean gelada;
    private short tamanho;
    private String marca;

    @Override
    public String getDescricaoProduto() {
        return (this.gelada ? "A bebida e gelada" : "A bebida nao e gelada") + " de tamanho " + this.tamanho
                + " e marca " + this.marca;
    }

}
