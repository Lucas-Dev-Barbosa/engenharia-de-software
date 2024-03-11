package br.edu.infnet.lucas.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "c")
public class Comida extends Produto {
	
	private float peso;
    private boolean vegano;
    private String ingredientes;

    @Override
    public String getDescricaoProduto() {
        return "O peso da comida e de " + this.peso + "KG."
                + (this.vegano ? " A comida e vegana" : " A comida nao e vegana"
                + " e possui os seguintes ingredientes: " + this.ingredientes);
    }

}
