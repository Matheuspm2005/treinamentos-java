package oop.college;

public class Student extends Person{
    private int subjects;
    private String course;

    @Override
    public String toString() {
        return "Student{" +
                "subjects=" + subjects +
                ", course='" + course + '\'' +
                '}';
    }

    public void withdraw(){
        System.out.println("Enrollment cancelled!");
    }

    public int getSubjects() {
        return subjects;
    }

    public void setSubjects(int subjects) {
        this.subjects = subjects;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
