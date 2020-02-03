package org.openjfx.model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

     private String userName;
     private String firstName;
     private String lastName;
     private Image picture;

     private static HashMap<String, User> users = new HashMap<>();

    public User(String userName, String firstName, String lastName, Image picture) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
    }

    User(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Image getPicture() {
        return this.picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static void setUsers(HashMap<String, User> userList) {
        users = userList;
    }

    public static void addUsers(User user) {
        users.put(user.getUserName(), user);
    }
}
