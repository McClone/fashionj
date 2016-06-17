package org.mcclone.service.impl;

import org.mcclone.domain.User;
import org.mcclone.domain.UserDao;
import org.mcclone.ext.data.SimpleRepository;
import org.mcclone.ext.data.orm.CrudRepository;
import org.mcclone.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhengsd
 */
@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource(name = "simpleRepository")
    private SimpleRepository<User, String> simpleRepository;

    @Override
    public void saveUser() {
        User user = new User();
        user.setUserName("admin");
        user.setUserId("admin");
        user.setPassword("123");
        simpleRepository.save(user);
        User temp = simpleRepository.findById(user.getId());
        if (temp != null) {
            logger.info(user.toString());
        }
    }
}
