package ca.roumani.lab2;

/**
 * Created by user on 1/21/18.
 */
public class PersonTax
{
    String name;
    String status;
    double income;
    double taxDue;
    double part1;
    double part2;
    double part3;
    double part4;
    public  PersonTax(String n,double in,String st){
        this.name=n;
        this.income=in;
        this.status=st;
        computeTax();
    }
    public PersonTax(){
        String name=" ";
        String status=" ";
        double income=0;
        double taxDue=0;
        double part1=0;
        double part2=0;
        double part3=0;
        double part4=0;
    }

    public void computeTax(){
        double t1=0;
        double t2=0;
        double t3=0;
        double part1=0;
        double part2=0;
        double part3=0;
        double part4=0;

        double temp=this.income;
        if(this.status.equals("Single")){
            t1=8350;
            t2=33950;
            t3=82250;
        }
        else if (this.status.equals("Married")){
            t1=16700;
            t2=67900;
            t3=137050;
        }
        else if (this.status.equals("Household")){
            t1=11950;
            t2=45500;
            t3=117450;
        }
        if(temp<=0){
            taxDue=0;
            part1=0;
            part2=0;
            part3=0;
            part4=0;
        }
        else if(temp<t1){
            part1=temp/10;

        }
        else if(temp<t2){
            part1=t1/10;
            temp-=t1;
            part2=(temp)*0.15;
            part3=0;
            part4=0;
        }
        else if(temp<t3){
            part1=t1/10;
            part2=(t2-t1)*0.15;
            temp-=t2;
            part3=temp*0.25;
            part4=0;

        }
        else{
            part1=t1/10;
            part2=(t2-t1)*0.15;
            part3=(t3-t2)*0.25;
            temp-=t3;
            part4=temp*0.30;
            if(part4<0){
                part4*=-1;
            }
        }
        this.part1=part1;
        this.part2=part2;
        this.part3=part3;
        this.part4=part4;
        this.taxDue=this.part1+this.part2+this.part3+this.part4;
    }
    public String getName(){
        return this.name;
    }
    public String getStatus(){
        return this.status;
    }
    public double getTaxDue(){
        return this.taxDue;
    }
    public double getPart1(){
        return this.part1;
    }
    public double getPart2(){
        return this.part2;
    }
    public double getPart3(){
        return this.part3;
    }
    public double getPart4(){
        return this.part4;
    }
}
