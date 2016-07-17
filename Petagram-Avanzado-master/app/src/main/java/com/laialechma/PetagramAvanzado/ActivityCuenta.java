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
public class ActivityCuenta extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText agregarusuario;
    ImageView star;
    private Button botonGuardar;

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
        botonGuardar = (Button) findViewById(R.id.botonGuardarCuenta);
        botonGuardar.setOnClickListener(this);

        SharedPreferences misReferencias = getSharedPreferences("shared", Context.MODE_PRIVATE);
        agregarusuario.setText( misReferencias.getString("perfilInstagram", ""));
    }


    @Override
    public void onClick(View v) {
        GuardarCuenta();
    }

    private void GuardarCuenta() {
        String usuario = agregarusuario.getText().toString().trim();
        if(ValidaCampo(usuario)){
            SharedPreferences perfilInstagram = getSharedPreferences("shared", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = perfilInstagram.edit();
            editor.putString("perfilInstagram", usuario);
            editor.commit();

            Toast.makeText(this, "La cuenta se guardó correctamente", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            agregarusuario.setError("Ingrese una cuenta de usario");
        }

    }

    private boolean ValidaCampo(String usuario) {
        if(usuario.isEmpty() || usuario == null || usuario.length() == 0)
            return false;
        else
            return true;
    }
}












