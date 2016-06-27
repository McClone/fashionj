package org.fashionwork.shiro;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.fashionwork.shiro.service.SecuritySourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengsd
 */
@Configuration
@EnableConfigurationProperties(ShiroProperties.class)
@ConditionalOnWebApplication
public class WebShiroAutoConfiguration implements InitializingBean, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(WebShiroAutoConfiguration.class);

    @Autowired
    private ShiroProperties shiroProperties;

    private ApplicationContext applicationContext;

    private Map<String, String> filterChainDefinitionMap = new HashMap<>();

    @Autowired(required = false)
    private SecuritySourceService securitySourceService;

    @Bean
    public DefaultWebSecurityManager securityManager() {
        List<Realm> realms = this.getBean(Realm.class, shiroProperties.getRealm());
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealms(realms);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setLoginUrl(shiroProperties.getLoginUrl());
        shiroFilter.setSuccessUrl(shiroProperties.getSuccessUrl());
        shiroFilter.setUnauthorizedUrl(shiroProperties.getUnauthorizedUrl());
        logger.info(shiroFilter.getFilterChainDefinitionMap().toString());
        return shiroFilter;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<String> anons = shiroProperties.getChain().getAnon();
        if (!CollectionUtils.isEmpty(anons)) {
            filterChainDefinitionMap.putAll(ShiroFilterUtils.mapFilterChain(anons, ShiroFilterUtils.FILTER_CHAIN_ANON));
        }
        List<String> logouts = shiroProperties.getChain().getLogout();
        if (!CollectionUtils.isEmpty(logouts)) {
            filterChainDefinitionMap.putAll(ShiroFilterUtils.mapFilterChain(logouts, ShiroFilterUtils.FILTER_CHAIN_LOGOUT));
        }
        String[] definitions = shiroProperties.getChain().getDefinitions();
        if (!ArrayUtils.isEmpty(definitions)) {
            setFilterChainDefinitions(definitions);
        }
        if (shiroProperties.getDataBase().getEnable() && securitySourceService != null) {
            for (String authority : securitySourceService.getAuthority()) {
                for (String resource : securitySourceService.getResources(authority)) {
                    String definition = String.format("%s=perms[%s]", resource, authority);
                    setFilterChainDefinitions(definition);
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("GET ApplicationContext......");
        this.applicationContext = applicationContext;
    }

    private <T> List<T> getBean(Class<T> tClass, String... beanNames) throws BeansException {
        List<T> beans = new ArrayList<>();
        for (String beanName : beanNames) {
            beans.add(this.applicationContext.getBean(beanName, tClass));
        }
        return beans;
    }

    private void setFilterChainDefinitions(String... definitions) {
        for (String definition : definitions) {
            setFilterChainDefinitions(definition);
        }
    }

    private void setFilterChainDefinitions(String definition) {
        Ini ini = new Ini();
        ini.load(definition);
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (org.apache.shiro.util.CollectionUtils.isEmpty(section)) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        setFilterChainDefinitionMap(section);
    }

    private void setFilterChainDefinitionMap(Map<String, String> section) {
        filterChainDefinitionMap.putAll(section);
    }

}
