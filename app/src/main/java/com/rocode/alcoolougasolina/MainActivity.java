package com.rocode.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editprecoAlcool;
    private TextInputEditText editprecoGasolina;
    private TextView textResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editprecoAlcool   = findViewById(R.id.editprecoAlcool);
        editprecoGasolina = findViewById(R.id.editprecoGasolina);
        textResultado     = findViewById(R.id.textResultado);
    }


    public void Calcular(View view ) {
        String precoalcool = editprecoAlcool.getText().toString();
        String precogasolina = editprecoGasolina.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados = validarCampos(precoalcool, precogasolina);
        if (camposValidados) {
            //conerter String para numeros
            Double valorAlcool = Double.parseDouble(precoalcool);
            Double valorGasolina = Double.parseDouble(precogasolina);

            /*
            Fazer calculo de menor preço
             Se (valorAlcool / valor gasolina) >= 0.7 é melhor utilizar gasolina
             senão é melhor utilizar álcool
             */
            Double resultado = valorAlcool / valorGasolina;

            if(resultado >= 0.7){
                textResultado.setText("é melhor utilizar gasolina");
            }else{
                textResultado.setText("é melhor utilizar Alcool");
            }

            //faltou explicar para que serve isso!???
            } else {
                textResultado.setText("Preencha os preços primeiro!");

            }

    }

    public boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

            if (pAlcool == null || pAlcool.equals("")){
                camposValidados = false;
            }else if(pGasolina == null || pGasolina.equals("")){
                camposValidados = false;
            }
            return camposValidados;



    }
}
