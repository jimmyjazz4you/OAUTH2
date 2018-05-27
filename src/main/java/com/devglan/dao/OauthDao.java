package com.devglan.dao;

import com.devglan.model.Oauth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthDao extends CrudRepository<Oauth, Long> {
    Oauth findByUsername(String username);
}
