package com.tahanebti.bitoftnops.roles;

import java.time.Instant;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tahanebti.bitOftnOps.core.domain.LongIdEntity;
import com.tahanebti.bitoftnops.users.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role extends LongIdEntity{

	@NotNull
    @Size(max = 50)
    @Column(length = 50, unique = true)
    private String name;
	
}
