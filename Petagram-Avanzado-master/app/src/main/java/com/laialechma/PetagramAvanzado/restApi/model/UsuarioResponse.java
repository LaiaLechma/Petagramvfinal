package com.laialechma.PetagramAvanzado.restApi.model;

/**
 * Created by Laia Lechma on 10/07/2016.
 */
public class UsuarioResponse {

    private String id;
    private String token;
    private String instagram;

    public UsuarioResponse(String id, String toke, String instagram) {
        this.id = id;
        this.token = toke;
        this.instagram = instagram;
    }

    public UsuarioResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToke() {
        return token;
    }

    public void setToke(String toke) {
        this.token = toke;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
