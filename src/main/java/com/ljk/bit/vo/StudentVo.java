package com.ljk.bit.vo;

import com.ljk.bit.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentVo extends Student{
    private int role;
    public StudentVo(){}
    public StudentVo(int role) {
        this.role = role;
    }

    public StudentVo(String name, String email, String password, String studentID, String tutorID, String instrumentID, int role) {
        super(name, email, password, studentID, tutorID, instrumentID);
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentVo studentVo = (StudentVo) o;
        return role == studentVo.role;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), role);
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "role=" + role +
                '}';
    }
}
