package oop.animal;

public class Dog extends Mammal{
    @Override
    public void makeSound() {
        System.out.println("Barking");
    }

    public void react(String speak){
        if(speak.equals("Fun"))
            System.out.println("The dog wags its tail.");
        else if(speak.equals("Angry"))
            System.out.println("The dog growls!");
        else
            System.out.println("The dog ignores...");
    }

    public void react(int age){
        if(age <= 7)
            System.out.println("The dog wants to play!");
        else
            System.out.println("The dog wants to rest.");
    }

    public void react(float weight){
        if(weight < 15)
            System.out.println("The dog can play all day!");
        else
            System.out.println("The dog is too heavy to run.");
    }
}
