package com.example.demo.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force=true)
@Table(name = "users")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

	
    @Column(name = "username")
    private String username;

    
    @Column(name = "password")
    private String password;
    
    
    @Column(name = "email")
    private String email;

    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	
	@Override
	public boolean isEnabled() {
		return true;
	} 
    
}






