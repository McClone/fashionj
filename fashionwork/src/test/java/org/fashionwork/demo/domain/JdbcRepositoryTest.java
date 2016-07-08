package org.fashionwork.demo.domain;

import org.fashionwork.demo.domain.page.JdbcRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhengsd
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcRepositoryTest {

    @Autowired
    private JdbcRepository jdbcRepository;

    @Test
    public void findAll() throws Exception {

        String sql = "SELECT ID id, USER_ID userId, USER_NAME userName FROM T_DEMO_USER";
        Page<User> userPage = jdbcRepository.findAll(new PageRequest(1, 5), sql, null, new BeanPropertyRowMapper<>(User.class));
        System.out.println(userPage.getContent());

    }
}