package com.mhwc.jobPlatform.service;


import com.mhwc.jobPlatform.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
	public User findByUserName(String userName);

	public User findById(Long id);

	public User findByEmail(String email);

	public User save(User user, List<GrantedAuthority> authorities);
	public User findByEmailAndPhoneNumber(String email, String phoneNumber);

	public User save(User user);
}
