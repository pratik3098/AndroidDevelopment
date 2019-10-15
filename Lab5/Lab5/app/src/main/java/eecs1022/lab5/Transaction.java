package eecs1022.lab5;

/**
 * Created by user on 3/1/18.
 */
public class Transaction
{
    private String type;
    private double amount;
    public Transaction(){
        this.type=null;
        this.amount=0;
    }

    public Transaction(String type,double amount){
        this.type=type;
        this.amount=amount;
    }
    public void setType(String t){
        this.type=t;
    }
    public void setAmount(double b){
        this.amount=b;
    }
    public String getType(){
        return this.type;
    }
    public double getAmount(){
        return this.amount;
    }
}
