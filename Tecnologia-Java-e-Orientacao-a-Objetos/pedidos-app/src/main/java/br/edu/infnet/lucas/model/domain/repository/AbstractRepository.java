package br.edu.infnet.lucas.model.domain.repository;

import br.edu.infnet.lucas.model.domain.AbstractEntity;

import java.util.*;

public abstract class AbstractRepository<T extends AbstractEntity> {

    protected Map<String, T> repositorio = new HashMap<>();

    public T getById(String id) {
        return repositorio.get(id);
    }

    public Set<T> getList() {
        Set<T> list = new HashSet<>();

        for(Map.Entry<String, T> item : repositorio.entrySet())
            list.add(item.getValue());

        return list;
    }

    public T insert(T item) {
        repositorio.put(item.getId(), item);
        return repositorio.get(item.getId());
    }

    public void delete(Integer id) {
        repositorio.remove(id);
    }

}
