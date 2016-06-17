package org.mcclone.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhengsd
 */
@Entity
@Table(name = "T_CST_AUTHORITY_RESOURCE")
public class AuthorityResource implements Serializable {
    private static final long serialVersionUID = 1532496240120287942L;

    private String id;
    private Resource resource;
    private Authority authority;

    public AuthorityResource() {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RES_ID", nullable = false)
    public Resource getResource() {
        return this.resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTH_ID", nullable = false)
    public Authority getAuthority() {
        return this.authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
