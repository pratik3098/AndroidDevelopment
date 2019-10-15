package eecs1022.lab5;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab5Activity extends AppCompatActivity
{
    Bank bank;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        bank = new Bank();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);
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


    private void setResult(String s){
        setContentsOfTextfield(R.id.result1,s);
    }
    private void resetResult(){
        setContentsOfTextfield(R.id.result1," ");
    }
    public void onClickCreateAccounts(View view)
    {
        resetResult();
        String name=getInputOfTextfield(R.id.name);
        double balance=Double.parseDouble(getInputOfTextfield(R.id.balance));
        bank.AccountCreation(name,balance);
        setResult(bank.getResult());
        bank.ResetResult();

    }
    public void onClickTransaction(View view){
        resetResult();
        String acc1=bank.conditioncheck(getInputOfTextfield(R.id.account1),'n');
        String acc2=bank.conditioncheck(getInputOfTextfield(R.id.account2),'n');
        double amount= Double.parseDouble(bank.conditioncheck(getInputOfTextfield(R.id.amount),'a'));
        int idFrom=bank.getClientId(acc1);
        int idTo=bank.getClientId(acc2);
        String ser=getItemSelected(R.id.service);
        bank.ClientTransaction(ser,idFrom,idTo,amount,acc1,acc2);
        setResult(bank.getResult());
        bank.ResetResult();

    }
    public void onClickStatement(View view)
    {
        resetResult();
        String name = bank.conditioncheck(getInputOfTextfield(R.id.accountName),'n');
        int id = bank.getClientId(name);
        bank.Statement(id, name);
        setResult(bank.getResult());
        bank.ResetResult();
    }
}
