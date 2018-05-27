package com.bpi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bpi.model.Oauth;

@Repository
public interface OauthDao extends CrudRepository<Oauth, Long> {
    Oauth findByUsername(String username);
}
