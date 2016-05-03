package com.example.george.petapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityUI extends AppCompatActivity {
    private List<Feed> myFeed = new ArrayList<Feed>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_ui);

        populateFeedList();
        populateListView();

    }

    private void populateFeedList() {
        myFeed.add(new Feed("toby", "dog", "George Hargis", "george_hargis@yahoo.com", R.drawable.dog));
        myFeed.add(new Feed("Mr Ass", "Cat", "Mike tyson", "earsareyummy@yahoo.com", R.drawable.cat));
        myFeed.add(new Feed("Nope Rope", "snake", "bobby Lee swagger", "deathbeforedishonour@yahoo.com", R.drawable.snake));
        myFeed.add(new Feed("fatty cakes", "dog", "Marsha B.", "marashphaes@yahoo.com", R.drawable.dog));
        myFeed.add(new Feed("Mr fluffy", "Bird", "danny butler", "george_hargis@yahoo.com", R.drawable.bird));
        myFeed.add(new Feed("franky", "dog", "james black", "jameshells@yahoo.com", R.drawable.dog));

    }

    private void populateListView() {
        ArrayAdapter<Feed> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.feedListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Feed>{
        public MyListAdapter(){
            super(MainActivityUI.this, R.layout.item_view, myFeed );
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //make sure we have a view to work with (may have been given null)
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            // find the pet to work with
            Feed CurrentFeed = myFeed.get(position);


            // fill the view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.icon_id);
            imageView.setImageResource(CurrentFeed.getPhoto());
            //
            return itemView;
        }
    }

}
