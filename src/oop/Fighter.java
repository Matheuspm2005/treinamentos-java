package oop;

public class Fighter {
    private String name;
    private String origin;
    private int age;
    private int height;
    private int weight;
    private String category;
    private int victory;
    private int loss;
    private int draw;

    public void introduceFighter(){
        System.out.printf("Born and raised in %s. %d years old, %d cm tall, %d kg.\n This beast has %d wins, " +
                "%d draws, and only %d losses.\n " +
                "I present to you the great %s fighter, %s!!!\n", getOrigin(), getAge(), getHeight(), getWeight(), getVictory(), getDraw(), getLoss(), getCategory(), getName());
    }
    public void status(){
        System.out.printf("Name: %s\nOrigin: %s\nAge: %d\nCategory: %s\nCard: %d/%d/%d\n",getName(), getOrigin(), getAge(), getCategory(), getVictory(), getLoss(), getDraw());
    }
    public void winFight(){
        setVictory(getVictory() + 1);
    }

    public void loseFight(){
        setLoss(getLoss() + 1);
    }

    public void drawFight(){
        setDraw(getDraw() + 1);
    }
    //Especial Methods
    public Fighter(String name, String origin, int age, int height, int weight, int victory, int loss, int draw){
        setName(name);
        this.origin = origin;
        this.age = age;
        this.height = height;
        setWeight(weight);
        this.victory = victory;
        this.loss = loss;
        this.draw = draw;
    }

    public String getOrigin() {
        return origin;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
        setCategory(weight);
    }

    public String getCategory() {
        return category;
    }

    private void setCategory(int weight) {
        if(weight < 52)
            category = "Invalid";
        else if(weight < 70)
            category = "Light Weight";
        else if(weight < 83)
            category = "Medium Weight";
        else if(weight < 110)
            category = "Heavy Weight";
        else category = "Invalid";
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}

