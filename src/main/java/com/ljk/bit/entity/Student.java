package com.ljk.bit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.ljk.bit.dto.StudentJsonView;
import com.ljk.bit.dto.StudentJsonViewWithDetail;
import com.ljk.bit.validators.ValidatorStudentGroup;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.util.Objects;
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @JsonView(StudentJsonView.class)
    @Size(min = 1,max = 10,message = "{student.name.error}",groups = {ValidatorStudentGroup.class})
    private String name;
    private String email;
    @JsonView(StudentJsonViewWithDetail.class)
    private String password;
    private String studentID;
    private String tutorID;
    private String instrumentID;

    public Student() {
    }

    public Student(String name, String email, String password,
                   String studentID, String tutorID, String instrumentID) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.studentID = studentID;
        this.tutorID = tutorID;
        this.instrumentID = instrumentID;
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

    public String getTutorID() {
        return tutorID;
    }

    public void setTutorID(String tutorID) {
        this.tutorID = tutorID;
    }

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
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
                Objects.equals(tutorID, student.tutorID) &&
                Objects.equals(instrumentID, student.instrumentID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, email, password, studentID, tutorID, instrumentID);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", studentID='" + studentID + '\'' +
                ", tutorID='" + tutorID + '\'' +
                ", instrumentID='" + instrumentID + '\'' +
                '}';
    }
}
