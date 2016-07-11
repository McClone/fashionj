package org.fashionwork.example.domain;

import org.hibernate.search.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhengsd
 */
@Entity
@Indexed
@Table(name = "T_DEMO_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1274709860011177114L;
    private String id;
    private String userId;
    private String userName;

    @Id
    @Column(name = "ID", nullable = false, length = 32)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Column(name = "USER_ID", nullable = false, length = 100)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
