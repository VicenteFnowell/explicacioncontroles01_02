package com.example.explicacioncontroles01_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_Aceptar;
    CheckBox cbmusica,cbdeporte,cbcine;
    RadioGroup rgSexo;
    Spinner spProvincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Identificación de vistas
        btn_Aceptar = (Button)findViewById(R.id.btnaceptar);
        cbmusica = (CheckBox) findViewById(R.id.cb_musica);
        cbdeporte = (CheckBox) findViewById(R.id.cb_deporte);
        cbcine = (CheckBox) findViewById(R.id.cb_cine);
        rgSexo = (RadioGroup)findViewById(R.id.rg_sexo);
        spProvincias=(Spinner)findViewById(R.id.sp_provincia);

        String[] provincias = {"Cádiz","Málaga","Almería","Córdoba"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,provincias);

        spProvincias.setAdapter(adaptador);



        //Evento boton de Aceptar construido con LISTENER

        btn_Aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Has clicado Aceptar",Toast.LENGTH_LONG).show();


            }
        });



    }

    //FIN ONCREATE

    //metodo onCLick del botón Seleccionar provincia
    public void Seleccionarprovincia (View view){
        //Como obtener el valor seleccionado de un Spinner

        String provinciaSeleccionada = spProvincias.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), "La provincia seleccionada es "+provinciaSeleccionada,
        Toast.LENGTH_LONG).show();


    }

//Evento botón de Cancelar construido con OnClick en XML
    public void pulsarCancelar (View view){

        //Comprobar elementos checkeados
        String preferencias="";

        if (cbmusica.isChecked()){
            preferencias+="Música ";
        }
        if (cbcine.isChecked()){
            preferencias+="Cine ";
        }
        if (cbdeporte.isChecked()){
            preferencias+="Deporte ";
        }
        Toast.makeText(getApplicationContext(),"Está checkeado: "+preferencias,Toast.LENGTH_LONG).show();

        //Comprobar elementos radiobuttons

        int id=rgSexo.getCheckedRadioButtonId();
        RadioButton rbSeleccionado = (RadioButton)findViewById(id);
        String textoRbSeleccionado = rbSeleccionado.getText().toString();

        Toast.makeText(getApplicationContext(),"SEXO: "+textoRbSeleccionado,
                Toast.LENGTH_LONG).show();


    }




}//FIN MAIN ACTIVITY
