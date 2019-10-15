package eecs1022.lab3;

/**
 * Created by user on 1/29/18.
 */
public class Game
{
    String R;
    String P;
    String S;
    boolean Round1;
    boolean Round2;
    boolean Round3;
    boolean gameover;
    String Winner;
    String Losser;
    public Game(){
        R="Rock";
        P="Paper";
        S="Scissors";
        Round1=false;
        Round2=false;
        Round3=false;
        Winner=" ";
        gameover=false;
        Losser=" ";
    }
    public String computeWin(String Player1,String Player2){
        String Winner=" ";
        String Losser=" ";
        if(Player1.equals("Rock")&&Player2.equals("Scissors")){
            Winner="Player1";
            Losser="Player2";
        }
        else if(Player1.equals("Scissors")&&Player2.equals("Rock")){
            Winner="Player2";
            Losser="Player1";
        }
        else if(Player1.equals("Paper")&&Player2.equals("Rock")){
            Winner="Player1";
            Losser="Player2";
        }
        else if(Player1.equals("Rock")&&Player2.equals("Paper")){
            Winner="Player2";
            Losser="Player1";
        }
        else if(Player1.equals("Scissors")&&Player2.equals("Paper")){
            Winner="Player1";
            Losser="Player2";
        }
        else if(Player1.equals("Paper")&&Player2.equals("Scissors")){
            Winner="Player2";
            Losser="Player1";
        }
        else{
            Winner="Tie";
            Losser="Tie";
        }
        this.Winner=Winner;
        this.Losser=Losser;
        return Winner;

    }
    public void setRound1(boolean n){
        this.Round1=n;
    }
    public void setRound2(boolean n){
        this.Round2=n;
    }
    public void setRound3(boolean n){
        this.Round3=n;
    }
    public void setgameover(boolean b){this.gameover=b;}
    public boolean getRound1(){
       return this.Round1;
    }
    public boolean getRound2(){
        return this.Round2;
    }
    public boolean getRound3(){
        return this.Round3;
    }
    public boolean getgameover(){return this.gameover;}
}

