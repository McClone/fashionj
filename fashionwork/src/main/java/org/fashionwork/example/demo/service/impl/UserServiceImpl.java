package org.fashionwork.example.demo.service.impl;

import org.fashionwork.example.demo.domain.User;
import org.fashionwork.example.demo.domain.UserRepository;
import org.fashionwork.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengsd
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    @CachePut(cacheNames = "redis-cache", key = "#user.id")
    @Override
    public User saveUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    //    @CacheEvict(value = "redis-cache", key = "#user.id")
    @Override
    public User deleteUser(User user) {
        this.userRepository.delete(user);
        return user;
    }

    //    @Cacheable(cacheNames = "redis-cache", key = "#id")
    @Override
    public User findUser(String id) {
        return userRepository.findOne(id);
    }

}
