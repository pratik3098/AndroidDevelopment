package eecs1022.lab5;

/**
 * Created by user on 3/1/18.
 */
public class Client
{
    private final int Max_num;
    private int count;
    private String Name;
    private double balance;
    private Transaction[] history;

    public Client(){
        this.Max_num=10;
        this.count=0;
        this.Name=null;
        this.balance=0;
        this.history=new Transaction[Max_num];
    }
    public Client(String n,double b){
        this.Max_num=10;
        this.Name=n;
        this.balance=b;
        this.count=0;
        this.history=new Transaction[Max_num];
    }
    public boolean Max_numReached(){
        if(this.Max_num==this.count)
            return true;
        else
            return false;
    }
    public void addTransaction(String type,double amount){
        if(this.count<this.Max_num)
        {
            this.history[this.count] = new Transaction(type, amount);
            this.count++;
        }
    }
    public Transaction getTransactionbyId(int id){
        if(id<this.count&&id>=0){
            return this.history[id];
        }
        else
            return null;
    }
    public int getTransactionCount(){
        return this.count;
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
