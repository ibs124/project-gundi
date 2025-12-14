package ibs124.gundi.model.domain;

import java.util.HashSet;
import java.util.Set;

import ibs124.gundi.config.JpaConfig;
import ibs124.gundi.validation.constraint.ValidPassword;
import ibs124.gundi.validation.constraint.ValidUsername;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private Set<Email> emails = new HashSet<>();
    private VerificationToken token;
    private Set<Role> roles = new HashSet<>();
    private String username;
    private String password;
    private String fullName;
    private boolean enabled;

    public User() {
        super();
    }

    @Transient
    public boolean add(Email x) {
        x.setUser(this);
        return this.getEmails().add(x);
    }

    @Transient
    public boolean remove(Email x) {
        return this.getEmails().remove(x);
    }

    @Transient
    public boolean add(Role x) {
        return this.getRoles().add(x);
    }

    @Transient
    public boolean remove(Role x) {
        return this.getRoles().remove(x);
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    public VerificationToken getToken() {
        return token;
    }

    public void setToken(VerificationToken token) {
        this.token = token;
        token.setUser(this);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles_map", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ValidPassword
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ValidUsername
    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false, columnDefinition = JpaConfig.COLUMN_BOOLEAN)
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
