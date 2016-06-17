package org.mcclone.ext.data.support;

import org.mcclone.ext.data.SimpleRepository;
import org.mcclone.ext.data.cache.CacheCrudRepository;
import org.mcclone.ext.data.orm.CrudRepository;
import org.mcclone.ext.data.orm.Persistable;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public class CrudRepositoryWrapper<T extends Persistable, PK extends Serializable> implements SimpleRepository<T, PK> {

    private CrudRepository<T, PK> crudRepository;

    private CacheCrudRepository<T, PK> attachedCrudRepository;

    public void save(T t) {
        this.crudRepository.save(t);
        this.attachedCrudRepository.save(t);
    }

    public void deleteById(PK id) {
        this.crudRepository.deleteById(id);
        this.attachedCrudRepository.deleteById(id);
    }

    public void update(T t) {
        this.crudRepository.update(t);
        this.attachedCrudRepository.update(t);
    }

    public T findById(PK id) {
        T t = this.attachedCrudRepository.findById(id);
        if (t == null) {
            this.crudRepository.findById(id);
        }
        return t;
    }

    public void setCrudRepository(CrudRepository<T, PK> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public void setAttachedCrudRepository(CacheCrudRepository<T, PK> attachedCrudRepository) {
        this.attachedCrudRepository = attachedCrudRepository;
    }
}
