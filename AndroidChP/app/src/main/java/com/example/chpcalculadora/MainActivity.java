package com.example.chpcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    //num1; num2; btnMais; btnMenos; btnMulti; btnDivisao; cmpresposta; btnMemoria1; btnMemoria2; btnMemoria3; btnMemoria4; btnMemoria5; btnFinalizar;

    ImageButton btnMais, btnMenos, btnMulti, btnDivisao, btnMemoria1, btnMemoria2, btnMemoria3, btnMemoria4, btnMemoria5;

    TextView num1, num2, cmpresposta;
    double resposta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFinalizar = (Button) findViewById(R.id.btnFinalizar);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        btnMais = findViewById(R.id.btnMais);
        btnMenos = findViewById(R.id.btnMenos);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivisao = findViewById(R.id.btnDivisao);

        btnMemoria1 = findViewById(R.id.btnMemoria1);
        btnMemoria2 = findViewById(R.id.btnMemoria2);
        btnMemoria3 = findViewById(R.id.btnMemoria3);
        btnMemoria4 = findViewById(R.id.btnMemoria4);
        btnMemoria5 = findViewById(R.id.btnMemoria5);

        cmpresposta = findViewById(R.id.cmpresposta);

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                double b = Double.parseDouble(num2.getText().toString());
                resposta = a + b;
                String respostaFinal = String.valueOf(resposta);
                cmpresposta.setText(respostaFinal);
                resposta = 0;
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                double b = Double.parseDouble(num2.getText().toString());
                resposta = a - b;
                String respostaFinal = String.valueOf(resposta);
                cmpresposta.setText(respostaFinal);
                resposta = 0;
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                double b = Double.parseDouble(num2.getText().toString());
                resposta = a * b;
                String respostaFinal = String.valueOf(resposta);
                cmpresposta.setText(respostaFinal);
                resposta = 0;
            }
        });

        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                double b = Double.parseDouble(num2.getText().toString());
                resposta = a / b;
                String respostaFinal = String.valueOf(resposta);
                cmpresposta.setText(respostaFinal);
                resposta = 0;
            }
        });

        /*
        btnMemoria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                double b = Double.parseDouble(num2.getText().toString());
                resposta = a / b;
                String respostaFinal = String.valueOf(resposta);
                cmpresposta.setText(respostaFinal);
                resposta = 0;
            }
        });
        */
    }
}