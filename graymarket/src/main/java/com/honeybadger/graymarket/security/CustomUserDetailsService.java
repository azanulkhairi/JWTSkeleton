package com.honeybadger.graymarket.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honeybadger.graymarket.model.User;
import com.honeybadger.graymarket.repo.UserRepository;

/*The first method loadUserByUsername() is used by Spring security. Notice the use of findByUsernameOrEmail method. This allows users to log in using either username or email.
The second method loadUserById() will be used by JWTAuthenticationFilter that we’ll define shortly.
*/
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() ->
						new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
				);
		return UserPrincipal.create(user);
	}

	 // This method is used by JWTAuthenticationFilter
	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new UsernameNotFoundException("user not found with id :"+id)
			);
		return UserPrincipal.create(user);
		
	}
}
