package com.example.farmaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextnombre, editTexttelefono;
    TextView Textviewid;
    Button buttonagregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextnombre= findViewById(R.id.editTextnombre);
        editTexttelefono= findViewById(R.id.editTexttelefono);
        Textviewid = findViewById(R.id.editTextid);
        buttonagregar= findViewById(R.id.buttonagregar);

        buttonagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consumirServicio();

            }
        });


    }

    public void consumirServicio(){
        // ahora ejecutaremos el hilo creado
        String id= Textviewid.getText().toString();
        String nombre= editTextnombre.getText().toString();
        String telefono= editTexttelefono.getText().toString();

        ServicioToask servicioToask=new ServicioToask(this, "http://192.168.1.8:3000/cliente",id,nombre,telefono);
        servicioToask.execute();



    }
}
