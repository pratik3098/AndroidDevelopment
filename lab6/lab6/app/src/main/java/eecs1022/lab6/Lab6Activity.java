package eecs1022.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab6Activity extends AppCompatActivity
{
    Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        game=new Game();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);
    }
    private void setContentsOfTextfield(int id, String n)
    {
        View view = findViewById(id);
        TextView textview = (TextView) view;
        textview.setText(n);
    }

    private String getInputOfTextfield(int id)
    {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        return editText.getText().toString();
    }

    private String getItemSelected(int id)
    {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        return spinner.getSelectedItem().toString();
    }

    public void Gamestart(View view){
        game=new Game();
        setContentsOfTextfield(R.id.result1,game.getResult());
        String p1=getInputOfTextfield(R.id.player1);
        String p2=getInputOfTextfield(R.id.player2);
        String pfirst=getItemSelected(R.id.playerselect);
        game.gamestart(p1,p2,pfirst);
        setContentsOfTextfield(R.id.result1,game.getResult());

    }
    public void Play(View view){
        game.play(Integer.parseInt(getItemSelected(R.id.spin1)),Integer.parseInt(getItemSelected(R.id.spin2)));
        setContentsOfTextfield(R.id.result1,game.getResult());
    }

}
