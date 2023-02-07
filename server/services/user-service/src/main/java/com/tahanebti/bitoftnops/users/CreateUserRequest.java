package com.tahanebti.bitoftnops.users;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

		@Schema(example = "endagorian")
    	@NotBlank
    	private String username;
	
	    @Schema(example = "taha.nebti@test.com")
	    @NotBlank
	    @Email
	    private String email;
	    
	    
	    private String password;
	    
	    private Long roleId;
}