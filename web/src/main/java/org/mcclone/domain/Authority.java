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
@Table(name = "T_DEMO_AUTHORITY")
public class Authority implements Serializable {
    private static final long serialVersionUID = -4294010195683012473L;

    private String id;
    private Set<RoleAuthority> roleAuthorities = new HashSet<>(0);
    private Set<AuthorityResource> authorityResources = new HashSet<>(0);

    public Authority() {
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authority")
    public Set<RoleAuthority> getRoleAuthorities() {
        return this.roleAuthorities;
    }

    public void setRoleAuthorities(Set<RoleAuthority> roleAuthorities) {
        this.roleAuthorities = roleAuthorities;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authority")
    public Set<AuthorityResource> getAuthorityResources() {
        return this.authorityResources;
    }

    public void setAuthorityResources(Set<AuthorityResource> authorityResources) {
        this.authorityResources = authorityResources;
    }

}
