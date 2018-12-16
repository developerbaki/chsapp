/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsapp.dao;

import java.util.List;

/**
 *
 * @author baki
 */
public interface Appointment {
    public void addAppointment(Appointment appointment);
    public void deleteAppointment(int Id);
    public void updateAppointment(Appointment appointment);
    public List <Appointment> getAppointmentInformation();
}
