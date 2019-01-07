package com.chsapp.servlet;

import com.chsapp.dao.AppointmentDao;
import com.chsapp.dao.AppointmentDaoImpl;
import com.chsapp.dao.UserDaoImpl;
import com.chsapp.model.Appointment;
import com.chsapp.util.CookieUtility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        

        String userName = CookieUtility.getKookieValue(request.getCookies(), "username");
        List<Appointment> appointments = appointmentDaoImpl.getPatientAppointments(userName);
      
        int i=5;
       
        
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
    }
}
