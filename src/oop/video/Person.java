package oop.video;

public abstract class Person {
    protected String name;
    protected int age;
    protected char sex;
    protected float experience;

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.experience = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience, int views) {
        this.experience = getExperience() + experience / views;
    }
}
