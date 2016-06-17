package org.mcclone.ext.data.orm.hibernate;

import org.hibernate.SessionFactory;
import org.mcclone.ext.data.orm.CrudRepository;
import org.mcclone.ext.data.orm.Persistable;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public class HibernateRepository<T extends Persistable, PK extends Serializable> implements CrudRepository<T, PK> {

    private SessionFactory sessionFactory;

    public void save(T t) {

    }

    public void deleteById(PK id) {

    }

    public void update(T t) {

    }

    public T findById(PK id) {
        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
