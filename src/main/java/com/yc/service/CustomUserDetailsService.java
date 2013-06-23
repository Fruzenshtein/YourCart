package com.yc.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.UserRepository;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userDAO;

	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		
		com.yc.model.User domainUser = userDAO.findByEmail(email);

		return new SecurityUserDetails(domainUser);
	}
	
	private final class SecurityUserDetails extends com.yc.model.User 
		implements UserDetails, Serializable {

		private static final long serialVersionUID = 1L;
		SecurityUserDetails(com.yc.model.User user) {
			setId(user.getId());
			setEmail(user.getEmail());
			setPassword(user.getPassword());
			setRole(user.getRole());
		}
		
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(getRole().getId()));
			return authList;
		}
		
		public List<String> getRoles(Integer role) {

			List<String> roles = new ArrayList<String>();

			if (role.intValue() == 1) {
				roles.add("ROLE_USER");
				roles.add("ROLE_ADMIN");
			} else if (role.intValue() == 2) {
				roles.add("ROLE_USER");
			}
			return roles;
		}
		
		public List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			for (String role : roles) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
			return authorities;
		}

		public String getUsername() {
			return getEmail();
		}
		
		public boolean isAccountNonExpired() {return true;}
		public boolean isAccountNonLocked() {return true;}
		public boolean isCredentialsNonExpired() {return true;}
		public boolean isEnabled() {return true;}
		
	}

}
