package org.mcclone.service.impl;

import org.mcclone.domain.User;
import org.mcclone.domain.UserDao;
import org.mcclone.ext.data.SimpleRepository;
import org.mcclone.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhengsd
 */
@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser() {
        logger.info("123");
//        User user = new User();
//        user.setUserName("admin");
//        user.setUserId("admin");
//        user.setPassword("123");
//        userDao.save(user);
//        User temp = userDao.findById(user.getId());
//        if (temp != null) {
//            logger.info(user.toString());
//        }
    }
}
