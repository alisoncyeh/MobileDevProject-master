package com.example.herbert.utapp;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUTEID;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // custom typeface
        Typeface RalewayMedium = Typeface.createFromAsset(getAssets(), "Raleway-Medium.ttf");
        Typeface RalewayRegular = Typeface.createFromAsset(getAssets(), "Raleway-Regular.ttf");

        // set typeface to TextViews & Buttons
        TextView textViewUTEID = (TextView)findViewById(R.id.textViewUTEID);
        TextView textViewPassword = (TextView)findViewById(R.id.textViewPassword);
        TextView textView = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button);
        Button buttonGuest = (Button)findViewById(R.id.buttonGuest);
        EditText editTextUTEID = (EditText)findViewById(R.id.editTextUTEID);
        textViewPassword.setTypeface(RalewayMedium);
        textViewUTEID.setTypeface(RalewayMedium);
        textView.setTypeface(RalewayRegular);
        button.setTypeface(RalewayRegular);
        buttonGuest.setTypeface(RalewayRegular);
        editTextUTEID.setTypeface(RalewayRegular);

        // test git push

    }

    public void onButtonClick(View v) {

        editTextUTEID = (EditText) findViewById(R.id.editTextUTEID);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);


        if (v.getId() == R.id.button)
        {
            if (editTextUTEID.getText().toString().equals("UTEID") &&
                    editTextPassword.getText().toString().equals("Password"))
            {
                Intent i = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(MainActivity.this, "wrong username or password", Toast.LENGTH_SHORT).show();
            }
        }

        else if (v.getId() == R.id.buttonGuest)
        {
            Intent i = new Intent(MainActivity.this, OptionsActivity.class);
            startActivity(i);
            Toast.makeText(MainActivity.this, "Signed in as Guest", Toast.LENGTH_SHORT).show();
        }


    }
}
