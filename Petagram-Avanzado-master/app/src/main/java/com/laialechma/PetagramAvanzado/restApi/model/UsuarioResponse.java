package com.laialechma.PetagramAvanzado.restApi.model;

/**
 * Created by Laia Lechma on 10/07/2016.
 */
public class UsuarioResponse {

    private String id;
    private String token;
    private String animal;


        public UsuarioResponse(String id, String token, String animal) {
            this.id = id;
            this.token = token;
            this.animal = animal;



        }

        public UsuarioResponse() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAnimal() {
            return animal;
        }

        public void setAnimal(String animal) {
            this.animal = animal;
        }
    }


