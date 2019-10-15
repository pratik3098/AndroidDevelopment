package eecs1022.lab3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab3Activity extends AppCompatActivity
{
    Player player1;
    Player player2;
    Game   game;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        player1=new Player();
        player2=new Player();
        game=new Game();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        setContentsOfTextView(R.id.result1,"New Game Started.");
        setContentsOfTextView(R.id.result2,"Enter names of players");
    }
    private String getInputofTextField(int id){
        View view=findViewById(id);
        EditText editText=(EditText) view;
        String input =editText.getText().toString();
        return input;
    }

    private void setContentsOfTextView(int id, String newContents){
        View view=findViewById(id);
        TextView textview=(TextView) view;
        textview.setText(newContents);
    }
    private void setContentsOfTextinput(int id,String Contents){
        View view=findViewById(id);
        EditText editview=(EditText)view;
        editview.setText(Contents);
    }
    private void enadisEditText(int id,boolean n){
        View view=findViewById(id);
        TextView textview=(TextView)view;
        EditText editview=(EditText)view;
        editview.setEnabled(n);
        textview.setTextColor(Color.BLACK);
    }
    private String getItemSelected(int id){
        View view=findViewById(id);
        Spinner spinner=(Spinner) view;
        String string=spinner.getSelectedItem().toString();
        return string;
    }
    public void setNameFields(){
        setContentsOfTextView(R.id.result1,"New Game Started.");
        setContentsOfTextView(R.id.result2,"Enter names of players");
        setContentsOfTextinput(R.id.player1Name,null);
        setContentsOfTextinput(R.id.player2Name,null);
    }
    public void onClickStartNewGame(View view){
        game=new Game();
        player1=new Player();
        player2=new Player();
        enadisEditText(R.id.player1Name,true);
        enadisEditText(R.id.player2Name,true);
        setContentsOfTextView(R.id.result1,"New Game Started.");
        setContentsOfTextView(R.id.result2,"Enter names of players");
        setContentsOfTextinput(R.id.player1Name,null);
        setContentsOfTextinput(R.id.player2Name,null);

    }

    public void onClickFinishRound1(View view){

       if(!getInputofTextField(R.id.player1Name).isEmpty()&&!getInputofTextField(R.id.player2Name).isEmpty())
        {
            enadisEditText(R.id.player1Name,false);
            enadisEditText(R.id.player2Name,false);
            player1.setName(getInputofTextField(R.id.player1Name));
            player2.setName(getInputofTextField(R.id.player2Name));
            String p1value = getItemSelected(R.id.p1r1);
            String p2value = getItemSelected(R.id.p2r1);
            String result1 = " ";
            player1.setValueR1(p1value);
            player2.setValueR1(p2value);
            String Winner;

            if (game.getRound1() == false)
            {
                Winner = game.computeWin(p1value, p2value);
                if (Winner.equals("Player1"))
                {
                    player1.setRound1Score(1);
                    player1.IncreamentFinal();
                    player1.setRound1Win(1);
                    result1 = String.format("Round1 is finished: %s is winner.", player1.getName());
                    setContentsOfTextView(R.id.result2, result1);
                } else if (Winner.equals("Player2"))
                {
                    player2.setRound1Score(1);
                    player2.IncreamentFinal();
                    player2.setRound1Win(1);
                    result1 = String.format("Round1 is finished: %s is winner.", player2.getName());
                    setContentsOfTextView(R.id.result2, result1);
                } else if (Winner.equals("Tie"))
                {
                    result1 = String.format("Round1 is finished: Tie between %s and %s.", player1.getName(), player2.getName());
                    setContentsOfTextView(R.id.result2, result1);
                }
                game.setRound1(true);
                setContentsOfTextView(R.id.result1, " ");
            }
        }
        else{
            setNameFields();
        }
    }
    public void onClickInputField(View view){
        setContentsOfTextView(R.id.result1, " ");
        setContentsOfTextView(R.id.result2, " ");
    }
    public void onClickFinishRound2(View view){
        setContentsOfTextView(R.id.result1, " ");
        setContentsOfTextView(R.id.result2, " ");
        String result1=" ";
        String result2=" ";
        player1.setValueR2(getItemSelected(R.id.p1r2));
        player2.setValueR2(getItemSelected(R.id.p2r2));
        String Winner;

            if (game.getRound1() && game.getRound2() == false)
            {
                Winner = game.computeWin(getItemSelected(R.id.p1r2), getItemSelected(R.id.p2r2));
                if (Winner.equals("Player1"))
                {
                    player1.setRound2Score(1);
                    player1.IncreamentFinal();
                } else if (Winner.equals("Player2"))
                {
                    player2.setRound2Score(1);
                    player2.IncreamentFinal();
                }
                else if(Winner.equals("Tie")){
                    game.setgameover(false);
                    game.setRound2(true);
                    result2 = String.format("Round2 is finished: Tie between %s and %s", player1.getName(), player2.getName());
                    result1 = " ";
                    setContentsOfTextView(R.id.result1, result1);
                    setContentsOfTextView(R.id.result2, result2);
                    return;
                }
                if (player1.getFinalScore() > player2.getFinalScore())
                {
                    player1.Win = true;
                    game.setgameover(true);
                    Winner = player1.getName();
                    player1.setRound2Win(1);
                    result1 = String.format("Round2 is finshed: %s is winner.", Winner);
                    result2 = "Game is Over.";
                } else if (player1.getFinalScore() < player2.getFinalScore())
                {
                    player2.Win = true;
                    game.setgameover(true);
                    Winner = player2.getName();
                    player2.setRound2Win(1);
                    result1 = String.format("Round2 is finished: %s is winner", Winner);
                    result2 = "Game is Over.";
                } else
                {
                    game.setRound2(true);
                    result2 = String.format("Round2 is finished: Tie between %s and %s", player1.getName(), player2.getName());
                    result1 = " ";
                }

                setContentsOfTextView(R.id.result1, result1);
                setContentsOfTextView(R.id.result2, result2);
            }
    }
    public void onClickFinishRound3(View view){
        if(game.getgameover()){
            setContentsOfTextView(R.id.result1,"Error: Game is aldredy over");
            setContentsOfTextView(R.id.result2, " ");
            return;
        }
        setContentsOfTextView(R.id.result1, " ");
        setContentsOfTextView(R.id.result2, " ");
        String result1=" ";
        String result2 = "Game is Over.";
        String Winner=" ";
        String p1value=getItemSelected(R.id.p1r3);
        String p2value=getItemSelected(R.id.p2r3);
        player1.setValueR3(p1value);
        player2.setValueR3(p2value);
            if (game.getRound2() && game.getRound3() == false && game.getRound1())
            {
                Winner = game.computeWin(p1value, p2value);
                if (Winner.equals("Player1"))
                {
                    player1.setRound3Score(1);
                    player1.IncreamentFinal();
                } else if (Winner.equals("Player2"))
                {
                    player2.setRound3Score(1);
                    player2.IncreamentFinal();
                }
                if (player1.getFinalScore() > player2.getFinalScore())
                {
                    player1.Win = true;
                    game.setgameover(true);
                    Winner = player1.getName();
                    player1.setRound3Win(1);
                    result1 = String.format("Round3 is finshed: %s is winner.", Winner);
                    game.setRound3(true);
                    game.setgameover(true);
                } else if (player1.getFinalScore() < player2.getFinalScore())
                {
                    player2.Win = true;
                    game.setgameover(true);
                    Winner = player2.getName();
                    player2.setRound3Win(1);
                    result1 = String.format("Round3 is finished: %s is winner", Winner);
                    game.setRound3(true);
                    game.setgameover(true);
                } else
                {
                    game.setRound3(true);
                    game.setgameover(true);
                    result1 = String.format("Round3 is finished: Tie between %s and %s", player1.getName(), player2.getName());
                }
                if (game.getgameover())
                {
                    setContentsOfTextView(R.id.result1, result1);
                    setContentsOfTextView(R.id.result2, result2);
                }

            }

    }

}
