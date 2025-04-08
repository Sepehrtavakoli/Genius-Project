package org.example.Models;

import java.io.File;

public class Account {
    private String username;
    private String password;
    private int age;
    private String email;
    private String role;
    public Account(String username, String password, int age, String email, String role) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Username" + username + " Age" + age + " Email" + email + " Role" + role;
    }
}
