package com.collectionexample.model.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.collectionexample.model.SingleVolleyQueue;

/**
 * Created by Lucas on 2015/11/12.
 */
public class ApiGetGoogle {
    private static final int Action = Request.Method.GET;
    private Context context;

    public ApiGetGoogle(Context context){
        this.context=context;
    }
    public void request(Response.Listener<String> succese,Response.ErrorListener fail){
        StringRequest request = new StringRequest(Action,list[0],succese,fail);
        RequestQueue queue = SingleVolleyQueue.get(context);
        queue.add(request);
    }
    public void imagerequest(Response.Listener<Bitmap> succese,Response.ErrorListener fail){
        ImageRequest imageRequest = new ImageRequest(list[1],succese,200,100, ImageView.ScaleType.CENTER_INSIDE, Bitmap.Config.ARGB_8888,fail);
        RequestQueue queue = SingleVolleyQueue.get(context);
        queue.add(imageRequest);
    }
    public void jsonObjectRequest(Response.Listener<String> succese,Response.ErrorListener fail){
        StringRequest jsonObjectRequest = new StringRequest(Action,list[2],succese,fail);
        RequestQueue queue = SingleVolleyQueue.get(context);
        queue.add(jsonObjectRequest);
    }
    public static final String[] list = {
            "http://www.google.com",
            "http://i.imgur.com/7spzG.png",
            "http://www.w3schools.com/json/myTutorials.txt"
    };

}
