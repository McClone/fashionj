package org.fashionwork.demo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zhengsd
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
