package com.example.lkty.munchiemapper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class onCampusList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_campus_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner foodSpin = (Spinner)findViewById(R.id.foodSpinner);
        ArrayAdapter<CharSequence> foodAdapter = ArrayAdapter.createFromResource(this,R.array.food_array, R.layout.spinner_text);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodSpin.setAdapter(foodAdapter);

        Spinner priceSpin = (Spinner)findViewById(R.id.priceSpinner);
        ArrayAdapter<CharSequence> priceAdapter = ArrayAdapter.createFromResource(this,R.array.prices, R.layout.spinner_text);
        priceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priceSpin.setAdapter(priceAdapter);

        Spinner distanceSpin = (Spinner)findViewById(R.id.distanceSpinner);
        ArrayAdapter<CharSequence> distanceAdapter = ArrayAdapter.createFromResource(this,R.array.distance, R.layout.spinner_text);
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distanceSpin.setAdapter(distanceAdapter);

    }

    public void onClick(View v){
        Intent intentSwitcher = new Intent(this,MainActivity.class);
        startActivity(intentSwitcher);
    }



}
