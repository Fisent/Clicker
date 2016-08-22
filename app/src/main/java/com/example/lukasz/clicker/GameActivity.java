package com.example.lukasz.clicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    private int multiplier;
    private int points;
    private int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        points = 0;
        multiplier = 1;
        price = 10;
        actualize();
    }

    public void onClick(View view)
    {
        points += multiplier;
        actualize();
    }

    public void onBuyClick(View view)
    {
        if(points>=price)
        {
            points-=price;
            multiplier*=2;
            price*=2;
        }
        actualize();
    }

    public void actualize()
    {

        if(points>=1000000)
        {
            startActivity(new Intent(this, WinActivity.class));
        }
        TextView t =(TextView) findViewById(R.id.score);
        t.setText(points+"");

        TextView textView = (TextView) findViewById(R.id.priceTextView);
        textView.setText(price+"");
    }
}
