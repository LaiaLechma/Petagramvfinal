package com.laialechma.PetagramAvanzado;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.laialechma.PetagramAvanzado.restApi.EndpointsApi;
import com.laialechma.PetagramAvanzado.restApi.adapter.RestApiAdapter;
import com.laialechma.PetagramAvanzado.restApi.model.UsuarioResponse;
import com.laialechma.recyclerviewfragments.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Laia Lechma on 08/07/2016.
 */
public class RecibirNotificaciones extends AppCompatActivity{

    private TextView tvId;
    private TextView tvInstagram;
    private TextView tvToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recibirnotificaciones);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getView();

        lanzarNotificaciones();

    }
    private void getView() {
        tvId = (TextView)findViewById(R.id.tvId);
        tvInstagram = (TextView)findViewById(R.id.tvInstagram);
        tvToken = (TextView) findViewById(R.id.tvToken);
    }
    private void lanzarNotificaciones() {
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }

    public void enviarToken(View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }

    private void enviarTokenRegistro(String token){
        Log.d("TOKEN", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = endpointsApi.registrarTokenID(token,"samy_rastreador");

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE", usuarioResponse.getId());
                Log.d("INSTAGRAM_FIREBASE", usuarioResponse.getInstagram());
                Log.d("TOKEN_FIREBASE", usuarioResponse.getToke());

                tvId.setText(usuarioResponse.getId());
                tvInstagram.setText(usuarioResponse.getInstagram());
                tvToken.setText(usuarioResponse.getToke());

            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Log.d("Fallo conexion" ,t.toString() );
            }
        });
    }
    private String getUsuarioInstagram() {
        SharedPreferences misReferencias = getSharedPreferences("shared", Context.MODE_PRIVATE);
        return misReferencias.getString("perfilInstagram", "");
    }

}
