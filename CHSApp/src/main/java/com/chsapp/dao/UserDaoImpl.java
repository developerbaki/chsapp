/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsapp.dao;

import com.chsapp.model.User;
import com.chsapp.util.DBConnectionUtility;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author baki
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean loginUser(String userName, String password) {
        try (Connection conn = DBConnectionUtility.DBConnectionUtility()) {
            String query = "select * from user where username=? and password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
           return rs.first();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } 
}
