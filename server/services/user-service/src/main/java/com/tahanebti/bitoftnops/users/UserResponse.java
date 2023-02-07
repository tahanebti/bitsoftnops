package com.tahanebti.bitoftnops.users;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {


	private UUID id;
	private String username;
	private String email; 
	private Date updatedAt;
	private Date createdAt;

}