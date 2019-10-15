package eecs1022.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab1Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
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
    private String getItemSelected(int id){
        View view=findViewById(id);
        Spinner spinner=(Spinner) view;
        String string=spinner.getSelectedItem().toString();
        return string;

    }
    public void computeBMIButtonClicked(View view){
        String textName=getInputofTextField(R.id.inputName);
        String textWeight=getInputofTextField(R.id.inputWeight);
        String textHeight=getInputofTextField(R.id.inputHeight);
        double weight=Double.parseDouble(textWeight);
        double height=Double.parseDouble(textHeight);
        String weightunit=getItemSelected(R.id.selectWeight);
        String heightunit=getItemSelected(R.id.selectHeight);
        if(weightunit.equals("Pounds"))
        {
            weight *= 0.453592;
        }
        if(heightunit.equals("Centimeters")){
            height*=0.01;
        }
        else if(heightunit.equals("Inches"))
        {
            height*=0.0254;
        }
        else if(heightunit.equals("Feets")){
            height*=0.3048;
        }
        Person person=new Person(textName,weight,height);
        double userbmi=person.getBMI();
        String contents=String.format("%s has BMI %.2f",person.getname(),person.getbmi());
        setContentsOfTextView(R.id.textAnswer,contents);
        setContentsOfTextView(R.id.textResult,String.format("You are %s",person.getresult()));
    }
}
