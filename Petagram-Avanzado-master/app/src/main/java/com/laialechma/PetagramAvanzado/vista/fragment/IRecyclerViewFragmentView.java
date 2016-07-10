package com.laialechma.PetagramAvanzado.vista.fragment;

import com.laialechma.PetagramAvanzado.adapter.ContactoAdaptador;
import com.laialechma.PetagramAvanzado.model.Contacto;
import com.laialechma.PetagramAvanzado.model.Seguidor;

import java.util.ArrayList;


public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
