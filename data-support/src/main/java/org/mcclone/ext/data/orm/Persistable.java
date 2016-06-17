package org.mcclone.ext.data.orm;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public interface Persistable<ID extends Serializable> extends Serializable {

    ID getId();
}
