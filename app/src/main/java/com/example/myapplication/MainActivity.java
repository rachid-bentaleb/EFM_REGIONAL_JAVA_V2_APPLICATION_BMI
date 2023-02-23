package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText Weight,Height;
    Button ok;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Weight = findViewById(R.id.Weight_text);
        Height = findViewById(R.id.Height_text);
        ok = findViewById(R.id.ok_button);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this , "votre BMI est : "+ calculeBMI() +" , votre etat est : " + etat(),Toast.LENGTH_LONG).show();
            }
        });

    }

    // La methode calcule() permettant da calculer l'IMC d'un personne
    public double calculeBMI(){
        double poid_valeu = Double.parseDouble(Weight.getText().toString());
        double taille_valeu = Double.parseDouble(Height.getText().toString());

        double BMI = (poid_valeu/(taille_valeu*taille_valeu));
        return  BMI ;
    }

    // La methode calcule() permettant da determiner l'etat d'un peresonne
    public String etat(){
        String etat = "";
        if(calculeBMI()<18.5){etat = "Underweight";}
        else if(calculeBMI()>=18.5 && calculeBMI()<25){etat = "Normal";}
        else if(calculeBMI()<40 && calculeBMI()>=25){etat = "Overweight";}
        else if(calculeBMI()>=40 ){etat = "Obese";}

        return etat;
    }
}