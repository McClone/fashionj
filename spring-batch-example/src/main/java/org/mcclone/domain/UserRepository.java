package org.mcclone.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhengsd
 */
public interface UserRepository extends JpaRepository<User, String> {
}
