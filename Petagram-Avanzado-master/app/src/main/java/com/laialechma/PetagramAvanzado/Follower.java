package com.laialechma.PetagramAvanzado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.laialechma.PetagramAvanzado.model.Followed;
import com.laialechma.PetagramAvanzado.restApi.EndpointsApi;
import com.laialechma.PetagramAvanzado.restApi.adapter.RestApiAdapter;
import com.laialechma.PetagramAvanzado.restApi.model.FollowedResponse;
import com.laialechma.recyclerviewfragments.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Laia Lechma on 17/07/2016.
 */
public class Follower extends AppCompatActivity {
    public ArrayList<Followed> followers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);
        getFollowedBy();
    }


    public void getFollowedBy(){

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);


        Call<FollowedResponse> followedResponseCall = endpointsApi.getFollowedBy();


        followedResponseCall.enqueue(new Callback<FollowedResponse>() {
            @Override
            public void onResponse(Call<FollowedResponse> call, Response<FollowedResponse> response) {
                FollowedResponse followedResponse = response.body();
                followers = followedResponse.getFolloweds();

            }

            @Override
            public void onFailure(Call<FollowedResponse> call, Throwable t) {

            }
        });




    }

}
