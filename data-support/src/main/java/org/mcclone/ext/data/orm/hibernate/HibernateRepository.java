package org.mcclone.ext.data.orm.hibernate;

import org.mcclone.ext.data.orm.CrudRepository;
import org.mcclone.ext.data.utils.ReflectionUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public class HibernateRepository<T, PK extends Serializable> implements CrudRepository<T, PK> {

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public HibernateRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
        this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
    }


    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    protected HibernateTemplate hibernateTemplate;

    protected Class<T> entityClass;

    public void save(T t) {
        hibernateTemplate.save(t);
    }

    public void deleteById(PK id) {
        hibernateTemplate.delete(this.findById(id));
    }

    public void update(T t) {
        hibernateTemplate.merge(t);
    }

    public T findById(PK id) {
        return this.hibernateTemplate.load(entityClass, id);
    }

}
