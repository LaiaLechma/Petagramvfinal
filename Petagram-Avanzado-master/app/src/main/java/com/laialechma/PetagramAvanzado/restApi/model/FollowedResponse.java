package com.laialechma.PetagramAvanzado.restApi.model;

import com.laialechma.PetagramAvanzado.model.Followed;


import java.util.ArrayList;

/**
 * Created by Laia Lechma on 28/06/2016.
 */
public class FollowedResponse {

    ArrayList<Followed> followeds;

    public ArrayList<Followed> getFolloweds() {
        return followeds;
    }

    public void setFolloweds(ArrayList<Followed> followeds) {
        this.followeds = followeds;
    }
}
