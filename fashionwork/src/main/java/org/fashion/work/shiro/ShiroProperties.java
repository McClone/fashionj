package org.fashion.work.shiro;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhengsd
 */
@ConfigurationProperties(prefix = "spring.shiro")
public class ShiroProperties {

    private String loginUrl;
    private String successUrl;
    private String unauthorizedUrl;
    private String realm;

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

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
}
