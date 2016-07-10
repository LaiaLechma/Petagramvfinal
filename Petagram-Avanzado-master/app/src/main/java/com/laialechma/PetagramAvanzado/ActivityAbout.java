package com.laialechma.PetagramAvanzado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.laialechma.recyclerviewfragments.R;

/**
 * Created by Laia Lechma on 26/06/2016.
 */
public class ActivityAbout extends AppCompatActivity {
    ImageView star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        star =((ImageView)findViewById(R.id.star));
        star.setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    public void iraFavoritos(View v){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
