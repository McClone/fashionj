package org.fashionwork.demo.web;

import org.fashionwork.demo.domain.User;
import org.fashionwork.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengsd
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public ResponseEntity findAllUser(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return ResponseEntity.ok(this.userService.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUser(@PathVariable String id) {
        return new ResponseEntity<User>(userService.findUser(id), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<User> saveOrUpddateUser(@RequestBody User user) {
        this.userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        this.userService.deleteUser(this.userService.findUser(id));
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<User>> search(String keyWord) {
        try {
            return new ResponseEntity<>(userService.findUserFullText(keyWord), HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
