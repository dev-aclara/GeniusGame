package com.example.genius;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnVermelho;
    Button btnAzul;
    Button btnAmarelo;
    Button btnVerde;
    Button btnNovoJogo;
    TextView txtRecorde;
    int numRandom,j=0;
    int vetor[] = new int [10000];
    int vetorVerifica[] = new int [10000];
    int rodada, limite = 0;
    boolean n=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bootStrap();
    }

    //declarando componentes
    protected void bootStrap()
    {
        btnVermelho = findViewById(R.id.btnVermelho);
        btnAzul = findViewById(R.id.btnAzul);
        btnAmarelo = findViewById(R.id.btnAmarelo);
        btnVerde = findViewById(R.id.btnVerde);
        btnNovoJogo = findViewById(R.id.btnNovoJogo);
        txtRecorde = findViewById(R.id.txtRecorde);
    }//bootStrap()

    public void btnNewGameClick (View v)
    {

            for(rodada=0; rodada <= limite; rodada++)
            {
                if(rodada==limite)
                    defineColor();
                else
                    repeatColor();
            }
            rodada = 0;
            limite++;

    }

    public void repeatColor()
    {
        if(vetor[rodada]==1)
        {
            btnVermelho.setBackgroundColor(Color.RED);
            btnAzul.setBackgroundColor(Color.rgb(43,103,175));
            btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
            btnVerde.setBackgroundColor(Color.rgb(104,189,79));
        }
        else if(vetor[rodada]==2)
        {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.BLUE);
            btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
            btnVerde.setBackgroundColor(Color.rgb(104,189,79));
        }
        else if(vetor[rodada]==3)
        {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.rgb(43,103,175));
            btnAmarelo.setBackgroundColor(Color.YELLOW);
            btnVerde.setBackgroundColor(Color.rgb(104,189,79));
        }
        else if(vetor[rodada]==4)
        {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.rgb(43,103,175));
            btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
            btnVerde.setBackgroundColor(Color.GREEN);
        }
    }

    public void defineColor()
    {

        Random random = new Random();
        numRandom = random.nextInt(100);

        if(numRandom<25)
        {
            btnVermelho.setBackgroundColor(Color.RED);
            btnAzul.setBackgroundColor(Color.rgb(43,103,175));
            btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
            btnVerde.setBackgroundColor(Color.rgb(104,189,79));
            vetor[rodada]=1;
        }
        else if(numRandom>25 && numRandom<50)
        {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.BLUE);
            btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
            btnVerde.setBackgroundColor(Color.rgb(104,189,79));
            vetor[rodada]=2;
        }
        else if(numRandom<75 && numRandom>50)
        {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.rgb(43,103,175));
            btnAmarelo.setBackgroundColor(Color.YELLOW);
            btnVerde.setBackgroundColor(Color.rgb(104,189,79));
            vetor[rodada]=3;
        }
        else if(numRandom<100 && numRandom>75)
        {
            btnVermelho.setBackgroundColor(Color.rgb(199,34,62));
            btnAzul.setBackgroundColor(Color.rgb(43,103,175));
            btnAmarelo.setBackgroundColor(Color.rgb(251,187,103));
            btnVerde.setBackgroundColor(Color.GREEN);
            vetor[rodada]=4;
        }

    }//defineColor()

    public void btnVermelho(View v)
    {
        vetorVerifica[j] = 1;
        j++;
    }
    public void btnAzul(View v)
    {
        vetorVerifica[j] = 2;
        j++;
    }
    public void btnAmarelo(View v)
    {
        vetorVerifica[j] = 3;
        j++;
    }
    public void btnVerde(View v)
    {
        vetorVerifica[j] = 4;
        j++;
    }
    /*public boolean verifica()
    {
        for(int i=0; i<=rodada; i++)
        {
            if(vetorVerifica[i]==vetor[i])
            {

            }
        }
    }*/

}