package models;

public abstract class User
{
    //------ATTRIBUTES----//
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    //--------CONSTRUCTOR--------------//
    public User(String name, String email)
    {
        this.name = name;
        this.email = email;
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        if (phoneNumber.length() != 8)
            System.out.println("The phone number must have 8 numbers");
        else
            this.phoneNumber = phoneNumber;
    }

    //-----TO STRING-----//
    @Override
    public String toString()
    {
        return "User: " + name + ", Email: " + email + "\nAddress: "+ address + ". Phone: " + phoneNumber;
    }

    //-------ABSTRACT METHOD----------//
    public abstract void showDataUser();
}
