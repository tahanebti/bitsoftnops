package com.tahanebti.bitoftnops.roles;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse  {

	private Long id;
	private String name;
	private Date createdAt;
	private Date updatedAt;
	
}