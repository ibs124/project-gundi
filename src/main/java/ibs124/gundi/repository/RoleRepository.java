package ibs124.gundi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibs124.gundi.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
