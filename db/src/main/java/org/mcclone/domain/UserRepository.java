package org.mcclone.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zhengsd
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
