package com.ljiangf.ObjectOrientedDesign;

public class Teacher implements Person{
    String name;
    String schoolName;
    String subject;

    @Override
    public void introduce(){
        System.out.println("I am a teacher.");
    }

    @Override
    public void work(){
        System.out.println("My work is to teach people " + subject);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }
}
