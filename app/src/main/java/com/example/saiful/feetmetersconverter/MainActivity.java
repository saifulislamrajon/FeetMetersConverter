package com.example.saiful.feetmetersconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnFeet, btnMeters, btnConvert;
    EditText editText;
    TextView tvFeet, tvMeters;
    Toolbar toolbar;
    int feet,meter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnFeet = (Button) findViewById(R.id.btnFeet);
        btnMeters = (Button) findViewById(R.id.btnMeters);
        btnConvert = (Button) findViewById(R.id.btnConvert);
        editText = (EditText) findViewById(R.id.editText);
        tvFeet = (TextView) findViewById(R.id.tvFeet);
        tvMeters = (TextView) findViewById(R.id.tvMeters);
        btnFeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFeet.setEnabled(false);
                tvMeters.setText(null);
                btnMeters.setEnabled(true);
            }
        });
        btnMeters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMeters.setEnabled(false);
                tvFeet.setText(null);
                btnFeet.setEnabled(true);
            }
        });
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnFeet.isEnabled() && btnMeters.isEnabled()) {
                    Toast.makeText(getApplicationContext(), "You have to disable any one fast", Toast.LENGTH_SHORT).show();
                } else if (btnFeet.isEnabled()) {
                    try{
                        feet = Integer.parseInt(editText.getText().toString());
                        //double meter= (int) (0.305*feet);
                        double meter = 0.305 * feet;
//                        int r=Math.round(meter);
                        String m = Double.toString(Math.round(meter));
                        tvMeters.setText(m);
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"Feet is empty",Toast.LENGTH_SHORT).show();
                    }


                } else if (btnMeters.isEnabled()) {
                    try{
                        meter = Integer.parseInt(editText.getText().toString());
                        double feet = meter / 0.305;
                        String f = Double.toString(Math.round(feet));
                        tvFeet.setText(f);
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"Meter is empty",Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
}
