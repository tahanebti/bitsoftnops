package com.tahanebti.bitoftnops.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tahanebti.bitOftnOps.core.domain.LongIdEntity;
import com.tahanebti.bitoftnops.users.User;

import lombok.*;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude = { "users", "privileges" })
@Entity
@Table(name = "roles")
public class UserRole extends LongIdEntity implements GrantedAuthority{


	@Enumerated(EnumType.STRING)
	@NaturalId
	private RoleName name;
	
	private String authorityContent;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();



	public boolean isAdminRole() {
		return null != this && this.name.equals(RoleName.ROLE_ADMIN);
	}

	@PreRemove
	private void removeRolesFromUsers() {
		for (User user : this.getUsers()) {
			user.getRoles().remove(this);
		}
	}

	@Override
	public String getAuthority() {
		return this.name.name();
	}
	
}
