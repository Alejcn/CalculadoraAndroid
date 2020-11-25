package com.alejandro.calculadoraandroid;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button_suma, button_resta, button_multiplicacion, button_division, button_porcentaje, button_decimales, button_clear, button_clearAll, button_cambioSigno, button_igual;
    private Button button_numero0, button_numero1, button_numero2, button_numero3, button_numero4, button_numero5, button_numero6, button_numero7, button_numero8, button_numero9;

    private TextView text_resultado, text_resultadoCadena;

    private float numero1;
    private float numero2;
    private boolean sumaBool, restaBool, multiBool, divisionBool, porcentajeBool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_resultado = findViewById(R.id.textView_resultado);
        text_resultadoCadena = findViewById(R.id.textView_resultadoCadena);

        button_suma = findViewById(R.id.button_suma);
        button_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_resultado.getText().length() != 0){
                    numero1 = Float.parseFloat(text_resultado.getText() + "");
                    sumaBool = true;
                    text_resultado.setText(null);
                }
            }
        });

        button_resta = findViewById(R.id.button_resta);
        button_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_resultado.getText().length() != 0){
                    numero1 = Float.parseFloat(text_resultado.getText() + "");
                    restaBool = true;
                    text_resultado.setText(null);
                }
            }
        });

        button_multiplicacion = findViewById(R.id.button_multiplicacion);
        button_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_resultado.getText().length() != 0){
                    numero1 = Float.parseFloat(text_resultado.getText() + "");
                    multiBool = true;
                    text_resultado.setText(null);
                }
            }
        });

        button_division = findViewById(R.id.button_division);
        button_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_resultado.getText().length() != 0){
                    numero1 = Float.parseFloat(text_resultado.getText() + "");
                    divisionBool = true;
                    text_resultado.setText(null);
                }
            }
        });

        button_porcentaje = findViewById(R.id.button_porcentaje);
        button_porcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultado.setText(String.valueOf(Double.parseDouble(text_resultado.getText().toString()) / 100.0));
            }
        });

        button_decimales = findViewById(R.id.button_decimal);
        button_decimales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String punto = ".";
                if(text_resultado.getText().toString().equals("0") && punto.equals(".")){
                    text_resultado.setText("0.");
                }else if(text_resultado.getText().toString().equals("0")){
                    text_resultado.setText(punto);
                }else{
                    text_resultado.setText(String.format("%s%s", text_resultado.getText().toString(), punto));
                }
            }
        });

        button_clear = findViewById(R.id.button_clear);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeros = text_resultado.getText().toString();
                int i = numeros.length();
                if(i > 0){
                    text_resultado.setText(numeros.substring(0, i - 1));
                }
            }
        });

        button_clearAll = findViewById(R.id.button_clearAll);
        button_clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText("");
            }
        });

        button_cambioSigno = findViewById(R.id.button_cambioSigno);
        button_cambioSigno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textInput = text_resultado.getText().toString();
                try {
                    if(textInput.charAt(0) == '-'){
                        text_resultado.setText(textInput.substring(1));
                    }else {
                        text_resultado.setText(String.format("-%s", textInput));
                    }
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        });

        button_igual = findViewById(R.id.button_igual);
        button_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_resultado.getText().length() != 0){
                    numero2 = Float.parseFloat(text_resultado.getText() + "");
                    if(sumaBool == true){
                        text_resultado.setText(numero1 + numero2 +"");
                        text_resultadoCadena.setText(numero1 + " + " + numero2 + " = " + (numero1+numero2));
                        sumaBool = false;
                    }else if(restaBool == true){
                        text_resultado.setText(numero1 - numero2 +"");
                        text_resultadoCadena.setText(numero1 + " - " + numero2 + " = " + (numero1-numero2));
                        restaBool = false;
                    }else if(multiBool == true){
                        text_resultado.setText(numero1 * numero2 +"");
                        text_resultadoCadena.setText(numero1 + " * " + numero2 + " = " + (numero1*numero2));
                        multiBool = false;
                    }else if(divisionBool == true){
                        text_resultado.setText(numero1 / numero2 +"");
                        text_resultadoCadena.setText(numero1 + " / " + numero2 + " = " + (numero1/numero2));
                        divisionBool = false;
                    }
                }
            }
        });

        button_numero0 = findViewById(R.id.button_0);
        button_numero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"0");
            }
        });

        button_numero1 = findViewById(R.id.button_1);
        button_numero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"1");
            }
        });

        button_numero2 = findViewById(R.id.button_2);
        button_numero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"2");
            }
        });

        button_numero3 = findViewById(R.id.button_3);
        button_numero3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"3");
            }
        });

        button_numero4 = findViewById(R.id.button_4);
        button_numero4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"4");
            }
        });

        button_numero5 = findViewById(R.id.button_5);
        button_numero5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"5");
            }
        });

        button_numero6 = findViewById(R.id.button_6);
        button_numero6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"6");
            }
        });

        button_numero7 = findViewById(R.id.button_7);
        button_numero7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"7");
            }
        });

        button_numero8 = findViewById(R.id.button_8);
        button_numero8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"8");
            }
        });

        button_numero9 = findViewById(R.id.button_9);
        button_numero9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultadoCadena.setText(null);
                text_resultado.setText(text_resultado.getText()+"9");
            }
        });
    }
}