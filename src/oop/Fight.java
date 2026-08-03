package oop;

import java.util.Objects;
import java.util.Random;

public class Fight{
    private Fighter challenger;
    private Fighter challenged;
    private boolean set;
    private int rounds;

    public void fight(){
        if(getSet()){
            System.out.println("###CHALLENGER###");
            challenger.introduceFighter();
            System.out.println("###CHALLENGED###");
            challenged.introduceFighter();
            Random random = new Random();
            int result = random.nextInt(3);
            switch(result) {
                case 0:
                    System.out.println("Draw!");
                    challenger.drawFight();
                    challenged.drawFight();
                    break;
                case 1:
                    System.out.println("Challenger Wins!");
                    challenger.winFight();
                    challenged.loseFight();
                    break;
                case 2:
                    System.out.println("Challenged Wins!");
                    challenged.winFight();
                    challenger.loseFight();
                    break;
            }
        }
        else
            System.out.println("Fight is not set");
    }
    public void scheduleFight(Fighter challenger, Fighter challenged, int rounds){
        if(!Objects.equals(challenger.getCategory(), "Invalid") && Objects.equals(challenger.getCategory(), challenged.getCategory()) && challenger!=challenged) {
            setSet(true);
            setRounds(rounds);
            setChallenger(challenger);
            setChallenged(challenged);
            System.out.println("Fight Scheduled!");
        }
        else {
            setSet(false);
            setRounds(rounds);
            setChallenger(challenger);
            setChallenged(challenged);
            System.out.println("The fight couldn't be set");
        }
    }

    public Fighter getChallenged() {
        return challenged;
    }

    private void setChallenged(Fighter challenged) {
        this.challenged = challenged;
    }

    public Fighter getChallenger() {
        return challenger;
    }

    private void setChallenger(Fighter challenger) {
        this.challenger = challenger;
    }

    public int getRounds() {
        return rounds;
    }

    private void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean getSet(){
        return set;
    }

    private void setSet(boolean set) {
        this.set = set;
    }
}
