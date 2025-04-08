package org.example.Models;


public class Admin extends Account {

    public Admin(String username, String password, int age,String email,String role) {

        super(username, password,age,email,"Admin");
    }

}

