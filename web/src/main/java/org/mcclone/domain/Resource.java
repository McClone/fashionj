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
@Table(name = "T_DEMO_RESOURCE")
public class Resource implements Serializable {
    private static final long serialVersionUID = 8855474816852141102L;

    private String id;
    private Set<AuthorityResource> authorityResources = new HashSet<>();

    public Resource() {
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "resource")
    public Set<AuthorityResource> getAuthorityResources() {
        return this.authorityResources;
    }

    public void setAuthorityResources(Set<AuthorityResource> authorityResources) {
        this.authorityResources = authorityResources;
    }
}
