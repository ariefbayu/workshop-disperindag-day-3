package org.akupeduli.workshophari3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.zip.Inflater;

public class Day3F4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_f3);

        ((Button)findViewById(R.id.button11)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //pertama, membuat object builder
                AlertDialog.Builder builder = new AlertDialog.Builder(Day3F4Activity.this);

                //kemudian kita inflate (membuka) xml layout ke object View
                LayoutInflater inf = LayoutInflater.from(Day3F4Activity.this);
                View v = inf.inflate(R.layout.day3_custom_layout, null);

                //setelah ada object view, kita pasang ke builder (setView())
                builder.setView(v);

                //lalu membuat object AlertDialog, agar bisa dicontrol (dismiss())
                final AlertDialog ad = builder.create();

                //custom button diambil dari object View (v.findViewById())
                Button customButton = (Button)v.findViewById(R.id.btnbutton);

                //lalu bikin listener
                customButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("DAY3", "custom button clicked");
                        Toast.makeText(getApplicationContext(),
                                "Custom button clicked",
                                Toast.LENGTH_SHORT).show();
                        //di sini kita sembunyikan alert dialog saat button clicked
                        ad.dismiss();
                    }
                });
                //ini untuk memunculkan alert dialog
                ad.show();
            }
        });
    }
}
