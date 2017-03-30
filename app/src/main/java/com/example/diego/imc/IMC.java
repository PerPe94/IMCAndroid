package com.example.diego.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IMC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        final EditText peso, altura;

        Button Calcular = (Button) findViewById(R.id.btncalcular);
        peso = (EditText) findViewById(R.id.txtxpeso);

        altura =(EditText) findViewById(R.id.txtaltura);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(peso.getText().toString().trim().length() == 0){
                    peso.requestFocus();

                    Toast.makeText(IMC.this,
                            "LLenar el peso",Toast.LENGTH_SHORT).show();

                }
                else if (altura.getText().toString().trim().length() == 0){
                    altura.requestFocus();

                    Toast.makeText(IMC.this,
                            "LLenar el altura",Toast.LENGTH_SHORT).show();
                }
                else{
                    float kg = Float.parseFloat(peso.getText().toString());
                    float cm = Float.parseFloat(altura.getText().toString());
                    float m = (cm / 100);
                    float imc = (kg / (m * m));

                    if(imc < 18.5){
                        Toast.makeText(IMC.this, "Tu IMC es: " + imc + "\n" +
                                "Estas delgado", Toast.LENGTH_SHORT).show();
                    }else if (imc < 24.9){
                        Toast.makeText(IMC.this, "Tu IMC es: " + imc + "\n" +
                                "Tu peso es normal", Toast.LENGTH_SHORT).show();
                    }else if  (imc < 29.9){
                        Toast.makeText(IMC.this, "Tu IMC es: " + imc + "\n" +
                                "Tienes sobrepeso", Toast.LENGTH_SHORT).show();
                    }else if (imc > 30){
                        Toast.makeText(IMC.this, "Tu IMC es: " + imc + "\n" +
                                "Padeces obesidad", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
