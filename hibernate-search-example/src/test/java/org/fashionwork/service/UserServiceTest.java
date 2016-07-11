package org.fashionwork.service;

import org.fashionwork.HibernateSearchExampleApplication;
import org.fashionwork.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengsd
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserFullText() throws Exception {
        List<User> userList = userService.findUserFullText("123");
        List<String> strings = userList.stream().map(User::getId).collect(Collectors.toList());
        System.out.println(strings);
    }
}