package com.devglan.service;

import com.devglan.model.Oauth;

import java.util.List;

public interface OauthService {

    Oauth save(Oauth user);
    List<Oauth> findAll();
    void delete(long id);
}
