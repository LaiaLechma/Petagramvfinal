package com.laialechma.PetagramAvanzado.notificaciones;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Laia Lechma on 08/07/2016.
 */
public class NotificacionIDTokenService extends FirebaseInstanceIdService{

private static final String TAG = "FIREBASE TOKEN";
    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }

    private void enviarTokenRegistro(String token){
        Log.d(TAG, token);
    }

}
