package org.mcclone.ext.data.orm;

import org.mcclone.ext.data.SimpleRepository;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public interface CrudRepository<T, PK extends Serializable> extends SimpleRepository<T, PK> {

}
