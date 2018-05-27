package com.bpi.controller;

import com.bpi.model.Oauth;
import com.bpi.service.OauthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class OauthController {

    @Autowired
    private OauthService userService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<Oauth> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Oauth create(@RequestBody Oauth user){
        return userService.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return "success";
    }

}
