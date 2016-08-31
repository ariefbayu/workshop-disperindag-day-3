package org.akupeduli.workshophari3;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class Day3F6Activity extends AppCompatActivity {
    EditText editText4;
    static int INTENT_CODE_ACTIVITY_6C = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_f6);

        ((Button)findViewById(R.id.button15)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Day3F6Activity.this, Day3F6bActivity.class);
                intent.putExtra("intent-data", "data dari activity a");
                intent.putExtra("data-number", 12);
                startActivity(intent);
            }
        });

        ((Button)findViewById(R.id.button16)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ambil package manager untuk melihat aplikasi terinstall
                PackageManager pm = getPackageManager();

                //pm.getInstalledPackages() berguna untuk mengambil aplikasi terinstall
                List<PackageInfo> installedApps =
                        pm.getInstalledPackages( PackageManager.GET_ACTIVITIES);
                for(int i = 0; i < installedApps.size(); i++){
                    //.packageName -> adalah package yang diset di
                    //    gradle baris `applicationId`
                    Log.d("DAY3", "App: " + installedApps.get(i).packageName);
                }

                //ambil start intent dari aplikasi yg ingin dibuka
                Intent i = pm.getLaunchIntentForPackage("org.akupeduli.workshophari2");
                startActivity(i);
            }
        });

        editText4 = (EditText)findViewById(R.id.editText4);

        ((Button)findViewById(R.id.button17)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Day3F6Activity.this, Day3F6cActivity.class);
                intent.putExtra("intent-data", editText4.getText().toString());
                //isi INTENT:
                //      static int INTENT_CODE_ACTIVITY_6C = 100001;
                startActivityForResult(intent, INTENT_CODE_ACTIVITY_6C);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == INTENT_CODE_ACTIVITY_6C){
            if(resultCode == RESULT_OK){
                TextView t10 = (TextView)findViewById(R.id.textView10);
                t10.setText("Data dari Activity C: " +
                        data.getStringExtra("data-kembalian"));
            }
        }
    }
}
