package org.mcclone.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mcclone.DbApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhengsd
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DbApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() throws Exception {
        User user = new User();
        user.setUserId("test");
        user.setUserName("test");
        userRepository.save(user);
    }

    @Test
    public void testFindAll() throws Exception {
        Iterable<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }
}