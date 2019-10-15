package eecs1022.lab4;

/**
 * Created by user on 2/26/18.
 */

public class Bank
{
    private boolean AccountCreation;
    private Client client1;
    private Client client2;
    private Client client3;
    public Bank(){
        this.AccountCreation=false;
        this.client1=new Client();
        this.client2=new Client();
        this.client3=new Client();
    }
    public void ClientConstructor(Client c,int id){
        if(id==1){
            this.client1=c;
        }
        else if(id==2){
            this.client2=c;
        }
        else if(id==3){
            this.client3=c;
        }
    }
    public void setAccountCreation(boolean b){
        this.AccountCreation=b;
    }
    public boolean getAccountCreation(){
        return this.AccountCreation;
    }
    public Client getClientbyId(int id){
        Client c=null;
        if(id==1){
            c=this.client1;
        }
        else if(id==2){
            c=this.client2;
        }
        else if(id==3){
            c=this.client3;
        }
        return c;
    }
    public void setClientbyId(int id,Client c){
        if(id==1){
            this.client1=c;
        }
        else if(id==2){
            this.client2=c;
        }
        else if(id==3){
            this.client3=c;
        }
    }
    public void deposit(double d,int id){
        if(id==1){
            this.client1.setBalance(this.client1.getBalance()+d);
        }
        else if(id==2){
            this.client2.setBalance(this.client2.getBalance()+d);
        }
        else if(id==3){
            this.client3.setBalance(this.client3.getBalance()+d);
        }
    }
    public void withdraw(double w,int id){
        if(id==1){
            this.client1.setBalance(this.client1.getBalance()-w);
        }
        else if(id==2){
            this.client2.setBalance(this.client2.getBalance()-w);
        }
        else if(id==3){
            this.client3.setBalance(this.client3.getBalance()-w);
        }
    }
    public void transfer(double a,int idFrom,int idTo){
        this.withdraw(a,idFrom);
        this.deposit(a,idTo);
    }
}