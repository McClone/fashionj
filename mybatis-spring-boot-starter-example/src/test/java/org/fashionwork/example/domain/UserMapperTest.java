package org.fashionwork.example.domain;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhengsd
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void findById() throws Exception {
        System.out.println(userMapper.findById("1"));
    }

    @Test
    public void findAll() throws Exception {
        System.out.println(userMapper.findAll());
    }

    @Test
    public void selectUserById() throws Exception {
        User user = sqlSession.selectOne("mybatis.mapper.UserMapper.selectUserById", "2");
        System.out.println(user);
    }
}