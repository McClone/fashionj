package org.mcclone.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author zhengsd
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:spring.xml")
public class RedisTemplateTest {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void testPublisher() throws Exception {
        redisTemplate.convertAndSend("test", "testPub");
    }

    @Test
    public void testValue() throws Exception {
        ValueOperations<String, User> vopForUser = redisTemplate.opsForValue();
        vopForUser.set("1", new User("1", "2", "3"));
        User user = vopForUser.get("1");
        System.out.println(user.getUserId());
    }

    /**
     * ���
     *
     * @throws Exception
     */

    @Test
    public void testPushList() throws Exception {
        ListOperations<String, User> lopForUser = redisTemplate.opsForList();
        lopForUser.leftPush("2", new User(UUID.randomUUID().toString().replace("-", ""), "2", "3"));
        lopForUser.leftPush("2", new User(UUID.randomUUID().toString().replace("-", ""), "2", "3"));
        lopForUser.leftPush("2", new User(UUID.randomUUID().toString().replace("-", ""), "2", "3"));

        List<User> uList = lopForUser.range("2", 0, 10);
        System.out.println(uList.size());
        for (User anUList : uList) {
            System.out.println(anUList.getId());
        }
    }

    /**
     * ����
     *
     * @throws Exception
     */
    @Test
    public void testPopList() throws Exception {
        ListOperations<String, User> lopForUser = redisTemplate.opsForList();
        System.out.println(lopForUser.size("abc"));
        User user = lopForUser.leftPop("abc");
        System.out.println(user.getId());
        User user2 = lopForUser.leftPop("abc");
        System.out.println(user2.getId());
        System.out.println(lopForUser.size("abc"));
    }
}
