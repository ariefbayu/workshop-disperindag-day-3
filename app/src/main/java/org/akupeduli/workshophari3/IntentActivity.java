package org.akupeduli.workshophari3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IntentActivity extends AppCompatActivity {
    private static int INTENT_CODE_DETAIL = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        ((Button)findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IntentActivity.this, IntentDetailActivity.class);
                startActivity(i);
            }
        });

        ((Button)findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IntentActivity.this, IntentDetailActivity.class);
                i.putExtra("data", "data awal");
                startActivityForResult(i, INTENT_CODE_DETAIL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == INTENT_CODE_DETAIL){
            if(resultCode == RESULT_OK){
                TextView text = (TextView)findViewById(R.id.textView3);
                text.setText("Isi Text: " + data.getStringExtra("hasil"));
            }
        }
    }
}
