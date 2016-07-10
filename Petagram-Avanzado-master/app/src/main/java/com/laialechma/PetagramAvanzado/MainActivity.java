package com.laialechma.PetagramAvanzado;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.laialechma.PetagramAvanzado.adapter.PageAdapter;
import com.laialechma.PetagramAvanzado.vista.fragment.PerfilFragment;
import com.laialechma.PetagramAvanzado.vista.fragment.RecyclerViewFragment;
import com.laialechma.recyclerviewfragments.R;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        Log.e("MainActivity", "onCreate");
        setUpViewPager();




        if (toolbar != null){
            setSupportActionBar(toolbar);
        }



    }

    private ArrayList<Fragment> agregarFragments(){
        Log.e("MainActivity", "agregarFragments");
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_contacts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.mContact:
                Intent i = new Intent(this, ActivityContacto.class);
                startActivity(i);
                break;
            case R.id.mCuenta:
                Intent intent1 = new Intent(this, ActivityCuenta.class);
                startActivity(intent1);
                break;
            case R.id.mrecibirnotificaciones:
                Intent int1 = new Intent(this, RecibirNotificaciones.class);
                startActivity(int1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
