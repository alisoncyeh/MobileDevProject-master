package com.example.herbert.utapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.net.URI;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void ButtonClick(View view) {
        Uri uri;
        Intent i;
        switch(view.getId()) {
            case R.id.buttonCanvas:
                uri = Uri.parse("https://canvas.utexas.edu");
                i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
                break;
            case R.id.buttonBandwidth:
                //should use webview for bandwidth and browser for canvas
                uri = Uri.parse("https://management.pna.utexas.edu/server/bwdetails.cgi");
                ///i.putExtra("Url","https://management.pna.utexas.edu/server/graph.cgi?");
                i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
                break;
            case R.id.buttonHornsLink:
                uri = Uri.parse("https://utexas.collegiatelink.net/");
                i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
                break;
            case R.id.buttonMaps:
                i = new Intent(this,MapsActivity.class);

                startActivity(i);
            ///herbert code here
                break;
            default:
                Toast.makeText(OptionsActivity.this, "Function still not implemented", Toast.LENGTH_SHORT).show();
                ///i = new Intent();
                //Context context = getApplicationContext();
                //CharSequence text = "We havent attached this anywhere yet";
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context, text, duration);
                //toast.show();
                break;
        }

        ///startActivity(i);

    }
}
