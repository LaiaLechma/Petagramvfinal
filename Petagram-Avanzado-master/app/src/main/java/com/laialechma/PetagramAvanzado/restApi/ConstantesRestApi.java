package com.laialechma.PetagramAvanzado.restApi;

/**
 * Created by Laia Lechma on 26/06/2016.
 */
public final class ConstantesRestApi {


    public static final String ROOT_URL0 = "https://fast-wildwood-84340.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN = "token-device/";



    //https://api.instagram.com/v1/users/self/media/recent/?access_token=3439765745.50b0ada.92b095037f0b492a84bf22c84e64ce2a

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3439765745.50b0ada.92b095037f0b492a84bf22c84e64ce2a";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String KEY_GET_MEDIA_USER = "users/self/media/";
    public static final String URL_GET_MEDIA_USER = KEY_GET_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String KEY_GET_RECENT_MEDIA_OTHER = "users/{id}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_OTHER = KEY_GET_RECENT_MEDIA_OTHER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String KEY_GET_FOLLOWEDBY = "users/self/follows";
    public static final String URL_GET_FOLLOWEDBY = KEY_GET_FOLLOWEDBY + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


}
