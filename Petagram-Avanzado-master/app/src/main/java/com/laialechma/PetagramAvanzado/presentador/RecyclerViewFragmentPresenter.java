package com.laialechma.PetagramAvanzado.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.laialechma.PetagramAvanzado.ActivityCuenta;
import com.laialechma.PetagramAvanzado.model.ConstructorContactos;
import com.laialechma.PetagramAvanzado.model.Contacto;
import com.laialechma.PetagramAvanzado.model.Followed;
import com.laialechma.PetagramAvanzado.restApi.EndpointsApi;
import com.laialechma.PetagramAvanzado.restApi.adapter.RestApiAdapter;
import com.laialechma.PetagramAvanzado.restApi.model.ContactoResponse;
import com.laialechma.PetagramAvanzado.restApi.model.FollowedResponse;
import com.laialechma.PetagramAvanzado.restApi.model.ImageListResponse;
import com.laialechma.PetagramAvanzado.vista.fragment.IRecyclerViewFragmentView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecyclerViewFragmentPresenter implements IRecylerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;
    private ArrayList<Followed> followeds;

    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactos();
        obtenerMediosRecientes();
        obtenerFollowed();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

       // if (ActivityCuenta.usuarioActual == "self") {
            Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia();
            contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
                @Override
                public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                    ContactoResponse contactoResponse = response.body();
                    contactos = contactoResponse.getContactos();
                    mostrarContactosRV();
                }

                @Override
                public void onFailure(Call<ContactoResponse> call, Throwable t) {
                    Toast.makeText(context, "Error de conexión", Toast.LENGTH_SHORT).show();
                    Log.e("Error de conexión", t.toString());
                }
            });

        }


    @Override
    public void obtenerFollowed() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyeDeserealizadorFollowedBy();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);
        Call<FollowedResponse> followedResponseCall = endpointsApi.getFollowedBy();
        followedResponseCall.enqueue(new Callback<FollowedResponse>(){
            @Override
            public void onResponse(Call<FollowedResponse> call, Response<FollowedResponse> response) {
                FollowedResponse followedResponse = response.body();
                followeds = followedResponse.getFolloweds();
                followeds = new ArrayList<Followed>();
                Followed yo = new Followed();
                //yo.setId("3436368772");
                yo.setUserName("samy_rastreador");
                followeds.add(yo);
                obtenerFollowed();
            }

            @Override
            public void onFailure(Call<FollowedResponse> call, Throwable t) {
                Toast.makeText(context, "Error de conexión", Toast.LENGTH_SHORT).show();
                Log.e("Error de conexión", t.toString());
            }
        });
    }


    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
