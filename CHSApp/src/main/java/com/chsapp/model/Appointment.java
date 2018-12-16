/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsapp.model;

/**
 *
 * @author baki
 */
public class Appointment {
    public int Id;
    public int patientId;
    public int appointmentStatusId;
    public Patient patient;
    public AppointmentStatus appointmentStatus;
}
