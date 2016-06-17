package org.mcclone.domain;

import org.mcclone.ext.data.orm.hibernate.HibernateRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhengsd
 */
@Repository
public class UserDaoImpl extends HibernateRepository<User, String> implements UserDao {
}
