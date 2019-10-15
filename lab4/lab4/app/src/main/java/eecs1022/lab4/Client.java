package eecs1022.lab4;

/**
 * Created by user on 2/26/18.
 */
public class Client
{
    private String Name;
    private double balance;

    public Client(){
        this.Name=null;
        this.balance=0;
    }
    public Client(String n,double b){
        this.Name=n;
        this.balance=b;
    }
    public void setName(String n){
        this.Name=n;
    }
    public String getName(){
        return this.Name;
    }
    public void setBalance(double b){
        this.balance=b;
    }
    public double getBalance(){
        return this.balance;
    }
}
