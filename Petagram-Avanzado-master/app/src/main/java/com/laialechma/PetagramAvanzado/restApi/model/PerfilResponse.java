package com.laialechma.PetagramAvanzado.restApi.model;


import com.laialechma.PetagramAvanzado.model.Contacto;

import java.util.ArrayList;


/**
 * Created by Laia Lechma on 28/06/2016.
 */
public class PerfilResponse {
    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

}
