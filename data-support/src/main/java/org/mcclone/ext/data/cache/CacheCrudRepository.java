package org.mcclone.ext.data.cache;

import org.mcclone.ext.data.SimpleRepository;
import org.mcclone.ext.data.orm.Persistable;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public interface CacheCrudRepository<T extends Persistable, PK extends Serializable> extends SimpleRepository<T, PK> {
}
