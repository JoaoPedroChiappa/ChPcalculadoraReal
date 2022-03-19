package com.example.chpcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //num1; num2; btnMais; btnMenos; btnMulti; btnDivisao; cmpresposta; btnMemoria1; btnMemoria2; btnMemoria3; btnMemoria4; btnMemoria5; btnFinalizar btnHistorico;

    private Date data = new Date();
    double resposta = 0;
    double memoria = 0;
    String txthistorico = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnMais, btnMenos, btnMulti, btnDivisao;

        TextView num1, num2, cmpresposta, cmpmemoria;

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        btnMais = findViewById(R.id.btnMais);
        btnMenos = findViewById(R.id.btnMenos);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivisao = findViewById(R.id.btnDivisao);

        Button btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        Button btnHistorico = (Button) findViewById(R.id.btnHistorico);
        Button btnMemoriaMais = (Button) findViewById(R.id.btnMemoriaMais);
        Button btnMemoriaMenos = (Button) findViewById(R.id.btnMemoriaMenos);
        Button btnMemoriaMostra = (Button) findViewById(R.id.btnMemoriaMostra);
        Button btnMemoriaArmazena = (Button) findViewById(R.id.btnMemoriaArmazena);
        Button btnMemoriaLimpa = (Button) findViewById(R.id.btnMemoriaLimpa);

        cmpresposta = findViewById(R.id.cmpresposta);
        cmpmemoria = findViewById(R.id.cmpmemoria);

        btnHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    FileOutputStream arquivoGravar = openFileOutput("calc.txt", MODE_APPEND);
                    String msg = txthistorico;
                    arquivoGravar.write(msg.getBytes());
                    arquivoGravar.close();
                }
                catch (IOException error){

                }

                Intent historico = new Intent(getApplicationContext(), ChpHistorico.class);
                startActivity(historico);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                double b = Double.parseDouble(num2.getText().toString());
                resposta = a + b;
                String respostaFinal = String.valueOf(resposta);
                txthistorico = txthistorico + "\n" + data + "\n" + String.valueOf(a) + " + " + String.valueOf(b) + " = " + String.valueOf(resposta) + "\n";
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
                txthistorico =  txthistorico + "\n" + data + "\n" + String.valueOf(a) + " - " + String.valueOf(b) + " = " + String.valueOf(resposta) + "\n";
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
                txthistorico =  txthistorico + "\n" + data + "\n" + String.valueOf(a) + " x " + String.valueOf(b) + " = " + String.valueOf(resposta) + "\n";
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
                txthistorico =  txthistorico + "\n" + data + "\n" + String.valueOf(a) + " / " + String.valueOf(b) + " = " + String.valueOf(resposta) + "\n";
                cmpresposta.setText(respostaFinal);
                resposta = 0;
            }
        });

        btnMemoriaMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                memoria = memoria + a;
                String respostaFinal = String.valueOf(memoria);
                txthistorico =  txthistorico + "\n" + data + "\n" + "M+ = " + String.valueOf(a)  + "\n";
                cmpmemoria.setText(respostaFinal);
            }
        });

        btnMemoriaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                memoria = memoria - a;
                String respostaFinal = String.valueOf(memoria);
                txthistorico = txthistorico + "\n" + data + "\n" + "M- = " + String.valueOf(a)  + "\n";
                cmpmemoria.setText(respostaFinal);
            }
        });

        btnMemoriaMostra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respostaFinal = String.valueOf(memoria);
                txthistorico = txthistorico + "\n" + data + "\n" + "MR = " + String.valueOf(memoria)  + "\n";
                cmpmemoria.setText(respostaFinal);
            }
        });

        btnMemoriaArmazena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(num1.getText().toString());
                memoria = a;
                String respostaFinal = String.valueOf(memoria);
                txthistorico = txthistorico + "\n" + data + "\n" + "MS = " + String.valueOf(a)  + "\n";
                cmpmemoria.setText(respostaFinal);
            }
        });

        btnMemoriaLimpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria = 0;
                String respostaFinal = String.valueOf(memoria);
                txthistorico = txthistorico + "\n" + data + "\n" + "MC"  + "\n";
                cmpmemoria.setText(respostaFinal);
            }
        });
    }
}