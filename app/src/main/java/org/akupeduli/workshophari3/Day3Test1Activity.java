package org.akupeduli.workshophari3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Day3Test1Activity extends AppCompatActivity {
    private static final int INTENT_CODE_DETAIL = 1;
    RadioGroup grupWisata;
    RadioButton radioPantai, radioAir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_test1);

        radioAir = (RadioButton)findViewById(R.id.radioAir);
        radioPantai= (RadioButton)findViewById(R.id.radioPantai);

        grupWisata = (RadioGroup)findViewById(R.id.grupWisata);
        ((Button)findViewById(R.id.button19)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kita buat intent untuk membuka halaman detail
                Intent intent = new Intent(Day3Test1Activity.this,
                        Day3TestDetailActivity.class);

                //cek ID button mana yang terpilih
                int checkId = grupWisata.getCheckedRadioButtonId();
                String mode = "";
                //berdasarkan ID button yg terpilih, kita set mode dengan
                //membandingkan dengan ID dari radio button
                if(checkId == radioAir.getId()){
                    mode = "mata-air";
                }
                if(checkId == radioPantai.getId()){
                    mode = "pantai";
                }
                //pasang mode ke intent agar bisa dibaca di activity detail
                intent.putExtra("mode", mode);
                //start activity detail dengan code INTENT_CODE_DETAIL
                startActivityForResult(intent, INTENT_CODE_DETAIL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //cek apakah intent code sama
        if(requestCode == INTENT_CODE_DETAIL){
            //cek apakah hasil selesai
            if(resultCode == RESULT_OK){
                TextView textDetail = (TextView)findViewById(R.id.textDetail);
                //kita simpan data kembalian dari string extra
                String dataKembalian = data.getStringExtra("result");
                //lalu ditampilkan
                textDetail.setText("Detail grup yang anda pilih: " + dataKembalian);

            }
        }

    }
}
