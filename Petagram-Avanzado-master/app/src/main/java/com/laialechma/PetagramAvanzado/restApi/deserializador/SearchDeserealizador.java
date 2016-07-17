package com.laialechma.PetagramAvanzado.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.laialechma.PetagramAvanzado.model.Followed;
import com.laialechma.PetagramAvanzado.restApi.JsonKeys;
import com.laialechma.PetagramAvanzado.restApi.model.SearchResponse;

import java.lang.reflect.Type;

/**
 * Created by Laia Lechma on 13/07/2016.
 */
public class SearchDeserealizador implements JsonDeserializer<SearchResponse> {
    @Override
    public SearchResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        SearchResponse searchResponse = gson.fromJson(json, SearchResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.SEARCH_ARRAY);
        searchResponse.setCuenta(deserealizadorSearch(jsonArray));
        return searchResponse;
    }

    private Followed deserealizadorSearch(JsonArray jsonArray) {
        Followed item = new Followed();
        if( jsonArray.size() > 0 ){
            JsonObject searchDataObject = jsonArray.get(0).getAsJsonObject();
            item.setFullName(searchDataObject.get(JsonKeys.SEARCH_FULLNAME).getAsString());
            item.setUserName(searchDataObject.get(JsonKeys.SEARCH_USERNAME).getAsString());
            item.setProfile_picture(searchDataObject.get(JsonKeys.SEARCH_PROFILEPICTURE).getAsString());
            item.setId(searchDataObject.get(JsonKeys.SEARCH_ID).getAsString());
        }
        else
            item.setUserName("NoEncontrado");
        return item;

    }
}
