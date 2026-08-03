package oop;

public class bank {
    private long id;
    protected int balance;
    private char type;
    private String owner;
    private boolean status;

    public void openAccount(char type, String owner){
        setType(type);
        setStatus(true);
        if (type == 'c')
            setBalance(50);
        else if (type == 's')
            setBalance(150);
    }
    public void closeAccount(){
        if (getBalance() > 0) {
            System.out.println("Account still have money");
        }
        else if (getBalance() < 0){
            System.out.println("Account in debit");;
        }
        else
            System.out.println("Account closed");
    }
    public void withdrawal(int cash){
        if (getStatus())
            if (getBalance() >= cash)
                setBalance(getBalance() - cash);
            else
                System.out.println("Insufficient funds");
        else
            System.out.println("Account is closed");
    }
    public void deposit(int cash){
        if (getStatus())
            setBalance(getBalance() + cash);
        else
            System.out.println("Account is closed");
    }
    public void fee(){
        int tax;
        if (getType() == 'c')
            tax = 1000;
        else
            tax = 1500;

        if (getStatus()) {
            if (getBalance() < tax)
                System.out.println("Not enough money, account in debt");
            setBalance(getBalance() - tax);
        }
    }
    public void createAccount(){
        balance = 0;
        status = false;
    }
    public void setId(long num){
        id = num;
    }
    public void setType(char t){
        type = t;
    }
    public void setOwner(String o){
        owner = o;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public long getId(){
        return id;
    }
    public char getType(){
        return type;
    }
    public String getOwner(){
        return owner;
    }
    public int getBalance(){
        return balance;
    }
    public boolean getStatus(){
        return status;
    }
}
