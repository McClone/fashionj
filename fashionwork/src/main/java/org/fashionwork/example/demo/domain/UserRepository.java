package org.fashionwork.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhengsd
 */
public interface UserRepository extends JpaRepository<User, String> {
}
