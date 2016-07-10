package com.laialechma.PetagramAvanzado.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.laialechma.PetagramAvanzado.model.Seguidor;
import com.laialechma.PetagramAvanzado.restApi.JsonKeys;
import com.laialechma.PetagramAvanzado.restApi.model.FollowedResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Laia Lechma on 28/06/2016.
 */
public class FollowebByDeserealizador  implements JsonDeserializer<FollowedResponse> {
    @Override
    public FollowedResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        FollowedResponse followedResponse = gson.fromJson(json, FollowedResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.FOLLOWED_ARRAY);
        followedResponse.setSeguidores(deserealizadorFollowBy(jsonArray));
        return followedResponse;
    }

    private ArrayList<Seguidor> deserealizadorFollowBy(JsonArray jsonArray) {
        ArrayList<Seguidor> seguidores = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject followedDataObject = jsonArray.get(i).getAsJsonObject();
            Seguidor seguidor = new Seguidor();
            seguidor.setId(followedDataObject.get(JsonKeys.FOLLOWED_ID).getAsString());
            seguidor.setFullName(followedDataObject.get(JsonKeys.FOLLOWED_FULLNAME).getAsString());
            seguidor.setUserName(followedDataObject.get(JsonKeys.FOLLOWED_USERNAME).getAsString());

            seguidores.add(seguidor);
        }

        return seguidores;
    }
}


