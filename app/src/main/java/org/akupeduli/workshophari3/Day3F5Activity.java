package org.akupeduli.workshophari3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Day3F5Activity extends AppCompatActivity {
    EditText editData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_f5);

        //kita ambil object shared pref dari context dengan menyertakan nama setting
        final SharedPreferences sharePref = getSharedPreferences("setting", 0);

        editData = (EditText)findViewById(R.id.editTextData);

        ((Button)findViewById(R.id.button12)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //editor digunakan untuk melakukan update maupun delete
                SharedPreferences.Editor edit = sharePref.edit();
                //editor.put... ("key data", "data yang ingin diisikan")
                edit.putString("data", editData.getText().toString());
                //apply() digunakan untuk menyimpan data ke xml
                edit.apply();
            }
        });

        ((Button)findViewById(R.id.button13)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = sharePref.edit();
                //editor.remove("key data") digunakan untuk menghapus shared pref
                edit.remove("data");
                edit.apply();
            }
        });

        ((Button)findViewById(R.id.button14)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //untuk ambil data, pakai sharedPref.get... ("key data", "data default);
                editData.setText(sharePref.getString("data", ""));
            }
        });
    }
}
