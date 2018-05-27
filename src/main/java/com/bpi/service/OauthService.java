package com.bpi.service;

import java.util.List;

import com.bpi.model.Oauth;

public interface OauthService {

    Oauth save(Oauth user);
    List<Oauth> findAll();
    void delete(long id);
}
