/**
 * 
 */
package main.com.zc.security.impl;

import java.util.ArrayList;
import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Omnya Alaa
 * 
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	/*
	 * Mock for users from database. In the real application users will be
	 * retrieved from database and proper Spring UserDetails object will be
	 * created then for each database user.
	 */

	/*
	 * @Autowired IUserRepository userRep;
	 */
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		try {

			//LoginStaffDTO dao = loginSecAppService.getUserByMail(username);
			Collection<GrantedAuthority> studentAuthorities = new ArrayList<GrantedAuthority>();
			studentAuthorities.add(new GrantedAuthorityImpl("Admin"));
			UserDetails user = new User(username, "123456", true,
					true, true, true, studentAuthorities);
			return user;
		} catch (IndexOutOfBoundsException ex) {
			throw new UsernameNotFoundException("UserAccount for name \""
					+ username + "\" not found.");
		}

		
		
	}

}
