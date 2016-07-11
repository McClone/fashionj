package org.fashionwork.example.service.impl;

import org.fashionwork.example.domain.User;
import org.fashionwork.example.service.UserService;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<User> findUserFullText(String keyWord) throws InterruptedException {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManagerFactory.createEntityManager());
        fullTextEntityManager.createIndexer().startAndWait();

        QueryBuilder qb = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(User.class)
                .get();
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
