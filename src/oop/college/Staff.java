package oop.college;

public class Staff extends Person{
    private String sector;
    private boolean working;

    @Override
    public String toString() {
        return "Staff{" +
                "sector='" + sector + '\'' +
                ", working=" + working +
                '}';
    }

    public void changeWork(){
        setWorking(!getWorking());
    }

    //Special Methods
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public boolean getWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
