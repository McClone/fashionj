package org.mcclone.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * @author zhengsd
 */
public interface UserRepository extends CrudRepository<User, String> {
}
