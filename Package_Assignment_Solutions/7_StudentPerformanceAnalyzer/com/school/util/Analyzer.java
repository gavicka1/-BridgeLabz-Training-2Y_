package com.school.util;
import com.school.data.Student;
public class Analyzer {
    public double average(Student s) { return (s.m1 + s.m2 + s.m3) / 3.0; }
    public String grade(double avg) {
        if(avg>=90) return "A"; else if(avg>=75) return "B"; else if(avg>=50) return "C"; else return "F";
    }
}