package org.akupeduli.workshophari3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentDetailActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_detail);

        text = (TextView)findViewById(R.id.editText2);
        text.setText(getIntent().getStringExtra("data"));

        ((Button)findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("hasil", text.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
