package com.tahanebti.bitoftnops.authentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignUpRequest {

    @Schema(example = "endagorion")
    @NotBlank
    private String username;
   
    @Schema(example = "passw@rd")
    @NotBlank
    private String password;
   
    @Schema(example = "taha.nebti@gmail.com")
    @Email
    private String email;
    
    private Boolean registerAsAdmin;
}