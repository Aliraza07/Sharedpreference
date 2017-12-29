package com.example.user.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText ed1, ed2, ed3;
    public static final String MyPreferences = "pref";
    public static final String Name = "name";
    public static final String Phone = "phone";
    public static final String Mail = "mail";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);

        btn = (Button) findViewById(R.id.button1);
        sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = ed1.getText().toString();
                String ph = ed2.getText().toString();
                String ml = ed3.getText().toString();
                saveToSharePreff(n, ph, ml);
                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_SHORT).show();
            }
        });

        ed1.setText(sharedPreferences.getString("name", ""));
        ed2.setText(sharedPreferences.getString("phone", ""));
        ed3.setText(sharedPreferences.getString("mail", ""));

    }

    private void saveToSharePreff(String name, String phone, String mail) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("phone", phone);
        editor.putString("mail", mail);
        editor.commit();
    }

}
