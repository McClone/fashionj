package org.mcclone.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengsd
 */
@Entity
@Table(name = "T_DEMO_ROLE")
public class Role implements Serializable {
    private static final long serialVersionUID = -493266446483197230L;

    private String id;
    private Set<RoleUser> roleUsers = new HashSet<>();
    private Set<RoleAuthority> roleAuthorities = new HashSet<>();

    public Role() {
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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
    public Set<RoleUser> getRoleUsers() {
        return this.roleUsers;
    }

    public void setRoleUsers(Set<RoleUser> roleUsers) {
        this.roleUsers = roleUsers;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
    public Set<RoleAuthority> getRoleAuthorities() {
        return this.roleAuthorities;
    }

    public void setRoleAuthorities(Set<RoleAuthority> roleAuthorities) {
        this.roleAuthorities = roleAuthorities;
    }

}
