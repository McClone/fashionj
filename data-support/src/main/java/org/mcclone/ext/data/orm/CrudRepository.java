package org.mcclone.ext.data.orm;

import org.mcclone.ext.data.orm.Persistable;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public interface CrudRepository<T extends Persistable, PK extends Serializable> {

    void save(T t);

    void deleteById(PK id);

    void update(T t);

    T findById(PK id);
}
