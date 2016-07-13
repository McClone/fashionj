package org.fashionwork.example.service.impl;

import org.fashionwork.example.domain.User;
import org.fashionwork.example.service.UserService;
import org.fashionwork.jdbc.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

/**
 * @author zhengsd
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcRepository jdbcRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        String sql = "SELECT ID id, USER_ID userId, USER_NAME userName FROM T_DEMO_USER";
        return this.jdbcRepository.queryForPage(pageable, sql, null, new BeanPropertyRowMapper<>(User.class));
    }

}
