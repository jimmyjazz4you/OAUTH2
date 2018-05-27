package com.bpi.service.impl;

import com.bpi.dao.OauthDao;
import com.bpi.model.Oauth;
import com.bpi.service.OauthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "oauthService")
public class OauthServiceImpl implements UserDetailsService, OauthService {
	
	@Autowired
	private OauthDao oauthDao;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Oauth user = oauthDao.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Oauth> findAll() {
		List<Oauth> list = new ArrayList<>();
		oauthDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		oauthDao.deleteById(id);
	}

	@Override
    public Oauth save(Oauth user) {
        return oauthDao.save(user);
    }
}
