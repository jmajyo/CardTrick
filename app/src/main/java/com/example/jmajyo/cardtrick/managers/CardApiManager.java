package com.example.jmajyo.cardtrick.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jmajyo.cardtrick.model.Card;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.Reader;
import java.io.StringReader;


public class CardApiManager {
    public interface CardApiManagerNewCardListener{
        public void onNewCard(Card card);
    }
    private CardApiManagerNewCardListener listener;

    public void setListener(CardApiManagerNewCardListener listener) {
        this.listener = listener;
    }

    private static final String URL = "http://192.168.1.38:8000/api/card";

    public void newCard(Context context){
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESPONSE", response);
                    parseJSON(response);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HORROR", "Connection went to shit to the tracks");
            }
        });

        queue.add(request);
    }

    private void parseJSON(String response) {
        Card card = new Card();
        Reader reader= new StringReader(response);
        Gson gson = new GsonBuilder().create();
        CardEntity[] cardEntities = gson.fromJson(reader, CardEntity[].class);
        for (int i = 0; i < cardEntities.length; i++) {
            card.setImage(cardEntities[i].getImage());
        }
        if(listener !=null){
            listener.onNewCard(card);
        }
    }
}
