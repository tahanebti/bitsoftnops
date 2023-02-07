package com.tahanebti.bitoftnops.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.tahanebti.bitOftnOps.core.utils.PageRequestBuilder;
import com.tahanebti.bitoftnops.exceptions.UserNotFoundException;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    
	private final UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}


	@Override
	public void delete(User user) {
		   user.setDeleted(true);
		   userRepository.save(user);
	}
	
	  @Override
	  public void deleteById(UUID id) {
		   Optional<User> entity = userRepository.findByIdAndDeletedFalse(id);
	    if (entity.isPresent()) {
	      delete(entity.get());
	    }
	  }

	@Override
	public void deleteAll(List<UUID> ids) {
		userRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAllByDeletedFalse();
	}

	@Override
	public Page<User> search(Specification<User> query, Integer _limit, Integer _offset, String _sort) {
		Pageable page = PageRequestBuilder.getPageRequest(_limit, _offset, _sort);

		if(query == null) {
			return userRepository.findAllByDeletedFalse(page);
		}
		
		return userRepository.findAllByDeletedFalse(query, page);
	}


		
    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsernameAndDeletedFalse(username);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmailAndDeletedFalse(email);
    }

    @Override
    public boolean hasUserWithUsername(String username) {
        return userRepository.existsByUsernameAndDeletedFalse(username);
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.existsByEmailAndDeletedFalse(email);
    }
    
    @Override
    public User validateAndGetUserByUsername(String username) {
        return getUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
    }

	
	@Override
	public User validateAndGetById(UUID id) {
		return userRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", id)));
	}

}