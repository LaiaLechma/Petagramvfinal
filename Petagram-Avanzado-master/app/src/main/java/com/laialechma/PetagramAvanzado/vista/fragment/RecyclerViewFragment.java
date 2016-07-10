package com.laialechma.PetagramAvanzado.vista.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laialechma.recyclerviewfragments.R;
import com.laialechma.PetagramAvanzado.adapter.ContactoAdaptador;
import com.laialechma.PetagramAvanzado.model.Contacto;
import com.laialechma.PetagramAvanzado.presentador.IRecylerViewFragmentPresenter;
import com.laialechma.PetagramAvanzado.presentador.RecyclerViewFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecylerViewFragmentPresenter presenter;
    private CircularImageView circularImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        circularImageView = (CircularImageView)v.findViewById(R.id.civPerfil);
        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    private void configImagenCircular() {
        circularImageView.setBorderWidth(10);
        circularImageView.addShadow();
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);
    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);

    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvContactos.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }
}
