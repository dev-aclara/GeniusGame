package com.example.genius;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

// Declaração das Variáveis
    Button btnVermelho;
    Button btnAzul;
    Button btnAmarelo;
    Button btnVerde;
    Button btnNovoJogo;
    Button btnContinuar;
    TextView txtRecorde;
    Handler handler = new Handler();
    int numRandom,j=0;
    int vetor[] = new int [10000];
    int vetorVerifica[] = new int [10000];
    int rodada=0, limite = 0;
    int delay = 1;
    int teste = 0;
    boolean verificador = false;
    int contador=-1;
    int delayVerificador = 5000;
    int pontuacao = 0;
    Preferencia pref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bootStrap();
    }

    // Declaração dos Componentes
    protected void bootStrap()
    {
        btnVermelho = findViewById(R.id.btnVermelho);
        btnAzul = findViewById(R.id.btnAzul);
        btnAmarelo = findViewById(R.id.btnAmarelo);
        btnVerde = findViewById(R.id.btnVerde);
        btnNovoJogo = findViewById(R.id.btnNovoJogo);
        btnContinuar = findViewById(R.id.btnContinuar);
        txtRecorde = findViewById(R.id.txtRecorde);
        pref = new Preferencia(getApplicationContext());
        pref.salvarDados("0");
    }//bootStrap()

    // Lógica por trás do botão de NOVO JOGO
    // Assim que clica no botão de NOVO JOGO ele é desabilitado
    public void btnNewGameClick (View v)
    {
        loop();
        btnNovoJogo.setEnabled(false);
        btnVermelho.setEnabled(true);
        btnAzul.setEnabled(true);
        btnAmarelo.setEnabled(true);
        btnVerde.setEnabled(true);
    } //btnNewGameClick (View v)

    // Lógica por trás do botão de CONTINUAR
    // Assim que clica no botão de CONTINUAR ele é desabilitado
    public void BtnContinuarJogo(View v)
    {
        loop();
        btnContinuar.setEnabled(false);
    } //BtnContinuarJogo(View v)

    public void loop()
    {
        for(rodada=0; rodada <= limite; rodada++)
        {

            if(rodada==limite)
            {
                defineColor();
            }
            else
            {
                repeatColor();
            }
            original();
            teste += vetor[rodada];

        }
        rodada = 0;
        limite++;
        delay = 1;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            Verficador();
            }},delayVerificador);
        delayVerificador+=2000;
    } //loop()

    public void Verficador()
    {
        for(int i=0; i<=limite; i++)
        {
            if(vetorVerifica[i]==vetor[i])
            {
                   contador++;
            }
        }
        j=0;

        if(contador == limite)
            verificador = true;
        else
            verificador = false;

        contador = -1;
        if(verificador == true)
        {
            btnContinuar.setEnabled(true);
            verificador = false;
            pontuacao++;
        }
        else
        {
            Toast.makeText(this,"Fim de jogo... \uD83D\uDE41",Toast.LENGTH_LONG).show();
            btnContinuar.setEnabled(false);
            btnNovoJogo.setEnabled(true);

            btnVermelho.setEnabled(false);
            btnAzul.setEnabled(false);
            btnAmarelo.setEnabled(false);
            btnVerde.setEnabled(false);

            delayVerificador = 5000;
            for(int i=0; i<=limite; i++)
            {
                vetorVerifica[i]= 0;
                vetor[i]=0;
            }
            limite=0;
            if(pontuacao>Integer.parseInt(pref.recuperarDados()))
            {
                txtRecorde.setText(Integer.toString(pontuacao));
                pref.salvarDados(Integer.toString(pontuacao));
            }
            pontuacao=0;
        }
    } // Verficador()

    public void original()
    {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
                btnAzul.setBackgroundColor(Color.rgb(43,103,175));
                btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
                btnVerde.setBackgroundColor(Color.rgb(104,189,79));
            }
        },delay*1000);
        delay++;
    } //original()

    public void repeatColor()
    {
        if(vetor[rodada]==1)
        {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnVermelho.setBackgroundColor(Color.rgb(238, 190, 197));
                    btnAzul.setBackgroundColor(Color.rgb(43,103,175));
                    btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
                    btnVerde.setBackgroundColor(Color.rgb(104,189,79));
                }
            },delay*1000);
            delay++;
        }
        else if(vetor[rodada]==2)
        {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
                    btnAzul.setBackgroundColor(Color.rgb(171, 201, 237));
                    btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
                    btnVerde.setBackgroundColor(Color.rgb(104,189,79));
                }
            },delay*1000);
            delay++;
        }
        else if(vetor[rodada]==3)
        {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
                    btnAzul.setBackgroundColor(Color.rgb(43,103,175));
                    btnAmarelo.setBackgroundColor(Color.rgb(255,255,224));
                    btnVerde.setBackgroundColor(Color.rgb(104,189,79));
                }
            },delay*1000);
            delay++;
        }
        else if(vetor[rodada]==4)
        {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
                    btnAzul.setBackgroundColor(Color.rgb(43,103,175));
                    btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
                    btnVerde.setBackgroundColor(Color.rgb(195, 233, 222));
                }
            },delay*1000);
            delay++;
        }
    } //repeatColor()

    // "Ascende" os botões respectivos do número randômico gerado
    // Se o número for menor que 25 o botão VERMELHO ascende os outros ficam com a cor original
    // Se o número for maior que 25 e menor que 50 o botão AZUL ascende os outros ficam com a cor original
    // Se o número for maior que 50 e menor que 75 o botão AMARELO ascende os outros ficam com a cor original
    // Se o número for maior que 75 e menor que 100 o botão VERDE ascende os outros ficam com a cor original
    public void defineColor()
    {
        // Gera um número randômico entre 1 a 100
        Random random = new Random();
        numRandom = random.nextInt(100);

        if(numRandom<25)
        {   handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnVermelho.setBackgroundColor(Color.rgb(238, 190, 197));
                btnAzul.setBackgroundColor(Color.rgb(43,103,175));
                btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
                btnVerde.setBackgroundColor(Color.rgb(104,189,79));
                }
            },delay*1000);
            vetor[rodada]=1;
            delay++;

        }
        else if(numRandom>25 && numRandom<50)
        {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.rgb(171, 201, 237));
            btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
            btnVerde.setBackgroundColor(Color.rgb(104,189,79));

                }
            },delay*1000);
            vetor[rodada]=2;
            delay++;
        }
        else if(numRandom<75 && numRandom>50)
        {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.rgb(43,103,175));
            btnAmarelo.setBackgroundColor(Color.rgb(255,255,224));
            btnVerde.setBackgroundColor(Color.rgb(104,189,79));
                }
            },delay*1000);
            vetor[rodada]=3;
            delay++;
        }
        else if(numRandom<100 && numRandom>75)
        {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.rgb(43,103,175));
            btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
            btnVerde.setBackgroundColor(Color.rgb(195, 233, 222));
                }
            },delay*1000);
            vetor[rodada]=4;
            delay++;
        }

    } //defineColor()

    public void btnVermelho(View v)
    {
        vetorVerifica[j] = 1;
        j++;
    } //btnVermelho(View v)

    public void btnAzul(View v)
    {
        vetorVerifica[j] = 2;
        j++;
    } //btnAzul(View v)

    public void btnAmarelo(View v)
    {
        vetorVerifica[j] = 3;
        j++;
    } //btnAmarelo(View v)

    public void btnVerde(View v)
    {
        vetorVerifica[j] = 4;
        j++;
    } //btnVerde(View v)

}