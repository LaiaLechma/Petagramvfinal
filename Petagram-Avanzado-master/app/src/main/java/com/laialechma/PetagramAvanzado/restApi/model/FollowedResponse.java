package com.laialechma.PetagramAvanzado.restApi.model;

import com.laialechma.PetagramAvanzado.model.Seguidor;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 28/06/2016.
 */
public class FollowedResponse {

        ArrayList<Seguidor> seguidores;

        public ArrayList<Seguidor> getSeguidores() {
            return seguidores;
        }

        public void setSeguidores(ArrayList<Seguidor> seguidores) {
            this.seguidores = seguidores;
        }
    }
