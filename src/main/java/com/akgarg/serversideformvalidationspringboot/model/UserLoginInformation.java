package com.akgarg.serversideformvalidationspringboot.model;

import javax.validation.constraints.NotBlank;

@SuppressWarnings("unused")
public class UserLoginInformation {

    @NotBlank(message = "Username can't be empty")
    private String username;

    @NotBlank(message = "password can't be empty")
    private String password;

    @NotBlank(message = "Please accept T&C")
    private String checkbox;

    public UserLoginInformation() {
    }

    public UserLoginInformation(String username, String password, String checkbox) {
        this.username = username;
        this.password = password;
        this.checkbox = checkbox;
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

    public String getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    @Override
    public String toString() {
        return "UserLoginInformation{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", checkbox='" + checkbox + '\'' +
                '}';
    }
}