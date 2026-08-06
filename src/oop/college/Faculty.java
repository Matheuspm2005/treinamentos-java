package oop.college;

public class Faculty extends Person{
    private String speciality;
    private int salary;

    public void increaseSalary(int i){
        setSalary(getSalary() + i);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "speciality='" + speciality + '\'' +
                ", salary=" + salary +
                '}';
    }

    //Special Methods
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
