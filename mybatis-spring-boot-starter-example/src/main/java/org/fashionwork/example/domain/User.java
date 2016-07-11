package org.fashionwork.example.domain;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1274709860011177114L;
    private String id;
    private String userId;
    private String userName;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
