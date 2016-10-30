package suvi.groupmessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button buttonSend;
    public static SharedPreferences numbers;
    public static final String preferences = "Inputs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editText);
        numbers = getSharedPreferences(preferences, Context.MODE_PRIVATE);

        buttonSend = (Button) findViewById(R.id.button_send);
        if (buttonSend != null) {
            buttonSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(R.string.send_sms)
                            .setCancelable(false).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if(text.getText().toString().isEmpty() || numbers==null){
                                if(numbers==null){
                                    showToast(String.valueOf(getText(R.string.no_nmbrs)));
                                }
                                if(text.getText().toString().isEmpty()){
                                    showToast(String.valueOf(getText(R.string.empty_msg)));
                                }
                            }else{
                                sendMessage("Number1");
                                sendMessage("Number2");
                                sendMessage("Number3");
                                sendMessage("Number4");
                                sendMessage("Number5");
                                sendMessage("Number6");
                                sendMessage("Number7");
                                sendMessage("Number8");
                                sendMessage("Number9");
                                sendMessage("Number10");

                                showToast(String.valueOf(getText(R.string.msg_sent)));
                                //finish();
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

        Button buttonNumbers = (Button) findViewById(R.id.button_numbers);
        if (buttonNumbers != null) {
            buttonNumbers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
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

    public void sendMessage(String key){
        SmsManager smsManager = SmsManager.getDefault();
        String smsText = text.getText().toString();
        if(!numbers.getString(key,"").isEmpty()){
            smsManager.sendTextMessage(numbers.getString(key,""), null, smsText, null, null);
        }
    }
}
