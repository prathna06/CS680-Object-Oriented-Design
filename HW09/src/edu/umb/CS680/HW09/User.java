package edu.umb.CS680.HW09;

public class User {
    private String name;
    private String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }


    public String getName(){
        return this.name;
    }
}
