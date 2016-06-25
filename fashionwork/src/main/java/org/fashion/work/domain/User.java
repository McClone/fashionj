package org.fashion.work.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhengsd
 */
@Entity
@Table(name = "T_DEMO_USER")
public class User implements Serializable{

    private static final long serialVersionUID = 1274709860011177114L;
    private String id;
    private String userId;
    private String userName;

    @Id
//    @GenericGenerator(name = "uuid", strategy = "uuid")
//    @GeneratedValue(generator = "uuid")
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
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
