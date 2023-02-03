package com.tahanebti.bitoftnops.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;

import com.tahanebti.bitOftnOps.core.domain.UuidEntity;
import com.tahanebti.bitoftnops.roles.Role;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "login"),
        @UniqueConstraint(columnNames = "email")
})
public class User extends UuidEntity {

	 	//@Pattern(regexp = Constants.LOGIN_REGEX)
	  	@Size(min = 1, max = 50)
	  	@Column( length = 50, unique = true, nullable = false)
	  	private String login;

	    
	    @NotNull
	    @Size(min = 60, max = 60)
	    @Column(length = 60, nullable = false)
	    private String password;
	    
	    @Email
	    @Size(min = 5, max = 254)
	    @Column(length = 254, unique = true)
	    private String email;

	    @NotNull
	    @Column(name = "is_active", nullable = false)
	    private boolean activated = true;

	    @NotNull
	    @Column(nullable = false)
	    private boolean enabled = false;

	    @Size(max = 20)
	    @Column(name = "activation_key", length = 20)
	    private String activationKey;

	    @Size(max = 20)
	    @Column(name = "reset_key", length = 20)
	    private String resetKey;

	    @Column(name = "reset_date")
	    private Instant resetDate = null;

	    
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "user_roles",
	        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
	        inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")}
	    )
	    @BatchSize(size = 20)
	    private Set<Role> roles = new HashSet<>();
	    // Lowercase the login before saving it in database
	    public void setLogin(String login) {
	        this.login = StringUtils.lowerCase(login, Locale.ENGLISH);
	    }

	
}
