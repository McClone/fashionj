package org.mcclone.ext.data.support;

import org.mcclone.ext.data.orm.CrudRepository;
import org.mcclone.ext.data.orm.Persistable;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public class CrudRepositoryWrapper<T extends Persistable, PK extends Serializable> implements CrudRepository<T, PK> {

    private CrudRepository<T, PK> crudRepository;

    private CrudRepository<T, PK> attachedCrudRepository;

    public void save(T t) {

    }

    public void deleteById(PK id) {

    }

    public void update(T t) {

    }

    public T findById(PK id) {
        return null;
    }

    public CrudRepository<T, PK> getCrudRepository() {
        return crudRepository;
    }

    public void setCrudRepository(CrudRepository<T, PK> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public CrudRepository<T, PK> getAttachedCrudRepository() {
        return attachedCrudRepository;
    }

    public void setAttachedCrudRepository(CrudRepository<T, PK> attachedCrudRepository) {
        this.attachedCrudRepository = attachedCrudRepository;
    }
}
