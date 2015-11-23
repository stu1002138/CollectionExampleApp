package com.collectionexample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.collectionexample.layout.VolleyLayout;
import com.collectionexample.model.network.ApiGetGoogle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {

    private VolleyLayout volleyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volleyLayout = new VolleyLayout(this);
        setContentView(volleyLayout);
        final String text = getBaseContext().getString(R.string.oh_no);
        ApiGetGoogle apiRequest = new ApiGetGoogle(this);
        apiRequest.request(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyLayout.setstringText().setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyLayout.setstringText().setText(text);
            }
        });
        apiRequest.imagerequest(new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                volleyLayout.setimageView().setImageBitmap(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyLayout.setimageView().setImageResource(R.mipmap.ic_launcher);
            }
        });
        apiRequest.jsonObjectRequest(new Response.Listener<String>() {
            @Override
            public void onResponse(String json) {
                int firstIndex = json.indexOf('[');
                json = json.substring(firstIndex, json.length());
                try {
                    Log.d("one", "get");
                    JSONArray jsonArray = new JSONArray(json);
                    String X = "";
                    Log.d("two", "get");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String display = obj.getString("display");
                        X = X + display + "\n";
                        volleyLayout.setjsonText().setText(X);
                        Log.d("get", "get");
                    }
                } catch (JSONException e) {
                    Log.d("json", "error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyLayout.setjsonText().setText("null");
            }
        });
    }
}
