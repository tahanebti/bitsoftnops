package com.tahanebti.bitoftnops.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tahanebti.bitOftnOps.core.specification.SpecificationsBuilder;
import com.tahanebti.bitOftnOps.core.utils.PageRequestBuilder;
import com.tahanebti.bitoftnops.security.CustomUserDetails;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
	private final SpecificationsBuilder<User> spec;

	//create
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public UserResponse createUser(@Valid @RequestBody CreateUserRequest request) {
		User user = userMapper.toCreate(request);
		return userMapper.toResponse(userService.save(user));
	}
	
	//update
	@PatchMapping("/{id}")
	public UserResponse updateUser(@PathVariable UUID id, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
		User user = userService.validateAndGetById(id);

		Optional.ofNullable(updateUserRequest.getUsername()).ifPresent(user::setUsername);
		Optional.ofNullable(updateUserRequest.getEmail()).ifPresent(user::setEmail);
		
		user = userService.save(user);
		
		return userMapper.toResponse(user);
	}
	
	//delete
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
		User user = userService.validateAndGetById(id);
		userService.delete(user);
		return ResponseEntity.ok(true);
	}
	
	//get one

	@GetMapping("/{id}")
	public UserResponse getUser(@PathVariable UUID id) {
		User user = userService.validateAndGetById(id);
		return userMapper.toResponse(user);
	}

	
	//find list

	@GetMapping
	public List<UserResponse> find() {
		return userService.getAll().stream().map(userMapper::toResponse).collect(Collectors.toList());
	}
	
	//find page

	@GetMapping("/search")
	public Map<String, Object> search(
			@Parameter(description = "native query search {} -- Example : username=:eq:tahanebti&profile.firstName=:cn:taha") @RequestParam(required = false) String query,
			@RequestParam(required = false, defaultValue = "1") Integer _offset,
			@RequestParam(required = false, defaultValue = "10") Integer _limit,
			@RequestParam(required = false, defaultValue = "id") String _sort) throws JsonProcessingException {

		Page<User> pageEntity = userService.search(spec.with(query), _limit, _offset, _sort);

		Map<String, Object> response = new HashMap<>();
		response.put("payload",
				pageEntity.getContent().stream().map(userMapper::toResponse).collect(Collectors.toList()));

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(PageRequestBuilder.getPageRequest(_offset, _limit, _sort));
		Map<String, Object> map = mapper.readValue(json, Map.class);

		response.put("pageNumber", pageEntity.getNumber());
		response.put("pageSize", pageEntity.getSize());
		response.put("totalElements", pageEntity.getTotalElements());
		response.put("last", pageEntity.isLast());
		response.put("first", pageEntity.isFirst());
		response.put("numberOfElements", pageEntity.getNumberOfElements());
		response.put("empty", pageEntity.isEmpty());
		return response;
	}

	
    
    @GetMapping("/me")
    public UserResponse getCurrentUser(@AuthenticationPrincipal CustomUserDetails currentUser) {
        User user = userService.validateAndGetUserByUsername(currentUser.getUsername());
        return userMapper.toResponse(user);
    }

    

    @GetMapping("/{username}")
    public UserResponse getUser(@PathVariable String username) {
        return userMapper.toResponse(userService.validateAndGetUserByUsername(username));
    }

    @DeleteMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponse deleteUser(@PathVariable String username) {
        User user = userService.validateAndGetUserByUsername(username);
        userService.delete(user);
        return userMapper.toResponse(user);
    }
}