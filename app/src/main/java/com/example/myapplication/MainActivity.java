package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView kostka;
    private int oczka;
    public Button losuj;
    public Button dodaj;
    public Button odejmij;
    public int flaga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kostka = findViewById(R.id.kostka);
        dodaj = findViewById(R.id.dodaj);
        odejmij = findViewById(R.id.odejmij);
        if (savedInstanceState != null) {
            oczka = savedInstanceState.getInt("Oczka", 0);
            kostka.setText(String.valueOf(oczka));

        }
        if(flaga == 0){
            dodaj.setVisibility(dodaj.INVISIBLE);
            odejmij.setVisibility(odejmij.INVISIBLE);
        }else{
            dodaj.setVisibility(dodaj.VISIBLE);
            odejmij.setVisibility(odejmij.VISIBLE);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Oczka",oczka);
    }

    public void Losuj(View view){
        if(flaga == 1){
            dodaj.setVisibility(dodaj.INVISIBLE);
            odejmij.setVisibility(odejmij.INVISIBLE);
        }else{
            dodaj.setVisibility(dodaj.VISIBLE);
            odejmij.setVisibility(odejmij.VISIBLE);
        }
        flaga = 1;
        kostka.setText(String.valueOf(oczka));
    }

    public void Dodaj(View view) {
        if(oczka<6 && flaga==1){
        oczka++;
        flaga = 0;
        dodaj.setVisibility(dodaj.INVISIBLE);
        odejmij.setVisibility(odejmij.INVISIBLE);
        kostka.setText(String.valueOf(oczka));
        }
    }

    public void Ujmij(View view){

        if(oczka>1 && flaga==1) {
            oczka--;
            flaga = 0;
            dodaj.setVisibility(dodaj.INVISIBLE);
            odejmij.setVisibility(odejmij.INVISIBLE);
            kostka.setText(String.valueOf(oczka));
        }
    }
}