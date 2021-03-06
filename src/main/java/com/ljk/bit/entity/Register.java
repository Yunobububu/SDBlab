package com.ljk.bit.entity;

import com.ljk.bit.validators.ValidatorRegisterGroup;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
@Component
public class Register {
    @Size(min = 1,max = 10,message = "{user.ID.length.error}",groups = {ValidatorRegisterGroup.class})
    private String userID;
    @Size(min = 1,max = 10,message = "{user.name.length.error}",groups = {ValidatorRegisterGroup.class})
    private String userName;
    private String password;
    private String email;
    @Range(message = "{user.role.null}",groups = {ValidatorRegisterGroup.class})
    private int role;

    public Register(String userID, String userName, String password, String email, int role) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Register() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Register{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return role == register.role &&
                Objects.equals(userID, register.userID) &&
                Objects.equals(userName, register.userName) &&
                Objects.equals(password, register.password) &&
                Objects.equals(email, register.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userID, userName, password, email, role);
    }
}
