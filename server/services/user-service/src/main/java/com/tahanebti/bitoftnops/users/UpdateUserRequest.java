package com.tahanebti.bitoftnops.users;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UpdateUserRequest {

	@Schema(example = "ginady")
	 @Email
	 private String username;

	 @Schema(example = "taha.nebti-2@gmail.com")
	 @Email
	 private String email;

}