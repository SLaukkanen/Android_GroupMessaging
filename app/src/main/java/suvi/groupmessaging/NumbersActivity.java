package suvi.groupmessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NumbersActivity extends AppCompatActivity {
    EditText name_to_del;
    Button buttonDel, buttonEdit, buttonSend;
    SharedPreferences inputs = MainActivity.numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        TextView textName1 = (TextView)findViewById(R.id.Name1);
        TextView textNumber1 = (TextView)findViewById(R.id.Number1);
        TextView textName2 = (TextView)findViewById(R.id.Name2);
        TextView textNumber2 = (TextView)findViewById(R.id.Number2);
        TextView textName3 = (TextView)findViewById(R.id.Name3);
        TextView textNumber3 = (TextView)findViewById(R.id.Number3);
        TextView textName4 = (TextView)findViewById(R.id.Name4);
        TextView textNumber4 = (TextView)findViewById(R.id.Number4);
        TextView textName5 = (TextView)findViewById(R.id.Name5);
        TextView textNumber5 = (TextView)findViewById(R.id.Number5);
        TextView textName6 = (TextView)findViewById(R.id.Name6);
        TextView textNumber6 = (TextView)findViewById(R.id.Number6);
        TextView textName7 = (TextView)findViewById(R.id.Name7);
        TextView textNumber7 = (TextView)findViewById(R.id.Number7);
        TextView textName8 = (TextView)findViewById(R.id.Name8);
        TextView textNumber8 = (TextView)findViewById(R.id.Number8);
        TextView textName9 = (TextView)findViewById(R.id.Name9);
        TextView textNumber9 = (TextView)findViewById(R.id.Number9);
        TextView textName10 = (TextView)findViewById(R.id.Name10);
        TextView textNumber10 = (TextView)findViewById(R.id.Number10);

        if(inputs != null){
            setNameNumber(textName1, "Name1");
            setNameNumber(textNumber1, "Number1");
            setNameNumber(textName2, "Name2");
            setNameNumber(textNumber2, "Number2");
            setNameNumber(textName3, "Name3");
            setNameNumber(textNumber3, "Number3");
            setNameNumber(textName4, "Name4");
            setNameNumber(textNumber4, "Number4");
            setNameNumber(textName5, "Name5");
            setNameNumber(textNumber5, "Number5");
            setNameNumber(textName6, "Name6");
            setNameNumber(textNumber6, "Number6");
            setNameNumber(textName7, "Name7");
            setNameNumber(textNumber7, "Number7");
            setNameNumber(textName8, "Name8");
            setNameNumber(textNumber8, "Number8");
            setNameNumber(textName9, "Name9");
            setNameNumber(textNumber9, "Number9");
            setNameNumber(textName10, "Name10");
            setNameNumber(textNumber10, "Number10");
        }

        buttonDel = (Button) findViewById(R.id.button_del);
        if (buttonDel != null) {
            buttonDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(NumbersActivity.this);
                    AlertDialog.Builder builder1 = builder.setMessage(R.string.del_num)
                            .setCancelable(false).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    name_to_del = (EditText)findViewById(R.id.n_del_edit);

                                    if(!name_to_del.getText().toString().isEmpty() || name_to_del != null){

                                        String nameToDel = name_to_del.getText().toString();
                                        String numDeleted = String.valueOf(getText(R.string.num_deleted));

                                        if (!nameToDel.isEmpty()) {
                                            if (nameToDel.equalsIgnoreCase(inputs.getString("Name1", ""))) {
                                                deleteName("Name1","Number1");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name2", ""))){
                                                deleteName("Name2","Number2");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name3", ""))){
                                                deleteName("Name3", "Number3");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name4", ""))){
                                                deleteName("Name4","Number4");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name5", ""))){
                                                deleteName("Name5","Number5");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name6", ""))){
                                                deleteName("Name6","Number6");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name7", ""))){
                                                deleteName("Name7","Number7");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name8", ""))){
                                                deleteName("Name8","Number8");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name9", ""))){
                                                deleteName("Name9","Number9");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else if(nameToDel.equalsIgnoreCase(inputs.getString("Name10", ""))){
                                                deleteName("Name10","Number10");
                                                showToast(numDeleted);
                                                reloadActivity();
                                            }else{
                                                showToast(String.valueOf(getText(R.string.name_not_found)));
                                            }
                                        }else{
                                            showToast(String.valueOf(getText(R.string.empty)));
                                        }
                                    }else{
                                        showToast(String.valueOf(getText(R.string.empty)));
                                    }
                                }
                            })
                            .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    showToast(String.valueOf(getText(R.string.clicked_no)));
                                }
                            });
                    builder.create();
                    builder.show();
                }
            });
        }

        buttonEdit = (Button) findViewById(R.id.button_edit);
        if (buttonEdit != null) {
            buttonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(NumbersActivity.this, EditNumbersActivity.class);
                    startActivity(intent);
                }
            });
        }

        buttonSend = (Button) findViewById(R.id.button_num_send);
        if (buttonSend != null) {
            buttonSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(NumbersActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void showToast(String text) {
        int duration = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void deleteName(String nameKey, String numberKey){
        SharedPreferences.Editor editor = inputs.edit();
        editor.putString(nameKey, "");
        editor.putString(numberKey, "");
        editor.apply();
    }

    public void reloadActivity(){
        Intent intent = new Intent(NumbersActivity.this, NumbersActivity.class);
        startActivity(intent);
    }

    public void setNameNumber(TextView text, String key){
        if (text != null) {
            text.setText(inputs.getString(key,""));
        }
    }
}
