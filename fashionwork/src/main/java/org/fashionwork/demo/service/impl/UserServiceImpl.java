package org.fashionwork.demo.service.impl;

import org.fashionwork.demo.domain.User;
import org.fashionwork.demo.domain.UserRepository;
import org.fashionwork.demo.service.UserService;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * @author zhengsd
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

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

    @Override
    public List<User> findUserFullText(String keyWord) throws InterruptedException {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManagerFactory.createEntityManager());
        fullTextEntityManager.createIndexer().startAndWait();

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(User.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .fuzzy()
                .onFields("userId", "userName")
                .matching(keyWord)
                .createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, User.class);
        return jpaQuery.getResultList();
    }
}
