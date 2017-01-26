package org.mcclone.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mcclone on 16-8-27.
 */
@Entity
@Table(name = "T_DEMO_USER_DETAILS")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String userId;
    private String userName;

    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID", nullable = false, length = 32)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "USER_ID", nullable = false, length = 100)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "USER_NAME", nullable = false, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
