package com.laialechma.PetagramAvanzado;

import android.content.Intent;
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
 * Created by Laia Lechma on 26/06/2016.
 */
public class ActivityContacto extends AppCompatActivity {

    TextInputEditText agregarname;
    TextInputEditText agregarmaill;
    TextInputEditText agregardescripcion;
    ImageView star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        star =((ImageView)findViewById(R.id.star));
        star.setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        agregarname = (TextInputEditText) findViewById(R.id.txtname);
        String name = agregarname.getText().toString();


        agregardescripcion = (TextInputEditText) findViewById(R.id.txtdescripcion);
        String descripcion = agregardescripcion.getText().toString();

        agregarmaill= (TextInputEditText) findViewById(R.id.txtmail);
        String email = agregarmaill.getText().toString();



        Bundle parametros = getIntent().getExtras();
        if(parametros != null) {
            agregarname.setText(parametros.getString("Nombre"));
            agregardescripcion.setText(parametros.getString("Descripcion"));
            agregarmaill.setText(parametros.getString("Mail"));
        }

        Button botonEnviar = (Button) findViewById(R.id.botonEnviarMail);
        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                agregarname = (TextInputEditText) findViewById(R.id.txtname);
                String name = agregarname.getText().toString();
                agregardescripcion = (TextInputEditText) findViewById(R.id.txtdescripcion);
                String descripcion = agregardescripcion.getText().toString();
                agregarmaill= (TextInputEditText) findViewById(R.id.txtmail);
                String email = agregarmaill.getText().toString();



                Toast.makeText(getBaseContext(), " Tu : " + name + " Enviar mail a : " + email, Toast.LENGTH_LONG).show();
                Intent sendIntent = new Intent((Intent.ACTION_SEND));
                sendIntent.setType("plain/text");
                sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                sendIntent.putExtra(Intent.EXTRA_TEXT, descripcion);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Mensaje desde PETAGRAM de: " + name);
                startActivity(Intent.createChooser(sendIntent, "Enviar mail atraves de "));
            }
        });

    }
    public void iraFavoritos(View v){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}