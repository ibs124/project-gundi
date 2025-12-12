package ibs124.gundi.model.entity;

import ibs124.gundi.model.enumm.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

    private RoleType type;

    public Role() {
        super();
    }

    public Role(RoleType x) {
        this();
        this.setType(x);
    }

    @Enumerated(EnumType.STRING)
    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }
}
