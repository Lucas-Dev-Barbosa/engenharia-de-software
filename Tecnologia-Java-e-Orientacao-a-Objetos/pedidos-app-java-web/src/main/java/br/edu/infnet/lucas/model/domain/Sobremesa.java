package br.edu.infnet.lucas.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "s")
public class Sobremesa extends Produto {

    private long quantidade;
    private boolean doce;
    private String informacao;

    @Override
    public String getDescricaoProduto() {
        return "Esta sobremesa tem a quantidade de " + this.quantidade + "."
                + (this.doce ? " Ela e doce" : " Ela nao e doce")
                + "Sua informacao e [" + this.informacao + "]";
    }
}
