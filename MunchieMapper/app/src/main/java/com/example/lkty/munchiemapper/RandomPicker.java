package com.example.lkty.munchiemapper;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class RandomPicker extends AppCompatActivity {

    ListView randomizerListView;
    int counter = 10;
    boolean complete = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createList();
    }

    private void createList()
    {
        Bundle placesData = getIntent().getExtras();

        //String[] placeNames = placesData.getStringArray("key");
        String[] placeNames = {"Hyrule", "M Kingdom", "The Mansion", "Dreamland"};

        ListAdapter placesListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, placeNames);
        randomizerListView = (ListView) findViewById(R.id.RandomizerListView);

        randomizerListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        randomizerListView.setAdapter(placesListAdapter);
    }

    public void cycleThroughList(View v)
    {
        if(complete)
        {
            complete = false;
            int waitTime = 1000;

            Handler changeSelectionHandler = new Handler();

            for (int i = 0; i < counter; i++) {
                changeSelectionHandler.postDelayed(changeSelectedItem, waitTime);
                waitTime += 300;
            }
        }
    }

    private Runnable changeSelectedItem = new Runnable()
    {
        @Override
        public void run()
        {
            int currentItemPosition = randomizerListView.getCheckedItemPosition();

            Random randomIntGenerator = new Random();
            int randomInt = randomIntGenerator.nextInt(randomizerListView.getAdapter().getCount());

            if(randomInt == currentItemPosition)
            {
                if(randomInt == randomizerListView.getAdapter().getCount() - 1)
                    randomInt = 0;
                else
                    randomInt += 1;
            }

            randomizerListView.setItemChecked(randomInt, true);


            counter--;

            if(counter <= 0)
            {
                Handler movingOnHandler = new Handler();
                movingOnHandler.postDelayed(sendInfoToNextActivity, 0);
            }
        }
    };

    private Runnable sendInfoToNextActivity = new Runnable()
    {
        @Override
        public void run()
        {
            int currentItemPosition = randomizerListView.getCheckedItemPosition();
            String place = String.valueOf(randomizerListView.getItemAtPosition(currentItemPosition));
            Toast.makeText(RandomPicker.this, place, Toast.LENGTH_SHORT).show();

            counter = 10;
            complete = true;
        }
    };

}
