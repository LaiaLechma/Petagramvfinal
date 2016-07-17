package com.laialechma.PetagramAvanzado.restApi.model;

import com.laialechma.PetagramAvanzado.model.Followed;

/**
 * Created by Laia Lechma on 13/07/2016.
 */
public class SearchResponse {
    Followed cuenta;

    public Followed getCuenta() {
        return cuenta;
    }

    public void setCuenta(Followed cuenta) {
        this.cuenta = cuenta;
    }
}
