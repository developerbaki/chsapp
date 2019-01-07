/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsapp.dao;

import com.chsapp.model.Appointment;
import com.chsapp.model.AppointmentStatus;
import com.chsapp.model.Patient;
import com.chsapp.util.DBConnectionUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author baki
 */
public class AppointmentDaoImpl implements AppointmentDao {

    @Override
    public List<Appointment> getPatientAppointments(String userName) {
        List<Appointment> patientAppointments = new ArrayList<Appointment>();
        try (Connection conn = DBConnectionUtility.DBConnectionUtility()) {
            String query = "SELECT appointment.id AS id, appointment.appointmentstatus_id AS astatus_id, appointment_status.name AS astatus_name, appointment.patient_id AS apatient_id, patient.name AS patient_name, patient.surname AS patient_surname, appointment.date AS date FROM appointment \n"
                    + "LEFT JOIN patient ON appointment.patient_id=patient.id \n"
                    + "LEFT JOIN user ON patient.user_id=user.id \n"
                    + "LEFT JOIN appointment_status ON appointment.appointmentstatus_id=appointment_status.id\n"
                    + "WHERE patient.username=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.Id = resultSet.getInt("id");
                appointment.appointmentStatus = new AppointmentStatus();
                appointment.appointmentStatus.Id = resultSet.getInt("astatus_id"); // bu astatus_id diye verdiğim şey benim tablomun baslık isimleri.
                appointment.appointmentStatus.Name = resultSet.getString("astatus_name");
                appointment.patient = new Patient();
                appointment.patient.Id = resultSet.getInt("apatient_id");
                appointment.patient.Name = resultSet.getString("patient_name");
                appointment.patient.Surname = resultSet.getString("patient_surname");
                appointment.date = resultSet.getString("date");
                patientAppointments.add(appointment);

            }
            return patientAppointments;
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return patientAppointments;
        }

    }

    @Override
    public boolean newPatientAppointment(Appointment appointment) {

        try (Connection conn = DBConnectionUtility.DBConnectionUtility()) {
            String query = "insert into appointment (id, date, province, district, hospital, clinic) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, "id");
            preparedStatement.setString(2, "date");
            preparedStatement.setString(3, "province");
            preparedStatement.setString(4, "district");
            preparedStatement.setString(5, "hospital");
            preparedStatement.setString(6, "clinic");
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Appointment> getDoctorAppointments(String userName) {
        List<Appointment> doctorAppointments = new ArrayList<Appointment>();
        try (Connection conn = DBConnectionUtility.DBConnectionUtility()) {
            String query = "SELECT appointment.id AS id, appointment.patient_id AS pid, appointment.date AS date FROM appointment WHERE appointment.doctor_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.Id = resultSet.getInt("id");
                appointment.patientId = resultSet.getInt("pid");
                appointment.date = resultSet.getString("date");
                doctorAppointments.add(appointment);
                return doctorAppointments;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctorAppointments;
    }

    public void deleteDoctorAppointment(int appointmentId) {
        try (Connection conn = DBConnectionUtility.DBConnectionUtility()) {
            String query = ("delete from appointment where appointment.id= " + appointmentId);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, appointmentId);
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
