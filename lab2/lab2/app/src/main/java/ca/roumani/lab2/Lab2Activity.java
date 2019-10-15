package ca.roumani.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab2Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
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
    private void resetcontent(int id){

        setContentsOfTextView(id," ");
    }
    public void computeTaxButtonClicked(View view){
        resetcontent(R.id.resultTaxdue);
        resetcontent(R.id.resultScheme);
        resetcontent(R.id.resultPart1);
        resetcontent(R.id.resultPart2);
        resetcontent(R.id.resultPart3);
        resetcontent(R.id.resultPart4);
        PersonTax p1=new PersonTax();
        String name=getInputofTextField(R.id.inputName);
        double income=Double.parseDouble(getInputofTextField(R.id.inputIncome));
        String status=getItemSelected(R.id.status);
        p1=new PersonTax(name,income,status);
        setContentsOfTextView(R.id.resultTaxdue,String.format("%s, your tax due is %.2f",p1.getName(),p1.getTaxDue()));
        if(p1.getTaxDue()>0)
        setContentsOfTextView(R.id.resultScheme,String.format("Calculation is based on the scheme of %s Filing:",p1.getStatus()));
        if(p1.getPart1()>0)
        setContentsOfTextView(R.id.resultPart1,String.format("Part I: $%.2f",p1.getPart1()));
        if(p1.getPart2()>0)
        setContentsOfTextView(R.id.resultPart2,String.format("Part II: $%.2f",p1.getPart2()));
        if(p1.getPart3()>0)
        setContentsOfTextView(R.id.resultPart3,String.format("Part III: $%.2f",p1.getPart3()));
        if(p1.getPart4()>0)
        setContentsOfTextView(R.id.resultPart4,String.format("Part IV: $%.2f",p1.getPart4()));
    }


}
