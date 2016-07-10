package com.laialechma.PetagramAvanzado.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.laialechma.PetagramAvanzado.model.Contacto;
import com.laialechma.PetagramAvanzado.restApi.JsonKeys;
import com.laialechma.PetagramAvanzado.restApi.model.PerfilResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Laia Lechma on 28/06/2016.
 */
public class PerfilDeserealizador implements JsonDeserializer <PerfilResponse> {

    @Override
    public PerfilResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PerfilResponse perfilUserResponse = gson.fromJson(json, PerfilResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.TIMELINE_ARRAY);
        perfilUserResponse.setContactos(deserealizadorPerfil(jsonArray));
        return perfilUserResponse;
    }

    private ArrayList<Contacto> deserealizadorPerfil(JsonArray jsonArray) {
        ArrayList<Contacto> users = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++ ){
            JsonObject mascotasDataObject = jsonArray.get(i).getAsJsonObject();
            Contacto item = new Contacto();
            JsonObject imageJson = mascotasDataObject.getAsJsonObject(JsonKeys.TIMELINE_IMAGES);
            JsonObject stdUrlJson = imageJson.getAsJsonObject(JsonKeys.TIMELINE_STANDARD_RESOLUTION);
            //item.setUrlFoto(stdUrlJson.get(JsonKeys.TIMELINE_IMAGE_URL).getAsString());

            JsonObject likesJson = mascotasDataObject.getAsJsonObject(JsonKeys.TIMELINE_LIKES);
            item.setLikes(likesJson.get(JsonKeys.TIMELINE_LIKES_COUNT).getAsInt());
            users.add(item);
        }

        return users;
    }
}
