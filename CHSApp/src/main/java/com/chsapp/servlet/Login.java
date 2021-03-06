package com.chsapp.servlet;

import com.chsapp.dao.UserDaoImpl;
import com.chsapp.model.LoginModel;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDaoImpl userDao = new UserDaoImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        int i=5;
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String un = request.getParameter("uname");
        String pw = request.getParameter("pass");

        PrintWriter out = response.getWriter();

        LoginModel loginModel = userDao.loginUser(un, pw);
        if (loginModel.Success) {
            Cookie ckUser = new Cookie("username", loginModel.Username);
            ckUser.setMaxAge(600);
            response.addCookie(ckUser);
            Cookie ckRole = new Cookie("role", loginModel.Rolename);
            ckRole.setMaxAge(600);
            response.addCookie(ckRole);

          /*  Cookie ckunreadMessageCount = new Cookie("unreadMessageCount", loginModel.unreadMessageCount.toString());
            ckRole.setMaxAge(600);
            response.addCookie(ckunreadMessageCount);
*/
            response.sendRedirect("home.jsp");
            return;
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            out.println("<font color=red>Girilen Bilgiler Yanlış</font>");
            rd.include(request, response);
        }
    }
}
