package model;

import lombok.Getter;

@Getter
public class APIUser {
    private String name;
    private String password;

    public APIUser(String name, String password) {this.name = name; this.password = password;}

    public static APIUser testAPIUser = new APIUser(System.getProperty("user","user"),
                System.getProperty("password","password"));

}
