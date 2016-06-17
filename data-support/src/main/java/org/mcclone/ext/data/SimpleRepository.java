package org.mcclone.ext.data;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public interface SimpleRepository<T, PK extends Serializable> {

    void save(T t);

    void deleteById(PK id);

    void update(T t);

    T findById(PK id);

}
