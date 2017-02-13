package com.example.jmajyo.cardtrick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jmajyo.cardtrick.managers.CardApiManager;
import com.example.jmajyo.cardtrick.model.Card;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ImageView cardImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardImage = (ImageView) findViewById(R.id.activity_main___card_image);

        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardApiManager cardApiManager = new CardApiManager();
                cardApiManager.setListener(new CardApiManager.CardApiManagerNewCardListener() {
                    @Override
                    public void onNewCard(Card card) {
                        Picasso.with(MainActivity.this).load(card.getImage()).placeholder(R.drawable.card_back_blue).into(cardImage);
                    }
                });
                cardApiManager.newCard(v.getContext());
            }
        });
    }
}
