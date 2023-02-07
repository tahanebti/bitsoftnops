package com.tahanebti.bitoftnops.roles;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.tahanebti.bitOftnOps.core.exception.DataDeletionException;

import com.tahanebti.bitOftnOps.core.utils.PageRequestBuilder;
import com.tahanebti.bitoftnops.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{



	private final RoleRepository roleRepository;


	@Override
	public UserRole save(UserRole role) {
		return roleRepository.save(role);
	}


	@Override
	public void delete(UserRole role) {
		try {
			roleRepository.delete(role);
		} catch (DataIntegrityViolationException ex) {
			 throw new DataDeletionException(role);
		}
		
	}

	  @Override
	  public void deleteById(Long id) {
		   Optional<UserRole> entity = roleRepository.findByIdAndDeletedFalse(id);
	    if (entity.isPresent()) {
	      delete(entity.get());
	    }
	  }
	@Override
	public void deleteAll(List<Long> ids) {
		roleRepository.deleteAllByIdInBatch(ids);
	}


	@Override
	public List<UserRole> getAll() {
		return roleRepository.findAllByDeletedFalse();
	}


	@Override
	public Page<UserRole> search(Specification<UserRole> query, Integer _limit, Integer _offset, String _sort) {
		Pageable page = PageRequestBuilder.getPageRequest(_limit, _offset, _sort);
        return roleRepository.findAllByDeletedFalse(query, page);
	}
	
	
	@Override
	public Set<UserRole> getRolesByUserId(UUID id) {
        return roleRepository.findRolesByUserId(id);		
	}

	@Override
	public UserRole validateAndGetById(Long id) {
		return roleRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Role with id %s not found", id)));
	}
	
	
}
