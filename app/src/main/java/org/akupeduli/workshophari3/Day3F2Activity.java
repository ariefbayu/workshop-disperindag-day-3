package org.akupeduli.workshophari3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Day3F2Activity extends AppCompatActivity {
    EditText editNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_f2);

        editNama = (EditText)findViewById(R.id.editText3);

        ((Button)findViewById(R.id.button10)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Day3F2Activity.this);
                builder.setTitle("Periksa Nama");
                final String nama = editNama.getText().toString();
                builder.setMessage("Apakah nama anda: " + nama + "?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("DAY3", "Ya, nama saya " + nama);
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("DAY3", "Nama saya bukan " + nama);
                    }
                });

                builder.show();
            }
        });
    }
}
