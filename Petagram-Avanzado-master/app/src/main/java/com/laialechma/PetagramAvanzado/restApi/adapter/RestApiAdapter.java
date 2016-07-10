package com.laialechma.PetagramAvanzado.restApi.adapter;

import com.laialechma.PetagramAvanzado.restApi.ConstantesRestApi;
import com.laialechma.PetagramAvanzado.restApi.EndpointsApi;
import com.laialechma.PetagramAvanzado.restApi.deserializador.ContactoDeserializador;
import com.laialechma.PetagramAvanzado.restApi.deserializador.FollowebByDeserealizador;
import com.laialechma.PetagramAvanzado.restApi.deserializador.PerfilDeserealizador;
import com.laialechma.PetagramAvanzado.restApi.model.ContactoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laialechma.PetagramAvanzado.restApi.model.FollowedResponse;
import com.laialechma.PetagramAvanzado.restApi.model.PerfilResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Laia Lechma on 26/06/2016.
 */
public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram (Gson gson){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(ConstantesRestApi.ROOT_URL)
               .addConverterFactory(GsonConverterFactory.create(gson))
               .build();

        return retrofit.create(EndpointsApi.class);
    }

    public EndpointsApi establecerConexionRestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL0)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        return retrofit.create(EndpointsApi.class);

    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());
        Gson miGson = gsonBuilder.create();
        return gsonBuilder.create();
    }

    public Gson construyeDeserealizadorFollowedBy(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(FollowedResponse.class, new FollowebByDeserealizador());
        Gson miGson = gsonBuilder.create();
        return gsonBuilder.create();
    }

    public Gson construyendoDeserealizadorPerfil(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PerfilResponse.class, new PerfilDeserealizador());
        Gson miGson = gsonBuilder.create();
        return gsonBuilder.create();
    }
}
