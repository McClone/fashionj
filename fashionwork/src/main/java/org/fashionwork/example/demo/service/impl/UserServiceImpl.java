package org.fashionwork.example.demo.service.impl;

import org.fashionwork.example.demo.domain.User;
import org.fashionwork.example.demo.domain.UserRepository;
import org.fashionwork.example.demo.domain.page.JdbcRepository;
import org.fashionwork.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;

/**
 * @author zhengsd
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcRepository jdbcRepository;

    @CachePut(cacheNames = "redis-cache", key = "#user.id")
    @Override
    public User saveUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    @CacheEvict(value = "redis-cache", key = "#user.id")
    @Override
    public User deleteUser(User user) {
        this.userRepository.delete(user);
        return user;
    }

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Cacheable(cacheNames = "redis-cache", key = "#id")
    @Override
    public User findUser(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
//        return this.userRepository.findAll(pageable);
        String sql = "SELECT ID id, USER_ID userId, USER_NAME userName FROM T_DEMO_USER";
        return this.jdbcRepository.queryForPage(pageable, sql, null, new BeanPropertyRowMapper<>(User.class));
    }

}
