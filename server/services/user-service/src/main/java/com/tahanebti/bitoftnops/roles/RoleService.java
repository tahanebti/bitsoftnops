package com.tahanebti.bitoftnops.roles;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;


public interface RoleService  {
	
	public UserRole save(UserRole role);
	
	public void delete(UserRole role);
	public void deleteById(Long id);
	public void deleteAll(List<Long> ids);
	
	public List<UserRole> getAll();
	public Page<UserRole> search(Specification<UserRole> query, Integer _limit, Integer _offset, String _sort);

	
	public Set<UserRole> getRolesByUserId(UUID id);

	public UserRole validateAndGetById(Long id);
}
