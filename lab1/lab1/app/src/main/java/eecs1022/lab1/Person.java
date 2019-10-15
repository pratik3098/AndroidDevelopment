package eecs1022.lab1;

/**
 * Created by user on 1/21/18.
 */
public class Person
{
    String name;
    double weight;
    double height;
    double bmi;
    String result;
    public Person (String n,double w, double h){
        this.name=n;
        this.weight=w;
        this.height=h;
        this.bmi=getBMI();
        this.result=bmiresult(this.bmi);
    }

    double getBMI(){
        double bmi=this.weight/(this.height*this.height);
        return bmi;
    }

    public String bmiresult(double bmi){
        String result;
        if(bmi<18.5){
            result="Underweight";
        }
        else if(bmi<25){
            result="Normal";
        }
        else if (bmi<30){
            result="Overweight";
        }
        else {
            result="Obese";
        }
        return result;
    }
    public double getbmi(){
        return this.bmi;
    }
    public String getname(){
        return this.name;
    }
    public String getresult(){
        return this.result;
    }
}
