package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User
{
    //------ATTRIBUTES----//
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    //--------CONSTRUCTOR--------------//
    public Doctor(String name, String email)
    {
        super(name,email);
    }

    //-------GETTERS AND SETTERS---------//
    public String getSpeciality()
    {
        return speciality;
    }

    public void setSpeciality(String speciality)
    {
        this.speciality = speciality;
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments()
    {
        return availableAppointments;
    }

    //--------METHODS--------//
    public void addAvailableAppointment(String date, String time)
    {
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }

    //-----TO STRING-----//
    @Override
    public String toString()
    {
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    //--------ABSTRACT METHOD IMPLEMENTATION--------/
    @Override
    public void showDataUser()
    {
        System.out.println(toString());
    }

    //----------NESTED CLASS---------//
    public static class AvailableAppointment
    {
        //------ATTRIBUTES----//
        private int id;
        private Date date;
        private String time;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        //--------CONSTRUCTOR--------//
        public AvailableAppointment(String date, String time)
        {
            try
            {
                this.date = format.parse(date);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            this.time = time;
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

        public Date getDate(String DATE)
        {
            return date;
        }

        public String getDate()
        {
            return format.format(date);
        }

        public void setDate(Date date)
        {
            this.date = date;
        }

        public String getTime()
        {
            return time;
        }

        public void setTime(String time)
        {
            this.time = time;
        }

        //-----TO STRING-----//
        @Override
        public String toString()
        {
            return "Available Appointments \nDate: " +date+ "\nTime: " + time;
        }
    }
}
