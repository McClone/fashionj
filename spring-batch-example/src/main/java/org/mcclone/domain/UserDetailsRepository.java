package org.mcclone.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mcclone on 16-8-27.
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
}
