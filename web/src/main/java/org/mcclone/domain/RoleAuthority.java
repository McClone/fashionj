package org.mcclone.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhengsd
 */
@Entity
@Table(name = "T_CST_ROLE_AUTHORITY")
public class RoleAuthority implements Serializable {
    private static final long serialVersionUID = -7037705137883405875L;

    private String id;
    private Role role;
    private Authority authority;

    public RoleAuthority() {
    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "ID", nullable = false, length = 32)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTH_ID", nullable = false)
    public Authority getAuthority() {
        return this.authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
