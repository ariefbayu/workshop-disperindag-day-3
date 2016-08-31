package org.akupeduli.workshophari3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Day3F6cActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_f6c);

        String data = getIntent().getStringExtra("intent-data");
        TextView t8 = (TextView)findViewById(R.id.textView8);
        t8.setText("Data dari Intent: " + data);

        ((Button)findViewById(R.id.button18)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e5 = (EditText) findViewById(R.id.editText5);
                Intent i = getIntent();
                i.putExtra("data-kembalian", e5.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
