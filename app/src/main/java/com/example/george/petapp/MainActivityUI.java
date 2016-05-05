package com.example.george.petapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityUI extends Activity {


    List<Feed> myFeed = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_activity_ui);

    populateFeedList();
    populateListView();

}

    private void populateFeedList() {
        myFeed.add(new Feed("toby", "dog", "George Hargis", "george@yahoo.com", R.drawable.dog));
        myFeed.add(new Feed("Mr Ass", "Cat", "Mike tyson", "earsareyummy@yahoo.com", R.drawable.cat));
        myFeed.add(new Feed("Nope Rope", "snake", "bobby Lee swagger", "deathbeforedishonour@yahoo.com", R.drawable.snake));
        myFeed.add(new Feed("fatty cakes", "dog", "Marsha B.", "marashphaes@yahoo.com", R.drawable.dog));
        myFeed.add(new Feed("Mr fluffy", "Bird", "danny butler", "george_hargis@yahoo.com", R.drawable.bird));
        myFeed.add(new Feed("franky", "dog", "james black", "jameshells@yahoo.com", R.drawable.dog));

    }

    private void populateListView() {
        ArrayAdapter<Feed> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listView);

        if (list != null) {
            list.setAdapter(adapter);
        }
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

        // TextView
        TextView petNameText = (TextView) itemView.findViewById(R.id.Pet_Name_id);
        petNameText.setText(CurrentFeed.getPetName());

        TextView userNameText = (TextView) itemView.findViewById(R.id.Person_name_id);
        userNameText.setText(CurrentFeed.getUserName());

        TextView petTypeText = (TextView) itemView.findViewById(R.id.Pet_type_id);
        petTypeText.setText(CurrentFeed.getPetType());

        TextView contactInfoText = (TextView) itemView.findViewById(R.id.Contact_Info_id);
        contactInfoText.setText(CurrentFeed.getEmail());

        //
        return itemView;
    }
}



    //
}
