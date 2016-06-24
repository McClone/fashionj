package org.fashion.work.shiro;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengsd
 */
@EnableConfigurationProperties(ShiroProperties.class)
public class WebShiroConfiguration implements InitializingBean {

    @Autowired
    private ShiroProperties shiroProperties;

    private List<Realm> realms;

    private Map<String, String> filterChainDefinitionMap = new HashMap<>();

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealms(realms);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        filterChainDefinitionMap.put("/**", "authc,perms[admin:manage]");
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setLoginUrl(shiroProperties.getLoginUrl());
        shiroFilter.setSuccessUrl(shiroProperties.getSuccessUrl());
        shiroFilter.setUnauthorizedUrl(shiroProperties.getUnauthorizedUrl());
        return shiroFilter;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.realms = ApplicationContextUtils.getBean(Realm.class, shiroProperties.getRealm());
        List<String> anons = shiroProperties.getChain().getAnon();
        if (!CollectionUtils.isEmpty(anons)) {
            filterChainDefinitionMap.putAll(ShiroFilterUtils.mapFilterChain(anons, ShiroFilterUtils.FILTER_CHAIN_ANON));
        }
        List<String> logouts = shiroProperties.getChain().getLogout();
        if (!CollectionUtils.isEmpty(logouts)) {
            filterChainDefinitionMap.putAll(ShiroFilterUtils.mapFilterChain(logouts, ShiroFilterUtils.FILTER_CHAIN_LOGOUT));
        }
    }

}
