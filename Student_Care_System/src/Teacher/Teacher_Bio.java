package Teacher;

import java.io.*;
import java.util.*;

public class Teacher_Bio{

    private String name;
    private String user_name;
    private String phone_number;
    private String e_mail;
    private String password;
    private String department;

    private ArrayList<Teacher_Bio>AL = new ArrayList<>();

    public Teacher_Bio(String name, String user_name, String phone_number, String e_mail, String password, String department) {

        this.name = name;
        this.user_name = user_name;
        this.phone_number = phone_number;
        this.e_mail = e_mail;
        this.password = password;
        this.department = department;
    }
    public void Teacher_Bio_Access()
    {
        // ArrayList<Teacher_Bio>Teacher_list = new ArrayList<>();

        //Read Teacher Data


    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getE_mail() {
        return e_mail;
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}