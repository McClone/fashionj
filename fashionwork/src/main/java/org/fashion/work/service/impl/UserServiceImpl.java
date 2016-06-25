package org.fashion.work.service.impl;

import org.fashion.work.domain.User;
import org.fashion.work.domain.UserRepository;
import org.fashion.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zhengsd
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
}
