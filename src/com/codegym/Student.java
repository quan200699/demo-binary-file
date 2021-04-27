package com.codegym;

public class Student extends Person {
    private String studentId;
    private double mark;

    public Student() {
    }

    public Student(String studentId, double mark) {
        this.studentId = studentId;
        this.mark = mark;
    }

    public Student(String name, String address, int age, String studentId, double mark) {
        super(name, address, age);
        this.studentId = studentId;
        this.mark = mark;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", mark=" + mark +
                '}';
    }
}
