package com.laialechma.PetagramAvanzado.restApi.model;

import com.laialechma.PetagramAvanzado.model.Contacto;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 13/07/2016.
 */
public class ImageListResponse {

         ArrayList<Contacto> contactos;

        public ArrayList<Contacto> getContactos() {
            return contactos;
        }

    public void setContactos (ArrayList<Contacto> contactos) {
            this.contactos = contactos;
    }
}



