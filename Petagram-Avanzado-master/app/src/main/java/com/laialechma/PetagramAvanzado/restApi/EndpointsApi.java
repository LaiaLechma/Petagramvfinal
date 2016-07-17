package com.laialechma.PetagramAvanzado.restApi;

import com.laialechma.PetagramAvanzado.restApi.model.ContactoResponse;
import com.laialechma.PetagramAvanzado.restApi.model.FollowedResponse;
import com.laialechma.PetagramAvanzado.restApi.model.PerfilResponse;
import com.laialechma.PetagramAvanzado.restApi.model.SearchResponse;
import com.laialechma.PetagramAvanzado.restApi.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Laia Lechma on 26/06/2016.
 */
public interface EndpointsApi {

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("token") String token, @Field("instagram") String instagram);


    /*
    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram);


    @FormUrlEncoded
        @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
        Call<UsuarioResponse> registrarTokenID(@Field("token") String token, @Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram);
    */


    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();

    @GET(ConstantesRestApi.URL_GET_FOLLOWEDBY)
    Call<FollowedResponse> getFollowedBy();

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_OTHER)
    Call<PerfilResponse> getRecentMediaOtherPerfil(@Path("id") String id);

    @GET(ConstantesRestApi.URL_SEARCH_USER)
    Call<SearchResponse> getUsuarioByBusqueda(@Query("q") String jack, @Query("access_token") String access_token);

}
