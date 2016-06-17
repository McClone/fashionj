package org.mcclone.ext.data.cache;

import org.mcclone.ext.data.orm.CrudRepository;
import org.mcclone.ext.data.orm.Persistable;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public interface CacheCrudRepository<T extends Persistable, PK extends Serializable> extends CrudRepository<T, PK> {
}
