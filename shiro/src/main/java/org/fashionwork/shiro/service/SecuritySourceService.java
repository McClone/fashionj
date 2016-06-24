package org.fashionwork.shiro.service;

import java.util.List;

/**
 * @author zhengsd
 */
public interface SecuritySourceService {

    List<String> getAuthority();

    List<String> getResources(String authority);

}