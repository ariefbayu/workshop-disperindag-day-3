package org.akupeduli.workshophari3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class Day3TestDetailActivity extends AppCompatActivity {
    String mode;
    CheckBox checkSendangBiru, checkGoaCina, checkMaron, checkPitu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_test_detail);

        checkSendangBiru = (CheckBox)findViewById(R.id.checkSendangBiru);
        checkGoaCina = (CheckBox)findViewById(R.id.checkGoacina);
        checkMaron = (CheckBox)findViewById(R.id.checkMaron);
        checkPitu = (CheckBox)findViewById(R.id.checkPitu);

        mode = getIntent().getStringExtra("mode");
        if(mode.equals("mata-air")){
            ((LinearLayout)findViewById(R.id.layoutPantai)).setVisibility(View.GONE);
        } else if(mode.equals("pantai")){
            ((LinearLayout)findViewById(R.id.layoutMataAir)).setVisibility(View.GONE);
        }

        ((Button)findViewById(R.id.button20)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "";
                if(mode.equals("pantai")){
                    if(checkSendangBiru.isChecked()){
                        result += "Sendang Biru, ";
                    }
                    if(checkGoaCina.isChecked()){
                        result += "Goa Cina, ";
                    }
                } else if(mode.equals("mata-air")){
                    if(checkMaron.isChecked()){
                        result += "Sumber Maron, ";
                    }
                    if(checkPitu.isChecked()){
                        result += "Sumber Pitu, ";
                    }
                }

                Intent intent = getIntent();
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
