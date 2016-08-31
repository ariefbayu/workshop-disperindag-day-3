package org.akupeduli.workshophari3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Day3F1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_f1);

        final AlertDialog.Builder builder =
                new AlertDialog.Builder(Day3F1Activity.this);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("DAY3", "positive button clicked");
            }
        });

        ((Button)findViewById(R.id.button8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("button 1");
                builder.setMessage("Ini contoh message");
                builder.show();
            }
        });

        ((Button)findViewById(R.id.button9)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("button 2");
                builder.setMessage(R.string.isi_alert_1);
                builder.show();
            }
        });
    }
}
