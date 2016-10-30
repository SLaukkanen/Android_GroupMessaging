package suvi.groupmessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class EditNumbersActivity extends AppCompatActivity {
    EditText name_1, number_1, name_2, number_2, name_3, number_3, name_4, number_4,
            name_5, number_5, name_6, number_6, name_7, number_7, name_8, number_8, name_9, number_9,
            name_10, number_10;
    Button buttonSave;
    SharedPreferences prefs = MainActivity.numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_numbers);

        name_1 = (EditText) findViewById(R.id.e_name1_edit);
        number_1 = (EditText) findViewById(R.id.e_number1_edit);
        name_2 = (EditText) findViewById(R.id.e_name2_edit);
        number_2 = (EditText) findViewById(R.id.e_number2_edit);
        name_3 = (EditText) findViewById(R.id.e_name3_edit);
        number_3 = (EditText) findViewById(R.id.e_number3_edit);
        name_4 = (EditText) findViewById(R.id.e_name4_edit);
        number_4 = (EditText) findViewById(R.id.e_number4_edit);
        name_5 = (EditText) findViewById(R.id.e_name5_edit);
        number_5 = (EditText) findViewById(R.id.e_number5_edit);
        name_6 = (EditText) findViewById(R.id.e_name6_edit);
        number_6 = (EditText) findViewById(R.id.e_number6_edit);
        name_7 = (EditText) findViewById(R.id.e_name7_edit);
        number_7 = (EditText) findViewById(R.id.e_number7_edit);
        name_8 = (EditText) findViewById(R.id.e_name8_edit);
        number_8 = (EditText) findViewById(R.id.e_number8_edit);
        name_9 = (EditText) findViewById(R.id.e_name9_edit);
        number_9 = (EditText) findViewById(R.id.e_number9_edit);
        name_10 = (EditText) findViewById(R.id.e_name10_edit);
        number_10 = (EditText) findViewById(R.id.e_number10_edit);

        final String name_1_key = "Name1";
        final String number_1_key = "Number1";
        final String name_2_key = "Name2";
        final String number_2_key = "Number2";
        final String name_3_key = "Name3";
        final String number_3_key = "Number3";
        final String name_4_key = "Name4";
        final String number_4_key = "Number4";
        final String name_5_key = "Name5";
        final String number_5_key = "Number5";
        final String name_6_key = "Name6";
        final String number_6_key = "Number6";
        final String name_7_key = "Name7";
        final String number_7_key = "Number7";
        final String name_8_key = "Name8";
        final String number_8_key = "Number8";
        final String name_9_key = "Name9";
        final String number_9_key = "Number9";
        final String name_10_key = "Name10";
        final String number_10_key = "Number10";

        if (prefs != null) {
            setNameNumber(prefs.getString(name_1_key,""), name_1, prefs.getString(number_1_key,""), number_1);
            setNameNumber(prefs.getString(name_2_key,""), name_2, prefs.getString(number_2_key,""), number_2);
            setNameNumber(prefs.getString(name_3_key,""), name_3, prefs.getString(number_3_key,""), number_3);
            setNameNumber(prefs.getString(name_4_key,""), name_4, prefs.getString(number_4_key,""), number_4);
            setNameNumber(prefs.getString(name_5_key,""), name_5, prefs.getString(number_5_key,""), number_5);
            setNameNumber(prefs.getString(name_6_key,""), name_6, prefs.getString(number_6_key,""), number_6);
            setNameNumber(prefs.getString(name_7_key,""), name_7, prefs.getString(number_7_key,""), number_7);
            setNameNumber(prefs.getString(name_8_key,""), name_8, prefs.getString(number_8_key,""), number_8);
            setNameNumber(prefs.getString(name_9_key,""), name_9, prefs.getString(number_9_key,""), number_9);
            setNameNumber(prefs.getString(name_10_key,""), name_10, prefs.getString(number_10_key,""), number_10);
        }

        buttonSave = (Button) findViewById(R.id.button_save);
        if (buttonSave != null) {
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!name_1.getText().toString().isEmpty()){
                        if(name_1.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_1.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_1.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_1.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_1.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_1.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_1.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_1.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_1.getText().toString().equalsIgnoreCase(name_10.getText().toString())){
                            showToast((name_1.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_1.getText().toString())){
                                saveContact(name_1_key, name_1.getText().toString(), number_1_key, number_1.getText().toString());
                            }else{
                                showToast(name_1.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_1_key, name_1.getText().toString(), number_1_key, number_1.getText().toString());
                    }
                    if(!name_2.getText().toString().isEmpty()){
                        if(name_2.getText().toString().equalsIgnoreCase(name_1.getText().toString()) || name_2.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_2.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_2.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_2.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_2.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_2.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_2.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_2.getText().toString().equalsIgnoreCase(name_10.getText().toString())){
                            showToast((name_2.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_2.getText().toString())){
                                saveContact(name_2_key, name_2.getText().toString(), number_2_key, number_2.getText().toString());
                            }else{
                                showToast(name_2.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_2_key, name_2.getText().toString(), number_2_key, number_2.getText().toString());
                    }
                    if(!name_3.getText().toString().isEmpty()){
                        if(name_3.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_3.getText().toString().equalsIgnoreCase(name_1.getText().toString()) || name_3.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_3.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_3.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_3.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_3.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_3.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_3.getText().toString().equalsIgnoreCase(name_10.getText().toString())){
                            showToast((name_3.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_3.getText().toString())){
                                saveContact(name_3_key, name_3.getText().toString(), number_3_key, number_3.getText().toString());
                            }else{
                                showToast(name_3.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_3_key, name_3.getText().toString(), number_3_key, number_3.getText().toString());
                    }
                    if(!name_4.getText().toString().isEmpty()){
                        if(name_4.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_4.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_4.getText().toString().equalsIgnoreCase(name_1.getText().toString()) || name_4.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_4.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_4.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_4.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_4.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_4.getText().toString().equalsIgnoreCase(name_10.getText().toString())){
                            showToast((name_4.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_4.getText().toString())){
                                saveContact(name_4_key, name_4.getText().toString(), number_4_key, number_4.getText().toString());
                            }else{
                                showToast(name_4.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_4_key, name_4.getText().toString(), number_4_key, number_4.getText().toString());
                    }
                    if(!name_5.getText().toString().isEmpty()){
                        if(name_5.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_5.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_5.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_5.getText().toString().equalsIgnoreCase(name_1.getText().toString()) || name_5.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_5.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_5.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_5.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_5.getText().toString().equalsIgnoreCase(name_10.getText().toString())){
                            showToast((name_5.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_5.getText().toString())){
                                saveContact(name_5_key, name_5.getText().toString(), number_5_key, number_5.getText().toString());
                            }else{
                                showToast(name_5.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_5_key, name_5.getText().toString(), number_5_key, number_5.getText().toString());
                    }
                    if(!name_6.getText().toString().isEmpty()){
                        if(name_6.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_6.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_6.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_6.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_6.getText().toString().equalsIgnoreCase(name_1.getText().toString()) || name_6.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_6.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_6.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_6.getText().toString().equalsIgnoreCase(name_10.getText().toString())){
                            showToast((name_6.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_6.getText().toString())){
                                saveContact(name_6_key, name_6.getText().toString(), number_6_key, number_6.getText().toString());
                            }else{
                                showToast(name_6.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_6_key, name_6.getText().toString(), number_6_key, number_6.getText().toString());
                    }
                    if(!name_7.getText().toString().isEmpty()) {
                        if (name_7.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_7.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_7.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_7.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_7.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_7.getText().toString().equalsIgnoreCase(name_1.getText().toString()) || name_7.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_7.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_7.getText().toString().equalsIgnoreCase(name_10.getText().toString())) {
                            showToast((name_7.getText().toString() + " " + String.valueOf(getText(R.string.name_used))));
                        } else {
                            if(checkNumber(number_7.getText().toString())){
                                saveContact(name_7_key, name_7.getText().toString(), number_7_key, number_7.getText().toString());
                            }else{
                                showToast(name_7.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_7_key, name_7.getText().toString(), number_7_key, number_7.getText().toString());
                    }
                    if(!name_8.getText().toString().isEmpty()){
                        if(name_8.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_8.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_8.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_8.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_8.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_8.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_8.getText().toString().equalsIgnoreCase(name_1.getText().toString()) || name_8.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_8.getText().toString().equalsIgnoreCase(name_10.getText().toString())){
                            showToast((name_8.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_8.getText().toString())){
                                saveContact(name_8_key, name_8.getText().toString(), number_8_key, number_8.getText().toString());
                            }else{
                                showToast(name_8.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_8_key, name_8.getText().toString(), number_8_key, number_8.getText().toString());
                    }
                    if(!name_9.getText().toString().isEmpty()){
                        if(name_9.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_9.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_9.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_9.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_9.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_9.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_9.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_9.getText().toString().equalsIgnoreCase(name_1.getText().toString()) || name_9.getText().toString().equalsIgnoreCase(name_10.getText().toString())){
                            showToast((name_9.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_9.getText().toString())){
                                saveContact(name_9_key, name_9.getText().toString(), number_9_key, number_9.getText().toString());
                            }else{
                                showToast(name_9.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_9_key, name_9.getText().toString(), number_9_key, number_9.getText().toString());
                    }
                    if(!name_10.getText().toString().isEmpty()){
                        if(name_10.getText().toString().equalsIgnoreCase(name_2.getText().toString()) || name_10.getText().toString().equalsIgnoreCase(name_3.getText().toString()) || name_10.getText().toString().equalsIgnoreCase(name_4.getText().toString()) || name_10.getText().toString().equalsIgnoreCase(name_5.getText().toString()) || name_10.getText().toString().equalsIgnoreCase(name_6.getText().toString()) || name_10.getText().toString().equalsIgnoreCase(name_7.getText().toString()) || name_10.getText().toString().equalsIgnoreCase(name_8.getText().toString()) || name_10.getText().toString().equalsIgnoreCase(name_9.getText().toString()) || name_10.getText().toString().equalsIgnoreCase(name_1.getText().toString())){
                            showToast((name_10.getText().toString()+" "+String.valueOf(getText(R.string.name_used))));
                        }else{
                            if(checkNumber(number_10.getText().toString())){
                                saveContact(name_10_key, name_10.getText().toString(), number_10_key, number_10.getText().toString());
                            }else{
                                showToast(name_10.getText().toString()+": "+String.valueOf(getText(R.string.number_invalid)));
                            }
                        }
                    }else{
                        saveContact(name_10_key, name_10.getText().toString(), number_10_key, number_10.getText().toString());
                    }

                    showToast(String.valueOf(getText(R.string.saved)));
                    Intent intent = new Intent(EditNumbersActivity.this, NumbersActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = MainActivity.numbers;
    }

    public void showToast(String text) {
        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void saveContact(String nameKey, String name, String numberKey, String number){
        if(name.isEmpty()){
            name="";
        }
        if(number.isEmpty()){
            number="";
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(nameKey, name);
        editor.putString(numberKey, number);
        editor.apply();
    }

    /*setNameNumber method finds names and numbers from SharedPreferences
    * and sets them as preview text to the edittexts*/
    public void setNameNumber(String namePref, EditText name, String numberPref, EditText number){
        if(!namePref.isEmpty()){
            name.setText(namePref);
            number.setText(numberPref);
        }
    }

    public boolean checkNumber(String number){
        String regex = "[\\d]{7,15}";
        if (Pattern.matches(regex, number)){
            return true;
        }else{
            return false;
        }
    }
}
