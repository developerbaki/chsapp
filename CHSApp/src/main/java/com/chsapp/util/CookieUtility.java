/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsapp.util;

import javax.servlet.http.Cookie;

/**
 *
 * @author baki
 */
public  class CookieUtility {

     public static String getKookieValue(Cookie[] cookies, String cookieName) {
        {
            String cookieValue = "";
            Cookie cookie;
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookieName.equals(cookie.getName())) {
                        cookieValue = cookie.getValue();
                    }
                }
            }
            return cookieValue;
        }
    }

}
