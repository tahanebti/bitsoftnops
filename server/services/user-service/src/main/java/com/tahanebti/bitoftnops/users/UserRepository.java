package com.tahanebti.bitoftnops.users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User>  {

	Optional<User> findByUsernameAndDeletedFalse(String username);

    Optional<User> findByEmailAndDeletedFalse(String email);

	boolean existsByUsernameAndDeletedFalse(String username);

	boolean existsByEmailAndDeletedFalse(String email);

	Optional<User> findByIdAndDeletedFalse(UUID id);

	List<User> findAllByDeletedFalse();
	
	List<User> findAllByDeletedFalse(Sort sort);
	
	Page<User> findAllByDeletedFalse(Specification<User> query, Pageable page);

	Page<User> findAllByDeletedFalse(Pageable page);

	

	  
}
