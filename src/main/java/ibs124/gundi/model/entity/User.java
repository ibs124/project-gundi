package ibs124.gundi.model.entity;

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
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private Set<Role> roles = new HashSet<>();
    private String username;
    private String password;
    private String fullName;
    private boolean enabled;

    public User() {
        super();
    }

    @Transient
    public Role removeRole(Role role) {
        this.getRoles().remove(role);
        return role;
    }

    @Transient
    public Role addRole(Role role) {
        this.getRoles().add(role);
        return role;
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
