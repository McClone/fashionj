package org.fashionwork.springboot.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengsd
 */
public class ShiroFilterUtils {

    public static final String FILTER_CHAIN_ANON = "anon";

    public static final String FILTER_CHAIN_LOGOUT = "logout";

    public static Map<String, String> mapFilterChain(List<String> chains, String filterName) {
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        for (String chain : chains) {
            filterChainDefinitionMap.put(chain, filterName);
        }
        return filterChainDefinitionMap;
    }
}
