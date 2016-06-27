package org.fashionwork.demo.service.impl;

import org.fashionwork.shiro.service.SecuritySourceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengsd
 */
@Service
public class SecuritySourceServiceImpl implements SecuritySourceService {

    @Override
    public List<String> getAuthority() {
        List<String> strings = new ArrayList<>();
        strings.add("user");
        return strings;
    }

    @Override
    public List<String> getResources(String authority) {
        if (authority.equals("user")) {
            List<String> strings = new ArrayList<>();
            strings.add("/user/**");
            return strings;
        }
        return null;
    }
}
