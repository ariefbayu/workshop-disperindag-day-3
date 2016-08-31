package org.akupeduli.workshophari3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Day3F6bActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_f6b);

        String intentData = getIntent().getStringExtra("intent-data");
        int intentNumber = getIntent().getIntExtra("data-number", 0);

        Toast.makeText(getApplicationContext(),
                "Data: " + intentData + " | Number: " + intentNumber,
                Toast.LENGTH_LONG).show();
    }
}
