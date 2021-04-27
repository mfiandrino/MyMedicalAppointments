package models;

import java.util.Date;

public class AppointmentDoctor implements ISchedulable
{
    //------ATTRIBUTES----//
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;

    //--------CONSTRUCTOR--------------//
    public AppointmentDoctor(Patient patient, Doctor doctor)
    {
        this.patient = patient;
        this.doctor = doctor;
    }

    //-------GETTERS AND SETTERS---------//
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time + " hrs.";
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    //-------INTERFACE IMPLEMENTATION------//
    @Override
    public void schedule(Date date, String time)
    {
        this.date = date;
        this.time = time;
    }
}