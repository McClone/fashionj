package org.fashionwork.demo.domain;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        User user = userMapper.findById("1");
        System.out.println(user);
    }

    @Test
    public void findAll() throws Exception {
        List<User> users = this.userMapper.findAll();
        System.out.println(users);
    }

    @Test
    public void findOne() throws Exception {
        User user = sqlSession.selectOne("mybatis.mapper.UserMapper.selectUserById", "2");
        System.out.println(user);
    }
}