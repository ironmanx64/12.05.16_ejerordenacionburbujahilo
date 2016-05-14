package org.android.davidch.a120516_ejerordenacionburbujahilo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textviewdesordenados;
    TextView textViewordenados;
    TextView textviewestado;
    TextView textViewporcetual;
    Button botonordenar;
    Button botoncancelar;
    int [] vectordesordenado;
    int []vectorordenado;
    String stringporcentual;
    String stringporcentualsubstring;
    float porcentual;
    Boolean pararordenar=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textviewdesordenados=(TextView)findViewById(R.id.textView2numerosdesordenados);
        textViewordenados=(TextView)findViewById(R.id.textView4numerosordenados);
        botonordenar=(Button)findViewById(R.id.buttonordenar);
        botoncancelar=(Button)findViewById(R.id.button2cancelar);
        textviewestado=(TextView)findViewById(R.id.textView5Enespera);
        textViewporcetual=(TextView)findViewById(R.id.textView6porcentual);
        vectordesordenado=crearvectordesordenado();
        mostrarvectordesordenado(vectordesordenado);
        porcentual=0;
        stringporcentual=porcentual+"%";
        Toast toastespera= Toast.makeText(this,"es espera",Toast.LENGTH_SHORT);
        toastespera.show();
        textViewporcetual.setText(stringporcentual);

        botonordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vectorordenado=ordenarvector(vectordesordenado);
                mostrarvectorsordenado(vectorordenado);


            }
        });

        botoncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pararordenar=true;
            }
        });



    }

    public void mostrarvectordesordenado(int [] vectordesordenado){

        String vectordesordenadostring="";

        for (int i = 0; i < vectordesordenado.length; i++) {
            if(vectordesordenado.length-1!=i){
                vectordesordenadostring+=vectordesordenado[i]+"-";
            }else{
                vectordesordenadostring+=vectordesordenado[i]+"";
            }

        }

        textviewdesordenados.setText(vectordesordenadostring);

    }

    public void mostrarvectorsordenado(int [] vectorsordenado){

        String vectorordenadostring="";

        for (int i = 0; i < vectorsordenado.length; i++) {
            if(vectorsordenado.length-1!=i){
                vectorordenadostring+=vectorsordenado[i]+"-";
            }else{
                vectorordenadostring+=vectorsordenado[i]+"";
            }

        }

        textViewordenados.setText(vectorordenadostring);

    }


    public int [] crearvectordesordenado(){
        int [] numerosdesordenados = new int[11];

        Random rdn = new Random();
        for (int i = 0; i < numerosdesordenados.length; i++) {
            numerosdesordenados[i]=rdn.nextInt(10);
        }


        return numerosdesordenados;
    }


    public int [] ordenarvector(int [] numerosdesordenados){
        Toast toastordenando= Toast.makeText(this,"Ordenando",Toast.LENGTH_SHORT);
        toastordenando.show();
        textviewestado.setText("Ordenando");
        int aux;
        float numerodevueltas=0;
        float valorvuelta;
        if(pararordenar!=true) {
            for (int i = 0; i < numerosdesordenados.length - 1; i++) {
                for (int j = 0; j < numerosdesordenados.length - 1; j++) {
                    if (numerosdesordenados[j] > numerosdesordenados[j + 1]) {
                        aux = numerosdesordenados[j + 1];
                        numerosdesordenados[j + 1] = numerosdesordenados[j];
                        numerosdesordenados[j] = aux;
                        numerodevueltas++;

                    }
                }
            }
            valorvuelta = (float) 100 / numerodevueltas;
            for (int i = 0; i < numerodevueltas; i++) {
                porcentual = porcentual + valorvuelta;
                stringporcentual = porcentual + "%";
                stringporcentualsubstring = stringporcentual.substring(0, 3) + "%";
                textViewporcetual.setText(stringporcentualsubstring);
            }
            Toast toastfinalizado = Toast.makeText(this, "Finalizado", Toast.LENGTH_SHORT);
            toastfinalizado.show();
            textviewestado.setText("Finalizado");
        } else{
            Toast toastCancelado = Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT);
            toastCancelado.show();
            textviewestado.setText("Cancelado");
            pararordenar=false;
        }



        return numerosdesordenados;
    }


}
