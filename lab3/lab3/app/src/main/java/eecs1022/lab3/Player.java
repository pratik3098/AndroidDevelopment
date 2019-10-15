package eecs1022.lab3;

/**
 * Created by user on 1/29/18.
 */
public class Player
{
    String Name;
    String R1Value;
    String R2Value;
    String R3Value;
    int Round1Win;
    int Round2Win;
    int Round3Win;
    int Round1Score;
    int Round2Score;
    int Round3Score;
    int FinalScore;
    boolean Win;

    public Player()
    {
        this.Name=null;
        this.Round1Score = 0;
        this.Round2Score = 0;
        this.Round3Score = 0;
        this.FinalScore = 0;
        this.Round1Win=0;
        this.Round2Win=0;
        this.Round3Win=0;
        this.Win = false;
        this.R1Value = null;
        this.R2Value = null;
        this.R3Value = null;
    }
    public Player(String n){
        this.Name=n;
    }
    public void setValueR1(String v)
    {
        this.R1Value = v;

    }
    public void setPlayerName(String n){
        this.Name=n;
    }
    public void setValueR2(String v)
    {
        this.R2Value = v;
    }

    public void setValueR3(String v)
    {
        this.R3Value = v;
    }

    public void setWinner(boolean s)
    {
        this.Win = s;
    }

    public void setRound1Score(int n)
    {
        this.Round1Score = n;
    }
    public void setRound2Score(int n)
    {
        this.Round2Score = n;
    }
    public void setRound3Score(int n){
        this.Round3Score=n;
    }
    public void IncreamentFinal(){
        this.FinalScore++;
    }
    public int getFinalScore(){
        return this.FinalScore;
    }
    public String getName(){
        return this.Name;
    }
    public void setName(String n){
        this.Name=n;
    }
    public void setRound1Win(int n){
        this.Round1Win=n;
    }
    public void setRound2Win(int n){
        this.Round2Win=n;
    }
    public void setRound3Win(int n){
        this.Round3Win=n;
    }
}
