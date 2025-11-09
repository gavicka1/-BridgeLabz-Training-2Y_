package com.school.data;
public class Student {
    public String name; public int m1, m2, m3;
    public Student(String n, int a, int b, int c) { name=n; m1=a; m2=b; m3=c; }
    public String toString() { return "Student: " + name + " Marks: " + m1 + ", " + m2 + ", " + m3; }
}