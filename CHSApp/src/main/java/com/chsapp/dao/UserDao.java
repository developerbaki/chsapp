/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.chsapp.dao;

import com.chsapp.model.LoginModel;

/**
 *
 * @author baki
 */
//user login
public interface UserDao {
    public LoginModel loginUser(String userName, String password );
    
    
}
