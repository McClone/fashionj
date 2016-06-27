package org.fashionwork.demo.service;

import org.fashionwork.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhengsd
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setUserId(new Date().toString());
        user.setUserName("admin");
        this.userService.saveUser(user);
    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }

    @Test
    public void findAll() throws Exception {
        String id1 = UUID.randomUUID().toString().replace("-", "");
        User user1 = new User();
        user1.setId(id1);
        user1.setUserId(new Date().toString());
        user1.setUserName("admin");
        this.userService.saveUser(user1);
        User userr1 = this.userService.findUser(id1);
        System.out.println(userr1);

        user1.setUserId(new Date().toString() + "22222");
        user1.setUserName("admin2");
        this.userService.saveUser(user1);
        User userr2 = userService.findUser(id1);
        System.out.println(userr2);

    }

    @Test
    public void findUser() throws Exception {

    }
}