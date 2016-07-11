package org.fashionwork.example.demo;

import org.fashionwork.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhengsd
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {

    @Test
    public void findAllUsers() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8890/demo/api/users/1", User.class);
        System.out.println(user);
    }

}
