/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsapp.dao;

import com.chsapp.model.LoginModel;
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
    public LoginModel loginUser(String userName, String password) {
        LoginModel loginModel = new LoginModel();
        loginModel.Success = false;
        try (Connection conn = DBConnectionUtility.DBConnectionUtility()) {
            String query = "SELECT user.username, user_role.name as role FROM user LEFT JOIN user_role ON user.user_role_id=user_role.id WHERE user.username=? AND user.password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                loginModel.Username = rs.getString("username");
                loginModel.Rolename = rs.getString("role");
                loginModel.Success = true;
                //loginModel.unreadMessageCount = 5;
            }

            return loginModel;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginModel;
    }
}
