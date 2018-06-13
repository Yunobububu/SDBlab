package com.ljk.bit.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Student {
    private String name;
    private String email;
    private String password;
    private String studentID;
    private String tutor_ID;
    private String instrument_ID;

    public Student() {
    }

    public Student(String name, String email, String password,
                   String studentID, String tutor_ID, String instrument_ID) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.studentID = studentID;
        this.tutor_ID = tutor_ID;
        this.instrument_ID = instrument_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTutor_ID() {
        return tutor_ID;
    }

    public void setTutor_ID(String tutor_ID) {
        this.tutor_ID = tutor_ID;
    }

    public String getInstrument_ID() {
        return instrument_ID;
    }

    public void setInstrument_ID(String instrument_ID) {
        this.instrument_ID = instrument_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(password, student.password) &&
                Objects.equals(studentID, student.studentID) &&
                Objects.equals(tutor_ID, student.tutor_ID) &&
                Objects.equals(instrument_ID, student.instrument_ID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, email, password, studentID, tutor_ID, instrument_ID);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", studentID='" + studentID + '\'' +
                ", tutor_ID='" + tutor_ID + '\'' +
                ", instrument_ID='" + instrument_ID + '\'' +
                '}';
    }
}
