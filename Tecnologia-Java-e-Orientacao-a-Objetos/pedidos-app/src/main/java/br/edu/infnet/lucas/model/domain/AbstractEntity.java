package br.edu.infnet.lucas.model.domain;

public abstract class AbstractEntity {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
