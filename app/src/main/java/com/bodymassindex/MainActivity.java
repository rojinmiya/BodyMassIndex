package com.bodymassindex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etHeight, etWeight;
    Button btnCalculate;
    TextView tvOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvOutput = findViewById(R.id.tvOutput);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {

                    float height = Float.parseFloat(etHeight.getText().toString());
                    float weight = Float.parseFloat(etWeight.getText().toString());

                    BMI bmi = new BMI(height, weight);
                    float result = bmi.Calculate();
                    tvOutput.setText(Float.toString(result));
                    if (result < 18.5) {
                        Toast.makeText(MainActivity.this, "UnderWeight", Toast.LENGTH_SHORT).show();
                    } else if (result > 18.4 || result < 25) {
                        Toast.makeText(MainActivity.this, "Normal Weight", Toast.LENGTH_SHORT).show();
                    } else if (result > 24.9 || result < 30) {
                        Toast.makeText(MainActivity.this, "OverWeight", Toast.LENGTH_SHORT).show();
                    } else if (result > 30) {
                        Toast.makeText(MainActivity.this, "Obesity", Toast.LENGTH_SHORT).show();

                    }


                }
            }
        });
        }



    public boolean check(){
        boolean isValid=true;


        if(TextUtils.isEmpty(etHeight.getText().toString())) {
            etHeight.setError("Enter Height");
            etHeight.requestFocus();
            isValid=false;

        }


        else if(TextUtils.isEmpty(etWeight.getText().toString())){
            etWeight.setError("Enter rate");
            etWeight.requestFocus();
            isValid=false;
  }



        return isValid;
    }

}
