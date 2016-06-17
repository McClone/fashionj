package org.mcclone.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mcclone.ext.data.cache.redis.RedisCacheCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

/**
 * @author zhengsd
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:spring.xml")
public class RedisTest {

    @Autowired
    private RedisCacheCrudRepository<User, String> redisCacheCrudRepository;

    @Test
    public void testRedis() throws Exception {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("admin");
        user.setUserId("admin");
        user.setPassword("123");
        redisCacheCrudRepository.save(user);
        User tmp = redisCacheCrudRepository.findById(user.getId());
        System.out.println(tmp);
    }
}
