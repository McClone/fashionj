package org.mcclone.domain;

import org.mcclone.ext.data.orm.IdPersistable;
import org.mcclone.ext.data.orm.Persistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengsd
 */
@Entity
@Table(name = "T_DEMO_USER")
public class User extends IdPersistable<String> implements Persistable<String> {
    private static final long serialVersionUID = -4176815481548915650L;

    private String userId;
    private String password;
    private String userName;
    private Set<RoleUser> roleUsers = new HashSet<>();

    public User() {
    }

    public User(String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

    @Column(name = "USER_ID", nullable = false, length = 30)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "USER_NAME", nullable = false, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    public Set<RoleUser> getRoleUsers() {
        return this.roleUsers;
    }

    public void setRoleUsers(Set<RoleUser> roleUsers) {
        this.roleUsers = roleUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", id='" + this.getId() + '\'' +
                '}';
    }
}
