package com.example.chpcalculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ChpHistorico extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chp_historico);

        Button btnApagaHistorico = (Button) findViewById(R.id.btnApagaHistorico);
        Button btnManterDia = (Button) findViewById(R.id.btnManterDia);
        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);

        TextView txtHistorico = findViewById(R.id.txtHistorico);

        try {
            FileInputStream arquivo = openFileInput("calc.txt");
            int tamanhoArquivo = arquivo.available();
            byte dadoByteArquivo[] = new byte[tamanhoArquivo];
            arquivo.read(dadoByteArquivo);
            String txtfinal = new String(dadoByteArquivo);
            txtHistorico.setText(txtfinal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnApagaHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmacao();
            }
        });

        btnManterDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    private AlertDialog alerta;

    private void confirmacao(){

        TextView txtHistorico = findViewById(R.id.txtHistorico);

        AlertDialog.Builder msgBox = new AlertDialog.Builder(this);
        msgBox.setTitle("Excluindo...");
        msgBox.setIcon(android.R.drawable.ic_menu_delete);
        msgBox.setMessage("Tem certeza que deseja excluir o histórico?");
        msgBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    FileOutputStream arquivoGravar = openFileOutput("calc.txt", MODE_PRIVATE);
                    String msg = "";
                    arquivoGravar.write(msg.getBytes());
                    arquivoGravar.close();
                    //Ao invés de chamar o arquivo de novo, passo msg em branco, sabendo que o arquivo foi apagado nas linhas acima.
                    txtHistorico.setText("");
                }
                catch (IOException error){

                }
                Toast.makeText(ChpHistorico.this, "Histórico apagado!", Toast.LENGTH_SHORT).show();
            }
        });
        msgBox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ChpHistorico.this, "Histórico não foi apagado!", Toast.LENGTH_SHORT).show();
            }
        });
        alerta = msgBox.create();
        alerta.show();
    }

}