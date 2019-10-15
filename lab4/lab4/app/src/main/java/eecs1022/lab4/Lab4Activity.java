package eecs1022.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab4Activity extends AppCompatActivity
{
    Bank bank;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        bank = new Bank();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);
    }

    private void setContentsOfTextfield(int id, String n)
    {
        View view = findViewById(id);
        TextView textview = (TextView) view;
        textview.setText(n);
    }

    private void setContentsOfTextinput(int id, String n)
    {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        editText.setText(n);
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

    private void setResultNameandBalance()
    {
        Client client1,client2,client3;
        client1=bank.getClientbyId(1);
        client2=bank.getClientbyId(2);
        client3=bank.getClientbyId(3);
        setContentsOfTextfield(R.id.result1, String.format("Client %s has $balance %.2f", client1.getName(), client1.getBalance()));
        setContentsOfTextfield(R.id.result2, String.format("Client %s has $balance %.2f", client2.getName(), client2.getBalance()));
        setContentsOfTextfield(R.id.result3, String.format("Client %s has $balance %.2f", client3.getName(), client3.getBalance()));
    }
    private void setResultError(String e){
        setContentsOfTextfield(R.id.result1, String.format("Error: Please enter valid %s",e));
        setContentsOfTextfield(R.id.result2, " ");
        setContentsOfTextfield(R.id.result3," ");
    }
    private int getId(String n){
        int id;
        if(n.equals("Client1")){
            id=1;
        }
        else if(n.equals("Client2")){
            id=2;
        }
        else if(n.equals("Client3")){
            id=3;
        }
        else{
            id=0;
        }
        return id;
    }
    public void onClickCreateAccounts(View view)
    {   double t;
        String n;
        Client c;
        t=Double.parseDouble(getInputOfTextfield(R.id.client1balance));
        n=getInputOfTextfield(R.id.client1name);
        c=new Client(n,t);
                bank.ClientConstructor(c, 1);
        t=Double.parseDouble(getInputOfTextfield(R.id.client2balance));
        n=getInputOfTextfield(R.id.client2name);
        c=new Client(n,t);
                bank.ClientConstructor(c, 2);
        t=Double.parseDouble(getInputOfTextfield(R.id.client3balance));
        n=getInputOfTextfield(R.id.client3name);
        c=new Client(n,t);
                bank.ClientConstructor(c, 3);
                bank.setAccountCreation(true);
        setResultNameandBalance();
    }
    public void onClickTransaction(View view){
        if(bank.getAccountCreation()){
            int idFrom=getId(getItemSelected(R.id.accown1));
            int idTo=getId(getItemSelected(R.id.accown2));
            double amount=Double.parseDouble(getInputOfTextfield(R.id.amount));
            if(getItemSelected(R.id.servicespin).equals("Deposit")){
                bank.deposit(amount,idTo);
                setResultNameandBalance();
            }
            else if(getItemSelected(R.id.servicespin).equals("Withdraw")){
                if(idFrom==0){
                    setResultError("Client");
                }
                else if(bank.getClientbyId(idFrom).getBalance()<amount){
                    setResultError("Amount");
                }
                else
                {
                    bank.withdraw(amount, idFrom);
                    setResultNameandBalance();
                }
            }
            else if(getItemSelected(R.id.servicespin).equals("Transfer")){
                if(idFrom==0){
                    setResultError("Client");
                }
                else if(bank.getClientbyId(idFrom).getBalance()<amount){
                    setResultError("Amount");
                }
                else
                {
                    bank.transfer(amount, idFrom, idTo);
                    setResultNameandBalance();
                }
            }
        }
    }
}
