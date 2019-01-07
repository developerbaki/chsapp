/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsapp.dao;

import com.chsapp.model.Appointment;
import java.util.List;

/**
 * * @author baki
 */
public interface AppointmentDao {
    public List <Appointment> getPatientAppointments(String userName); //select işlemi sql
    public boolean newPatientAppointment(Appointment appointment); //insert işlemi sql
    public List <Appointment> getDoctorAppointments(String userName);
    public void deleteDoctorAppointment(int appointmentId);
    
}
