package com.laialechma.PetagramAvanzado;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.laialechma.recyclerviewfragments.R;

/**
 * Created by Laia Lechma on 27/06/2016.
 */
public class ActivityCuenta extends AppCompatActivity {

    TextInputEditText agregarusuario;
    ImageView star;
    public static String usuarioActual = "self";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        star =((ImageView)findViewById(R.id.star));
        star.setVisibility(View.INVISIBLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        agregarusuario = (TextInputEditText) findViewById(R.id.txtusuario);
        Button botonGuardar = (Button) findViewById(R.id.botonGuardarCuenta);
       // botonGuardar.setOnClickListener(this);

        SharedPreferences misReferencias = getSharedPreferences("shared", Context.MODE_PRIVATE);
        agregarusuario.setText( misReferencias.getString("perfilInstagram", ""));
    }

        public void onClick(View v) {
            guardarCuenta(v);
        }



    public void guardarCuenta(View v){
        Toast.makeText(this, "User: " + usuarioActual, Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }

    private void ConfigurarCuenta() {
        String usuario = agregarusuario.getText().toString().trim();
        agregarusuario = (TextInputEditText) findViewById(R.id.txtname);

        Toast.makeText(this, "User: " + usuarioActual, Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void usuario01(View v) {
        usuarioActual = "appsrsanchezcobian";
        Toast.makeText(this, usuarioActual, Toast.LENGTH_SHORT).show();
    }
}

        /*private void ConfigurarCuenta() {
                String usuario = agregarusuario.getText().toString().trim();
                agregarusuario = (TextInputEditText) findViewById(R.id.txtname);


                if(Usuario(usuario)){
                    SharedPreferences perfilInstagram = getSharedPreferences("shared", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = perfilInstagram.edit();
                    editor.putString("perfilInstagram", usuario);
                    editor.commit();

                    //Toast.makeText(this, "La cuenta se guardó correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    agregarusuario.setError("Cuenta de usario");
                }
            }

            private boolean Usuario(String agregarusuario) {
                if(agregarusuario.isEmpty() || agregarusuario == null || agregarusuario.length() == 0)
                    return false;
                else
                    return true;
            }

        }*/












