package com.tahanebti.bitoftnops.roles;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole>  {

	//Role findByName(String roleName);

	@Query(value = "select roles.* FROM ROLES roles WHERE roles.name = :name", nativeQuery = true)
    Optional<UserRole> findByName(@Param("name") RoleName roleName);
	
	//List<Role> findByPermissionEntityName(String name, String objectClass, String ext);


	@Query(value = "select roles.* FROM ROLES roles, USERS_ROLES ur WHERE roles.id = ur.role_id and ur.user_id = :id", nativeQuery = true)
    Set<UserRole> findRolesByUserId(@Param("id") UUID id);

	Optional<UserRole> findByIdAndDeletedFalse(Long id);

	List<UserRole> findAllByDeletedFalse();

	Page<UserRole> findAllByDeletedFalse(Specification<UserRole> query, Pageable page);

	
	
}
