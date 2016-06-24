package org.fashion.work.shiro;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author zhengsd
 */
@ConfigurationProperties(prefix = "spring.shiro")
public class ShiroProperties {

    private String loginUrl;
    private String successUrl;
    private String unauthorizedUrl;
    private String[] realm;
    private final Chain chain = new Chain();

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getUnauthorizedUrl() {
        return unauthorizedUrl;
    }

    public void setUnauthorizedUrl(String unauthorizedUrl) {
        this.unauthorizedUrl = unauthorizedUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String[] getRealm() {
        return realm;
    }

    public void setRealm(String[] realm) {
        this.realm = realm;
    }

    public Chain getChain() {
        return chain;
    }

    public static class Chain {
        private List<String> anon;
        private List<String> logout;
        private String[] definitions;

        public List<String> getAnon() {
            return anon;
        }

        public void setAnon(List<String> anon) {
            this.anon = anon;
        }

        public List<String> getLogout() {
            return logout;
        }

        public void setLogout(List<String> logout) {
            this.logout = logout;
        }

        public String[] getDefinitions() {
            return definitions;
        }

        public void setDefinitions(String[] definitions) {
            this.definitions = definitions;
        }
    }
}
