package org.mcclone.ext.data.orm;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author zhengsd
 */
@MappedSuperclass
public abstract class IdPersistable<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 781064765637077486L;
    private ID id;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "ID", nullable = false, length = 32)
    public ID getId() {
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
