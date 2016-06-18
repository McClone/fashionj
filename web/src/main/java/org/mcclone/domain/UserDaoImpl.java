package org.mcclone.domain;

import org.mcclone.ext.data.orm.hibernate.HibernateRepository;
import org.mcclone.ext.data.support.CrudRepositoryWrapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhengsd
 */
@Repository
public class UserDaoImpl extends CrudRepositoryWrapper<User, String> implements UserDao {
}
